package model.transaction;

import java.util.ArrayList;
import java.util.List;

public class Transaction {

    private String transactionId;
    private String customerId;
    private String transactionType; // IMPORT hoặc EXPORT
    private String transactionDate;
    private List<OrderItem> orderItems;

    public Transaction() {
        this.orderItems = new ArrayList<>();
    }

    public Transaction(String transactionId,
                       String customerId,
                       String transactionType,
                       String transactionDate) {

        if (transactionId == null || transactionId.trim().isEmpty()) {
            throw new IllegalArgumentException("Transaction ID cannot be empty.");
        }

        if (customerId == null || customerId.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer ID cannot be empty.");
        }

        this.transactionId = transactionId;
        this.customerId = customerId;
        this.transactionType = transactionType;
        this.transactionDate = transactionDate;
        this.orderItems = new ArrayList<>();
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        if (customerId == null || customerId.trim().isEmpty()) {
            System.out.println("Customer ID cannot be empty.");
            return;
        }
        this.customerId = customerId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        if (!transactionType.equalsIgnoreCase("IMPORT")
                && !transactionType.equalsIgnoreCase("EXPORT")) {

            System.out.println("Transaction type must be IMPORT or EXPORT.");
            return;
        }
        this.transactionType = transactionType;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        if (transactionDate == null || transactionDate.trim().isEmpty()) {
            System.out.println("Date cannot be empty.");
            return;
        }
        this.transactionDate = transactionDate;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    // Add / Remove OrderItem
    public void addOrderItem(OrderItem item) {
        if (item == null) {
            System.out.println("OrderItem is null.");
            return;
        }
        orderItems.add(item);
    }

    public void removeOrderItem(String orderItemId) {
        if (orderItemId == null || orderItemId.trim().isEmpty()) {
            System.out.println("Invalid OrderItem ID.");
            return;
        }

        orderItems.removeIf(item -> item.getOrderItemId().equals(orderItemId));
    }

    // Calculate total amount
    public double getTotalAmount() {
        if (orderItems.isEmpty()) {
            return 0;
        }

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
                ", customerId='" + customerId + '\'' +
                ", transactionType='" + transactionType + '\'' +
                ", transactionDate='" + transactionDate + '\'' +
                ", totalAmount=" + getTotalAmount() +
                ", orderItems=" + orderItems +
                '}';
    }
}