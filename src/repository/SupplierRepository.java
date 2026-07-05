package repository;

import java.util.ArrayList;
import model.supplier.Supplier;
import util.FileUtils;

public class SupplierRepository {

    public static ArrayList<Supplier> loadSuppliers(String filePath) {
        ArrayList<Supplier> list = new ArrayList<>();
        ArrayList<String> lines = FileUtils.readFile(filePath);

        for (String line : lines) {
            if (line.trim().isEmpty()) continue;
            String[] parts = line.split(",");
            if (parts.length == 4) {
                String id = parts[0].trim();
                String name = parts[1].trim();
                String contactName = parts[2].trim();
                String phone = parts[3].trim();
                list.add(new Supplier(id, name, contactName, phone));
            }
        }
        return list;
    }

    public static void saveSuppliers(String filePath, ArrayList<Supplier> list) {
        ArrayList<String> lines = new ArrayList<>();
        for (Supplier sup : list) {
            String line = sup.getSupplierID() + "," + sup.getSupplierName() + "," + sup.getContactName() + "," + sup.getPhoneNumber();
            lines.add(line);
        }
        FileUtils.writeFile(filePath, lines);
    }
}