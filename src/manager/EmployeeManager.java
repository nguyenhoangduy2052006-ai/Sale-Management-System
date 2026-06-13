package Management;

import Entity.Employee; // Khai báo để sử dụng thực thể Employee từ package Entity
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManagement {

    // Khai báo danh sách lưu trữ nhân viên trong bộ nhớ
    private ArrayList<Employee> employeeList;

    public EmployeeManagement() {
        employeeList = new ArrayList<>();
    }

    // =========================================================
    // 1. HÀM HIỂN THỊ MENU ĐIỀU HƯỚNG (ĐÃ KẾT NỐI TÍNH NĂNG THẬT)
    // =========================================================
    public void displayMenu(Scanner sc) {
        int choice;
        do {
            System.out.println("\n----------------------------------");
            System.out.println("     EMPLOYEE MANAGEMENT MENU     ");
            System.out.println("----------------------------------");
            System.out.println("1. Add a new employee");
            System.out.println("2. Update employee information");
            System.out.println("3. Remove an employee");
            System.out.println("4. List all employees");
            System.out.println("0. Back to Main Menu ");
            System.out.println("----------------------------------");
            System.out.print("Please enter your choice (0-4): ");

            choice = sc.nextInt();
            sc.nextLine(); // Xóa bộ đệm sau khi nhập số

            switch (choice) {
                case 1:
                    addEmployee(sc); // Kích hoạt chức năng thêm thật
                    break;
                case 2:
                    updateEmployeeRole(sc); // Kích hoạt chức năng sửa thật
                    break;
                case 3:
                    removeEmployee(sc); // Kích hoạt chức năng xóa thật
                    break;
                case 4:
                    listAllEmployees(); // Kích hoạt chức năng xem danh sách thật
                    break;
                case 0:
                    System.out.println("Dang quay lai Man hinh chinh...");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (choice != 0);
    }

    // =========================================================
    // 2. CÁC HÀM XỬ LÝ CHỨC NĂNG CHI TIẾT
    // =========================================================
    // Chức năng 1: Thêm nhân viên mới
    public void addEmployee(Scanner sc) {
        System.out.println("\n--- Add New Employee ---");
        System.out.print("Enter Employee ID: ");
        String id = sc.nextLine();

        if (findEmployeeById(id) != null) {
            System.out.println("Error: Employee ID already exists!");
            return;
        }

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Role: ");
        String role = sc.nextLine();
        System.out.print("Enter Phone Number: ");
        String phone = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        Employee newEmp = new Employee(id, name, role, phone, password);
        employeeList.add(newEmp);
        System.out.println("=> Employee added successfully!");
    }

    // Chức năng 4: Xem danh sách nhân viên dưới dạng bảng
    public void listAllEmployees() {
        System.out.println("\n--- Employee List ---");
        if (employeeList.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }
        System.out.printf("| %-10s | %-20s | %-15s | %-15s |\n", "ID", "Name", "Role", "Phone");
        System.out.println("-----------------------------------------------------------------------");
        for (Employee emp : employeeList) {
            emp.displayEmployeeInfo();
        }
    }

    // Chức năng 2: Cập nhật chức vụ và số điện thoại
    public void updateEmployeeRole(Scanner sc) {
        System.out.println("\n--- Update Employee Information ---");
        System.out.print("Enter Employee ID to update: ");
        String id = sc.nextLine();

        Employee emp = findEmployeeById(id);
        if (emp != null) {
            System.out.print("Enter new Role (Current: " + emp.getRole() + "): ");
            String newRole = sc.nextLine();
            emp.setRole(newRole);

            System.out.print("Enter new Phone Number (Current: " + emp.getPhoneNumber() + "): ");
            String newPhone = sc.nextLine();
            emp.setPhoneNumber(newPhone);

            System.out.println("=> Employee information updated successfully!");
        } else {
            System.out.println("Error: Employee not found.");
        }
    }

    // Chức năng 3: Xóa nhân viên khỏi hệ thống
    public void removeEmployee(Scanner sc) {
        System.out.println("\n--- Remove Employee ---");
        System.out.print("Enter Employee ID to remove: ");
        String id = sc.nextLine();

        Employee emp = findEmployeeById(id);
        if (emp != null) {
            employeeList.remove(emp);
            System.out.println("=> Employee removed successfully!");
        } else {
            System.out.println("Error: Employee not found.");
        }
    }

    // Hàm phụ trợ: Tìm kiếm nhân viên nhanh bằng ID
    private Employee findEmployeeById(String id) {
        for (Employee emp : employeeList) {
            if (emp.getEmployeeID().equalsIgnoreCase(id)) {
                return emp;
            }
        }
        return null;
    }
}
