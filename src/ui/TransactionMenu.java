/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import java.util.Scanner;
import manager.TransactionManager;
import model.transaction.Transaction;

public class TransactionMenu {

    private TransactionManager transactionManager;
    private Scanner sc;

    public TransactionMenu() {
        transactionManager = new TransactionManager();
        sc = new Scanner(System.in);
    }

    public void showMenu() {

        int choice;

        do {

            System.out.println("\n===== TRANSACTION MANAGEMENT =====");
            System.out.println("1. Add Transaction");
            System.out.println("2. Display Transactions");
            System.out.println("3. Search Transaction");
            System.out.println("4. Update Transaction");
            System.out.println("5. Delete Transaction");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    addTransactionUI();
                    break;

                case 2:
                    transactionManager.displayTransactions();
                    break;

                case 3:
                    searchTransactionUI();
                    break;

                case 4:
                    updateTransactionUI();
                    break;

                case 5:
                    deleteTransactionUI();
                    break;

                case 0:
                    System.out.println("Exit.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }

    private void addTransactionUI() {

        System.out.print("Transaction ID: ");
        String transactionId = sc.nextLine();

        System.out.print("Product ID: ");
        String productId = sc.nextLine();

        System.out.print("Product Name: ");
        String productName = sc.nextLine();

        System.out.print("Quantity: ");
        int quantity = Integer.parseInt(sc.nextLine());

        System.out.print("Transaction Type (IMPORT/EXPORT): ");
        String type = sc.nextLine();

        System.out.print("Transaction Date: ");
        String date = sc.nextLine();

        Transaction transaction = new Transaction(
                transactionId,
                productId,
                productName,
                quantity,
                type,
                date
        );

        transactionManager.addTransaction(transaction);
    }

    private void searchTransactionUI() {

        System.out.print("Enter Transaction ID: ");
        String id = sc.nextLine();

        Transaction transaction =
                transactionManager.findTransactionById(id);

        if (transaction != null) {
            System.out.println(transaction);
        } else {
            System.out.println("Transaction not found.");
        }
    }

    private void updateTransactionUI() {

        System.out.print("Transaction ID: ");
        String transactionId = sc.nextLine();

        System.out.print("New Product ID: ");
        String productId = sc.nextLine();

        System.out.print("New Product Name: ");
        String productName = sc.nextLine();

        System.out.print("New Quantity: ");
        int quantity = Integer.parseInt(sc.nextLine());

        System.out.print("New Type: ");
        String type = sc.nextLine();

        System.out.print("New Date: ");
        String date = sc.nextLine();

        transactionManager.updateTransaction(
                transactionId,
                productId,
                productName,
                quantity,
                type,
                date
        );
    }

    private void deleteTransactionUI() {

        System.out.print("Transaction ID: ");
        String transactionId = sc.nextLine();

        transactionManager.deleteTransaction(transactionId);
    }
}