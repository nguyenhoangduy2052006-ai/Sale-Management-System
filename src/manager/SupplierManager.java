package manager; // Khai báo vị trí tệp nằm trong gói quản lý nghiệp vụ chung

import model.supplier.Supplier; // Nhập dữ liệu khuôn mẫu từ gói model.supplier
import java.util.ArrayList;
import java.util.Scanner;

// Lớp xử lý toàn bộ logic CRUD lưu trữ dữ liệu của Nhà cung cấp
public class SupplierManager {
    // Khai báo mảng động đúng tên biến listSupplier như trong hình ảnh thiết kế của ông
    private ArrayList<Supplier> listSupplier = new ArrayList<>();

    // 1. CHỨC NĂNG THÊM MỚI (Nhập trực tiếp từ Scanner)
    public void addSupplier(Scanner scanner) {
        System.out.println("\n--- Add New Supplier ---");
        System.out.print("Enter Supplier ID: ");
        String supplierID = scanner.nextLine().trim(); // Nhập và dùng .trim() để cắt bỏ khoảng trắng thừa ở 2 đầu chuỗi

        // Kiểm tra trùng lặp mã nhà cung cấp trong danh sách bằng hàm getSupplierID()
        for (Supplier s : listSupplier) {
            if (s.getSupplierID().equalsIgnoreCase(supplierID)) {
                System.out.println("Error: Supplier ID already exists!");
                return; // Kết thúc hàm sớm nếu bị trùng, chặn không cho chạy tiếp xuống dưới
            }
        }

        System.out.print("Enter Supplier Name: ");
        String supplierName = scanner.nextLine().trim();
        System.out.print("Enter Contact Name: ");
        String contactName = scanner.nextLine().trim();
        System.out.print("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine().trim();

        // Tạo mới thực thể Supplier và đưa trực tiếp vào ArrayList
        Supplier newSupplier = new Supplier(supplierID, supplierName, contactName, phoneNumber);
        listSupplier.add(newSupplier);
        System.out.println("Supplier added successfully!");
    }

    // 2. CHỨC NĂNG CẬP NHẬT THÔNG TIN NHÀ CUNG CẤP
    public void updateSupplier(Scanner scanner) {
        System.out.println("\n--- Update Supplier ---");
        System.out.print("Enter Supplier ID to update: ");
        String supplierID = scanner.nextLine().trim();

        Supplier supplier = null; // Khởi tạo biến lính canh tạm thời bằng null
        for (Supplier s : listSupplier) {
            if (s.getSupplierID().equalsIgnoreCase(supplierID)) {
                supplier = s; // Gán đối tượng tìm thấy vào biến tạm
                break;        // Tìm thấy rồi thì ngắt vòng lặp ngay lập tức để tiết kiệm bộ nhớ
            }
        }

        // Báo lỗi nếu kết thúc vòng lặp mà biến tạm vẫn bằng null
        if (supplier == null) {
            System.out.println("Error: Supplier not found!");
            return;
        }

        // XỬ LÝ NHẬP THÔNG TIN MỚI THÔNG MINH: Nếu nhấn Enter bỏ trống -> Giữ nguyên giá trị cũ
        System.out.print("Enter New Supplier Name (Current: " + supplier.getSupplierName() + "): ");
        String newName = scanner.nextLine().trim();
        if (!newName.isEmpty()) { // Kiểm tra người dùng có gõ chữ hay không (không rỗng mới cập nhật)
            supplier.setSupplierName(newName);
        }

        System.out.print("Enter New Contact Name (Current: " + supplier.getContactName() + "): ");
        String newContact = scanner.nextLine().trim();
        if (!newContact.isEmpty()) {
            supplier.setContactName(newContact);
        }

        System.out.print("Enter New Phone Number (Current: " + supplier.getPhoneNumber() + "): ");
        String newPhone = scanner.nextLine().trim();
        if (!newPhone.isEmpty()) {
            supplier.setPhoneNumber(newPhone);
        }

        System.out.println("Supplier updated successfully!");
    }

    // 3. CHỨC NĂNG XÓA BỎ NHÀ CUNG CẤP
    public void deleteSupplier(Scanner scanner) {
        System.out.println("\n--- Delete Supplier ---");
        System.out.print("Enter Supplier ID to delete: ");
        String supplierID = scanner.nextLine().trim();

        // Sử dụng biến chạy index để thực hiện xóa khỏi ArrayList
        for (int i = 0; i < listSupplier.size(); i++) {
            if (listSupplier.get(i).getSupplierID().equalsIgnoreCase(supplierID)) {
                listSupplier.remove(i); // Xóa bản ghi
                System.out.println("Supplier deleted successfully!");
                return; // Đã xóa xong thì dừng luôn hàm
            }
        }
        System.out.println("Error: Supplier not found!");
    }

    // 4. CHỨC NĂNG TÌM KIẾM THEO TỪ KHÓA (ID hoặc Tên)
    public void searchSupplier(Scanner scanner) {
        System.out.println("\n--- Search Supplier ---");
        System.out.print("Enter Keyword (ID or Name) to search: ");
        String keyword = scanner.nextLine().trim().toLowerCase(); // Đưa hết từ khóa về chữ thường

        boolean found = false; // Đặt cờ hiệu báo trạng thái tìm kiếm
        for (Supplier s : listSupplier) {
            // Kiểm tra từ khóa xuất hiện trong chuỗi ID hoặc chuỗi Tên Nhà cung cấp
            if (s.getSupplierID().toLowerCase().contains(keyword) || 
                s.getSupplierName().toLowerCase().contains(keyword)) {
                System.out.println(s.toString()); // Xuất thông tin dòng dữ liệu tìm thấy
                found = true; // Bật cờ hiệu lên true
            }
        }

        if (!found) { // Nếu quét hết danh sách mà cờ vẫn false
            System.out.println("No matching supplier found.");
        }
    }

    // 5. CHỨC NĂNG XUẤT TOÀN BỘ DANH BẠ NHÀ CUNG CẤP
    public void displaySupplier() {
        System.out.println("\n--- Supplier List ---");
        if (listSupplier.isEmpty()) {
            System.out.println("No suppliers available.");
            return;
        }
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.printf("| %-12s | %-25s | %-20s | %-15s |\n", "Supplier ID", "Supplier Name", "Contact Name", "Phone Number");
        System.out.println("-------------------------------------------------------------------------------------");
        for (Supplier s : listSupplier) {
            System.out.println(s.toString());
        }
        System.out.println("-------------------------------------------------------------------------------------");
    }
}