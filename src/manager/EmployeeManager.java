package manager; // Khớp chính xác với tên thư mục viết thường bên trái của ông

import model.employee.Employee; // Sửa lại đường dẫn import đúng vị trí gói model.employee
import java.util.ArrayList;

// Lớp quản lý xử lý các chức năng nghiệp vụ (CRUD) của Nhân viên
public class EmployeeManager { // Đã đổi tên class trùng khít 100% với tên file EmployeeManager.java
    // Sử dụng kỹ thuật ArrayList để lưu trữ danh sách nhân viên trong bộ nhớ máy
    private final ArrayList<Employee> employeeList;

    // Hàm khởi tạo tạo mới một danh sách rỗng
    public EmployeeManager() {
        this.employeeList = new ArrayList<>();
    }

    // Chức năng: Thêm nhân viên mới vào hệ thống
    public boolean addEmployee(Employee emp) {
        // Duyệt qua toàn bộ danh sách để kiểm tra trùng mã ID
        for (Employee e : employeeList) {
            // Nếu mã ID đã tồn tại (không phân biệt chữ hoa chữ thường)
            if (e.getEmployeeID().equalsIgnoreCase(emp.getEmployeeID())) {
                // Trả về false báo hiệu thêm thất bại
                return false; 
            }
        }
        // Thêm nhân viên mới vào ArrayList nếu không trùng ID
        employeeList.add(emp);
        // Trả về true báo hiệu thành công
        return true;
    }

    // Chức năng: Cập nhật thông tin nhân viên theo ID
    public boolean updateEmployee(String id, String newName, String newRole, String newPhone, String newPassword) {
        // Duyệt tìm nhân viên cần sửa trong danh sách
        for (Employee e : employeeList) {
            // Nếu tìm thấy nhân viên có ID trùng khớp
            if (e.getEmployeeID().equalsIgnoreCase(id)) {
                // Tiến hành ghi đè dữ liệu mới bằng các hàm setter
                e.setEmployeeName(newName);
                e.setRole(newRole);
                e.setPhoneNumber(newPhone);
                e.setPassword(newPassword);
                // Trả về true báo hiệu cập nhật thành công
                return true;
            }
        }
        // Trả về false nếu duyệt hết danh sách mà không thấy ID này
        return false;
    }

    // Chức năng: Xóa nhân viên khỏi hệ thống theo ID
    public boolean removeEmployee(String id) {
        // Duyệt tìm nhân viên cần xóa trong danh sách
        for (Employee e : employeeList) {
            // Nếu tìm thấy nhân viên có ID trùng khớp
            if (e.getEmployeeID().equalsIgnoreCase(id)) {
                // Thực hiện xóa đối tượng này ra khỏi danh sách bộ nhớ
                employeeList.remove(e);
                // Trả về true báo hiệu xóa thành công
                return true;
            }
        }
        // Trả về false nếu không tìm thấy nhân viên cần xóa
        return false;
    }

    // Tuân thủ nghiêm ngặt yêu cầu: Tìm kiếm theo cả ID và Tên nhân viên
    public ArrayList<Employee> searchEmployee(String keyword) {
        // Khởi tạo một danh sách phụ để chứa các kết quả tìm thấy
        ArrayList<Employee> results = new ArrayList<>();
        // Duyệt qua từng nhân viên trong danh sách tổng
        for (Employee e : employeeList) {
            // Kiểm tra xem ID có trùng khớp hoặc Tên có chứa từ khóa tìm kiếm hay không
            if (e.getEmployeeID().equalsIgnoreCase(keyword) || 
                e.getEmployeeName().toLowerCase().contains(keyword.toLowerCase())) {
                // Nếu thỏa mãn thì thêm vào danh sách kết quả
                results.add(e);
            }
        }
        // Trả về danh sách kết quả tìm kiếm được
        return results;
    }

    // Chức năng: Hiển thị toàn bộ danh sách nhân viên hiện tại
    public void displayEmployees() {
        // Nếu danh sách hiện tại đang trống
        if (employeeList.isEmpty()) {
            System.out.println("No employees available.");
            return;
        }
        // Hiển thị tiêu đề cột định dạng bảng
        System.out.println("-------------------------------------------------------------------------");
        System.out.printf("| %-10s | %-20s | %-15s | %-15s |\n", "ID", "Name", "Role", "Phone");
        System.out.println("-------------------------------------------------------------------------");
        // Duyệt và in ra chuỗi định dạng của từng nhân viên
        for (Employee e : employeeList) {
            System.out.println(e.toString());
        }
        System.out.println("-------------------------------------------------------------------------");
    }
    
    // Hàm bổ trợ: Tìm kiếm đối tượng nhân viên gốc nhanh bằng ID chính xác
    public Employee findById(String id) {
        for (Employee e : employeeList) {
            if (e.getEmployeeID().equalsIgnoreCase(id)) {
                // Trả về đối tượng nhân viên tìm thấy
                return e;
            }
        }
        // Không tìm thấy trả về null
        return null;
    }
}