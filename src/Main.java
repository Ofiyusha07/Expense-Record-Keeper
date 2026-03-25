import java.util.Scanner;

import service.ExpenseService;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExpenseService service = new ExpenseService();

        while (true) {
            System.out.println("\n1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Delete Expense");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Title: ");
                String title = scanner.nextLine();

                System.out.print("Amount: ");
                double amount = scanner.nextDouble();
                scanner.nextLine();

                System.out.print("Category: ");
                String category = scanner.nextLine();

                service.addExpense(title, amount, category);
            }
            else if (choice == 2) {
                service.viewExpenses();
            }
            else if (choice == 3) {
                System.out.print("Enter ID: ");
                int id = scanner.nextInt();
                service.deleteExpense(id);
            }
            else {
                break;
            }
        }
    }
}