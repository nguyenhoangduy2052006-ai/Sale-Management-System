package manager;

import model.supplier.Supplier;
import java.util.ArrayList;

// Lớp xử lý THUẦN LOGIC CRUD lưu trữ và tương tác dữ liệu của Nhà cung cấp
public class SupplierManager {
    // Khai báo mảng động lưu trữ danh sách nhà cung cấp
    private ArrayList<Supplier> listSupplier = new ArrayList<>();

    // Hàm bổ trợ: Tìm kiếm thực thể nhà cung cấp theo ID (Dùng nội bộ và cung cấp cho UI)
    public Supplier findSupplier(String supplierID) {
        for (Supplier s : listSupplier) {
            if (s.getSupplierID().equalsIgnoreCase(supplierID)) {
                return s; // Trả về đối tượng tìm thấy
            }
        }
        return null; // Không tìm thấy thì trả về null
    }

    // 1. CHỨC NĂNG THÊM MỚI (Nhận đối tượng đã đúc sẵn từ UI)
    public boolean addSupplier(Supplier supplier) {
        // Kiểm tra trùng lặp mã nhà cung cấp trước khi add
        if (findSupplier(supplier.getSupplierID()) != null) {
            return false; // Trùng mã, thêm thất bại
        }
        listSupplier.add(supplier);
        return true; // Thêm thành công
    }

    // 2. CHỨC NĂNG CẬP NHẬT THÔNG TIN (Nhận các tham số dữ liệu chuẩn từ UI)
    public boolean updateSupplier(String id, String name, String contact, String phone) {
        Supplier s = findSupplier(id);
        if (s == null) {
            return false; // Không tìm thấy nhà cung cấp cần sửa
        }
        // Tiến hành ghi đè dữ liệu mới
        s.setSupplierName(name);
        s.setContactName(contact);
        s.setPhoneNumber(phone);
        return true; // Cập nhật thành công
    }

    // 3. CHỨC NĂNG XÓA BỎ NHÀ CUNG CẤP
    public boolean deleteSupplier(String supplierID) {
        for (int i = 0; i < listSupplier.size(); i++) {
            if (listSupplier.get(i).getSupplierID().equalsIgnoreCase(supplierID)) {
                listSupplier.remove(i); // Xóa bản ghi khỏi ArrayList
                return true; // Xóa thành công
            }
        }
        return false; // Không tìm thấy để xóa
    }

    // 4. CHỨC NĂNG TÌM KIẾM THEO TỪ KHÓA (Trả về 1 danh sách các kết quả khớp)
    public ArrayList<Supplier> searchSupplier(String keyword) {
        ArrayList<Supplier> searchResults = new ArrayList<>();
        String kw = keyword.toLowerCase();
        
        for (Supplier s : listSupplier) {
            // Nếu ID hoặc Tên chứa từ khóa thì add vào danh sách kết quả
            if (s.getSupplierID().toLowerCase().contains(kw) || 
                s.getSupplierName().toLowerCase().contains(kw)) {
                searchResults.add(s);
            }
        }
        return searchResults; // Trả danh sách về cho UI tự in
    }

    // 5. HÀM LẤY TOÀN BỘ DANH SÁCH (Để bên UI mang đi hiển thị)
    public ArrayList<Supplier> getListSupplier() {
        return listSupplier;
    }
}