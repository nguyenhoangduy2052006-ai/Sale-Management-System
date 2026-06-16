package model.customer;

public class RegularCustomer extends Customer {

    private double regularDiscount;

    public RegularCustomer(String customerID, String customerName,
                           String phoneNumber, String address,
                           double totalPurchase,
                           double regularDiscount) {
        super(customerID, customerName, phoneNumber,
              address, totalPurchase);
        this.regularDiscount = regularDiscount;
    }

    public double getRegularDiscount() {
        return regularDiscount;
    }

    public void setRegularDiscount(double regularDiscount) {
        this.regularDiscount = regularDiscount;
    }
}
