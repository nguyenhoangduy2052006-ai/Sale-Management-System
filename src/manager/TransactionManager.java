/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
        transactionList.add(transaction);
        System.out.println("Thêm giao dịch thành công.");
    }

    // READ - Hiển thị tất cả giao dịch
    public void displayTransactions() {

        if (transactionList.isEmpty()) {
            System.out.println("Danh sách giao dịch trống.");
            return;
        }

        System.out.println("\n===== DANH SÁCH GIAO DỊCH =====");

        for (Transaction transaction : transactionList) {
            System.out.println(transaction);
        }
    }

    // READ - Tìm giao dịch theo ID
    public Transaction findTransactionById(String transactionId) {

        for (Transaction transaction : transactionList) {

            if (transaction.getTransactionId()
                    .equalsIgnoreCase(transactionId)) {

                return transaction;
            }
        }

        return null;
    }

    // UPDATE
    public void updateTransaction(String transactionId,
                                  String newTransactionType,
                                  String newTransactionDate) {

        Transaction transaction =
                findTransactionById(transactionId);

        if (transaction == null) {
            System.out.println("Không tìm thấy giao dịch.");
            return;
        }
        transaction.setTransactionType(newTransactionType);
        transaction.setTransactionDate(newTransactionDate);

        System.out.println("Cập nhật giao dịch thành công.");
    }

    // DELETE
    public void deleteTransaction(String transactionId) {

        Transaction transaction =
                findTransactionById(transactionId);

        if (transaction == null) {
            System.out.println("Không tìm thấy giao dịch.");
            return;
        }

        transactionList.remove(transaction);

        System.out.println("Xóa giao dịch thành công.");
    }

    // Đếm số lượng giao dịch
    public int getTotalTransactions() {
        return transactionList.size();
    }
}