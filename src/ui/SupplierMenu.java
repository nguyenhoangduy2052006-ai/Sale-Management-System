package ui;

import manager.SupplierManager;
import model.supplier.Supplier;
import java.util.ArrayList;
import java.util.Scanner;

public class SupplierMenu {

    private SupplierManager supplierManager;
    private Scanner scanner;

    public SupplierMenu(SupplierManager supplierManager) {
        this.supplierManager = supplierManager;
        this.scanner = new Scanner(System.in);
    }

    // Hàm điều phối chính của Menu Nhà cung cấp
    public void showMenu() {
        int choice;
        do {
            System.out.println("\n==================================");
            System.out.println("          SUPPLIER MENU           ");
            System.out.println("==================================");
            System.out.println("1. Add Supplier");
            System.out.println("2. Update Supplier");
            System.out.println("3. Delete Supplier");
            System.out.println("4. Search Supplier");
            System.out.println("5. Display Supplier");
            System.out.println("0. Back");
            System.out.println("==================================");
            System.out.print("Please enter your choice (0-5): ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice! Please enter a number.");
                choice = -1;
                continue;
            }

            switch (choice) {
                case 1:
                    addSupplierUI();
                    break;
                case 2:
                    updateSupplierUI();
                    break;
                case 3:
                    deleteSupplierUI();
                    break;
                case 4:
                    searchSupplierUI();
                    break;
                case 5:
                    displaySupplierUI();
                    break;
                case 0:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 0);
    }

    private void addSupplierUI() {
        System.out.println("\n--- Add New Supplier ---");
        System.out.print("Enter Supplier ID: ");
        String supplierID = scanner.nextLine().trim();

        if (supplierManager.findSupplier(supplierID) != null) {
            System.out.println("Error: Supplier ID already exists!");
            return;
        }

        System.out.print("Enter Supplier Name: ");
        String supplierName = scanner.nextLine().trim();
        System.out.print("Enter Contact Name: ");
        String contactName = scanner.nextLine().trim();
        System.out.print("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine().trim();

        Supplier newSupplier = new Supplier(supplierID, supplierName, contactName, phoneNumber);
        if (supplierManager.addSupplier(newSupplier)) {
            System.out.println("Supplier added successfully!");
        } else {
            System.out.println("Error: Add supplier failed!");
        }
    }

    private void updateSupplierUI() {
        System.out.println("\n--- Update Supplier ---");
        System.out.print("Enter Supplier ID to update: ");
        String supplierID = scanner.nextLine().trim();

        Supplier supplier = supplierManager.findSupplier(supplierID);
        if (supplier == null) {
            System.out.println("Error: Supplier not found!");
            return;
        }

        System.out.print("Enter New Supplier Name (Current: " + supplier.getSupplierName() + "): ");
        String newName = scanner.nextLine().trim();
        if (newName.isEmpty()) {
            newName = supplier.getSupplierName();
        }

        System.out.print("Enter New Contact Name (Current: " + supplier.getContactName() + "): ");
        String newContact = scanner.nextLine().trim();
        if (newContact.isEmpty()) {
            newContact = supplier.getContactName();
        }

        System.out.print("Enter New Phone Number (Current: " + supplier.getPhoneNumber() + "): ");
        String newPhone = scanner.nextLine().trim();
        if (newPhone.isEmpty()) {
            newPhone = supplier.getPhoneNumber();
        }

        if (supplierManager.updateSupplier(supplierID, newName, newContact, newPhone)) {
            System.out.println("Supplier updated successfully!");
        } else {
            System.out.println("Error: Update failed!");
        }
    }

    private void deleteSupplierUI() {
        System.out.println("\n--- Delete Supplier ---");
        System.out.print("Enter Supplier ID to delete: ");
        String supplierID = scanner.nextLine().trim();

        if (supplierManager.deleteSupplier(supplierID)) {
            System.out.println("Supplier deleted successfully!");
        } else {
            System.out.println("Error: Supplier not found!");
        }
    }

    private void searchSupplierUI() {
        System.out.println("\n--- Search Supplier ---");
        System.out.print("Enter Keyword (ID or Name) to search: ");
        String keyword = scanner.nextLine().trim();

        ArrayList<Supplier> results = supplierManager.searchSupplier(keyword);

        if (results.isEmpty()) {
            System.out.println("No matching supplier found.");
        } else {

            for (Supplier s : results) {
                System.out.println(s.toString());
            }
        }
    }

    private void displaySupplierUI() {
        System.out.println("\n--- Supplier List ---");
        ArrayList<Supplier> list = supplierManager.getListSupplier();

        if (list.isEmpty()) {
            System.out.println("No suppliers available.");
            return;
        }

        System.out.println("-------------------------------------------------------------------------------------");
        System.out.printf("| %-12s | %-25s | %-20s | %-15s |\n", "Supplier ID", "Supplier Name", "Contact Name", "Phone Number");
        System.out.println("-------------------------------------------------------------------------------------");
        for (Supplier s : list) {
            System.out.println(s.toString());
        }
        System.out.println("-------------------------------------------------------------------------------------");
    }
}
