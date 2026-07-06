package repository;

import java.util.ArrayList;
import java.util.List; // Bắt buộc phải dùng List theo bài mẫu của Duy
import model.inventory.Inventory;
import util.FileUtils;

public class InventoryRepository {

    public static ArrayList<Inventory> loadInventory(String filePath) {
        ArrayList<Inventory> list = new ArrayList<>();

        List<String> lines = FileUtils.readLines(filePath);

        for (String line : lines) {
            try {
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String id = parts[0].trim();
                    String name = parts[1].trim();
                    int quantity = Integer.parseInt(parts[2].trim());
                    String location = parts[3].trim();
                    list.add(new Inventory(id, name, quantity, location));
                }
            } catch (Exception e) {
                System.out.println("Error parsing inventory line: " + line + " - skipping");
            }
        }
        return list;
    }

    public static void saveInventory(String filePath, ArrayList<Inventory> list) {
        List<String> lines = new ArrayList<>();

        for (Inventory inv : list) {
            String line = inv.getInventoryID() + "," + inv.getItemName() + "," + inv.getQuantity() + "," + inv.getLocation();
            lines.add(line);
        }

        FileUtils.writeLines(filePath, lines);
        System.out.println("Inventory saved successfully!");
    }
}
