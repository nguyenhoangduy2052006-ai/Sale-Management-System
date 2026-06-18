package manager; // Khai báo file nằm trong gói manager

import model.inventory.Inventory; // Import lớp Model Inventory để sử dụng
import java.util.ArrayList;        // Import thư viện mảng động ArrayList

// Lớp xử lý nghiệp vụ (CRUD) - Thêm, Sửa, Xóa, Tìm kiếm vật tư kho
public class InventoryManager {
   // Khai báo mảng động ArrayList để lưu danh sách các đối tượng Inventory
    //  private final 
    private ArrayList<Inventory> inventoryList;

    // Hàm khởi tạo: Khi tạo một Manager mới thì cấp phát bộ nhớ cho danh sách luôn
    
    public InventoryManager() {
        this.inventoryList = new ArrayList<>();
    }

    // CHỨC NĂNG C: CREATE - THÊM MỚI VẬT TƯ
    //giải thích hàm addinventory
    public boolean addInventory(Inventory inv) {
        // Vòng lặp For-each duyệt qua từng sản phẩm 'i' đang có trong danh sách
        for (Inventory i : inventoryList) {
            // Nếu phát hiện mã ID nhập vào trùng với ID đã tồn tại (không phân biệt hoa thường)
            if (i.getInventoryID().equalsIgnoreCase(inv.getInventoryID())) {
                return false; // Trả về false báo hiệu trùng mã, thêm thất bại
            }
        }
        inventoryList.add(inv); // Nếu không trùng, thêm sản phẩm mới vào ArrayList
        return true;            // Trả về true báo hiệu thêm thành công
    }

    // CHỨC NĂNG U: UPDATE - ĐIỀU CHỈNH THÔNG TIN VẬT TƯ
    //tìm hiểu lại updateinventory
    public boolean updateInventory(String id, String newName, int newQty, String newLocation) {
        // Tìm sản phẩm trong danh sách dựa vào ID truyền vào
        for (Inventory i : inventoryList) {
            if (i.getInventoryID().equalsIgnoreCase(id)) {
                // Nếu tìm thấy, cập nhật lại toàn bộ thông tin mới
                i.setItemName(newName);
                i.setQuantity(newQty);
                i.setLocation(newLocation);
                return true; // Trả về true báo hiệu cập nhật thành công
            }
        }
        return false; // Không tìm thấy ID tương ứng, trả về false
    }

    // CHỨC NĂNG D: DELETE - XÓA VẬT TƯ KHỎI KHO
    public boolean removeInventory(String id) {
        // Dùng vòng lặp For truyền thống với biến đếm 'i' (Index) để xóa an toàn
        for (int i = 0; i < inventoryList.size(); i++) {
            if (inventoryList.get(i).getInventoryID().equalsIgnoreCase(id)) {
                inventoryList.remove(i); // Xóa phần tử tại vị trí index 'i'
                return true;             // Thoát hàm và báo thành công
            }
        }
        return false; // Không tìm thấy phần tử cần xóa
    }

    // CHỨC NĂNG R: READ - TÌM KIẾM THEO TỪ KHÓA (ID hoặc Tên)
    //giải thích cách thức hoạt động của hàm search
    public ArrayList<Inventory> searchInventory(String keyword) {
        ArrayList<Inventory> results = new ArrayList<>(); // Tạo mảng phụ chứa kết quả tìm thấy
        for (Inventory i : inventoryList) {
            // Kiểm tra nếu ID trùng khớp HOẶC Tên sản phẩm có chứa từ khóa (chuyển hết về chữ thường)
            if (i.getInventoryID().equalsIgnoreCase(keyword) || 
                i.getItemName().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(i); // Thêm phần tử thỏa mãn vào danh sách kết quả
            }
        }
        return results; // Trả về danh sách kết quả (có thể rỗng nếu không tìm thấy gì)
    }

    // CHỨC NĂNG R: READ - XUẤT TOÀN BỘ DANH SÁCH RA MÀN HÌNH
    public void displayInventory() {
        if (inventoryList.isEmpty()) { // Kiểm tra nếu danh sách rỗng
            System.out.println("Inventory is empty.");
            return; // Thoát hàm luôn, không cần chạy đoạn dưới
        }
        // In tiêu đề cột của bảng
        System.out.println("-------------------------------------------------------------------------");
        System.out.printf("| %-12s | %-25s | %-10s | %-15s |\n", "Inventory ID", "Item Name", "Quantity", "Location");
        System.out.println("-------------------------------------------------------------------------");
        // Duyệt danh sách và in từng dòng ra bằng hàm toString() đã viết ở lớp Model
        for (Inventory i : inventoryList) {
            System.out.println(i.toString());
        }
        System.out.println("-------------------------------------------------------------------------");
    }

    // HÀM PHỤ TRỢ: Tìm nhanh đối tượng gốc bằng ID (Dùng để kiểm tra nhanh trong file Menu)
    // tìm hiểu lại hàm này
    public Inventory findById(String id) {
        for (Inventory i : inventoryList) {
            if (i.getInventoryID().equalsIgnoreCase(id)) {
                return i; // Trả về cả đối tượng gốc
            }
        }
        return null; // Không tìm thấy thì trả về null
    }
}