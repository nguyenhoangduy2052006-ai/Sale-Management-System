
package ui;

import model.product.Product;
import model.product.Laptop;
import model.product.Television;
import model.product.Smartphone;
import manager.ProductManager;

import util.InputHelper;

import java.util.Scanner;

public class ProductMenu {
    private final ProductManager productManager; // Declare attribute of Productmenu
    private final Scanner scanner;
    // Declare constructor
    public ProductMenu (ProductManager productManager) {
        this.productManager= productManager;
        this.scanner= new Scanner(System.in);
    }
    
    public void showMenu () {
        int choice;
        do {
            System.out.println("\n" + InputHelper.repeatChar("=", 50)); // Java hieu se repeatChar là method cua Inputhelper vao di vao do de goi ham nay va dung
            System.out.println("        PRODUCT MANAGER");
            System.out.println(InputHelper.repeatChar("=", 50));
            System.out.println("1. Add New Product");
            System.out.println("2. Update Product");
            System.out.println("3. Remove Product");
            System.out.println("4. Display All Product");
            System.out.println("5. Search Product by ID");
            System.out.println("0. Exit")  ;
            System.out.print("Input your choice: ");
            choice = InputHelper.readInt(scanner); // goi tuw ham check integer from util
            // luu ý: cach dung nay chi co the dung khi ham do la static
            switch (choice) {
                case 1: 
                    addNewProduct();
                    break;
                case 2:
                    updateProduct();
                    break;
                case 3:
                    removeProduct();
                    break;
                case 4:
                    displayProductList();
                    break;
                case 5:
                    searchProductById();
                    break;
                case 0:
                    System.out.println("Returning to main menu.");
                    break;
                default:
                    System.out.println ("Invalid choice.");

            }
        } while (choice!=0);
    }    
        // ==================== CÁC HÀM HỖ TRỢ ====================
        
        private void addNewProduct() {
        System.out.println("\n--- ADD NEW PRODUCT ---");
        System.out.println("Choose product type:");
        System.out.println("1. Laptop");
        System.out.println("2. Smartphone");
        System.out.println("3. Television");
        int type = InputHelper.readInt(scanner, 1, 3);

            String prefix;
            switch (type) {
                case 1:
                    prefix = "LT";
                    break;
                case 2:
                    prefix = "SP";
                    break;
                default:
                    prefix = "TV";
                    break;
            }

            // ← VALIDATE ID NGAY TẠI ĐÂY — vòng lặp yêu cầu nhập lại nếu sai
            String id;
            while (true) {
                System.out.print("Product ID (e.g: " + prefix + "001): ");
                id = scanner.nextLine().trim();

                // Kiểm tra đúng prefix
                if (!id.startsWith(prefix)) {
                    System.out.println("Invalid ID! Must start with " + prefix + ". Please try again.");
                    continue;
                }

                // Kiểm tra phần sau prefix phải là số
                String numberPart = id.substring(prefix.length());
                if (numberPart.isEmpty() || !numberPart.matches("\\d+")) {
                    System.out.println("Invalid ID! After " + prefix + " must be numbers. Please try again.");
                    continue;
                }

                // Kiểm tra ID đã tồn tại chưa
                if (productManager.findProductById(id) != null) {
                    System.out.println("ID already existed! Please try again.");
                    continue;
                }

                break; // ← ID hợp lệ → thoát vòng lặp
            }


        System.out.print("Product Name: ");
        String name = scanner.nextLine().trim();
        
        System.out.print("Category: ");
        String category = scanner.nextLine().trim();

        System.out.print("Price (VND): ");
        double price = InputHelper.readDouble(scanner, 0);

        System.out.print("Initial Quantity: ");
        int quantity = InputHelper.readInt(scanner, 0);

        Product newProduct = null;
        
        switch (type) {
            case 1: // Laptop
            {
                System.out.print("CPU: ");
                String cpu= scanner.nextLine().trim();
                System.out.print("RAM (e.g: 16GB): ");
                String ram = scanner.nextLine().trim();
                System.out.print("Storage (e.g: 512GB): ");
                String storage = scanner.nextLine().trim();
                
                newProduct = new Laptop(id, name, category, price, quantity, cpu, ram, storage);
                break;
            }
            case 2: // Smartphone
            {
                System.out.print("Screen Size (e.g: 6.7 inch): ");
                String screen = scanner.nextLine().trim();
                System.out.print("Camera: ");
                String camera = scanner.nextLine().trim();
                System.out.print("Battery: ");
                String battery = scanner.nextLine().trim();

                newProduct = new Smartphone(id, name, category, price, quantity, screen, camera, battery);
                break;
            }
                
            case 3: // Television
            {
                System.out.print("Screen Size: ");
                String screen = scanner.nextLine().trim();
                System.out.print("Resolution (4K/8K/...): ");
                String resolution = scanner.nextLine().trim();

                newProduct = new Television(id, name, category, price, quantity, screen, resolution);
                break;
            }
        }
        if (newProduct != null) {
            try {
                if (productManager.addNewProduct(newProduct)) {
                    System.out.println("Product added successfully!");
                } else {
                    System.out.println("Error: Product ID already existed!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
    
        // updateProduct method
    private void updateProduct() {
        System.out.print("\nEnter Product ID to update: ");
        String id = scanner.nextLine().trim();

        Product p = productManager.findProductById(id);
        if (p == null) {
            System.out.println("Product not found!");
            return;
        }
        
        System.out.println(InputHelper.repeatChar("-", 170));
        System.out.format("%-8s %-30s %-30s %-20s %-15s %-30s\n","ID", "Name", "Category", "Price", "Quantity", "Detail");
        System.out.println("Current Info: " + p);
        System.out.println(InputHelper.repeatChar("-", 170));

        System.out.print("New Name (leave blank to skip): ");
        String newName = scanner.nextLine().trim();

        System.out.print("New Price (0 to skip): ");
        double newPrice = InputHelper.readDouble(scanner, 0);

        System.out.print("New Quantity (-1 to skip): ");
        int newQuantity = InputHelper.readInt(scanner, -1);

        if (productManager.updateProductInfo(id, newName.isEmpty() ? null : newName, newPrice, newQuantity)) {
            System.out.println("Updated successfully!");
        } else {
            System.out.println("Update failed!");
        }
    }
    
    // Remove product
    private void removeProduct() {
        System.out.print("\nEnter Product ID to remove: ");
        String id = scanner.nextLine().trim();
        if (productManager.removeProduct(id)) {
            System.out.println("Removed successfully!");
        } else {
            System.out.println("Product not found!");
        }
    }
    
    // Search by ID
    private void searchProductById() {
        System.out.print("\nEnter Product ID: ");
        String id = scanner.nextLine().trim();
        Product p = productManager.findProductById(id);

        if (p != null) {
            System.out.println("Found: " + p);
        } else {
            System.out.println(" Product not found!");
        }
    }
    
    // Display Product list
    private void displayProductList () {
        System.out.println("----- PRODUCT LIST -----\n");
        System.out.println(InputHelper.repeatChar("-", 180));
        System.out.format("%-8s %-30s %-30s %-20s %-15s %-30s\n","ID", "Name", "Category", "Price", "Quantity", "Detail");
        System.out.println(InputHelper.repeatChar("-", 180));
        if (productManager.getProductList().isEmpty()) {
            System.out.println("No products available.");
        } else {
            productManager.displayProductList();
        }
        
    }
}
