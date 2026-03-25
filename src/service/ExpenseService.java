package service;

import model.Expense;
import file.FileManager;
import java.util.ArrayList;

public class ExpenseService {

    private ArrayList<Expense> expenses = FileManager.loadFromFile();

    //  Генерация ID (исправленная)
    private int getNextId() {
        int maxId = 0;
        for (Expense e : expenses) {
            if (e.getId() > maxId) {
                maxId = e.getId();
            }
        }
        return maxId + 1;
    }

    //  CREATE
    public void addExpense(String title, double amount, String category) {
        Expense expense = new Expense(getNextId(), title, amount, category);
        expenses.add(expense);
        FileManager.saveToFile(expenses);
    }

    //  READ
    public void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses found.");
            return;
        }

        for (Expense e : expenses) {
            System.out.println(e);
        }
    }

    //  DELETE
    public void deleteExpense(int id) {
        boolean removed = expenses.removeIf(e -> e.getId() == id);

        if (removed) {
            System.out.println("Deleted successfully.");
        } else {
            System.out.println("Expense not found.");
        }

        FileManager.saveToFile(expenses);
    }

    //  UPDATE
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