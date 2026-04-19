package model;

// Базовый класс для всех транзакций (например, расходы)
public class Transaction {

    // Поля (данные объекта)
    protected int id;        // уникальный ID
    protected String title;  // название (например: еда, транспорт)
    protected double amount; // сумма

    // Конструктор — вызывается при создании объекта
    public Transaction(int id, String title, double amount) {
        this.id = id;
        this.title = title;
        this.amount = amount;
    }

    // Геттеры — получить значения полей
    public int getId() { return id; }
    public String getTitle() { return title; }
    public double getAmount() { return amount; }

    // Сеттеры — изменить значения полей
    public void setTitle(String title) { this.title = title; }
    public void setAmount(double amount) { this.amount = amount; }

    // Метод для красивого вывода информации
    public String getDetails() {
        return id + " | " + title + " | " + amount;
    }
}