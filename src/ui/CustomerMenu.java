package ui;

import java.util.Scanner;
import manager.CustomerManager;
import model.customer.Customer;

public class CustomerMenu {

    private CustomerManager customerManager;
    private Scanner sc;

    public CustomerMenu() {
        customerManager = new CustomerManager();
        sc = new Scanner(System.in);
    }

    public void showMenu() {
        int choice;

        do {
            System.out.println("\n===== CUSTOMER MENU =====");
            System.out.println("1. Add Customer");
            System.out.println("2. Update Customer");
            System.out.println("3. Remove Customer");
            System.out.println("4. Search Customer");
            System.out.println("5. Display Customers");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    String id = sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();

                    System.out.print("Enter Address: ");
                    String address = sc.nextLine();

                    System.out.print("Enter Total Purchase: ");
                    double totalPurchase = Double.parseDouble(sc.nextLine());

                    Customer customer = new Customer(
                            id,
                            name,
                            phone,
                            address,
                            totalPurchase
                    );

                    customerManager.addCustomer(customer);
                    System.out.println("Add Customer Successfully!");
                    break;

                case 2:
                    System.out.print("Enter Customer ID: ");
                    id = sc.nextLine();

                    System.out.print("New Name: ");
                    name = sc.nextLine();

                    System.out.print("New Phone: ");
                    phone = sc.nextLine();

                    System.out.print("New Address: ");
                    address = sc.nextLine();

                    if (customerManager.updateCustomer(id, name, phone, address)) {
                        System.out.println("Update Successfully!");
                    } else {
                        System.out.println("Customer Not Found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Customer ID: ");
                    id = sc.nextLine();

                    if (customerManager.removeCustomer(id)) {
                        System.out.println("Remove Successfully!");
                    } else {
                        System.out.println("Customer Not Found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Customer ID: ");
                    id = sc.nextLine();

                    Customer c = customerManager.searchCustomer(id);

                    if (c != null) {
                        System.out.println(c);
                    } else {
                        System.out.println("Customer Not Found!");
                    }
                    break;

                case 5:
                    customerManager.displayCustomers();
                    break;

                case 0:
                    System.out.println("Exit Program");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 0);
    }
}
