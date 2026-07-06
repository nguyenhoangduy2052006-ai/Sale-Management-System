package repository;

import java.util.ArrayList;
import java.util.List;
import model.employee.Employee; // Đảm bảo đúng tên package model của ông
import util.FileUtils;

public class EmployeeRepository {

    // LOAD — Read file using Duy's shared readLines function
    public static ArrayList<Employee> loadEmployees(String filePath) {
        ArrayList<Employee> list = new ArrayList<>();
        List<String> lines = FileUtils.readLines(filePath); 

        for (String line : lines) {
            try {
                if (line.trim().isEmpty()) continue;
                
                // Giả sử dữ liệu phân tách bằng dấu phẩy hoặc dấu gạch đứng tùy file dữ liệu của nhóm ông
                String[] parts = line.split(","); 
                if (parts.length >= 4) { // Điều chỉnh số lượng thuộc tính cho khớp với Model Employee
                    String id = parts[0].trim();
                    String name = parts[1].trim();
                    // Thêm các thuộc tính khác của Employee vào đây...
                    
                    // list.add(new Employee(id, name, ...));
                }
            } catch (Exception e) {
                System.out.println("Error parsing employee line: " + line + " - skipping");
            }
        }
        return list;
    }

    // SAVE — Write file using Duy's shared writeLines function
    public static void saveEmployees(String filePath, ArrayList<Employee> list) {
        List<String> lines = new ArrayList<>();
        
        for (Employee emp : list) {
            // Chuyển Object thành chuỗi string format tương ứng
            String line = emp.getEmployeeID() + "," + emp.getEmployeeName(); // Thêm các thuộc tính khác...
            lines.add(line);
        }
        
        FileUtils.writeLines(filePath, lines);
        System.out.println("Employees saved successfully!");
    }
}