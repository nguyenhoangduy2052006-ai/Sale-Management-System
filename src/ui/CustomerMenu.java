package ui;

import manager.CustomerManager; // Import lớp quản lý từ package manager
import model.customer.Customer; // Import lớp dữ liệu từ package model
// Import chuẩn 2 lớp con kế thừa từ package model.customer
import model.customer.VipCustomer;
import model.customer.RegularCustomer; 

import java.util.Scanner;

public class CustomerMenu {

    private final CustomerManager manager;
    private final Scanner scanner;

    // Nhận CustomerManager từ MainMenu truyền sang để đồng bộ dữ liệu
    public CustomerMenu(CustomerManager manager) {
        this.manager = manager;
        this.scanner = new Scanner(System.in);
    }

    // Phương thức chạy Menu khớp hoàn toàn với case 2 trong MainMenu của bạn
    public void showMenu() {
        int choice;
        do {
            displayMenu();
            System.out.print("Input your choice (1-7): ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                choice = -1; 
            }

            switch (choice) {
                case 1:
                    handleAddCustomer();
                    break;
                case 2:
                    handleSearchCustomer();
                    break;
                case 3:
                    handleUpdateCustomer();
                    break;
                case 4:
                    handleRemoveCustomer();
                    break;
                case 5:
                    System.out.println("\n==================================");
                    System.out.println("         CUSTOMER LIST            ");
                    System.out.println("==================================");
                    manager.displayCustomers();
                    break;
                case 6:
                    handleDisplayTopCustomers();
                    break;
                case 7:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice! Please choose between 1 and 7.");
            }
            System.out.println(); 
        } while (choice != 7);
    }

    // Giao diện menu con của Khách Hàng
    private void displayMenu() {
        System.out.println("==================================");
        System.out.println("      CUSTOMER MANAGEMENT        ");
        System.out.println("==================================");
        System.out.println("1. Add New Customer");
        System.out.println("2. Search Customer by ID");
        System.out.println("3. Update Customer Information");
        System.out.println("4. Remove Customer");
        System.out.println("5. Display All Customers");
        System.out.println("6. Display Top Purchasing Customers");
        System.out.println("7. Back to Main Menu");
        System.out.println("==================================");
    }

    // 1. Xử lý chức năng thêm khách hàng mới (CHO PHÉP NHẬP ĐẦY ĐỦ THÔNG TIN REGULAR & VIP)
    private void handleAddCustomer() {
        System.out.println("\n--- ADD NEW CUSTOMER ---");
        
        System.out.println("Select Customer Type:");
        System.out.println("1. Regular Customer");
        System.out.println("2. VIP Customer");
        System.out.print("Your choice: ");
        int typeChoice;
        try {
            typeChoice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            typeChoice = 1; // Mặc định là khách thường nếu nhập lỗi
        }
        
        if (typeChoice != 1 && typeChoice != 2) {
            System.out.println("Invalid type choice! Defaulted to Regular.");
            typeChoice = 1;
        }

        System.out.print("Enter Customer ID: ");
        String id = scanner.nextLine().trim();
        System.out.print("Enter Customer Name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Enter Phone Number: ");
        String phone = scanner.nextLine().trim();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine().trim();
        
        System.out.print("Enter Initial Total Purchase Value: ");
        double totalPurchase = 0;
        try {
            totalPurchase = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount! Set to 0 by default.");
        }

        Customer customer = null;
        try {
            if (typeChoice == 1) {
                // --- ĐOẠN CHO NHẬP THÊM THÔNG TIN REGULAR ---
                System.out.print("Enter Regular Discount (e.g., 0.05 for 5%): ");
                double regularDiscount = 0.0;
                try {
                    regularDiscount = Double.parseDouble(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid discount format! Set to 0.0 by default.");
                }

                System.out.print("Enter Initial Reward Points: ");
                int rewardPoints = 0;
                try {
                    rewardPoints = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid points format! Set to 0 by default.");
                }
                // --------------------------------------------
                
                // Khởi tạo RegularCustomer (7 tham số)
                customer = new RegularCustomer(id, name, phone, address, totalPurchase, regularDiscount, rewardPoints);
            } else {
                // --- ĐOẠN CHO NHẬP THÊM THÔNG TIN VIP ---
                System.out.print("Enter VIP Discount (e.g., 0.15 for 15%): ");
                double vipDiscount = 0.15; 
                try {
                    vipDiscount = Double.parseDouble(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid discount format! Set to 0.15 by default.");
                }

                System.out.print("Enter VIP Level (Gold/Silver/Platinum): ");
                String vipLevel = scanner.nextLine().trim();
                if (vipLevel.isEmpty()) {
                    vipLevel = "Gold"; 
                }
                // ----------------------------------------
                
                // Khởi tạo VipCustomer (7 tham số)
                customer = new VipCustomer(id, name, phone, address, totalPurchase, vipDiscount, vipLevel);
            }

            if (manager.addCustomer(customer)) {
                System.out.println("Customer added successfully!");
            } else {
                System.out.println("Failed to add customer!");
            }
        } catch (Exception e) {
            System.out.println("Error initializing customer object. Please check your subclass constructors.");
        }
    }

    // 2. Xử lý tìm kiếm khách hàng
    private void handleSearchCustomer() {
        System.out.println("\n--- SEARCH CUSTOMER ---");
        System.out.print("Enter Customer ID to search: ");
        String id = scanner.nextLine().trim();
        
        Customer c = manager.searchCustomer(id);
        if (c != null) {
            System.out.println("\n[Customer Found]:");
            System.out.println(c);
        } else {
            System.out.println("No customer found with ID: " + id);
        }
    }

    // 3. Xử lý cập nhật thông tin khách hàng
    private void handleUpdateCustomer() {
        System.out.println("\n--- UPDATE CUSTOMER ---");
        System.out.print("Enter Customer ID to update: ");
        String id = scanner.nextLine().trim();

        if (manager.searchCustomer(id) == null) {
            System.out.println("Customer ID does not exist!");
            return;
        }

        System.out.print("Enter New Name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Enter New Phone Number: ");
        String phone = scanner.nextLine().trim();
        System.out.print("Enter New Address: ");
        String address = scanner.nextLine().trim();

        if (manager.updateCustomer(id, name, phone, address)) {
            System.out.println("Customer updated successfully!");
        } else {
            System.out.println("Failed to update customer!");
        }
    }

    // 4. Xử lý xóa khách hàng
    private void handleRemoveCustomer() {
        System.out.println("\n--- REMOVE CUSTOMER ---");
        System.out.print("Enter Customer ID to remove: ");
        String id = scanner.nextLine().trim();

        if (manager.removeCustomer(id)) {
            System.out.println("Customer removed successfully!");
        } else {
            System.out.println("No customer found to remove!");
        }
    }

    // 6. Xử lý hiển thị top khách hàng mua nhiều nhất
    private void handleDisplayTopCustomers() {
        System.out.println("\n--- TOP PURCHASING CUSTOMERS ---");
        System.out.print("Enter the number of top customers to display (N): ");
        int topN;
        try {
            topN = Integer.parseInt(scanner.nextLine());
            if (topN <= 0) {
                System.out.println("The number must be greater than 0!");
                return;
            }
            manager.displayTopCustomers(topN);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid integer.");
        }
    }
}
