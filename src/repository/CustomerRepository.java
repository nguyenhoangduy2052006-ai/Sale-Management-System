package repository;

import model.customer.Customer;
import util.FileUtils; // Sửa thành util (số ít, bỏ chữ s)
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
    private final String FILE_PATH = "customer.txt";

    /*
     * 1. HÀM LOAD: Đọc file thô -> Đúc thành Object -> Trả về cho CustomerManager
     */
    public ArrayList<Customer> load() {
        ArrayList<Customer> list = new ArrayList<>();
        List<String> lines = FileUtils.readLines(FILE_PATH); // Sửa thành readLines cho đúng với file FileUtils
        
        for (String line : lines) {
            String[] parts = line.split(",");
            
            // Kiểm tra cấu trúc dòng có đủ dữ liệu không (ít nhất là 5 trường)
            if (parts.length >= 5) {
                // Bám sát theo các trường bạn dùng trong Manager
                String id = parts[0].trim();
                String name = parts[1].trim();
                String phone = parts[2].trim();
                String address = parts[3].trim();
                double totalPurchase = Double.parseDouble(parts[4].trim());
                
                // Khởi tạo đối tượng Customer
                Customer customer = new Customer(id, name, phone, address, totalPurchase);
                
                list.add(customer);
            }
        }
        return list;
    }

    /**
     * 2. HÀM SAVE: Lấy danh sách từ CustomerManager -> Chuyển thành chuỗi -> Ghi xuống file .txt
     */
    public void save(ArrayList<Customer> list) {
        List<String> lines = new ArrayList<>();
        
        for (Customer c : list) {
            // Sử dụng CHÍNH XÁC các hàm getter có trong Customer của bạn
            // Bỏ các dấu chấm phẩy ở giữa dòng, chỉ để 1 dấu ở cuối câu lệnh nối chuỗi
            String line = c.getCustomerID() + "," +
                          c.getCustomerName() + "," +
                          c.getPhoneNumber() + "," +
                          c.getAddress() + "," +
                          c.getTotalPurchase();

            lines.add(line);
        }
        FileUtils.writeLines(FILE_PATH, lines); // Sửa thành writeLines cho đúng với file FileUtils
    }
}
