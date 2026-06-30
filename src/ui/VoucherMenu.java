package ui;

import model.voucher.Voucher;
import manager.VoucherManager; // Import VoucherManager từ package manager sang

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class VoucherMenu {
    private final VoucherManager voucherManager;
    private final Scanner scanner;
    private final DateTimeFormatter formatter;

    public VoucherMenu(VoucherManager voucherManager) {
        this.voucherManager = voucherManager;
        this.scanner = new Scanner(System.in);
        this.formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Định dạng: Năm-Tháng-Ngày
    }

    public void showMenu() {
        int choice;
        do {
            System.out.println("\n==================================================");
            System.out.println("                VOUCHER MANAGEMENT");
            System.out.println("==================================================");
            System.out.println("1. Add New Voucher");
            System.out.println("2. Search Voucher by Code");
            System.out.println("3. Update Voucher Discount");
            System.out.println("4. Remove Voucher");
            System.out.println("5. Display All Vouchers");
            System.out.println("6. Display Valid Vouchers");
            System.out.println("7. Check Voucher Validity");
            System.out.println("0. Back to Main Menu");
            System.out.println("==================================================");
            System.out.print("Input your choice: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Clear buffer
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine(); // Clear buffer khi nhập lỗi
                choice = -1;
                continue;
            }

            switch (choice) {
                case 1:
                    addNewVoucher();
                    break;
                case 2:
                    searchVoucher();
                    break;
                case 3:
                    updateVoucher();
                    break;
                case 4:
                    removeVoucher();
                    break;
                case 5:
                    System.out.println("\n--- All Vouchers ---");
                    voucherManager.displayVouchers();
                    break;
                case 6:
                    System.out.println("\n--- Valid Vouchers ---");
                    voucherManager.displayValidVouchers();
                    break;
                case 7:
                    checkValidity();
                    break;
                case 0:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 0);
    }

    // 1. Hàm thêm mới Voucher
    private void addNewVoucher() {
        System.out.println("\n--- Add New Voucher ---");
        System.out.print("Enter Voucher ID: ");
        String id = scanner.nextLine().trim();
        System.out.print("Enter Voucher Code: ");
        String code = scanner.nextLine().trim();
        
        System.out.print("Enter Discount Value: ");
        double discount = 0;
        try {
            discount = scanner.nextDouble();
            scanner.nextLine(); // Clear buffer
        } catch (Exception e) {
            System.out.println("Invalid discount value!");
            scanner.nextLine();
            return;
        }

        System.out.print("Enter Expiry Date (yyyy-MM-dd): ");
        String dateStr = scanner.nextLine().trim();
        LocalDate expiryDate;
        try {
            expiryDate = LocalDate.parse(dateStr, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format! Use yyyy-MM-dd.");
            return;
        }

        System.out.print("Is Active? (true/false): ");
        boolean status = false;
        try {
            status = scanner.nextBoolean();
            scanner.nextLine(); // Clear buffer
        } catch (Exception e) {
            System.out.println("Invalid status! Defaulted to 'false'.");
            scanner.nextLine();
        }

        Voucher newVoucher = new Voucher(id, code, discount, expiryDate, status);
        if (voucherManager.addVoucher(newVoucher)) {
            System.out.println("Voucher added successfully!");
        } else {
            System.out.println("Failed to add! Duplicate ID or Code.");
        }
    }

    // 2. Tìm kiếm Voucher
    private void searchVoucher() {
        System.out.print("\nEnter Voucher Code to search: ");
        String code = scanner.nextLine().trim();
        Voucher v = voucherManager.searchVoucher(code);
        if (v != null) {
            System.out.println("Found: ID: " + v.getVoucherID() 
                    + " | Code: " + v.getVoucherCode() 
                    + " | Discount: " + v.getDiscountValue() 
                    + " | Expiry: " + v.getExpiryDate() 
                    + " | Status: " + (v.isStatus() ? "Active" : "Inactive"));
        } else {
            System.out.println("Voucher not found!");
        }
    }

    // 3. Cập nhật chiết khấu
    private void updateVoucher() {
        System.out.print("\nEnter Voucher Code to update: ");
        String code = scanner.nextLine().trim();
        System.out.print("Enter New Discount Value: ");
        double discount;
        try {
            discount = scanner.nextDouble();
            scanner.nextLine(); // Clear buffer
        } catch (Exception e) {
            System.out.println("Invalid value!");
            scanner.nextLine();
            return;
        }

        if (voucherManager.updateVoucher(code, discount)) {
            System.out.println("Voucher updated successfully!");
        } else {
            System.out.println("Update failed! Code not found or invalid discount.");
        }
    }

    // 4. Xóa Voucher
    private void removeVoucher() {
        System.out.print("\nEnter Voucher Code to remove: ");
        String code = scanner.nextLine().trim();
        if (voucherManager.removeVoucher(code)) {
            System.out.println("Voucher removed successfully!");
        } else {
            System.out.println("Remove failed! Voucher code does not exist.");
        }
    }

    // 7. Kiểm tra tính hợp lệ nhanh
    private void checkValidity() {
        System.out.print("\nEnter Voucher Code to check: ");
        String code = scanner.nextLine().trim();
        if (voucherManager.isVoucherValid(code)) {
            System.out.println("Status: VALID (Active and Unexpired)");
        } else {
            System.out.println("Status: INVALID (Expired, Inactive, or Does not exist)");
        }
    }
}
