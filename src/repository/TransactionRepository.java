package repository;

import java.util.ArrayList;
import java.util.List;
import model.transaction.OrderItem;
import model.transaction.Transaction;
import util.FileUtils;
public class TransactionRepository {
    private static final String FILE_PATH = "data/transactions.txt";
    // LOAD - Read file and create Transaction list
    public ArrayList<Transaction> loadTransactions() {
        ArrayList<Transaction> transactionList = new ArrayList<>();
        List<String> lines = FileUtils.readLines(FILE_PATH);
        Transaction currentTransaction = null;
        for (String line : lines) {
            try {
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] parts = line.split("\\|");
                switch (parts[0]) {
                    case "TRANSACTION":
                        if (parts.length < 5) {
                            System.out.println("Invalid transaction line: " + line);
                            continue;
                        }
                        currentTransaction = new Transaction(
                                parts[1].trim(),
                                parts[2].trim(),
                                parts[3].trim(),
                                parts[4].trim()
                        );
                        break;
                    case "ITEM":
                        if (currentTransaction == null) {
                            System.out.println("OrderItem without Transaction.");
                            continue;
                        }
                        if (parts.length < 5) {
                            System.out.println("Invalid OrderItem line: " + line);
                            continue;
                        }
                        OrderItem item = new OrderItem(
                                parts[1].trim(),
                                parts[2].trim(),
                                Integer.parseInt(parts[3].trim()),
                                Double.parseDouble(parts[4].trim())
                        );
                        currentTransaction.addOrderItem(item);
                        break;
                    case "END":
                        if (currentTransaction != null) {
                            transactionList.add(currentTransaction);
                            currentTransaction = null;
                        }
                        break;
                    default:
                        System.out.println("Unknown record type: " + line);
                }
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                 System.out.println("Invalid data: " + line);
            }
        }
        System.out.println("Loaded " + transactionList.size() + " transactions.");
        return transactionList;
    }
    // SAVE - Convert Transaction list to text file
    public void saveTransactions(ArrayList<Transaction> transactionList) {
        List<String> lines = new ArrayList<>();
        for (Transaction transaction : transactionList) {
            lines.add(
                    "TRANSACTION|"
                    + transaction.getTransactionId() + "|"
                    + transaction.getCustomerId() + "|"
                    + transaction.getTransactionType() + "|"
                    + transaction.getTransactionDate()
            );
                        // Save all OrderItems
            for (OrderItem item : transaction.getOrderItems()) {
                lines.add(
                        "ITEM|"
                        + item.getOrderItemId() + "|"
                        + item.getProductId() + "|"
                        + item.getQuantity() + "|"
                        + item.getUnitPrice()
                );
            }
            // Mark the end of one Transaction
            lines.add("END");
        }
        FileUtils.writeLines(FILE_PATH, lines);
        System.out.println("Transactions saved successfully.");
    }
}