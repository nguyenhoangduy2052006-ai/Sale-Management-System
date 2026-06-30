package model.customer;

public class VipCustomer extends Customer {

    private double vipDiscount;
    private String vipLevel;

    public VipCustomer(String customerID, String customerName,
                       String phoneNumber, String address,
                       double totalPurchase,
                       double vipDiscount,
                       String vipLevel) {
        super(customerID, customerName, phoneNumber, address, totalPurchase);
        this.vipDiscount = vipDiscount;
        this.vipLevel = vipLevel;
    }

    public double getVipDiscount() {
        return vipDiscount;
    }

    public void setVipDiscount(double vipDiscount) {
        this.vipDiscount = vipDiscount;
    }

    public String getVipLevel() {
        return vipLevel;
    }

    public void setVipLevel(String vipLevel) {
        this.vipLevel = vipLevel;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nCustomer Type: VIP"
                + "\nVIP Discount: " + vipDiscount
                + "\nVIP Level: " + vipLevel;
    }
}
