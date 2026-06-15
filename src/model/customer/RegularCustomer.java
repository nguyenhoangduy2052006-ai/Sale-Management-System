package model.customer;

public class RegularCustomer extends Customer {

    // Thuộc tính riêng của RegularCustomer
    private double regularDiscount;

    // Constructor
    public RegularCustomer(String customerID,
                           String customerName,
                           String phoneNumber,
                           String address,
                           double regularDiscount) {

        super(customerID, customerName, phoneNumber, address);
        this.regularDiscount = regularDiscount;
    }

    // Getter
    public double getRegularDiscount() {
        return regularDiscount;
    }

    // Setter
    public void setRegularDiscount(double regularDiscount) {
        this.regularDiscount = regularDiscount;
    }

    // Tính giảm giá
    public double calculateDiscount() {
        return getTotalPurchase() * regularDiscount;
    }
