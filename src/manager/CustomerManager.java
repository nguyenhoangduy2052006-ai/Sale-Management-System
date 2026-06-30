package manager;

import model.customer.Customer;
import java.util.ArrayList;
import java.util.Comparator;

public class CustomerManager {

    private ArrayList<Customer> customerList;

    public CustomerManager() {
        customerList = new ArrayList<>();
    }

    // 1. Thêm khách hàng mới
    public boolean addCustomer(Customer customer) {
        if (customer == null) return false;

        // Kiểm tra trùng ID (Sử dụng getCustomerID() từ class Customer của bạn)
        for (Customer c : customerList) {
            if (c.getCustomerID().equalsIgnoreCase(customer.getCustomerID())) {
                System.out.println("Duplicate ID! Cannot add customer.");
                return false;
            }
        }

        customerList.add(customer);
        return true;
    }

    // 2. Tìm kiếm khách hàng theo ID
    public Customer searchCustomer(String id) {
        for (Customer c : customerList) {
            if (c.getCustomerID().equalsIgnoreCase(id)) {
                return c;
            }
        }
        return null;
    }

    // 3. Cập nhật thông tin khách hàng (Dùng các hàm set tương ứng từ class Customer)
    public boolean updateCustomer(String id, String name, String phone, String address) {
        Customer c = searchCustomer(id);

        if (c != null) {
            c.setCustomerName(name);
            c.setPhoneNumber(phone);
            c.setAddress(address);
            return true;
        }

        return false;
    }

    // 4. Xóa khách hàng
    public boolean removeCustomer(String id) {
        Customer c = searchCustomer(id);

        if (c != null) {
            customerList.remove(c);
            return true;
        }

        return false;
    }

    // 5. Hiển thị danh sách khách hàng
    public void displayCustomers() {
        if (customerList.isEmpty()) {
            System.out.println("No customer found!");
            return;
        }

        // Tự động gọi hàm toString() đã override trong class Customer của bạn
        for (Customer c : customerList) {
            System.out.println(c);
            System.out.println("-------------------");
        }
    }

    // 6. Hiển thị top khách hàng mua nhiều nhất (Sử dụng getTotalPurchase())
    public void displayTopCustomers(int topN) {
        if (customerList.isEmpty()) {
            System.out.println("No customer found!");
            return;
        }

        ArrayList<Customer> sortedList = new ArrayList<>(customerList);

        // Sắp xếp giảm dần theo tổng giá trị mua hàng
        sortedList.sort(new Comparator<Customer>() {
            @Override
            public int compare(Customer c1, Customer c2) {
                return Double.compare(c2.getTotalPurchase(), c1.getTotalPurchase());
            }
        });

        // In ra top N khách hàng
        for (int i = 0; i < topN && i < sortedList.size(); i++) {
            System.out.println(sortedList.get(i));
            System.out.println("-------------------");
        }
    }
}
