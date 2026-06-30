package ui;

import java.util.Scanner;
import manager.VoucherManager;
import model.voucher.Voucher;

public class VoucherMenu {

    private VoucherManager voucherManager;
    private  Scanner sc;

    public VoucherMenu(VoucherManager voucherManager) {
        voucherManager = new VoucherManager();
        sc = new Scanner(System.in);
    }

    public void showMenu() {
        int choice;

        do {
            System.out.println("\n===== VOUCHER MENU =====");
            System.out.println("1. Add Voucher");
            System.out.println("2. Update Voucher");
            System.out.println("3. Remove Voucher");
            System.out.println("4. Search Voucher");
            System.out.println("5. Display Vouchers");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    System.out.print("Enter Voucher ID: ");
                    String id = sc.nextLine();

                    System.out.print("Enter Voucher Code: ");
                    String code = sc.nextLine();

                    System.out.print("Enter Discount Value: ");
                    double discount = Double.parseDouble(sc.nextLine());

                    System.out.print("Enter Expiry Date: ");
                    String expiryDate = sc.nextLine();

                    System.out.print("Enter Status (true/false): ");
                    boolean status = Boolean.parseBoolean(sc.nextLine());

                    Voucher voucher = new Voucher(
                            id,
                            code,
                            discount,
                            expiryDate,
                            status
                    );

                    voucherManager.addVoucher(voucher);
                    System.out.println("Add Voucher Successfully!");
                    break;

                case 2:
                    System.out.print("Enter Voucher Code: ");
                    code = sc.nextLine();

                    System.out.print("Enter New Discount Value: ");
                    discount = Double.parseDouble(sc.nextLine());

                    if (voucherManager.updateVoucher(code, discount)) {
                        System.out.println("Update Successfully!");
                    } else {
                        System.out.println("Voucher Not Found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Voucher Code: ");
                    code = sc.nextLine();

                    if (voucherManager.removeVoucher(code)) {
                        System.out.println("Remove Successfully!");
                    } else {
                        System.out.println("Voucher Not Found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Voucher Code: ");
                    code = sc.nextLine();

                    Voucher v = voucherManager.searchVoucher(code);

                    if (v != null) {
                        System.out.println(v);
                    } else {
                        System.out.println("Voucher Not Found!");
                    }
                    break;

                case 5:
                    voucherManager.displayVouchers();
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


