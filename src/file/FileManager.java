package file;

import model.Expense;
import java.io.*;
import java.util.ArrayList;

public class FileManager {

    private static final String FILE_NAME = "expenses.txt";

    // Сохранение в txt
    public static void saveToFile(ArrayList<Expense> expenses) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Expense e : expenses) {
                writer.write(e.getId() + "," + e.getTitle() + "," + e.getAmount() + "," + e.getCategory());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving file!");
        }
    }

    // Загрузка из txt
    public static ArrayList<Expense> loadFromFile() {
        ArrayList<Expense> list = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String title = data[1];
                double amount = Double.parseDouble(data[2]);
                String category = data[3];

                list.add(new Expense(id, title, amount, category));
            }

        } catch (IOException e) {
            System.out.println("File not found, starting fresh.");
        }

        return list;
    }

    // EXPORT в CSV
    public static void exportToCSV(ArrayList<Expense> expenses) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("expenses.csv"))) {
            for (Expense e : expenses) {
                writer.write(e.getId() + "," + e.getTitle() + "," + e.getAmount() + "," + e.getCategory());
                writer.newLine();
            }
            System.out.println("Exported to CSV.");
        } catch (IOException e) {
            System.out.println("Error exporting CSV!");
        }
    }

    // IMPORT из CSV
    public static ArrayList<Expense> importFromCSV() {
        ArrayList<Expense> list = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("expenses.csv"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String title = data[1];
                double amount = Double.parseDouble(data[2]);
                String category = data[3];

                list.add(new Expense(id, title, amount, category));
            }

            System.out.println("Imported from CSV.");

        } catch (IOException e) {
            System.out.println("CSV file not found.");
        }

        return list;
    }
}