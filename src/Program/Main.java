package Program;

import java.util.Scanner;

// CHỈ IMPORT PHÂN HỆ CỦA ÔNG ĐỂ KHÔNG BỊ LỖI (CÁC PHÂN HỆ KHÁC CHƯA CÓ FILE)
import Management.EmployeeManagement; 

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Chỉ khởi tạo phân hệ Quản lý nhân viên 
        EmployeeManagement employeeMgr = new EmployeeManagement();
        
        int choice;
        
        do {
            System.out.println("\nSYSTEM INTERFACE");
            System.out.println("1. MAIN MENU");
            System.out.println("=======================================");
            System.out.println("        SALES MANAGEMENT SYSTEM        ");
            System.out.println("=======================================");
            System.out.println("1. Product Management");
            System.out.println("2. Customer Management");
            System.out.println("3. Sale Management");
            System.out.println("4. Inventory Management");
            System.out.println("5. Reporting");
            System.out.println("6. Supplier Management");
            System.out.println("7. Employee Management");
            System.out.println("8. Voucher Management");
            System.out.println("9. Exit");
            System.out.println("---------------------------------------");
            System.out.print("Choose an option: ");
            
            choice = sc.nextInt();
            sc.nextLine(); // Xóa bộ đệm dòng

            // Điều hướng chính xác theo sơ đồ phân rã hệ thống (System Decomposition)
            switch (choice) {
                case 1:
                    System.out.println("\n>>> Entering Product Management Sub-Menu... <<<");
                    break;
                case 2:
                    System.out.println("\n>>> Entering Customer Management Sub-Menu... <<<");
                    break;
                case 3:
                    System.out.println("\n>>> Entering Sale Management Sub-Menu... <<<");
                    break;
                case 4:
                    System.out.println("\n>>> Entering Inventory Management Sub-Menu... <<<");
                    break;
                case 5:
                    System.out.println("\n>>> Entering Reporting Sub-Menu... <<<");
                    break;
                case 6:
                    System.out.println("\n>>> Entering Supplier Management Sub-Menu... <<<");
                    break;
                case 7:
                    // Gọi đến menu con chức năng quản lý nhân viên của ông
                    employeeMgr.displayMenu(sc); 
                    break;
                case 8:
                    System.out.println("\n>>> Entering Voucher Management Sub-Menu... <<<");
                    break;
                case 9:
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 9);
        
        sc.close();
    }
}