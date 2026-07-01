package model.employee;

public class Employee {

    private final String employeeID;
    private String employeeName;
    private String role;
    private String phoneNumber;
    private String password;

    public Employee(String employeeID, String employeeName, String role, String phoneNumber, String password) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.role = role;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("| %-10s | %-20s | %-15s | %-15s |", employeeID, employeeName, role, phoneNumber);
    }
}
