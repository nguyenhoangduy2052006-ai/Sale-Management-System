package manager;

import model.voucher.Voucher;
import java.util.ArrayList;

public class VoucherManagement {

    // Encapsulation
    private ArrayList<Voucher> voucherList;

    // Constructor
    public VoucherManagement() {
        voucherList = new ArrayList<>();
    }

    // Thêm voucher
    public void addVoucher(Voucher voucher) {
        voucherList.add(voucher);
    }

    // Kiểm tra voucher tồn tại
    public boolean checkVoucher(String voucherCode) {

        for (Voucher voucher : voucherList) {

            if (voucher.getVoucherCode().equals(voucherCode)) {
                return true;
            }
        }

        return false;
    }

    // Đếm số lượng voucher
    public int countVoucher() {
        return voucherList.size();
    }

    // Hiển thị danh sách voucher
    public void displayVoucher() {

        for (Voucher voucher : voucherList) {

            System.out.println("Voucher Code: "
                    + voucher.getVoucherCode());

            System.out.println("Discount Value: "
                    + voucher.getDiscountValue());

            System.out.println("--------------------");
        }
    }

    // Getter
    public ArrayList<Voucher> getVoucherList() {
        return voucherList;
    }

    // Setter
    public void setVoucherList(ArrayList<Voucher> voucherList) {
        this.voucherList = voucherList;
    }
}
