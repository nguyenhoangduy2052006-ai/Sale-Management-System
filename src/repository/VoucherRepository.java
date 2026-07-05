package repository;

import model.voucher.Voucher;
import util.FileUtils;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VoucherRepository {
    private static final String FILE_PATH = "data/vouchers.txt";
    
    // LOAD — đọc file tạo danh sách Voucher
    public ArrayList<Voucher> loadVouchers() {
        ArrayList<Voucher> voucherList = new ArrayList<>();
        List<String> lines = FileUtils.readLines(FILE_PATH);
        
        for (String line : lines) {
            try {
                if (line.trim().isEmpty()) continue; // bỏ qua dòng trống nếu có
                
                String[] parts = line.split("\\|");
                String id = parts[0];
                String code = parts[1];
                double discountValue = Double.parseDouble(parts[2]);
                LocalDate expiryDate = LocalDate.parse(parts[3]); // Định dạng text trong file: YYYY-MM-DD
                boolean status = Boolean.parseBoolean(parts[4]);
                
                Voucher v = new Voucher(id, code, discountValue, expiryDate, status);
                
                if (v != null) {
                    voucherList.add(v);
                }
            } 
            catch (Exception e) {
                System.out.println("Error parsing line: " + line + "- skipping");
            }
        }
        
        // === ĐÃ THÊM: In thông báo số lượng voucher giống y như Product ===
        System.out.println("Loaded " + voucherList.size() + " vouchers.");
        
        return voucherList;
    }
    
    // SAVE — convert danh sách Voucher -> ghi xuống file
    public void saveVouchers(ArrayList<Voucher> voucherList) {
        List<String> lines = new ArrayList<>();
        
        for (Voucher v : voucherList) {
            // Convert toàn bộ thuộc tính đối tượng thành chuỗi text phân tách bằng dấu |
            String line = v.getVoucherID() + "|" 
                    + v.getVoucherCode() + "|" 
                    + v.getDiscountValue() + "|" 
                    + v.getExpiryDate() + "|" 
                    + v.isStatus();
            
            lines.add(line);
        }
        
        FileUtils.writeLines(FILE_PATH, lines);
    }
}
