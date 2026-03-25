package model;

public class Transaction {
    protected int id;
    protected String title;
    protected double amount;

    public Transaction(int id, String title, double amount) {
        this.id = id;
        this.title = title;
        this.amount = amount;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public double getAmount() { return amount; }

    public void setTitle(String title) { this.title = title; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getDetails() {
        return id + " | " + title + " | " + amount;
    }
}