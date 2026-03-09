package com.Service;

import com.DAO.impl.EntriesDaoImpl;
import com.DAO.impl.TopicsDaoImpl;
import com.model.Entry;
import com.model.Topic;

import java.util.List;
import java.util.Scanner;

public class LearningLogService {
    private static Scanner scanner = new Scanner(System.in);
    private static TopicsDaoImpl topicDAO = new TopicsDaoImpl();
    private static EntriesDaoImpl entryDAO = new EntriesDaoImpl(topicDAO);

    public void start()
    {
        System.out.println("=================================");
        System.out.println("  WELCOME ");
        System.out.println("=================================");

        while (true) {
            displayMainMenu();
            int option = getIntInput("Choose an option: ");

            switch (option) {
                case 1:
                    topicMenu();
                    break;
                case 2:
                    entryMenu();
                    break;
                case 3:
                    System.out.println("Thank you for using Learning Journal. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void displayMainMenu() {
        System.out.println("\n=== MAIN MENU ===");
        System.out.println("1. Topic Management");
        System.out.println("2. Entry Management");
        System.out.println("3. Exit");
    }

    private static void topicMenu() {
        while (true) {
            System.out.println("\n=== TOPIC MANAGEMENT ===");
            System.out.println("1. Add New Topic");
            System.out.println("2. View All Topics");
            System.out.println("3. Back to Main Menu");

            int option = getIntInput("Choose an option: ");

            switch (option) {
                case 1:
                    addTopic();
                    break;
                case 2:
                    viewAllTopics();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void entryMenu() {
        while (true) {
            System.out.println("\n=== ENTRY MANAGEMENT ===");
            System.out.println("1. Add New Entry");
            System.out.println("2. View All Entries");
            System.out.println("3. Back to Main Menu");

            int option = getIntInput("Choose an option: ");

            switch (option) {
                case 1:
                    addEntry();
                    break;
                case 2:
                    viewAllEntries();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void addTopic() {
        System.out.println("\n--- Add New Topic ---");
        System.out.print("Enter topic name: ");
        String name = scanner.nextLine();

        // FIXED: Create Topic with the name, not empty constructor
        Topic topic = new Topic(name);
        Topic added = topicDAO.addTopic(topic);  // FIXED: method name should be addTopic, not addTopic

        if (added != null) {
            System.out.println("Topic added successfully! ID: " + added.getId());
        }
    }

    private static void viewAllTopics() {
        System.out.println("\n--- All Topics ---");
        List<Topic> topics = topicDAO.getAllTopics();
        if (topics.isEmpty()) {
            System.out.println("No topics found.");
        } else {
            for (Topic topic : topics) {
                System.out.println(topic);
            }
        }
    }

    private static void addEntry() {
        System.out.println("\n--- Add New Entry ---");

        List<Topic> topics = topicDAO.getAllTopics();
        if (topics.isEmpty()) {
            System.out.println("Please add a topic first.");
            return;
        }

        System.out.println("Available Topics:");
        for (Topic topic : topics) {
            System.out.println("ID: " + topic.getId() + " | " + topic.getName());
        }

        int topicId = getIntInput("Enter topic ID: ");
        System.out.print("Enter your learning note: ");
        String note = scanner.nextLine();

        Entry entry = new Entry(topicId, note);
        Entry added = entryDAO.addEntry(entry);

        if (added != null) {
            System.out.println("Entry added successfully! ID: " + added.getId());
        }
    }

    private static void viewAllEntries() {
        System.out.println("\n--- All Entries ---");
        List<Entry> entries = entryDAO.getAllEntries();
        if (entries.isEmpty()) {
            System.out.println("No entries found.");
        } else {
            for (Entry entry : entries) {
                System.out.println(entry);
            }
        }
    }



    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = Integer.parseInt(scanner.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}

