package repository;

import java.util.ArrayList;
import model.employee.Employee;
import util.FileUtils; 

public class EmployeeRepository {

    // Hàm load: Đọc file .txt -> Chuyển thành ArrayList<Employee>
    public static ArrayList<Employee> loadEmployees(String filePath) {
        ArrayList<Employee> list = new ArrayList<>();
        // Gọi hàm đọc file dùng chung từ FileUtils
        ArrayList<String> lines = FileUtils.readFile(filePath); 

        for (String line : lines) {
            if (line.trim().isEmpty()) continue;
            String[] parts = line.split(",");
            if (parts.length == 3) {
                String id = parts[0].trim();
                String name = parts[1].trim();
                String role = parts[2].trim();
                list.add(new Employee(id, name, role)); 
            }
        }
        return list;
    }

    // Hàm save: Gom ArrayList<Employee> -> Chuyển thành chuỗi thô -> Ghi xuống file
    public static void saveEmployees(String filePath, ArrayList<Employee> list) {
        ArrayList<String> lines = new ArrayList<>();
        for (Employee emp : list) {
            // ĐÃ SỬA: Dùng chính xác getEmployeeID() và getEmployeeName() của ông
            String line = emp.getEmployeeID() + "," + emp.getEmployeeName() + "," + emp.getRole();
            lines.add(line);
        }
        FileUtils.writeFile(filePath, lines); 
    }
}