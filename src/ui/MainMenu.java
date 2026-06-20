
package ui;

import manager.*;
import java.util.Scanner;
public class MainMenu {
    private final ProductMenu productMenu;
    private final CustomerMenu customerMenu;
    private final TransactionMenu transactionMenu;
    private final EmployeeMenu employeeMenu;
    private final SupplierMenu supplierMenu;
    private final InventoryMenu inventoryMenu;
    private final VoucherMenu voucherMenu;
    private final ReportMenu reportMenu;
    
    private final Scanner scanner = new Scanner (System.in);
    
    public MainMenu (ProductManager pm,
            CustomerManager cm,
            EmployeeManager em,
            SupplierManager sm,
            TransactionManager tm,
            InventoryManager im,
            VoucherManager vm) {
        
        this.productMenu = new ProductMenu (pm);
        this.customerMenu= new CustomerMenu (cm);
        this.transactionMenu = new TransactionMenu (tm, pm);
        this.employeeMenu = new EmployeeMenu (em);
        this.supplierMenu = new SupplierMenu (sm);
        this.inventoryMenu = new InventoryMenu (im);
        this.voucherMenu = new VoucherMenu (vm);
        this.reportMenu = new ReportMenu (pm, cm, tm);
    }
    
    public void displayMainMenu () {
        int choice;
        do {
            System.out.println(util.InputHelper.repeatChar("=", 50));
            System.out.println("SALE MANAGEMENT SYSTEM");
            System.out.println(util.InputHelper.repeatChar("=", 50));
            
            System.out.println("1. Product Management");
            System.out.println("2. Customer Management");
            System.out.println("3. Transaction Managerment");
            System.out.println("4. Inventory Management");
            System.out.println("5. Supplier Managerment");
            System.out.println("6. Employee Management");
            System.out.println("7. Voucher Managemen");
            System.out.println("8. Reporting");
            System.out.println("0. Exit");
            
            System.out.println(util.InputHelper.repeatChar("=", 50));
            System.out.println("Input your choice: ");
            
            choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer?
            
            switch (choice) {
                case 1: {
                    productMenu.productMenu();
                    break;
                }
                case 2: {
                    customerMenu.showMenu(); // Thao doi lai ten phuong thuc
                    break;
                }
                case 3: {
                    transactionMenu.showMenu(); // noi Huy doi lai ten phuong thuc
                    break;
                }
                case 4: {
                    //inventoryMenu.displayMenu(scanner, invMgr); Tung co van de ve logic
                    break;
                }
                case 5: {
                    // supplierMenu.displayMenu(); Tung co van de ve logic
                    break;
                }
                case 6: {
                    employeeMenu.showMenu(); 
                    break;
                }
                case 7: {
                    voucherMenu.showMenu ();
                    break;
                }
                case 8: {
                    // reportMenu.reportMenu(); 
                    System.out.println("not yet do it");
                    break;
                }
                case 0: {
                    break;
                } 
                default:
                    System.out.println ("invalid!");
            }
        }while (choice!=0);
    }
}
