package main;

import manager.*;
import ui.*;

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
        
        // ==================== CHẠY CHƯƠNG TRÌNH ====================
        System.out.println(util.InputHelper.repeatChar ("=", 50));
        System.out.println("SALE MANAGEMENT SYSTEM - GROUP 6 ");
        System.out.println(util.InputHelper.repeatChar("=", 50));
        
        
    }
    
}