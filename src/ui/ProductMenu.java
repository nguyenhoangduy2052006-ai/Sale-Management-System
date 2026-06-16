
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
    
    public void productMenu () {
        int choice;
        do {
            System.out.println("\n" + InputHelper.repeatChar("=", 50)); // Java hieu se repeatChar là method cua Inputhelper vao di vao do de goi ham nay va dung
            System.out.println("                        PRODUCT MANAGER");
            System.out.println(InputHelper.repeatChar("=", 50));
            System.out.println("1. Add New Product");
            System.out.println("2. Update Product");
            System.out.println("3. Remove Product");
            System.out.println("4. Display All Product");
            System.out.println("5. Search Product by ID");
            System.out.println("6. Search Product by Name");
            System.out.println("0. Exit");
            
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
                case 6:
                    searchProductByName();
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

        System.out.print("Product ID (e.g: LT001, SP001, TV001): ");
        String id = scanner.nextLine().trim();

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
                System.out.println("Battery: ");
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
         productManager.addNewProduct(newProduct);
        }
    }
    
        // updateProduct method
    private void updateProduct() {
        System.out.print("\nEnter Product ID to update: ");
        String id = scanner.nextLine().trim();

        Product p = productManager.findProductById(id);
        if (p == null) {
            System.out.println("❌ Product not found!");
            return;
        }

        System.out.println("Current Info: " + p);

        System.out.print("New Name (leave blank to skip): ");
        String newName = scanner.nextLine().trim();

        System.out.print("New Price (0 to skip): ");
        double newPrice = InputHelper.readDouble(scanner, 0);

        System.out.print("New Quantity (-1 to skip): ");
        int newQty = InputHelper.readInt(scanner, -1);

        productManager.updateProductInfo(id, newName.isEmpty() ? null : newName, newPrice, newQty);
    }
    
    // Remove product
    private void removeProduct() {
        System.out.print("\nEnter Product ID to remove: ");
        String id = scanner.nextLine().trim();
        productManager.removeProduct(id);
    }
    
    // Search by ID
    private void searchProductById() {
        System.out.print("\nEnter Product ID: ");
        String id = scanner.nextLine().trim();
        Product p = productManager.findProductById(id);

        if (p != null) {
            System.out.println("Found: " + p);
        } else {
            System.out.println("❌ Product not found!");
        }
    }
}
