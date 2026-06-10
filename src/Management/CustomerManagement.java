// Lớp này thuộc package management
package management;

// Import lớp Customer từ package entity
import entity.Customer;

// Import ArrayList để lưu danh sách khách hàng
import java.util.ArrayList;

// Khai báo lớp CustomerManagement
public class CustomerManagement {

    // Thuộc tính private để thể hiện tính đóng gói
    // Danh sách chứa nhiều đối tượng Customer
    private ArrayList<Customer> customerList;

    // Constructor
    // Được gọi khi tạo đối tượng CustomerManagement
    public CustomerManagement() {

        // Khởi tạo danh sách rỗng
        customerList = new ArrayList<>();
    }

    // Thêm khách hàng mới vào danh sách
    public void addNewCustomer(Customer customer) {

        // Thêm đối tượng Customer vào ArrayList
        customerList.add(customer);
    }

    // Cập nhật thông tin khách hàng
    public void updateCustomerInfor(String customerID,
                                    String name,
                                    String phone,
                                    String address) {

        // Duyệt toàn bộ danh sách khách hàng
        for (Customer customer : customerList) {

            // Kiểm tra ID có trùng không
            if (customer.getCustomerID().equals(customerID)) {

                // Gọi phương thức updateCustomerInfor()
                // của lớp Customer để cập nhật dữ liệu
                customer.updateCustomerInfor(
                        name,
                        phone,
                        address
                );
            }
        }
    }

    // Xóa khách hàng theo ID
    public void removeCustomer(String customerID) {

        // Duyệt danh sách khách hàng
        for (Customer customer : customerList) {

            // Nếu tìm thấy khách hàng có ID tương ứng
            if (customer.getCustomerID().equals(customerID)) {

                // Xóa khách hàng khỏi danh sách
                customerList.remove(customer);

                // Dừng vòng lặp sau khi xóa
                break;
            }
        }
    }

    // Tìm khách hàng theo ID
    public Customer searchCustomerByID(String customerID) {

        // Duyệt danh sách khách hàng
        for (Customer customer : customerList) {

            // Nếu ID trùng khớp
            if (customer.getCustomerID().equals(customerID)) {

                // Trả về khách hàng tìm được
                return customer;
            }
        }

        // Không tìm thấy thì trả về null
        return null;
    }

    // Hiển thị danh sách khách hàng
    public void listCustomer() {

        // Duyệt tất cả khách hàng trong danh sách
        for (Customer customer : customerList) {

            // Hiển thị mã khách hàng
            System.out.println(customer.getCustomerID());

            // Hiển thị tên khách hàng
            System.out.println(customer.getCustomerName());

            // Hiển thị số điện thoại
            System.out.println(customer.getPhoneNumber());

            // Hiển thị địa chỉ
            System.out.println(customer.getAddress());

            // Hiển thị tổng tiền mua hàng
            System.out.println(customer.getTotalPurchase());
        }
    }
}
