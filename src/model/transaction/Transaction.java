
package model.transaction;

import java.util.ArrayList;
import java.util.List;

public class Transaction {

    private String transactionId;
    private String transactionType; // IMPORT hoặc EXPORT
    private String transactionDate;
    private List<OrderItem> orderItems; 

    public Transaction() {
        this.orderItems= new ArrayList<>();
    }

    public Transaction(String transactionId,
                       String transactionType,
                       String transactionDate) {

        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.transactionDate = transactionDate;
        this.orderItems= new ArrayList<>();
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }
    
    public List<OrderItem> getOrderItems() { 
        return orderItems; 
    }
    
    // Thêm/xóa OrderItem
    public void addOrderItem(OrderItem item) { 
        orderItems.add(item); 
    }

    public void removeOrderItem(String orderItemId) {
        orderItems.removeIf(item -> item.getOrderItemId().equals(orderItemId));
    }
     
    // Tính tổng tiền hóa đơn
    public double getTotalAmount() {
        double total = 0;
        for (OrderItem item : orderItems) {
            total += item.getTotalPrice();
        }
        return total;
    }
    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId='" + transactionId + '\'' +
                ", transactionType='" + transactionType + '\'' +
                ", transactionDate='" + transactionDate + '\'' +
                ", totalAmount=" + getTotalAmount() +
                ", orderItems=" + orderItems +
                '}';
    }
}