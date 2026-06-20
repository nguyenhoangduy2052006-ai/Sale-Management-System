
package ui;

import java.util.Scanner;
import manager.TransactionManager;
import model.transaction.Transaction;
import manager.ProductManager;

public class TransactionMenu {

    private TransactionManager transactionManager;
    private Scanner sc;

    public TransactionMenu(TransactionManager transactionManager, ProductManager productManager) {
        this.transactionManager = transactionManager;
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
        String id = sc.nextLine();

        System.out.print("Transaction Type (IMPORT/EXPORT): ");
        String type = sc.nextLine();

        System.out.print("Transaction Date: ");
        String date = sc.nextLine();

        Transaction transaction = new Transaction(id, type, date);

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
        String id = sc.nextLine();

        System.out.print("New Type(IMPORT/EXPORT): ");
        String type = sc.nextLine();

        System.out.print("New Date (dd/MM/yyyy): ");
        String date = sc.nextLine();

        transactionManager.updateTransaction(id, type, date);
    }

    private void deleteTransactionUI() {

        System.out.print("Transaction ID: ");
        String id = sc.nextLine();

        transactionManager.deleteTransaction(id);
    }
}