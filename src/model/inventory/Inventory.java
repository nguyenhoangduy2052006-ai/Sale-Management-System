package model.inventory; // Khai báo vị trí thư mục của file trong dự án

// Lớp đối tượng (Model) đại diện cho 1 sản phẩm/vật tư trong kho
public class Inventory {
    // Khai báo các thuộc tính (đặc điểm) của vật tư kho
    //tìm hiểu lại toàn bộ
    private String inventoryID;   // Mã vật tư (Ví dụ: INV001)
    private String itemName;      // Tên sản phẩm/vật tư
    private int quantity;         // Số lượng tồn kho
    private String location;      // Vị trí lưu trữ trong kho (Ví dụ: Kệ A1)

    // Hàm khởi tạo (Constructor) có tham số để tạo nhanh một đối tượng vật tư
    public Inventory(String inventoryID, String itemName, int quantity, String location) {
        this.inventoryID = inventoryID; // Gán giá trị truyền vào cho thuộc tính lớp
        this.itemName = itemName;
        this.quantity = quantity;
        this.location = location;
    }

    // --- CÁC HÀM GETTER VÀ SETTER (Đóng gói dữ liệu) ---
    // Getter: Dùng để lấy giá trị ra | Setter: Dùng để thay đổi/gán giá trị mới
    
    public String getInventoryID() { return inventoryID; }
    public void setInventoryID(String inventoryID) { this.inventoryID = inventoryID; }

    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    // Hàm toString() định dạng cách hiển thị thông tin sản phẩm theo dạng hàng (Row) trong bảng
    @Override
    public String toString() {
        // %-12s: Căn lề trái, độ rộng 12 ký tự cho Chuỗi (String)
        // %-10d: Căn lề trái, độ rộng 10 ký tự cho Số nguyên (Integer)
        return String.format("| %-12s | %-25s | %-10d | %-15s |", inventoryID, itemName, quantity, location);
    }
}