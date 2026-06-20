
package model.transaction;
public class OrderItem {

    private String orderItemId;
    private String productId;
    private int quantity;
    private double unitPrice;

    public OrderItem() {
    }

    public OrderItem(String orderItemId, String productId, int quantity, double unitPrice) {
        this.orderItemId = orderItemId;
        this.productId=productId;
        this.quantity= quantity;
        this.unitPrice = unitPrice;
    }

    public String getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(String orderItemId) {
        this.orderItemId = orderItemId;
        
    }
    
    public String getProductId() {
        return productId; 
    }
    public void setProductId(String productId) {
        this.productId = productId; 
    }
    
    public int getQuantity() { 
        return quantity; 
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity; 
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
    
    public double getTotalPrice () {
        return quantity*unitPrice; // Ham tien ich
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "orderItemId='" + orderItemId + '\'' +
                ", productId='" + productId + '\'' +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", totalPrice=" + getTotalPrice() +
                '}';
    }
}