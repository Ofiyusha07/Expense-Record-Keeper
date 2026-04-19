package file;

import model.Expense;
import java.io.*;
import java.util.ArrayList;

// Класс для работы с файлом (сохранение и загрузка данных)
public class FileManager {

    // Имя файла, в котором хранятся данные
    private static final String FILE_NAME = "expenses.txt";

    // Метод сохраняет список расходов в файл
    public static void saveToFile(ArrayList<Expense> expenses) {

        // try-with-resources автоматически закрывает файл
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {

            // Проходим по всем расходам
            for (Expense e : expenses) {

                // Записываем данные в формате CSV (через запятую)
                writer.write(e.getId() + "," + e.getTitle() + "," + e.getAmount() + "," + e.getCategory());
                writer.newLine(); // переход на новую строку
            }

        } catch (IOException e) {
            // Обработка ошибки при записи
            System.out.println("Error saving file!");
        }
    }

    // Метод загружает данные из файла и возвращает список расходов
    public static ArrayList<Expense> loadFromFile() {

        ArrayList<Expense> list = new ArrayList<>();

        // Чтение файла
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            // Читаем файл построчно
            while ((line = reader.readLine()) != null) {

                // Разделяем строку по запятой
                String[] data = line.split(",");

                // Преобразуем данные в нужные типы
                int id = Integer.parseInt(data[0]);
                String title = data[1];
                double amount = Double.parseDouble(data[2]);
                String category = data[3];

                // Создаём объект и добавляем в список
                list.add(new Expense(id, title, amount, category));
            }

        } catch (IOException e) {
            // Если файла нет — просто начинаем с пустого списка
            System.out.println("File not found, starting fresh.");
        }

        return list;
    }
}