package manager;

import model.inventory.Inventory;
import java.util.ArrayList;

public class InventoryManager {
    private ArrayList<Inventory> inventoryList;

    public InventoryManager() {
        this.inventoryList = new ArrayList<>();
    }

    public boolean addInventory(Inventory inv) {
        for (Inventory i : inventoryList) {
            if (i.getInventoryID().equalsIgnoreCase(inv.getInventoryID())) {
                return false;
            }
        }
        inventoryList.add(inv);
        return true;
    }

    public boolean updateInventory(String id, String newName, int newQty, String newLocation) {
        for (Inventory i : inventoryList) {
            if (i.getInventoryID().equalsIgnoreCase(id)) {
                i.setItemName(newName);
                i.setQuantity(newQty);
                i.setLocation(newLocation);
                return true;
            }
        }
        return false;
    }

    public boolean removeInventory(String id) {
        for (int i = 0; i < inventoryList.size(); i++) {
            if (inventoryList.get(i).getInventoryID().equalsIgnoreCase(id)) {
                inventoryList.remove(i);
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
}