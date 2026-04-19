package service;

import model.Expense;
import file.FileManager;
import java.util.ArrayList;

// Сервисный класс — содержит всю бизнес-логику работы с расходами
public class ExpenseService {

    // Список расходов (загружается из файла при запуске)
    private ArrayList<Expense> expenses = FileManager.loadFromFile();

    // Генерация уникального ID
    private int getNextId() {
        int maxId = 0;

        // ищем максимальный ID в списке
        for (Expense e : expenses) {
            if (e.getId() > maxId) {
                maxId = e.getId();
            }
        }

        return maxId + 1; // следующий ID
    }

    // CREATE — добавление расхода
    public void addExpense(String title, double amount, String category) {
        Expense expense = new Expense(getNextId(), title, amount, category);
        expenses.add(expense);

        // сохраняем изменения в файл
        FileManager.saveToFile(expenses);
    }

    // READ — просмотр всех расходов
    public void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses found.");
            return;
        }

        for (Expense e : expenses) {
            System.out.println(e); // вызывает toString()
        }
    }

    // DELETE — удаление по ID
    public void deleteExpense(int id) {
        boolean removed = expenses.removeIf(e -> e.getId() == id);

        if (removed) {
            System.out.println("Deleted successfully.");
        } else {
            System.out.println("Expense not found.");
        }

        FileManager.saveToFile(expenses);
    }

    // EXPORT (по сути просто сохранение)
    public void exportData() {
        FileManager.saveToFile(expenses);
        System.out.println("Data exported.");
    }

    // IMPORT (загрузка из файла)
    public void importData() {
        expenses = FileManager.loadFromFile();
        System.out.println("Data imported.");
    }

    // UPDATE — обновление данных
    public void updateExpense(int id, String newTitle, double newAmount, String newCategory) {
        for (Expense e : expenses) {
            if (e.getId() == id) {

                e.setTitle(newTitle);
                e.setAmount(newAmount);
                e.setCategory(newCategory);

                FileManager.saveToFile(expenses);
                System.out.println("Updated successfully.");
                return;
            }
        }

        System.out.println("Expense not found.");
    }
}