package diary;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Diary {
    private final Scanner scanner = new Scanner(System.in);
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public void run() {
        System.out.println("=== Simple Diary ===");
        boolean running = true;

        while (running) {
            System.out.println("\n1. Add Entry");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addEntry();
                    break;
                case 2:
                    running = false;
                    System.out.println("Exiting Diary...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void addEntry() {
        System.out.print("Enter your diary entry: ");
        String text = scanner.nextLine();
        String timestamp = LocalDateTime.now().format(formatter);
        String entry = timestamp + " - " + text;
        FileHandler.saveEntry(entry);
        System.out.println("Entry saved.");
    }
}

