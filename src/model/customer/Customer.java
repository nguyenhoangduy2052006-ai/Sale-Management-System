
package model.customer;

public class Customer {
        // Encapsulation: che giấu dữ liệu bằng private
    private String customerID;
    private String customerName;
    private String phoneNumber;
    private String address;
    private double totalPurchase;

    // Constructor
    public Customer(String customerID, String customerName,
                    String phoneNumber, String address) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.totalPurchase = 0.0;
    }

    // updateCustomerInfor()
    public void updateCustomerInfor(String newName,
                                    String newPhoneNumber,
                                    String newAddress) {
        this.customerName = newName;
        this.phoneNumber = newPhoneNumber;
        this.address = newAddress;
    }

    // changeName()
    public void changeName(String newName) {
        this.customerName = newName;
    }

    // changePhoneNumber()
    public void changePhoneNumber(String newPhoneNumber) {
        this.phoneNumber = newPhoneNumber;
    }

    // changeAddress()
    public void changeAddress(String newAddress) {
        this.address = newAddress;
    }

    // addPurchase()
    public void addPurchase(double amount) {
        if (amount > 0) {
            this.totalPurchase += amount;
        } else {
            System.out.println("Invalid Purchase Amount");
        }
    }

    // resetCustomerInfor()
    public void resetCustomerInfor() {
        this.customerName = "";
        this.phoneNumber = "";
        this.address = "";
        this.totalPurchase = 0.0;
    }

    // Getter methods
    public String getCustomerID() {
        return customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public double getTotalPurchase() {
        return totalPurchase;
    }
}

