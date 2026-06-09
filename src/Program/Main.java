package Program;

import java.util.Scanner;
import Management.EmployeeManagement; // 1. THÊM DÒNG NÀY ĐỂ IMPORT

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 2. ĐỔI EmployeeManager THÀNH EmployeeManagement CHO ĐÚNG TÊN FILE
        EmployeeManagement empManager = new EmployeeManagement(); 
        int choice;
        do {
            System.out.println("\n==================================");
            System.out.println("     SALE MANAGEMENT SYSTEM       ");
            System.out.println("==================================");
            System.out.println("1. Add a new employee");
            System.out.println("2. Update employee information");
            System.out.println("3. Remove an employee");
            System.out.println("4. List all employees");
            System.out.println("0. Exit System");
            System.out.println("==================================");
            System.out.print("Please enter your choice (0-4): ");
            
            choice = sc.nextInt();
            sc.nextLine(); // Xóa bộ đệm sau khi nhập số

            switch (choice) {
                case 1:
                    empManager.addEmployee(sc);
                    break;
                case 2:
                    empManager.updateEmployeeRole(sc);
                    break;
                case 3:
                    empManager.removeEmployee(sc);
                    break;
                case 4:
                    empManager.listAllEmployees();
                    break;
                case 0:
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
        
        sc.close();
    }
}