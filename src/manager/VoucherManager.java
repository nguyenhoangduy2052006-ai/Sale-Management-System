package manager;

import model.voucher.Voucher;
import java.time.LocalDate;
import java.util.ArrayList;

// 👉 CHỈ THÊM IMPORT NÀY
import java.io.*;

public class VoucherManager {

    private ArrayList<Voucher> voucherList;

    public VoucherManager() {
        voucherList = new ArrayList<>();
    }

    // Add voucher (check trùng ID hoặc Code)
    public boolean addVoucher(Voucher voucher) {
        for (Voucher v : voucherList) {
            if (v.getVoucherID().equalsIgnoreCase(voucher.getVoucherID())
                    || v.getVoucherCode().equalsIgnoreCase(voucher.getVoucherCode())) {
                return false;
            }
        }
        voucherList.add(voucher);
        return true;
    }

    // Search by code
    public Voucher searchVoucher(String code) {
        for (Voucher v : voucherList) {
            if (v.getVoucherCode().equalsIgnoreCase(code)) {
                return v;
            }
        }
        return null;
    }

    // Update discount
    public boolean updateVoucher(String code, double discountValue) {
        Voucher v = searchVoucher(code);
        if (v != null && discountValue > 0) {
            v.setDiscountValue(discountValue);
            return true;
        }
        return false;
    }

    // Remove voucher
    public boolean removeVoucher(String code) {
        Voucher v = searchVoucher(code);
        if (v != null) {
            voucherList.remove(v);
            return true;
        }
        return false;
    }

    // Display all vouchers
    public void displayVouchers() {
        if (voucherList.isEmpty()) {
            System.out.println("Voucher list is empty!");
            return;
        }

        for (Voucher v : voucherList) {
            System.out.println(
                    "ID: " + v.getVoucherID()
                    + " | Code: " + v.getVoucherCode()
                    + " | Discount: " + v.getDiscountValue()
                    + " | Expiry: " + v.getExpiryDate()
                    + " | Status: " + (v.isStatus() ? "Active" : "Inactive")
            );
        }
    }

    // Display valid vouchers
    public void displayValidVouchers() {
        LocalDate today = LocalDate.now();
        boolean hasValid = false;

        for (Voucher v : voucherList) {
            if (v.isStatus()
                    && v.getExpiryDate() != null
                    && !v.getExpiryDate().isBefore(today)) {

                System.out.println(
                        "ID: " + v.getVoucherID()
                        + " | Code: " + v.getVoucherCode()
                        + " | Expiry: " + v.getExpiryDate()
                );

                hasValid = true;
            }
        }

        if (!hasValid) {
            System.out.println("No valid vouchers available.");
        }
    }

    // Check validity
    public boolean isVoucherValid(String code) {
        Voucher v = searchVoucher(code);
        if (v == null || v.getExpiryDate() == null) {
            return false;
        }

        LocalDate today = LocalDate.now();

        return v.isStatus()
                && !v.getExpiryDate().isBefore(today);
    }

    // =========================
    // ✅ FILE I/O - SAVE (ONLY ADD)
    // =========================
    public void saveToFile(String filename) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename));

            for (Voucher v : voucherList) {
                bw.write(v.getVoucherID() + ","
                        + v.getVoucherCode() + ","
                        + v.getDiscountValue() + ","
                        + v.getExpiryDate() + ","
                        + v.isStatus());
                bw.newLine();
            }

            bw.close();
            System.out.println("Save file success!");

        } catch (IOException e) {
            System.out.println("Save file error!");
        }
    }

    // =========================
    // ✅ FILE I/O - LOAD (ONLY ADD)
    // =========================
    public void loadFromFile(String filename) {
        try {
            File file = new File(filename);

            if (!file.exists()) {
                System.out.println("File not found!");
                return;
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {

                String[] p = line.split(",");

                // CHỈ SỬA KHÚC NÀY: Ép kiểu p[3] từ String sang LocalDate
                Voucher v = new Voucher(
                        p[0],
                        p[1],
                        Double.parseDouble(p[2]),
                        LocalDate.parse(p[3]), 
                        Boolean.parseBoolean(p[4])
                );

                voucherList.add(v);
            }

            br.close();
            System.out.println("Load file success!");

        } catch (Exception e) {
            System.out.println("Load file error!");
        }
    }
}
