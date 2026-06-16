package model.customer;

public class VipCustomer extends Customer {

    private double vipDiscount;

    public VipCustomer(String customerID, String customerName,
                       String phoneNumber, String address,
                       double totalPurchase,
                       double vipDiscount) {
        super(customerID, customerName, phoneNumber,
              address, totalPurchase);
        this.vipDiscount = vipDiscount;
    }

    public double getVipDiscount() {
        return vipDiscount;
    }

    public void setVipDiscount(double vipDiscount) {
        this.vipDiscount = vipDiscount;
    }
}
