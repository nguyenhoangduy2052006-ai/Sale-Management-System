package ui;

import java.util.Scanner;
import manager.CustomerManager;
import model.customer.Customer;
import model.customer.VipCustomer;
import model.customer.RegularCustomer;

public class CustomerMenu {

    private CustomerManager customerManager;
    private Scanner sc;

    public CustomerMenu(CustomerManager customerManager) {
        this.customerManager = customerManager;
        this.sc = new Scanner(System.in);
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

                // ================= ADD CUSTOMER =================
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

                    System.out.println("1. VIP");
                    System.out.println("2. Regular");
                    System.out.print("Choose type: ");
                    int type = Integer.parseInt(sc.nextLine());

                    Customer customer;

                    if (type == 1) {

                        System.out.print("VIP Discount: ");
                        double vipDiscount = Double.parseDouble(sc.nextLine());

                        System.out.print("VIP Level: ");
                        String vipLevel = sc.nextLine();

                        customer = new VipCustomer(
                                id, name, phone, address,
                                totalPurchase, vipDiscount, vipLevel
                        );

                    } else {

                        System.out.print("Regular Discount: ");
                        double regDiscount = Double.parseDouble(sc.nextLine());

                        System.out.print("Reward Points: ");
                        int rewardPoints = Integer.parseInt(sc.nextLine());

                        customer = new RegularCustomer(
                                id, name, phone, address,
                                totalPurchase, regDiscount, rewardPoints
                        );
                    }

                    // ⭐ FIX QUAN TRỌNG: CHECK RETURN VALUE
                    if (customerManager.addCustomer(customer)) {
                        System.out.println("Add Customer Successfully!");
                    } else {
                        System.out.println("Add Failed! Duplicate ID.");
                    }

                    break;

                // ================= UPDATE =================
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

                // ================= REMOVE =================
                case 3:

                    System.out.print("Enter Customer ID: ");
                    id = sc.nextLine();

                    if (customerManager.removeCustomer(id)) {
                        System.out.println("Remove Successfully!");
                    } else {
                        System.out.println("Customer Not Found!");
                    }

                    break;

                // ================= SEARCH =================
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

                // ================= DISPLAY =================
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
}
