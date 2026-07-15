package main;

import manager.*;
import ui.*;
import java.util.ArrayList;
import java.util.List;
import util.FileUtils;

public class Main {
    public static void main (String[] args) {
        
        // ==================== KHỞI TẠO CÁC MANAGER ====================
        ProductManager productManager = new ProductManager ();
        CustomerManager customerManager = new CustomerManager ();
        EmployeeManager employeeManager = new EmployeeManager ();
        SupplierManager supplierManager = new SupplierManager ();
        TransactionManager transactionManager = new TransactionManager ();
        InventoryManager inventoryManager = new InventoryManager ();
        VoucherManager voucherManager = new VoucherManager ();
        
        // ==================== KHỞI TẠO CÁC MENU ====================
        MainMenu mainMenu = new MainMenu(
        productManager,
        customerManager,
        employeeManager,
        supplierManager,
        transactionManager,
        inventoryManager,
        voucherManager);
        
        // ==================== Load data ==================== 
        productManager.loadData();
        voucherManager.loadData();  // ĐÃ THÊM: Tự động nạp danh sách voucher từ file txt lên bộ nhớ
        customerManager.loadData(); // ĐÃ THÊM MỚI: Tự động nạp danh sách khách hàng từ file txt lên bộ nhớ
        transactionManager.loadData();
        

    // ==================== CHẠY CHƯƠNG TRÌNH ====================     
        mainMenu.displayMainMenu();
    
    
    // ==================== save data ==================== 
        productManager.saveData();
        voucherManager.saveData();  // ĐÃ THÊM: Tự động ghi đè danh sách voucher mới xuống file txt khi thoát
        customerManager.saveData(); // ĐÃ THÊM MỚI: Tự động ghi đè danh sách khách hàng mới xuống file txt khi thoát
        transactionManager.saveData();
    }    
}
