package manager;

import model.customer.Customer;
import repository.CustomerRepository;
import java.util.ArrayList;
import java.util.Comparator;

public class CustomerManager {

    private ArrayList<Customer> customerList;
    private CustomerRepository repository; 

    public CustomerManager() {
        repository = new CustomerRepository(); 
        customerList = new ArrayList<>(); // Khởi tạo danh sách rỗng, dữ liệu sẽ được nạp thông qua Main
    }

    // 1. Thêm khách hàng mới
    public boolean addCustomer(Customer customer) {
        if (customer == null) return false;

        for (Customer c : customerList) {
            if (c.getCustomerID().equalsIgnoreCase(customer.getCustomerID())) {
                System.out.println("Duplicate ID! Cannot add customer.");
                return false;
            }
        }

        customerList.add(customer);
        // Đã bỏ dòng repository.save() tại đây để tối ưu hóa, dữ liệu sẽ lưu khi THOÁT ứng dụng
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

    // 3. Cập nhật thông tin khách hàng
    public boolean updateCustomer(String id, String name, String phone, String address) {
        Customer c = searchCustomer(id);

        if (c != null) {
            c.setCustomerName(name);
            c.setPhoneNumber(phone);
            c.setAddress(address);
            
            // Đã bỏ dòng repository.save() tại đây
            return true;
        }

        return false;
    }

    // 4. Xóa khách hàng
    public boolean removeCustomer(String id) {
        Customer c = searchCustomer(id);

        if (c != null) {
            customerList.remove(c);
            
            // Đã bỏ dòng repository.save() tại đây
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

        for (Customer c : customerList) {
            System.out.println(c);
            System.out.println("-------------------");
        }
    }

    // 6. Hiển thị top khách hàng mua nhiều nhất
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

    // ==================== ĐÃ ĐỒNG BỘ XUỐNG CUỐI: LOAD & SAVE DATA ====================

    // Nạp dữ liệu từ file txt vào danh sách customerList khi mở ứng dụng
    public void loadData() {
        this.customerList = repository.loadCustomers();
    }

    // Ghi đè toàn bộ danh sách customerList hiện tại xuống file txt khi tắt ứng dụng
    public void saveData() {
        repository.saveCustomers(this.customerList);
    }
}
