import java.util.Scanner;
import service.ExpenseService;

public class Main {
    public static void main(String[] args) {

        // Создаем Scanner для ввода с клавиатуры
        Scanner scanner = new Scanner(System.in);

        // Создаем объект сервиса для работы с расходами
        ExpenseService service = new ExpenseService();

        // Бесконечный цикл (меню работает постоянно, пока не выйдет)
        while (true) {

            // Вывод меню
            System.out.println("\n1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Delete Expense");
            System.out.println("4. Update Expense");
            System.out.println("5. Export to CSV");
            System.out.println("6. Import from CSV");
            System.out.println("7. Exit");

            int choice;

            // Проверка правильности ввода (чтобы ввели число)
            while (true) {
                System.out.print("Choose option: ");
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    scanner.nextLine(); // очищаем буфер
                    break;
                } else {
                    System.out.println("Invalid input! Enter a number.");
                    scanner.nextLine(); // очищаем неправильный ввод
                }
            }

            // 1. Добавление расхода
            if (choice == 1) {
                System.out.print("Title: ");
                String title = scanner.nextLine();

                double amount;

                // Проверка ввода суммы
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

                // Вызов метода добавления
                service.addExpense(title, amount, category);
            }

            // 2. Показать все расходы
            else if (choice == 2) {
                service.viewExpenses();
            }

            // 3. Удалить расход
            else if (choice == 3) {
                int id;

                // Проверка ввода ID
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

            // 4. Обновить расход
            else if (choice == 4) {
                int id;

                // Ввод ID
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

                // Новый заголовок
                System.out.print("New Title: ");
                String title = scanner.nextLine();

                double amount;

                // Новый amount с проверкой
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

                // Новая категория
                System.out.print("New Category: ");
                String category = scanner.nextLine();

                // Обновление расхода
                service.updateExpense(id, title, amount, category);
            }

            // 5. Экспорт в CSV файл
            else if (choice == 5) {
                service.exportData();
            }

            // 6. Импорт из CSV файла
            else if (choice == 6) {
                service.importData();
            }

            // 7. Выход из программы
            else if (choice == 7) {
                System.out.println("Goodbye!");
                break; // выход из цикла
            }

            // Если ввели неправильный номер меню
            else {
                System.out.println("Invalid choice!");
            }
        }
    }
}