package model.transaction;

public class OrderItem {

    private String orderItemId;
    private String productId;
    private int quantity;
    private double unitPrice;

    public OrderItem() {
    }

    public OrderItem(String orderItemId, String productId, int quantity, double unitPrice) {

        if (orderItemId == null || orderItemId.trim().isEmpty()) {
            throw new IllegalArgumentException("Order Item ID cannot be empty.");
        }

        if (productId == null || productId.trim().isEmpty()) {
            throw new IllegalArgumentException("Product ID cannot be empty.");
        }

        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0.");
        }

        if (unitPrice < 0) {
            throw new IllegalArgumentException("Unit price cannot be negative.");
        }

        this.orderItemId = orderItemId;
        this.productId = productId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public String getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(String orderItemId) {

        if (orderItemId == null || orderItemId.trim().isEmpty()) {
            System.out.println("Order Item ID cannot be empty.");
            return;
        }

        this.orderItemId = orderItemId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {

        if (productId == null || productId.trim().isEmpty()) {
            System.out.println("Product ID cannot be empty.");
            return;
        }

        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {

        if (quantity <= 0) {
            System.out.println("Quantity must be greater than 0.");
            return;
        }

        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {

        if (unitPrice < 0) {
            System.out.println("Unit price cannot be negative.");
            return;
        }

        this.unitPrice = unitPrice;
    }

    public double getTotalPrice() {

        if (quantity <= 0 || unitPrice < 0) {
            return 0;
        }

        return quantity * unitPrice;
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