package ui; // Khớp chính xác với package ui viết thường hiện tại của ông

import model.employee.Employee; // Import đúng thực thể Employee từ model
import manager.EmployeeManager; // Import đúng lớp quản lý EmployeeManager từ gói manager
import java.util.Scanner;
import java.util.ArrayList;

// Lớp giao diện Menu xử lý tương tác nhập xuất của Phân hệ Nhân viên
public class EmployeeMenu {

    private void displayEmployees(ArrayList<Employee> employeeList) {
        if (employeeList.isEmpty()) {
            System.out.println("No employees available.");
            return;
        }

        System.out.println("-------------------------------------------------------------------------");
        System.out.printf("| %-10s | %-20s | %-15s | %-15s |\n",
                "ID", "Name", "Role", "Phone");
        System.out.println("-------------------------------------------------------------------------");

        for (Employee e : employeeList) {
            System.out.println(e.toString());
        }

        System.out.println("-------------------------------------------------------------------------");
    }

    // Hàm hiển thị và điều hướng Menu chức năng
    // Đã sửa tham số truyền vào thành EmployeeManager cho khớp với class xử lý
    public void displayMenu(Scanner sc, EmployeeManager empMgr) {

        int choice;
        // Vòng lặp do-while giữ người dùng ở lại menu cho đến khi chọn 0
        do {
            System.out.println("\n===========================================");
            System.out.println("               EMPLOYEE MENU               ");
            System.out.println("===========================================");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Remove Employee");
            System.out.println("4. Search Employee (by ID/Name)");
            System.out.println("5. Display All Employees");
            System.out.println("0. Back");
            System.out.println("===========================================");
            System.out.print("Please enter your choice (0-5): ");

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice! Please enter a number.");
                choice = -1;
                continue;
            }

            switch (choice) {
                case 1: // Chức năng thêm mới nhân viên
                    System.out.print("Enter ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Role: ");
                    String role = sc.nextLine();
                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();
                    System.out.print("Enter Password: ");
                    String pass = sc.nextLine();

                    if (empMgr.addEmployee(new Employee(id, name, role, phone, pass))) {
                        System.out.println("Added successfully!");
                    } else {
                        System.out.println("Error: Employee ID already exists!");
                    }
                    break;

                case 2: // Chức năng sửa đổi dữ liệu nhân viên
                    System.out.print("Enter Employee ID to update: ");
                    String upId = sc.nextLine();
                    Employee current = empMgr.findById(upId);
                    if (current == null) {
                        System.out.println("Error: Employee not found.");
                    } else {
                        System.out.print("New Name (Current: " + current.getEmployeeName() + "): ");
                        String newName = sc.nextLine();
                        System.out.print("New Role (Current: " + current.getRole() + "): ");
                        String newRole = sc.nextLine();
                        System.out.print("New Phone (Current: " + current.getPhoneNumber() + "): ");
                        String newPhone = sc.nextLine();
                        System.out.print("New Password: ");
                        String newPass = sc.nextLine();

                        empMgr.updateEmployee(upId, newName, newRole, newPhone, newPass);
                        System.out.println("Updated successfully!");
                    }
                    break;

                case 3: // Chức năng xóa bỏ nhân viên
                    System.out.print("Enter Employee ID to remove: ");
                    String rmId = sc.nextLine();
                    if (empMgr.removeEmployee(rmId)) {
                        System.out.println("Removed successfully!");
                    } else {
                        System.out.println("Error: Employee not found.");
                    }
                    break;

                case 4: // Chức năng tìm kiếm theo từ khóa (ID hoặc Tên)
                    System.out.print("Enter Keyword (ID or Name) to search: ");
                    String kw = sc.nextLine();
                    ArrayList<Employee> searchRes = empMgr.searchEmployee(kw);
                    if (searchRes.isEmpty()) {
                        System.out.println("No matching employee found.");
                    } else {
                        System.out.println("\n--- Search Results ---");
                        for (Employee e : searchRes) {
                            System.out.println(e.toString());
                        }
                    }
                    break;
                case 5:
                    displayEmployees(empMgr.getAllEmployees());
                    break;

                case 0: // Quay lại menu chính
                    System.out.println("Returning to main menu...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 0);
    }
}
