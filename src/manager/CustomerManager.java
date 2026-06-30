package manager;

import model.customer.Customer;
import java.util.ArrayList;
import java.util.Comparator;

public class CustomerManager {

    private ArrayList<Customer> customerList;

    public CustomerManager() {
        customerList = new ArrayList<>();
    }

    public boolean addCustomer(Customer customer) {

        if (customer == null) return false;

        for (Customer c : customerList) {
            if (c.getCustomerID().equalsIgnoreCase(customer.getCustomerID())) {
                System.out.println("Duplicate ID! Cannot add customer.");
                return false;
            }
        }

        customerList.add(customer);
        return true;
    }

    
    public Customer searchCustomer(String id) {

        for (Customer c : customerList) {
            if (c.getCustomerID().equalsIgnoreCase(id)) {
                return c;
            }
        }
        return null;
    }

  
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

    
    public boolean removeCustomer(String id) {

        Customer c = searchCustomer(id);

        if (c != null) {
            customerList.remove(c);
            return true;
        }

        return false;
    }

    
    public void displayCustomers() {

        if (customerList.isEmpty()) {
            System.out.println("No customer found!");
            return;
        }

        for (Customer c : customerList) {
            System.out.println(c);
            System.out.println("-------------------");
        }
    }

    
    public void displayTopCustomers(int topN) {

        if (customerList.isEmpty()) {
            System.out.println("No customer found!");
            return;
        }

        ArrayList<Customer> sortedList = new ArrayList<>(customerList);

        sortedList.sort(new Comparator<Customer>() {
            @Override
            public int compare(Customer c1, Customer c2) {
                return Double.compare(c2.getTotalPurchase(), c1.getTotalPurchase());
            }
        });

        for (int i = 0; i < topN && i < sortedList.size(); i++) {
            System.out.println(sortedList.get(i));
            System.out.println("-------------------");
        }
    }
} 
