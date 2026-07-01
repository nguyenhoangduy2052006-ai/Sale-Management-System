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
        // Validate input rỗng
        if (id == null || id.trim().isEmpty()
                || newName == null || newName.trim().isEmpty()
                || newRole == null || newRole.trim().isEmpty()
                || newPhone == null || newPhone.trim().isEmpty()
                || newPassword == null || newPassword.trim().isEmpty()) {
            return false;
        }

        for (Employee e : employeeList) {
            if (e.getEmployeeID().equalsIgnoreCase(id)) {
                e.setEmployeeName(newName.trim());
                e.setRole(newRole.trim());
                e.setPhoneNumber(newPhone.trim());
                e.setPassword(newPassword.trim());
                return true;
            }
        }
        return false;
    }

    public boolean removeEmployee(String id) {
        // Đổi sang index-based loop để xóa an toàn, tránh rủi ro crash bộ nhớ
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getEmployeeID().equalsIgnoreCase(id)) {
                employeeList.remove(i);
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
