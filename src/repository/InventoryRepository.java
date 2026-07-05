package repository;

import java.util.ArrayList;
import model.inventory.Inventory;
import util.FileUtils;

public class InventoryRepository {

    public static ArrayList<Inventory> loadInventory(String filePath) {
        ArrayList<Inventory> list = new ArrayList<>();
        ArrayList<String> lines = FileUtils.readFile(filePath);

        for (String line : lines) {
            if (line.trim().isEmpty()) continue;
            String[] parts = line.split(",");
            if (parts.length == 4) {
                String id = parts[0].trim();
                String name = parts[1].trim();
                int quantity = Integer.parseInt(parts[2].trim());
                String location = parts[3].trim();
                list.add(new Inventory(id, name, quantity, location));
            }
        }
        return list;
    }

    public static void saveInventory(String filePath, ArrayList<Inventory> list) {
        ArrayList<String> lines = new ArrayList<>();
        for (Inventory inv : list) {
            String line = inv.getInventoryID() + "," + inv.getItemName() + "," + inv.getQuantity() + "," + inv.getLocation();
            lines.add(line);
        }
        FileUtils.writeFile(filePath, lines);
    }
}