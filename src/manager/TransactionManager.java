package manager;

import java.util.ArrayList;
import model.transaction.Transaction;

public class TransactionManager {

    private final ArrayList<Transaction> transactionList;

    public TransactionManager() {
        transactionList = new ArrayList<>();
    }

    // CREATE
    public void addTransaction(Transaction transaction) {

        if (transaction == null) {
            System.out.println("Transaction is null.");
            return;
        }

        if (findTransactionById(transaction.getTransactionId()) != null) {
            System.out.println("Transaction ID already exists.");
            return;
        }

        if (transaction.getTransactionId() == null
                || transaction.getTransactionId().trim().isEmpty()) {
            System.out.println("Transaction ID cannot be empty.");
            return;
        }

        if (transaction.getTransactionType() == null
                || transaction.getTransactionType().trim().isEmpty()) {
            System.out.println("Transaction type cannot be empty.");
            return;
        }

        if (!transaction.getTransactionType().equalsIgnoreCase("IMPORT")
                && !transaction.getTransactionType().equalsIgnoreCase("EXPORT")) {
            System.out.println("Transaction type must be IMPORT or EXPORT.");
            return;
        }

        if (transaction.getTransactionDate() == null
                || transaction.getTransactionDate().trim().isEmpty()) {
            System.out.println("Transaction date cannot be empty.");
            return;
        }

        // BR8: Transaction must contain at least one OrderItem
        if (transaction.getOrderItems().isEmpty()) {
            System.out.println("Transaction must contain at least one OrderItem.");
            return;
        }

        transactionList.add(transaction);
        System.out.println("Transaction added successfully.");
    }

    // READ - Display all transactions
    public void displayTransactions() {

        if (transactionList.isEmpty()) {
            System.out.println("Transaction list is empty.");
            return;
        }

        System.out.println("\n===== TRANSACTION LIST =====");

        for (Transaction transaction : transactionList) {
            System.out.println(transaction);
        }
    }

    // READ - Find transaction by ID
    public Transaction findTransactionById(String transactionId) {

        if (transactionId == null || transactionId.trim().isEmpty()) {
            return null;
        }

        for (Transaction transaction : transactionList) {

            if (transaction.getTransactionId().equalsIgnoreCase(transactionId)) {
                return transaction;
            }
        }

        return null;
    }

    // UPDATE
    public void updateTransaction(String transactionId,
                                  String newTransactionType,
                                  String newTransactionDate) {

        Transaction transaction = findTransactionById(transactionId);

        if (transaction == null) {
            System.out.println("Transaction not found.");
            return;
        }

        if (newTransactionType == null
                || newTransactionType.trim().isEmpty()) {
            System.out.println("Transaction type cannot be empty.");
            return;
        }

        if (!newTransactionType.equalsIgnoreCase("IMPORT")
                && !newTransactionType.equalsIgnoreCase("EXPORT")) {
            System.out.println("Transaction type must be IMPORT or EXPORT.");
            return;
        }

        if (newTransactionDate == null
                || newTransactionDate.trim().isEmpty()) {
            System.out.println("Transaction date cannot be empty.");
            return;
        }

        transaction.setTransactionType(newTransactionType);
        transaction.setTransactionDate(newTransactionDate);

        System.out.println("Transaction updated successfully.");
    }

    // DELETE
    public void deleteTransaction(String transactionId) {

        if (transactionId == null || transactionId.trim().isEmpty()) {
            System.out.println("Invalid transaction ID.");
            return;
        }

        Transaction transaction = findTransactionById(transactionId);

        if (transaction == null) {
            System.out.println("Transaction not found.");
            return;
        }

        transactionList.remove(transaction);

        System.out.println("Transaction deleted successfully.");
    }

    // Return total number of transactions
    public int getTotalTransactions() {
        return transactionList.size();
    }

    // Return transaction list
    public ArrayList<Transaction> getTransactionList() {
        return transactionList;
    }
}