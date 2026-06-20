
package ui;

import model.employee.Employee;
import manager.EmployeeManager;
import java.util.Scanner;
import java.util.ArrayList;

public class EmployeeMenu {
    private EmployeeManager employeeManager; // ← thêm field
    private Scanner sc;                       // ← thêm field

    // ← thêm constructor nhận tham số
    public EmployeeMenu(EmployeeManager employeeManager) {
        this.employeeManager = employeeManager;
        this.sc = new Scanner(System.in);
    }

    public void showMenu() { // 
        int choice;
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
                case 1:
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

                    if (employeeManager.addEmployee(new Employee(id, name, role, phone, pass))) {
                        System.out.println("Added successfully!");
                    } else {
                        System.out.println("Error: Employee ID already exists!");
                    }
                    break;

                case 2:
                    System.out.print("Enter Employee ID to update: ");
                    String upId = sc.nextLine();
                    Employee current = employeeManager.findById(upId);
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

                        employeeManager.updateEmployee(upId, newName, newRole, newPhone, newPass);
                        System.out.println("Updated successfully!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Employee ID to remove: ");
                    String rmId = sc.nextLine();
                    if (employeeManager.removeEmployee(rmId)) {
                        System.out.println("Removed successfully!");
                    } else {
                        System.out.println("Error: Employee not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Keyword (ID or Name) to search: ");
                    String kw = sc.nextLine();
                    ArrayList<Employee> searchRes = employeeManager.searchEmployee(kw);
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
                    displayEmployees(employeeManager.getAllEmployees());
                    break;

                case 0:
                    System.out.println("Returning to main menu...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 0);
    }

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
}