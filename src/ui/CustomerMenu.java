package ui;

import java.util.Scanner;
import manager.CustomerManager;

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

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Add Customer");
                    break;

                case 2:
                    System.out.println("Update Customer");
                    break;

                case 3:
                    System.out.println("Remove Customer");
                    break;

                case 4:
                    System.out.println("Search Customer");
                    break;

                case 5:
                    customerManager.displayCustomers();
                    break;

                case 0:
                    System.out.println("Exit Program");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);
    }
}
