package ui;

import java.util.Scanner;
import manager.CustomerManagement;
import model.customer.Customer;

public class CustomerMenu {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CustomerManagement cm = new CustomerManagement();

        int choice;

        do {
            System.out.println("\n===== CUSTOMER MENU =====");
            System.out.println("1. Add Customer");
            System.out.println("2. Search Customer");
            System.out.println("3. Display Customers");
            System.out.println("4. Remove Customer");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            choice = sc.nextInt();
            sc.nextLine(); // Clear bộ nhớ đệm tránh nuốt chữ

            switch (choice) {

                case 1:
                    System.out.print("Customer ID: ");
                    String id = sc.nextLine();

                    System.out.print("Customer Name: ");
                    String name = sc.nextLine();

                    System.out.print("Phone Number: ");
                    String phone = sc.nextLine();

                    System.out.print("Address: ");
                    String address = sc.nextLine();

                    // Khởi tạo đối tượng theo đúng Constructor 4 tham số của bạn
                    Customer customer = new Customer(id, name, phone, address);

                    cm.addNewCustomer(customer);

                    System.out.println("Customer added successfully!");
                    break;

                case 2:
                    System.out.print("Enter Customer ID: ");
                    String searchID = sc.nextLine();

                    Customer found = cm.searchCustomerByID(searchID);

                    // BỎ HẲN IF-ELSE: Dùng toán tử ba ngôi để check null và hiển thị kết quả
                    System.out.println(found != null 
                        ? "ID: " + found.getCustomerID() 
                          + "\nName: " + found.getCustomerName() 
                          + "\nPhone: " + found.getPhoneNumber() 
                          + "\nAddress: " + found.getAddress()
                          + "\nTotal Purchase: " + found.getTotalPurchase()
                        : "Customer not found!");
                    
                    break;

                case 3:
                    // Gọi hàm hiển thị toàn bộ danh sách khách hàng từ Manager
                    cm.listCustomer();
                    break;

                case 4:
                    System.out.print("Enter Customer ID: ");
                    String removeID = sc.nextLine();

                    // Gọi hàm xóa theo ID từ Manager
                    cm.removeCustomer(removeID);

                    System.out.println("Customer removed!");
                    break;

                case 0:
                    System.out.println("Program ended.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);

        sc.close();
    }
}
