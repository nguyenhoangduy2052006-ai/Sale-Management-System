/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Nguyen Hoang Duy
 */
public class Customer {
    package entity;

public class Customer {

    // Attributes
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
        this.address = address;
        this.totalPurchase = 0.0;

        if (phoneNumber.matches("\\d{10}")) {
            this.phoneNumber = phoneNumber;
        } else {
            this.phoneNumber = "";
            System.out.println("Phone number must contain exactly 10 digits.");
        }
    }

    // Update all customer information
    public void updateCustomerInfor(String customerName,
                                    String phoneNumber,
                                    String address) {

        this.customerName = customerName;
        this.address = address;

        if (phoneNumber.matches("\\d{10}")) {
            this.phoneNumber = phoneNumber;
        } else {
            System.out.println("Phone number must contain exactly 10 digits.");
        }
    }

    // Change customer name
    public void changeName(String newName) {
        this.customerName = newName;
    }

    // Change phone number
    public void changePhoneNumber(String newPhoneNumber) {

        if (newPhoneNumber.matches("\\d{10}")) {
            this.phoneNumber = newPhoneNumber;
        } else {
            System.out.println("Phone number must contain exactly 10 digits.");
        }
    }

    // Change address
    public void changeAddress(String newAddress) {
        this.address = newAddress;
    }

    // Add purchase amount
    public void addPurchase(double amount) {
        if (amount > 0) {
            this.totalPurchase += amount;
        }
    }

    // Reset customer information
    public void resetCustomerInfor() {
        this.customerName = "";
        this.phoneNumber = "";
        this.address = "";
        this.totalPurchase = 0.0;
    }

    // Getters
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
    
}
