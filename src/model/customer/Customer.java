package model.customer;

public class Customer {

    private String customerID;
    private String customerName;
    private String phoneNumber;
    private String address;
    private double totalPurchase;

    public Customer(String customerID, String customerName,
                    String phoneNumber, String address,
                    double totalPurchase) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.totalPurchase = totalPurchase;
    }

    // Getter Customer ID
    public String getCustomerID() {
        return customerID;
    }

    // Không có setCustomerID()

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getTotalPurchase() {
        return totalPurchase;
    }

    public void setTotalPurchase(double totalPurchase) {
        this.totalPurchase = totalPurchase;
    }
}
