package repository;

import model.customer.Customer;
import util.FileUtils;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
    private static final String FILE_PATH = "data/customers.txt";

    // LOAD — đọc file tạo danh sách Customer
    public ArrayList<Customer> loadCustomers() {
        ArrayList<Customer> customerList = new ArrayList<>();
        List<String> lines = FileUtils.readLines(FILE_PATH);
        
        for (String line : lines) {
            try {
                if (line.trim().isEmpty()) continue; // bỏ qua dòng trống nếu có
                
                String[] parts = line.split("\\|");
                
                // Kiểm tra cấu trúc dòng có đủ dữ liệu không (ít nhất là 5 trường)
                if (parts.length >= 5) {
                    String id = parts[0].trim();
                    String name = parts[1].trim();
                    String phone = parts[2].trim();
                    String address = parts[3].trim();
                    double totalPurchase = Double.parseDouble(parts[4].trim());
                    
                    Customer customer = new Customer(id, name, phone, address, totalPurchase);
                    
                    if (customer != null) {
                        customerList.add(customer);
                    }
                }
            } 
            catch (Exception e) {
                System.out.println("Error parsing line: " + line + " - skipping");
            }
        }
        
        // === ĐỒNG BỘ: In thông báo số lượng customer giống hệt Voucher và Product ===
        System.out.println("Loaded " + customerList.size() + " customers.");
        
        return customerList;
    }

    // SAVE — convert danh sách Customer -> ghi xuống file
    public void saveCustomers(ArrayList<Customer> customerList) {
        List<String> lines = new ArrayList<>();
        
        for (Customer c : customerList) {
            // Convert toàn bộ thuộc tính đối tượng thành chuỗi text phân tách bằng dấu |
            String line = c.getCustomerID() + "|" +
                          c.getCustomerName() + "|" +
                          c.getPhoneNumber() + "|" +
                          c.getAddress() + "|" +
                          c.getTotalPurchase();

            lines.add(line);
        }
        
        FileUtils.writeLines(FILE_PATH, lines);
    }
}
