package Program;

import java.util.Scanner;
// import Management.EmployeeManagement; // Tạm ẩn nếu không gọi ở Main

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        
        do {
            // GIAO DIỆN GIỐNG 100% ẢNH MẪU CỦA LEADER
            System.out.println("\nSYSTEM INTERFACE");
            System.out.println("1. MAIN MENU");
            System.out.println("=======================================");
            System.out.println("        SALES MANAGEMENT SYSTEM        ");
            System.out.println("=======================================");
            System.out.println("1. Manage Products");
            System.out.println("2. Manage Customers");
            System.out.println("3. Manage Sales Transactions");
            System.out.println("4. Reports");
            System.out.println("5. Exit"); 
            System.out.println("---------------------------------------");
            System.out.print("Choose an option: ");
            
            choice = sc.nextInt();
            sc.nextLine(); // Xóa bộ đệm

            switch (choice) {
                case 1:
                    System.out.println("\n>>> Entering Product Management... <<<");
                    break;
                case 2:
                    System.out.println("\n>>> Entering Customer Management... <<<");
                    break;
                case 3:
                    System.out.println("\n>>> Entering Sales Transactions... <<<");
                    break;
                case 4:
                    System.out.println("\n>>> Entering Reports... <<<");
                    break;
                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
        
        sc.close();
    }
}