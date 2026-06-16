package ui; // Khai báo file nằm trong phân hệ UI hiển thị màn hình người dùng

import manager.SupplierManager; // Kết nối liên kết với lớp xử lý SupplierManager
import java.util.Scanner;

public class SupplierMenu {

    // Hàm điều phối nhận Scanner điều khiển hệ thống và thực thể quản lý supplierManager gốc
    public void displayMenu(Scanner scanner, SupplierManager supplierManager) {
        int choice;
        do {
            System.out.println("\n==================================");
            System.out.println("          SUPPLIER MENU           ");
            System.out.println("==================================");
            System.out.println("1. Add Supplier");
            System.out.println("2. Update Supplier");
            System.out.println("3. Delete Supplier");
            System.out.println("4. Search Supplier");
            System.out.println("5. Display Supplier");
            System.out.println("0. Back");
            System.out.println("==================================");
            System.out.print("Please enter your choice (0-5): ");

            // CƠ CHẾ BẮT LỖI NHẬP LIỆU: Tránh ứng dụng crash khi người dùng gõ nhầm chữ thay vì số
            try {
                // Đọc toàn bộ dòng dưới dạng chuỗi rồi ép kiểu về số nguyên int để triệt tiêu lỗi nuốt dòng của Scanner
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                // Nhảy vào đây nếu người dùng nhập chữ (ví dụ nhập "abc")
                System.out.println("Invalid choice! Please enter a number.");
                choice = -1; // Đặt giá trị mặc định sai để vòng lặp continue chạy lại màn hình nhập
                continue;
            }

            // Gọi các chức năng xử lý tương ứng từ lớp Manager dựa vào số đã chọn
            switch (choice) {
                case 1:
                    supplierManager.addSupplier(scanner);
                    break;
                case 2:
                    supplierManager.updateSupplier(scanner);
                    break;
                case 3:
                    supplierManager.deleteSupplier(scanner);
                    break;
                case 4:
                    supplierManager.searchSupplier(scanner);
                    break;
                case 5:
                    supplierManager.displaySupplier();
                    break;
                case 0:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 0); // Tiếp tục lặp lại bảng điều khiển nếu lựa chọn nhập vào khác số 0
    }
}