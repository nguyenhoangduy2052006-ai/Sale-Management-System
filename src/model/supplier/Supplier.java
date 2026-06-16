package model.supplier; // Khai báo vị trí thư mục lưu trữ file thực thể nhà cung cấp

// Lớp Model mô tả cấu trúc dữ liệu của một Nhà cung cấp
public class Supplier {
    private String supplierID;   // Mã nhà cung cấp
    private String supplierName; // Tên công ty/nhà cung cấp
    private String contactName;  // Tên người đại diện liên hệ
    private String phoneNumber;  // Số điện thoại liên lạc

    // Hàm Constructor khởi tạo đối tượng nhanh với đầy đủ tham số đầu vào
    public Supplier(String supplierID, String supplierName, String contactName, String phoneNumber) {
        this.supplierID = supplierID;
        this.supplierName = supplierName;
        this.contactName = contactName;
        this.phoneNumber = phoneNumber;
    }

    // --- Bộ hàm Getter và Setter phục vụ truy xuất dữ liệu an toàn ---
    public String getSupplierID() { return supplierID; }
    public void setSupplierID(String supplierID) { this.supplierID = supplierID; }

    public String getSupplierName() { return supplierName; }
    public void setSupplierName(String supplierName) { this.supplierName = supplierName; }

    public String getContactName() { return contactName; }
    public void setContactName(String contactName) { this.contactName = contactName; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    // Hàm định dạng dòng dữ liệu khi xuất ra màn hình bảng danh sách
    @Override
    public String toString() {
        return String.format("| %-12s | %-25s | %-20s | %-15s |", supplierID, supplierName, contactName, phoneNumber);
    }
}