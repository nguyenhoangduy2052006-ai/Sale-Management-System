package manager;

import model.voucher.Voucher;
import repository.VoucherRepository; // Import repository để kết nối file
import java.time.LocalDate;
import java.util.ArrayList;

public class VoucherManager {

    private ArrayList<Voucher> voucherList;
    // Khai báo đối tượng repository để phục vụ việc đọc/ghi file txt
    private VoucherRepository voucherRepository;

    public VoucherManager() {
        voucherList = new ArrayList<>();
        voucherRepository = new VoucherRepository(); // Khởi tạo repository
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

    // ==================== ĐÃ CHUYỂN XUỐNG CUỐI: LOAD & SAVE DATA ====================

    // Nạp dữ liệu từ file txt vào danh sách voucherList khi mở ứng dụng
    public void loadData() {
        this.voucherList = voucherRepository.loadVouchers();
    }

    // Ghi đè toàn bộ danh sách voucherList hiện tại xuống file txt khi tắt ứng dụng
    public void saveData() {
        voucherRepository.saveVouchers(this.voucherList);
    }
}
