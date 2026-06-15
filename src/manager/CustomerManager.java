package manager;

import model.customer.Customer;
import java.util.ArrayList;

public class CustomerManagement {

    // Encapsulation
    private ArrayList<Customer> customerList;

    // Constructor
    public CustomerManagement() {
        customerList = new ArrayList<>();
    }

    // Thêm khách hàng
    public void addNewCustomer(Customer customer) {
        customerList.add(customer);
    }

    // Cập nhật thông tin khách hàng
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

    // Xóa khách hàng theo ID
    public void removeCustomer(String customerID) {

        for (int i = 0; i < customerList.size(); i++) {

            if (customerList.get(i).getCustomerID().equals(customerID)) {

                customerList.remove(i);
                break;
            }
        }
    }

    // Tìm khách hàng theo ID
    public Customer searchCustomerByID(String customerID) {

        for (Customer customer : customerList) {

            if (customer.getCustomerID().equals(customerID)) {
                return customer;
            }
        }

        return null;
    }

    // Hiển thị danh sách khách hàng
    public void listCustomer() {

        for (Customer customer : customerList) {

            System.out.println("ID: " + customer.getCustomerID());
            System.out.println("Name: " + customer.getCustomerName());
            System.out.println("Phone: " + customer.getPhoneNumber());
            System.out.println("Address: " + customer.getAddress());
            System.out.println("Total Purchase: " + customer.getTotalPurchase());

            System.out.println("--------------------");
        }
    }

    // Getter
    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    // Setter
    public void setCustomerList(ArrayList<Customer> customerList) {
        this.customerList = customerList;
    }
}
    }
}
