
package model.employee;

// Lớp Model biểu diễn thông tin của một Nhân viên (Encapsulation)
public class Employee {
    // Khai báo các thuộc tính private để bảo mật dữ liệu
    //tìm hiểu lại
    private String employeeID;
    private String employeeName;
    private String role;
    private String phoneNumber;
    private String password;

    // Hàm khởi tạo (Constructor) có đầy đủ tham số
    public Employee(String employeeID, String employeeName, String role, String phoneNumber, String password) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.role = role;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    // Các hàm Getter và Setter để truy cập và cập nhật dữ liệu hợp lệ
    // tìm hiểu lại getter và setter
    public String getEmployeeID() { return employeeID; }
    public void setEmployeeID(String employeeID) { this.employeeID = employeeID; }

    public String getEmployeeName() { return employeeName; }
    public void setEmployeeName(String employeeName) { this.employeeName = employeeName; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    // Hàm toString() định dạng dòng dữ liệu hiển thị theo dạng bảng
    @Override
    public String toString() {
        return String.format("| %-10s | %-20s | %-15s | %-15s |", employeeID, employeeName, role, phoneNumber);
    }
}