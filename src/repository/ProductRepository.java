
package repository;

import model.product.*;
import util.FileUtils;
import java.util.ArrayList;
import java.util.List;


public class ProductRepository {
    private static final String FILE_PATH = "data/products.txt";
    
    // LOAD — đọc file tạo danh sách Product
    public ArrayList<Product> loadProducts () {
        ArrayList<Product> productList = new ArrayList<>();
        List<String> lines = FileUtils.readLines(FILE_PATH);
        
        for (String line : lines) {
            try {
                String[] parts = line.split("\\|");
                String type = parts[0];
                String id= parts[1];
                String name=parts[2];
                String category=parts[3];
                double price = Double.parseDouble(parts[4]);
                int quantity = Integer.parseInt(parts[5]);
                
                Product p = null;
                switch (type) {
                    case "LT": {
                        String cpu = parts[6];
                        String ram = parts [7];
                        String storage = parts [8];
                        p= new Laptop (id, name, category, price, quantity, cpu, ram, storage);
                        break;
                    }
                    case "SP": {
                        String screenSize = parts [6];
                        String camera = parts [7];
                        String battery = parts [8];
                        p = new Smartphone (id, name, category, price, quantity, screenSize, camera, battery);
                        break;
                    }
                    case "TV": {
                        String screenSize = parts[6];
                        String resolution = parts[7];
                        p = new Television(id, name, category, price, quantity, screenSize, resolution);
                        break;
                    }
                    default:
                        System.out.println ("Unknown product type: " + type +"- skipping");
                }
                if (p!=null) {
                    productList.add(p);
                }
            }
            catch (Exception e){
                System.out.println("Error parsing line: " + line + "- skipping");
            }
        }
        
        return productList;
    }
    
    // SAVE — convert danh sách Product -> ghi xuống file
    public void saveProducts (ArrayList<Product> productList) {
        List<String> lines = new ArrayList<>();
        
        for (Product p : productList) {
            // phan chung cua Product
            String common= p.getIdPrefix() + "|" + p.getProductId() + "|" + p.getProductName() + "|" + p.getCategory() + "|" + p.getPrice() + "|" + p.getQuantity();
            // Phần riêng theo từng loại
            String line = common;
            if (p instanceof Laptop) {
                Laptop l = (Laptop) p;
                line += "|" + l.getCPU() + "|" + l.getRam() + "|" + l.getStorage();
            } else if (p instanceof Smartphone) {
                Smartphone s = (Smartphone) p;
                line+= "|" + s.getScreenSize() + "|" + s.getCamera() + "|" + s.getBattery();
                
            } else if (p instanceof Television) {
                Television t = (Television) p;
                line += "|" + t.getScreenSize() + "|" + t.getResolution();
            }
            lines.add(line);
        }
        
        FileUtils.writeLines(FILE_PATH, lines);
        System.out.println("Products saved successfully!");
    }
}
