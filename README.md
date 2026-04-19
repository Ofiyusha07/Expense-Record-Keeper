# Expense Record Keeper

My name is Arabbaeva Ofiya, i am second year student from COMFCI-24. This project is a console-based Java program for tracking personal expenses. The user can add, view, update and delete expenses. All data is saved in a file, so it is not lost after restarting the program.

The main goal of this project was to practice Java programming, understand object-oriented programming concepts and work with file handling.

The program uses ArrayList as the main data structure to store expenses during runtime. Each expense is represented as an object with fields such as id, title, amount and category. When the program starts, data is loaded from a file into the list, and after each operation the list is saved back to the file.

The program is divided into several modules. Main.java is responsible for user interaction and menu. ExpenseService.java contains the main logic such as adding, updating and deleting expenses. FileManager.java is responsible for reading and writing data to files. Expense.java represents the expense object, and Transaction.java is the parent class used to demonstrate inheritance.

The main algorithms used in the project are simple. For example, when generating a new id, the program iterates through all existing expenses and finds the maximum id, then assigns the next value. For deleting, the program removes an element from the list using a condition. For updating, it searches for an expense by id and modifies its fields.

Object-oriented programming principles are used in this project. Encapsulation is implemented through private fields and getters/setters. Inheritance is shown by the Expense class extending the Transaction class. Polymorphism is demonstrated by overriding the getDetails() method.

The program also includes input validation to prevent incorrect data entry. For example, it checks if the user enters a number for amount or id, and shows an error message if the input is invalid.

All data is stored in a file called expenses.txt and is automatically loaded when the program starts. The program also allows exporting data to a CSV file and importing it back.

During development, one of the problems I faced was incorrect ID generation. Initially, every time the program restarted, new expenses were assigned the same id, because the counter was reset. I solved this problem by implementing a method that scans existing data, finds the maximum id and generates the next one based on it.

Another issue was input errors, for example when the user entered text instead of a number. This caused the program to crash. I fixed this by adding validation using Scanner methods such as hasNextInt() and hasNextDouble().

To run the program, open the project in IntelliJ IDEA and run Main.java. Then use the menu in the console.


This screenshot shows how a new expense is added and then displayed in the list.
<img width="1919" height="1199" alt="add and view opp" src="https://github.com/user-attachments/assets/e95233f2-5f71-47ae-911a-4b8d830a7a0b" />

This screenshot shows updating an existing expense and viewing the updated result.
<img width="1919" height="1199" alt="update and view oppp" src="https://github.com/user-attachments/assets/a1d73fcd-cf1c-4fd3-9e84-d942c2fcca61" />

This screenshot demonstrates deleting an expense and viewing the updated list.
<img width="1919" height="1199" alt="delete and view opp" src="https://github.com/user-attachments/assets/54f4c536-e2a6-4d03-9ed4-4486edf546d6" />

This screenshot shows how the program handles incorrect input and prevents crashes.
<img width="1919" height="1199" alt="Error Handling" src="https://github.com/user-attachments/assets/9c98a595-ac74-4d54-86ae-bd2cc8e7d13c" />

This screenshot shows how data is stored in the text file used for persistence.
<img width="1919" height="1199" alt="saving in txt file" src="https://github.com/user-attachments/assets/487b10d2-26a5-4037-9b28-d521c17615ce" />

This screenshot shows how data is exported to CSV and then imported back into the program.
<img width="1919" height="1199" alt="import and export CSV" src="https://github.com/user-attachments/assets/75bf045c-1d2b-4ad2-8d53-8b62c4066b5a" />

This screenshot shows the CSV file created after exporting data. The file can be opened outside the program.
<img width="1919" height="1199" alt="CSV in computer" src="https://github.com/user-attachments/assets/75446068-c38a-477a-9981-434c61c01a4d" />
