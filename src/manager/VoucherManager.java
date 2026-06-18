package manager;

import model.voucher.Voucher;
import java.util.ArrayList;

public class VoucherManager {

    private ArrayList<Voucher> voucherList;

    public VoucherManager() {
        voucherList = new ArrayList<>();
    }

    // Add
    public void addVoucher(Voucher voucher) {
        voucherList.add(voucher);
    }

    // Search
    public Voucher searchVoucher(String code) {
        for (Voucher v : voucherList) {
            if (v.getVoucherCode().equalsIgnoreCase(code)) {
                return v;
            }
        }
        return null;
    }

    // Update
    public boolean updateVoucher(String code, double discountValue) {
        Voucher v = searchVoucher(code);

        if (v != null) {

            if (discountValue >= 5) {
                v.setDiscountValue(discountValue);
                return true;
            }

        }

        return false;
    }

    // Remove
    public boolean removeVoucher(String code) {
        Voucher v = searchVoucher(code);

        if (v != null) {
            voucherList.remove(v);
            return true;
        }

        return false;
    }

    // Display
    public void displayVouchers() {
        for (Voucher v : voucherList) {
            System.out.println(v);
        }
    }
}
