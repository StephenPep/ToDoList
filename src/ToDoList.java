import java.util.ArrayList;  // Importing ArrayList to store tasks
import java.util.Scanner;    // Importing Scanner to read input from the user
import java.io.FileWriter;   // Importing FileWriter to save tasks to a file
import java.io.IOException;  // Importing IOException to handle file errors

public class ToDoList {

    // ArrayList is used here to store the tasks. It allows us to dynamically add tasks.
    private static ArrayList<String> tasks = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Scanner is used to capture input from the user
        boolean running = true;  // This boolean variable keeps the program running until we want to quit

        // The loop below keeps displaying the menu until the user chooses to quit
        while (running) {
            // Printing the menu options so the user knows what they can do
            System.out.println("\n==== To-Do List Menu ====");
            System.out.println("1. Add a task");
            System.out.println("2. View tasks");
            System.out.println("3. Save tasks to file");
            System.out.println("4. Quit");
            System.out.print("Select an option: ");

            // Here we get the user's input for their menu choice
            int choice = scanner.nextInt();
            scanner.nextLine();  // This is needed to consume the newline character after entering a number

            // Based on the user's choice, we call the appropriate function
            switch (choice) {
                case 1:
                    addTask(scanner);  // Calling function to add a task
                    break;
                case 2:
                    displayTasks();  // Calling function to display the current list of tasks
                    break;
                case 3:
                    saveTasksToFile();  // Calling function to save tasks to a file
                    break;
                case 4:
                    System.out.println("Exiting... Goodbye!");
                    running = false;  // Setting running to false will stop the loop and exit the program
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");  // Handling invalid input
            }
        }

        scanner.close();  // closing the Scanner to prevent any potential resource leaks
        
        
        System.out.println("Go Hatters!!\n");
		/* This is used to print out onto the console
		 * the "Go Hatters" command
		 */
		
		System.out.println("Program by: Stephen Peprah Wereko");
		/* This is where my program ends,
		 * by printing out "Program by:(my name)
		 */
    }

    // This function adds a task to the list
    // We ask the user for the task, then store it in our ArrayList
    private static void addTask(Scanner scanner) {
        // Asking the user for the task they want to add
        System.out.print("Enter a task: ");
        String task = scanner.nextLine();  // This reads the task as a string
        tasks.add(task);  // We add the task to our list
        System.out.println("Task added!");  // Letting the user know the task was successfully added
    }

    // This function displays the current tasks in the list
    // If the list is empty, we tell the user there are no tasks
    private static void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Your to-do list is empty.");  // If no tasks are in the list, we tell the user
        } else {
            // We print all the tasks in the list, one by one
            System.out.println("\nYour To-Do List:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));  // Printing each task with its index number
            }
        }
    }

    // This function saves the tasks to a text file
    // We write each task on a new line in the file "todolist.txt"
    private static void saveTasksToFile() {
        try {
            // FileWriter is used to write to a file. If the file doesn't exist, it'll create it.
            FileWriter writer = new FileWriter("todolist.txt");
            
            // For every task in the list, write it to the file, one task per line
            for (String task : tasks) {
                writer.write(task + "\n");  // '\n' ensures the tasks are written on separate lines
            }
            writer.close();  // Closing the writer after we're done to free up resources
            System.out.println("Tasks saved to 'todolist.txt'.");  // Let the user know the save was successful
        } catch (IOException e) {
            // If something goes wrong while saving, we catch the error and tell the user
            System.out.println("An error occurred while saving the tasks.");
            e.printStackTrace();  // This prints out the details of the error for debugging
        }
    }
}
