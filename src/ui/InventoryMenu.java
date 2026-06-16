package ui; // Khai báo gói giao diện người dùng

import model.inventory.Inventory;
import manager.InventoryManager;
import java.util.ArrayList;
import java.util.Scanner;

// Lớp hiển thị giao diện Menu Console điều khiển phân hệ Kho hàng
public class InventoryMenu {
    // Hàm nhận vào Scanner từ Main và đối tượng quản lý dữ liệu gốc invMgr
    public void displayMenu(Scanner sc, InventoryManager invMgr) {
        int choice; // Biến lưu lựa chọn của người dùng
        do {
            System.out.println("\n==================================");
            System.out.println("          INVENTORY MENU          ");
            System.out.println("==================================");
            System.out.println("1. Add Inventory Item");
            System.out.println("2. Update Inventory Item");
            System.out.println("3. Remove Inventory Item");
            System.out.println("4. Search Inventory (by ID/Name)");
            System.out.println("5. Display All Inventory");
            System.out.println("0. Back");
            System.out.println("==================================");
            System.out.print("Please enter your choice (0-5): ");
            
            choice = sc.nextInt();
            sc.nextLine(); // Đọc bỏ dòng trống/lệnh Enter thừa trong bộ đệm Scanner để tránh lỗi nhảy dòng ở lệnh sau

            switch (choice) {
                case 1: // CHỨC NĂNG THÊM MỚI
                    System.out.print("Enter Inventory ID: "); String id = sc.nextLine();
                    if (invMgr.findById(id) != null) { // Kiểm tra xem ID này có ai dùng chưa
                        System.out.println("Error: Inventory ID already exists!");
                        break; // Trùng thì dừng luôn case, bắt nhập lại từ đầu menu
                    }
                    System.out.print("Enter Item Name: "); String name = sc.nextLine();
                    System.out.print("Enter Quantity: "); int qty = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Warehouse Location: "); String loc = sc.nextLine();
                    
                    // Gọi hàm add và truyền object mới tạo vào
                    if (invMgr.addInventory(new Inventory(id, name, qty, loc))) {
                        System.out.println("Added to inventory successfully!");
                    }
                    break;
                case 2: // CHỨC NĂNG CẬP NHẬT
                    System.out.print("Enter Inventory ID to update: "); String upId = sc.nextLine();
                    Inventory current = invMgr.findById(upId); // Tìm dữ liệu hiện tại
                    if (current == null) {
                        System.out.println("Error: Inventory item not found.");
                    } else {
                        // Hiển thị lại giá trị cũ để người dùng dễ nhìn trước khi nhập mới
                        System.out.print("New Item Name (Current: " + current.getItemName() + "): "); String newName = sc.nextLine();
                        System.out.print("New Quantity (Current: " + current.getQuantity() + "): "); int newQty = sc.nextInt(); sc.nextLine();
                        System.out.print("New Location (Current: " + current.getLocation() + "): "); String newLoc = sc.nextLine();
                        
                        invMgr.updateInventory(upId, newName, newQty, newLoc); // Tiến hành đè dữ liệu mới
                        System.out.println("Inventory updated successfully!");
                    }
                    break;
                case 3: // CHỨC NĂNG XÓA
                    System.out.print("Enter Inventory ID to remove: "); String rmId = sc.nextLine();
                    if (invMgr.removeInventory(rmId)) {
                        System.out.println("Removed successfully!");
                    } else {
                        System.out.println("Error: Item not found.");
                    }
                    break;
                case 4: // CHỨC NĂNG TÌM KIẾM
                    System.out.print("Enter Keyword (ID or Item Name) to search: "); String kw = sc.nextLine();
                    ArrayList<Inventory> searchRes = invMgr.searchInventory(kw); // Nhận danh sách kết quả trả về
                    if (searchRes.isEmpty()) {
                        System.out.println("No matching items found.");
                    } else {
                        System.out.println("\n--- Search Results ---");
                        for (Inventory i : searchRes) System.out.println(i.toString()); // In các kết quả tìm thấy
                    }
                    break;
                case 5: // HIỂN THỊ TẤT CẢ
                    invMgr.displayInventory();
                    break;
                case 0:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 0); // Vòng lặp chạy liên tục cho đến khi người dùng nhập số 0 để quay lại
    }
}