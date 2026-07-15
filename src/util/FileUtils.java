
package util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    // Đọc tất cả dòng từ file → trả về List<String>
    public static List<String> readLines(String filePath) {
        List<String> lines = new ArrayList<>();

        File file = new File(filePath);
        if (!file.exists()) {
            return lines; // file chưa có → trả về rỗng, không báo lỗi
        }

        try ( BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) { // bỏ qua dòng trống
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + filePath);
        }

        return lines;
    }

    // Ghi danh sách dòng xuống file
    public static void writeLines(String filePath, List<String> lines) {
        // Tạo thư mục data/ nếu chưa tồn tại
        File dir = new File("data");
        if (!dir.exists()) {
            dir.mkdirs();
        }

        try ( BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing file: " + filePath);
        }
    }

    /*
    public static ArrayList<String> readFile(String filePath) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static void writeFile(String filePath, ArrayList<String> lines) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }*/
}
