package model.inventory;

public class Inventory {

    private final String inventoryID;
    private String itemName;
    private int quantity;
    private String location;

    public Inventory(String inventoryID, String itemName, int quantity, String location) {
        this.inventoryID = inventoryID;
        this.itemName = itemName;
        this.quantity = quantity;
        this.location = location;
    }

    public String getInventoryID() {
        return inventoryID;
    }
    // HÀM setInventoryID() ĐÃ ĐƯỢC XÓA BỎ ĐỂ ĐẢM BẢO AN TOÀN HỆ THỐNG

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return String.format("| %-12s | %-25s | %-10d | %-15s |", inventoryID, itemName, quantity, location);
    }
}
