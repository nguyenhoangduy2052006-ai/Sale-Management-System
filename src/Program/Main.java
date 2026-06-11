package Program;

import java.util.Scanner;

// IMPORT CHÍNH XÁC THEO THỨ TỰ CÁC MODULE TRONG REPORT
import Management.ProductManagement;
import Management.CustomerManagement;
import Management.SaleManagement;
import Management.InventoryManagement;
import Management.Reporting;
import Management.SupplierManagement;
import Management.EmployeeManagement;
import Management.VoucherManagement;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Khởi tạo các đối tượng quản lý tương ứng với 8 phân hệ
        ProductManagement productMgr = new ProductManagement();
        CustomerManagement customerMgr = new CustomerManagement();
        SaleManagement saleMgr = new SaleManagement();
        InventoryManagement inventoryMgr = new InventoryManagement();
        Reporting reportingMgr = new Reporting();
        SupplierManagement supplierMgr = new SupplierManagement();
        EmployeeManagement employeeMgr = new EmployeeManagement();
        VoucherManagement voucherMgr = new VoucherManagement();
        
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
                    // productMgr.displayMenu(sc); 
                    break;
                case 2:
                    System.out.println("\n>>> Entering Customer Management Sub-Menu... <<<");
                    // customerMgr.displayMenu(sc); 
                    break;
                case 3:
                    System.out.println("\n>>> Entering Sale Management Sub-Menu... <<<");
                    // saleMgr.displayMenu(sc);
                    break;
                case 4:
                    System.out.println("\n>>> Entering Inventory Management Sub-Menu... <<<");
                    // inventoryMgr.displayMenu(sc);
                    break;
                case 5:
                    System.out.println("\n>>> Entering Reporting Sub-Menu... <<<");
                    // reportingMgr.displayMenu(sc);
                    break;
                case 6:
                    System.out.println("\n>>> Entering Supplier Management Sub-Menu... <<<");
                    // supplierMgr.displayMenu(sc);
                    break;
                case 7:
                    // Kích hoạt Menu chức năng chi tiết (Add, Update, Delete) cho phần của ông
                    employeeMgr.displayMenu(sc); 
                    break;
                case 8:
                    System.out.println("\n>>> Entering Voucher Management Sub-Menu... <<<");
                    // voucherMgr.displayMenu(sc);
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