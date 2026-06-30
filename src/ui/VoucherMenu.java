package ui;

import model.voucher.Voucher;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class VoucherMenu {

    private VoucherManager manager;
    private Scanner scanner;

    public VoucherMenu() {
        manager = new VoucherManager();
        scanner = new Scanner(System.in);
    }

    
    public void showMenu() {
        int choice = -1;
        do {
            System.out.println("\n========== VOUCHER MANAGEMENT SYSTEM ==========");
            System.out.println("1. Add a New Voucher");
            System.out.println("2. Search Voucher by Code");
            System.out.println("3. Update Voucher Discount Value");
            System.out.println("4. Remove a Voucher");
            System.out.println("5. Display All Vouchers");
            System.out.println("6. Display Valid Vouchers (Active & Unexpired)");
            System.out.println("7. Check if a Voucher is Valid");
            System.out.println("0. Exit");
            System.out.print("Enter your choice (0-7): ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        addVoucherMenu();
                        break;
                    case 2:
                        searchVoucherMenu();
                        break;
                    case 3:
                        updateVoucherMenu();
                        break;
                    case 4:
                        removeVoucherMenu();
                        break;
                    case 5:
                        manager.displayVouchers();
                        break;
                    case 6:
                        manager.displayValidVouchers();
                        break;
                    case 7:
                        checkVoucherValidityMenu();
                        break;
                    case 0:
                        System.out.println("Exiting system. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice! Please choose between 0 and 7.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number.");
            }
            System.out.println("-----------------------------------------------");
        } while (choice != 0);
    }

    
    private void addVoucherMenu() {
        System.out.println("\n--- Add New Voucher ---");
        System.out.print("Enter Voucher ID: ");
        String id = scanner.nextLine().trim();
        System.out.print("Enter Voucher Code: ");
        String code = scanner.nextLine().trim();

        double discount = -1;
        while (discount <= 0) {
            try {
                System.out.print("Enter Discount Value (> 0): ");
                discount = Double.parseDouble(scanner.nextLine());
                if (discount <= 0) System.out.println("Discount must be greater than 0.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format. Try again.");
            }
        }

        LocalDate expiryDate = null;
        while (expiryDate == null) {
            System.out.print("Enter Expiry Date (YYYY-MM-DD): ");
            String dateInput = scanner.nextLine().trim();
            try {
                expiryDate = LocalDate.parse(dateInput);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format! Please use YYYY-MM-DD.");
            }
        }

        System.out.print("Is Active? (true/false): ");
        boolean status = Boolean.parseBoolean(scanner.nextLine());

        
        Voucher newVoucher = new Voucher(id, code, discount, expiryDate, status);

        if (manager.addVoucher(newVoucher)) {
            System.out.println("Voucher added successfully!");
        } else {
            System.out.println("Failed to add! Voucher ID or Code already exists.");
        }
    }

    
    private void searchVoucherMenu() {
        System.out.println("\n--- Search Voucher ---");
        System.out.print("Enter Voucher Code to search: ");
        String code = scanner.nextLine().trim();
        
        Voucher v = manager.searchVoucher(code);
        if (v != null) {
            System.out.println("Voucher Found:");
            System.out.println("ID: " + v.getVoucherID() + " | Code: " + v.getVoucherCode() + " | Discount: " + v.getDiscountValue() + " | Expiry: " + v.getExpiryDate() + " | Status: " + (v.isStatus() ? "Active" : "Inactive"));
        } else {
            System.out.println("No voucher found with code: " + code);
        }
    }

   
    private void updateVoucherMenu() {
        System.out.println("\n--- Update Voucher Discount ---");
        System.out.print("Enter Voucher Code to update: ");
        String code = scanner.nextLine().trim();

        System.out.print("Enter New Discount Value: ");
        try {
            double newDiscount = Double.parseDouble(scanner.nextLine());
            if (manager.updateVoucher(code, newDiscount)) {
                System.out.println("Discount updated successfully!");
            } else {
                System.out.println("Update failed! Voucher not found or invalid discount value.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid discount format.");
        }
    }

    
    private void removeVoucherMenu() {
        System.out.println("\n--- Remove Voucher ---");
        System.out.print("Enter Voucher Code to remove: ");
        String code = scanner.nextLine().trim();

        if (manager.removeVoucher(code)) {
            System.out.println("Voucher removed successfully!");
        } else {
            System.out.println("Remove failed! Voucher code not found.");
        }
    }

    
    private void checkVoucherValidityMenu() {
        System.out.println("\n--- Check Voucher Validity ---");
        System.out.print("Enter Voucher Code to check: ");
        String code = scanner.nextLine().trim();

        if (manager.isVoucherValid(code)) {
            System.out.println("Result: This voucher is VALID and USABLE.");
        } else {
            System.out.println("Result: This voucher is INVALID (either expired, inactive, or does not exist).");
        }
    }
}
