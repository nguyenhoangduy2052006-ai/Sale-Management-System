package repository;

import java.util.ArrayList;
import java.util.List;
import model.supplier.Supplier; // Đảm bảo đúng tên package model của ông
import util.FileUtils;

public class SupplierRepository {

    // LOAD — Read file using Duy's shared readLines function
    public static ArrayList<Supplier> loadSuppliers(String filePath) {
        ArrayList<Supplier> list = new ArrayList<>();
        List<String> lines = FileUtils.readLines(filePath);

        for (String line : lines) {
            try {
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] parts = line.split(",");
                if (parts.length >= 4) {
                    String id = parts[0].trim();
                    String name = parts[1].trim();

                }
            } catch (Exception e) {
                System.out.println("Error parsing supplier line: " + line + " - skipping");
            }
        }
        return list;
    }

    public static void saveSuppliers(String filePath, ArrayList<Supplier> list) {
        List<String> lines = new ArrayList<>();

        for (Supplier sup : list) {
            String line = sup.getSupplierID() + "," + sup.getSupplierName();
            lines.add(line);
        }

        FileUtils.writeLines(filePath, lines);
        System.out.println("Suppliers saved successfully!");
    }
}
