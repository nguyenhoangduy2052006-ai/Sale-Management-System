/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management;

/**
 *
 * @author Nguyen Hoang Duy
 */
public class CustomerManagement {

    private ArrayList<Customer> customerList;

    public CustomerManager() {
        customerList = new ArrayList<>();
    }

    // Add new customer
    public void addNewCustomer(Customer customer) {
        customerList.add(customer);
    }

    // Update customer information
    public void updateCustomerInfor(String customerID,
                                    String name,
                                    String phone,
                                    String address) {

        for (Customer customer : customerList) {

            if (customer.getCustomerID().equals(customerID)) {

                customer.updateCustomerInfor(
                        name,
                        phone,
                        address
                );

                break;
            }
        }
    }

    // Remove customer
    public void removeCustomerInfor(String customerID) {

        for (int i = 0; i < customerList.size(); i++) {

            if (customerList.get(i)
                    .getCustomerID()
                    .equals(customerID)) {

                customerList.remove(i);
                break;
            }
        }
    }

    // List all customers
    public void listCustomer() {

        for (Customer customer : customerList) {

            System.out.println("ID: "
                    + customer.getCustomerID());

            System.out.println("Name: "
                    + customer.getCustomerName());

            System.out.println("Phone: "
                    + customer.getPhoneNumber());

            System.out.println("Address: "
                    + customer.getAddress());

            System.out.println("Total Purchase: "
                    + customer.getTotalPurchase());

            System.out.println();
        }
    }

    // Search customer by name
    public void searchCustomerByName(String name) {

        for (Customer customer : customerList) {

            if (customer.getCustomerName()
                    .equalsIgnoreCase(name)) {

                System.out.println("ID: "
                        + customer.getCustomerID());

                System.out.println("Name: "
                        + customer.getCustomerName());

                System.out.println("Phone: "
                        + customer.getPhoneNumber());

                System.out.println("Address: "
                        + customer.getAddress());

                System.out.println("Total Purchase: "
                        + customer.getTotalPurchase());
            }
        }
    }
}
    
}
