package model.voucher;

public class Voucher {

    private String voucherCode;
    private String discountType;
    private double discountValue;
    private String voucherStartDate;
    private String voucherEndDate;
    private int usageLimit;
    private boolean voucherStatus;

    // Constructor
    public Voucher(String voucherCode, String discountType,
                   double discountValue, String voucherStartDate,
                   String voucherEndDate, int usageLimit,
                   boolean voucherStatus) {

        this.voucherCode = voucherCode;
        this.discountType = discountType;
        this.discountValue = discountValue;
        this.voucherStartDate = voucherStartDate;
        this.voucherEndDate = voucherEndDate;
        this.usageLimit = usageLimit;
        this.voucherStatus = voucherStatus;
    }

    // Getter & Setter
    public String getVoucherCode() {
        return voucherCode;
    }

    public void setVoucherCode(String voucherCode) {
        this.voucherCode = voucherCode;
    }

    public double getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(double discountValue) {
        this.discountValue = discountValue;
    }

    // Kiểm tra voucher còn hiệu lực
    public boolean validateVoucher() {
        return voucherStatus;
    }

    // Tính số tiền được giảm
    public double applyDiscount(double totalAmount) {
        return totalAmount * discountValue / 100;
    }
}
