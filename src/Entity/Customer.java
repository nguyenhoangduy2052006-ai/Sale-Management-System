package entity;

public class Main {

    public static void main(String[] args) {

        Customer customer = new Customer(
                "C003",
                "Thi",
                "036420554",
                "Ho Chi Minh City"
        );

        customer.changeName("Lien");
        customer.addPurchase(500000);

        System.out.println("ID: " + customer.getCustomerID());
        System.out.println("Name: " + customer.getCustomerName());
        System.out.println("Phone: " + customer.getPhoneNumber());
        System.out.println("Address: " + customer.getAddress());
        System.out.println("Total Purchase: " + customer.getTotalPurchase());
    }
}
