package manager;

import model.employee.Employee;
import java.util.ArrayList;

public class EmployeeManager {
    private final ArrayList<Employee> employeeList;

    public EmployeeManager() {
        this.employeeList = new ArrayList<>();
    }

    public boolean addEmployee(Employee emp) {
        for (Employee e : employeeList) {
            if (e.getEmployeeID().equalsIgnoreCase(emp.getEmployeeID())) {
                return false;
            }
        }
        employeeList.add(emp);
        return true;
    }

    public boolean updateEmployee(String id, String newName, String newRole, String newPhone, String newPassword) {
        for (Employee e : employeeList) {
            if (e.getEmployeeID().equalsIgnoreCase(id)) {
                e.setEmployeeName(newName);
                e.setRole(newRole);
                e.setPhoneNumber(newPhone);
                e.setPassword(newPassword);
                return true;
            }
        }
        return false;
    }

    public boolean removeEmployee(String id) {
        for (Employee e : employeeList) {
            if (e.getEmployeeID().equalsIgnoreCase(id)) {
                employeeList.remove(e);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Employee> searchEmployee(String keyword) {
        ArrayList<Employee> results = new ArrayList<>();
        for (Employee e : employeeList) {
            if (e.getEmployeeID().equalsIgnoreCase(keyword)
                    || e.getEmployeeName().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(e);
            }
        }
        return results;
    }

    public ArrayList<Employee> getAllEmployees() {
        return employeeList;
    }

    public Employee findById(String id) {
        for (Employee e : employeeList) {
            if (e.getEmployeeID().equalsIgnoreCase(id)) {
                return e;
            }
        }
        return null;
    }
}