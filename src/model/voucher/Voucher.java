package model.voucher;

public class Voucher {

    private String voucherID;
    private String voucherCode;
    private double discountValue;
    private String expiryDate;
    private boolean status;

    public Voucher(String voucherID, String voucherCode,
                   double discountValue, String expiryDate,
                   boolean status) {
        this.voucherID = voucherID;
        this.voucherCode = voucherCode;
        this.discountValue = discountValue;
        this.expiryDate = expiryDate;
        this.status = status;
    }

    public String getVoucherID() {
        return voucherID;
    }

    public void setVoucherID(String voucherID) {
        this.voucherID = voucherID;
    }

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

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}

