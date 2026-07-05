package manager;

import model.inventory.Inventory;
import java.util.ArrayList;
import repository.InventoryRepository;

public class InventoryManager {

    private ArrayList<Inventory> inventoryList;
    private final String FILE_PATH = "data/inventory.txt";

    public InventoryManager() {
        // AUTOMATIC LOAD: Fetch data from the txt file into the list when the Manager is initialized
        this.inventoryList = InventoryRepository.loadInventory(FILE_PATH);
    }

    public boolean addInventory(Inventory inv) {
        for (Inventory i : inventoryList) {
            if (i.getInventoryID().equalsIgnoreCase(inv.getInventoryID())) {
                return false;
            }
        }
        inventoryList.add(inv);

        InventoryRepository.saveInventory(FILE_PATH, inventoryList);
        return true;
    }

    public boolean updateInventory(String id, String newName, int newQty, String newLocation) {
        if (id == null || id.trim().isEmpty()
                || newName == null || newName.trim().isEmpty()
                || newLocation == null || newLocation.trim().isEmpty()
                || newQty < 0) {
            return false;
        }

        for (Inventory i : inventoryList) {
            if (i.getInventoryID().equalsIgnoreCase(id)) {
                i.setItemName(newName.trim());
                i.setQuantity(newQty);
                i.setLocation(newLocation.trim());
                // SAVE FILE: Automatically persist data to the txt file after updating
                InventoryRepository.saveInventory(FILE_PATH, inventoryList);
                return true;
            }
        }
        return false;
    }

    public boolean removeInventory(String id) {
        for (int i = 0; i < inventoryList.size(); i++) {
            if (inventoryList.get(i).getInventoryID().equalsIgnoreCase(id)) {
                inventoryList.remove(i);

                InventoryRepository.saveInventory(FILE_PATH, inventoryList);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Inventory> searchInventory(String keyword) {
        ArrayList<Inventory> results = new ArrayList<>();
        for (Inventory i : inventoryList) {
            if (i.getInventoryID().equalsIgnoreCase(keyword)
                    || i.getItemName().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(i);
            }
        }
        return results;
    }

    public ArrayList<Inventory> getAllInventory() {

        inventoryList = InventoryRepository.loadInventory(FILE_PATH);
        return inventoryList;
    }

    public Inventory findById(String id) {
        for (Inventory i : inventoryList) {
            if (i.getInventoryID().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return null;
    }

    public boolean reduceStock(String id, int sellQty) {

        inventoryList = InventoryRepository.loadInventory(FILE_PATH);

        Inventory inv = findById(id);
        if (inv == null || sellQty <= 0) {
            System.out.println("Inventory Error: Product not found or invalid sales quantity!");
            return false;
        }

        if (inv.getQuantity() < sellQty) {
            System.out.println("Inventory Error: Insufficient stock available for this sale!");
            return false;
        }

        inv.setQuantity(inv.getQuantity() - sellQty);
        System.out.println("Inventory: Successfully reduced " + sellQty + " unit(s) for Product ID: " + id);

        InventoryRepository.saveInventory(FILE_PATH, inventoryList);
        return true;
    }
}
