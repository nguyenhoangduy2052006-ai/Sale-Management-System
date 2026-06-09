package Management;

import Entity.Employee; // Phải import class Employee từ package Entity
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManagement {
    private ArrayList<Employee> employeeList;

    public EmployeeManagement() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Scanner sc) {
        System.out.println("--- Add New Employee ---");
        System.out.print("Enter Employee ID: ");
        String id = sc.nextLine();
        
        if(findEmployeeById(id) != null) {
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

    public void listAllEmployees() {
        System.out.println("--- Employee List ---");
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

    public void updateEmployeeRole(Scanner sc) {
        System.out.println("--- Update Employee Information ---");
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

    public void removeEmployee(Scanner sc) {
        System.out.println("--- Remove Employee ---");
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

    private Employee findEmployeeById(String id) {
        for (Employee emp : employeeList) {
            if (emp.getEmployeeID().equalsIgnoreCase(id)) {
                return emp;
            }
        }
        return null;
    }
}