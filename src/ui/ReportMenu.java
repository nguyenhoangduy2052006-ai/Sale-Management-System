
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
            System.out.println("4. Low Stock Products (Quantity < 5)");
            System.out.println("5. Top Customer");
            System.out.println("6. Best-selling products");
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
                    reportLowStockProducts();
                    break;
                    
                case 5: 
                    reportTopCustomers();
                    break;
                
                case 6:
                    reportBestSellingProducts();
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
    
   
    
    // Báo cáo 4: Sản phẩm sắp hết hàng
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
    
    // Báo cáo 5: Top Customer
    private void reportTopCustomers() {
        System.out.println("\n===== TOP CUSTOMERS =====");
        System.out.print("Enter number of top customers to display: ");
        try {
            int topN = Integer.parseInt(SC.nextLine());
            if (topN <= 0) {
                System.out.println("Number must be greater than 0.");
                return;
            }
            customerManager.displayTopCustomers(topN); 
        } catch (NumberFormatException e) {
            System.out.println("Invalid number!");
        }
    }
    
    // Báo cáo 6: Best-Selling Product
    private void reportBestSellingProducts() {
        System.out.println("\n===== BEST-SELLING PRODUCTS =====");

        // Bước 1: Lấy toàn bộ Transaction
        ArrayList<Transaction> transactions = transactionManager.getTransactionList();
        if (transactions.isEmpty()) {
            System.out.println("No transactions available.");
            return;
        }

        // Bước 2: Tạo 2 ArrayList để lưu productId và totalQuantity tương ứng
        ArrayList<String> productIds = new ArrayList<>();
        ArrayList<Integer> quantities = new ArrayList<>();

        // Bước 3: Duyệt qua tất cả Transaction → OrderItem → cộng dồn quantity
        for (Transaction t : transactions) {
            for (model.transaction.OrderItem item : t.getOrderItems()) {
                String pid = item.getProductId();
                int qty = item.getQuantity();

                // Kiểm tra productId đã có trong danh sách chưa
                int index = productIds.indexOf(pid);
                if (index == -1) {
                    // Chưa có → thêm mới
                    productIds.add(pid);
                    quantities.add(qty);
                } else {
                    // Đã có → cộng dồn
                    quantities.set(index, quantities.get(index) + qty);
                }
            }
        }

        if (productIds.isEmpty()) {
            System.out.println("No products sold yet.");
            return;
        }

        // Bước 4: Sắp xếp theo quantity giảm dần (Bubble Sort)
        for (int i = 0; i < productIds.size() - 1; i++) {
            for (int j = 0; j < productIds.size() - i - 1; j++) {
                if (quantities.get(j) < quantities.get(j + 1)) {
                    // Đổi chỗ quantity
                    int tempQty = quantities.get(j);
                    quantities.set(j, quantities.get(j + 1));
                    quantities.set(j + 1, tempQty);
                    // Đổi chỗ productId tương ứng
                    String tempId = productIds.get(j);
                    productIds.set(j, productIds.get(j + 1));
                    productIds.set(j + 1, tempId);
                }
            }
        }

        // Bước 5: Hiển thị kết quả — tra thêm Product để lấy tên
        System.out.printf("%-10s %-25s %-15s %-10s%n",
                "ID", "Name", "Category", "Total Sold");
        System.out.println(util.InputHelper.repeatChar("-", 60));

        for (int i = 0; i < productIds.size(); i++) {
            Product p = productManager.findProductById(productIds.get(i));
            if (p != null) {
                System.out.printf("%-10s %-25s %-15s %-10d%n",
                        p.getProductId(),
                        p.getProductName(),
                        p.getCategory(),
                        quantities.get(i));
            }
        }
    }
}
