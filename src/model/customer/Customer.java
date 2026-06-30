package model.customer;

public class Customer {

    protected String customerID;
    protected String customerName;
    protected String phoneNumber;
    protected String address;
    protected double totalPurchase;

    public Customer(String customerID, String customerName,
                    String phoneNumber, String address,
                    double totalPurchase) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.totalPurchase = totalPurchase;
    }

    public String getCustomerID() {
        return customerID;
    }

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

    @Override
    public String toString() {
        return "Customer ID: " + customerID +
               "\nCustomer Name: " + customerName +
               "\nPhone Number: " + phoneNumber +
               "\nAddress: " + address +
               "\nTotal Purchase: " + totalPurchase;
    }
}
