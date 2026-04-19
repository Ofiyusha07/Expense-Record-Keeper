package model;

// Класс Expense (расход) наследуется от Transaction
public class Expense extends Transaction {

    // Дополнительное поле только для расходов
    private String category;

    // Конструктор вызывает конструктор родителя через super
    public Expense(int id, String title, double amount, String category) {
        super(id, title, amount); // передаём общие поля
        this.category = category; // задаём своё поле
    }

    // Геттер — получить категорию
    public String getCategory() {
        return category;
    }

    // Сеттер — изменить категорию
    public void setCategory(String category) {
        this.category = category;
    }

    // Переопределение метода родителя (полиморфизм)
    @Override
    public String getDetails() {
        return id + " | " + title + " | " + amount + " | " + category;
    }

    // Автоматический вывод объекта (например при println)
    @Override
    public String toString() {
        return getDetails();
    }
}