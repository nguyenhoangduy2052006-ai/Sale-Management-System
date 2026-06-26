package model.inventory; 
public class Inventory {
     
    private String inventoryID;   
    private String itemName;      
    private int quantity;         
    private String location;    

    // Hàm khởi tạo (Constructor) có tham số để tạo nhanh một đối tượng vật tư
    public Inventory(String inventoryID, String itemName, int quantity, String location) {
        this.inventoryID = inventoryID; // Gán giá trị truyền vào cho thuộc tính lớp
        this.itemName = itemName;
        this.quantity = quantity;
        this.location = location;
    }
    
    public String getInventoryID() { return inventoryID; }
    public void setInventoryID(String inventoryID) { this.inventoryID = inventoryID; }

    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    
    @Override
    public String toString() {
        // %-12s: Căn lề trái, độ rộng 12 ký tự cho Chuỗi (String)
        // %-10d: Căn lề trái, độ rộng 10 ký tự cho Số nguyên (Integer)
        return String.format("| %-12s | %-25s | %-10d | %-15s |", inventoryID, itemName, quantity, location);
    }
}