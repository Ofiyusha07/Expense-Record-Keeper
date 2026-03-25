package model;

public class Expense extends Transaction {

    private String category;

    public Expense(int id, String title, double amount, String category) {
        super(id, title, amount);
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // 🔥 Полиморфизм (переопределение метода)
    @Override
    public String getDetails() {
        return id + " | " + title + " | " + amount + " | " + category;
    }

    @Override
    public String toString() {
        return getDetails();
    }
}