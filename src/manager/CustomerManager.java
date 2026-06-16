package manager;

import model.customer.Customer;
import java.util.ArrayList;

public class CustomerManager {

    private ArrayList<Customer> customerList;

    public CustomerManager() {
        customerList = new ArrayList<>();
    }

    // Add
    public void addCustomer(Customer customer) {
        try {
            customerList.add(customer);
        } catch (Exception e) {
            System.out.println("Add customer failed!");
        }
    }

    // Search
    public Customer searchCustomer(String id) {
        for (Customer c : customerList) {
            if (c.getCustomerID().equalsIgnoreCase(id)) {
                return c;
            }
        }
        return null;
    }

    // Update
    public boolean updateCustomer(String id, String name,
                                  String phone, String address) {
        Customer c = searchCustomer(id);

        if (c != null) {
            c.setCustomerName(name);
            c.setPhoneNumber(phone);
            c.setAddress(address);
            return true;
        }

        return false;
    }

    // Remove
    public boolean removeCustomer(String id) {
        Customer c = searchCustomer(id);

        if (c != null) {
            try {
                return customerList.remove(c);
            } catch (Exception e) {
                System.out.println("Remove customer failed!");
            }
        }

        return false;
    }

    // Display
    public void displayCustomers() {
        for (Customer c : customerList) {
            System.out.println(c);
        }
    }
}
