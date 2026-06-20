
package ui;

import manager.ProductManager;
import manager.CustomerManager;
import manager.TransactionManager;
import model.product.Product;
import model.customer.Customer;
import model.transaction.Transaction;

import java.util.ArrayList;
import java.util.Scanner;

public class ReportMenu {
    private ProductManager productManager;
    private CustomerManager customerManager;
    private TransactionManager transactionManager;
    private Scanner SC;
    
    public ReportMenu (ProductManager productManager,CustomerManager customerManager, TransactionManager transactionManager) {
        this.productManager=productManager;
        this.customerManager=customerManager;
        this.transactionManager=transactionManager;
        this.SC= new Scanner(System.in);
    }
    
    public void showMenu() {
        int choice;
        do {
            System.out.println("\n===== REPORT MENU =====");
            System.out.println("1. Total Products in Store");
            System.out.println("2. Total Customers");
            System.out.println("3. Total Transactions");
            System.out.println("4. Transaction Summary (IMPORT/EXPORT)");
            System.out.println("5. Low Stock Products (Quantity < 5)");
            System.out.println("0. Back");
            System.out.print("Choose: ");

            try {
                choice = Integer.parseInt(SC.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice!");
                choice = -1;
                continue;
            }

            switch (choice) {
                case 1:
                    reportTotalProducts();
                    break;
                case 2:
                    reportTotalCustomers();
                    break;
                case 3:
                    reportTotalTransactions();
                    break;
                case 4:
                    reportTransactionSummary();
                    break;
                case 5:
                    reportLowStockProducts();
                    break;
                case 0:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }
    
    //  ==================== CÁC HÀM HỖ TRỢ ====================
    // Báo cáo 1: Tổng số sản phẩm
    private void reportTotalProducts() {
        ArrayList<Product> list = productManager.getProductList();
        System.out.println("\n===== PRODUCT REPORT =====");
        System.out.println("Total products: " + list.size());
        productManager.displayProductList();
    }

    // Báo cáo 2: Tổng số khách hàng
    private void reportTotalCustomers() {
        System.out.println("\n===== CUSTOMER REPORT =====");
        customerManager.displayCustomers();
    }

    // Báo cáo 3: Tổng số giao dịch
    private void reportTotalTransactions() {
        System.out.println("\n===== TRANSACTION REPORT =====");
        System.out.println("Total transactions: " + transactionManager.getTotalTransactions());
        transactionManager.displayTransactions();
    }
    
    // Báo cáo 4: Thống kê IMPORT/EXPORT
    private void reportTransactionSummary() {
        // Cần getter từ TransactionManager — dùng cách tạm thời
        System.out.println("\n===== TRANSACTION SUMMARY =====");
        System.out.println("Total transactions: " + transactionManager.getTotalTransactions()); 
    }
    
    // Báo cáo 5: Sản phẩm sắp hết hàng
    private void reportLowStockProducts() {
        System.out.println("\n===== LOW STOCK REPORT (Quantity < 5) =====");
        ArrayList<Product> list = productManager.getProductList();
        boolean found = false;
        for (Product p : list) {
            if (p.getQuantity() < 5) {
                System.out.println(p.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("All products have sufficient stock.");
        }
    }
}
