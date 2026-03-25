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
            System.out.println("4. Update Expense");
            System.out.println("5. Exit");

            int choice;

            //  Validation для меню
            while (true) {
                System.out.print("Choose option: ");
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    break;
                } else {
                    System.out.println("Invalid input! Enter a number.");
                    scanner.nextLine();
                }
            }

            if (choice == 1) {
                System.out.print("Title: ");
                String title = scanner.nextLine();

                double amount;
                //  Validation для суммы
                while (true) {
                    System.out.print("Amount: ");
                    if (scanner.hasNextDouble()) {
                        amount = scanner.nextDouble();
                        scanner.nextLine();
                        break;
                    } else {
                        System.out.println("Invalid input! Enter a number.");
                        scanner.nextLine();
                    }
                }

                System.out.print("Category: ");
                String category = scanner.nextLine();

                service.addExpense(title, amount, category);
            }

            else if (choice == 2) {
                service.viewExpenses();
            }

            else if (choice == 3) {
                int id;

                while (true) {
                    System.out.print("Enter ID: ");
                    if (scanner.hasNextInt()) {
                        id = scanner.nextInt();
                        scanner.nextLine();
                        break;
                    } else {
                        System.out.println("Invalid input! Enter a number.");
                        scanner.nextLine();
                    }
                }

                service.deleteExpense(id);
            }

            else if (choice == 4) {
                int id;

                while (true) {
                    System.out.print("Enter ID to update: ");
                    if (scanner.hasNextInt()) {
                        id = scanner.nextInt();
                        scanner.nextLine();
                        break;
                    } else {
                        System.out.println("Invalid input! Enter a number.");
                        scanner.nextLine();
                    }
                }

                System.out.print("New Title: ");
                String title = scanner.nextLine();

                double amount;

                while (true) {
                    System.out.print("New Amount: ");
                    if (scanner.hasNextDouble()) {
                        amount = scanner.nextDouble();
                        scanner.nextLine();
                        break;
                    } else {
                        System.out.println("Invalid input! Enter a number.");
                        scanner.nextLine();
                    }
                }

                System.out.print("New Category: ");
                String category = scanner.nextLine();

                service.updateExpense(id, title, amount, category);
            }

            else if (choice == 5) {
                System.out.println("Goodbye!");
                break;
            }

            else {
                System.out.println("Invalid choice!");
            }
        }
    }
}