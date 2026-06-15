package model.customer;

public class VipCustomer extends Customer {

    // Thuộc tính riêng của khách hàng VIP
    private double vipDiscount;

    // Constructor
    public VipCustomer(String customerID,
                       String customerName,
                       String phoneNumber,
                       String address,
                       double vipDiscount) {

        super(customerID, customerName, phoneNumber, address);
        this.vipDiscount = vipDiscount;
    }

    // Getter
    public double getVipDiscount() {
        return vipDiscount;
    }

    // Setter
    public void setVipDiscount(double vipDiscount) {
        this.vipDiscount = vipDiscount;
    }

    // Tính số tiền giảm giá
    public double calculateDiscount() {
        return getTotalPurchase() * vipDiscount;
    }
}
