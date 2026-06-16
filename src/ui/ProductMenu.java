
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
}
