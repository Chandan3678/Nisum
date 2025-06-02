package day2;



import java.util.*;

class Event {
    String title;
    String time;
    String description;

    // Constructor for Event
    public Event(String title, String time, String description) {
        this.title = title;
        this.time = time;
        this.description = description;
    }

    // Override toString to display event details
    @Override
    public String toString() {
        return "Title: " + title + ", Time: " + time + ", Description: " + description;
    }
}

public class EventCalendar {
    // TreeMap to store events by date, ensuring chronological order
    private static TreeMap<String, List<Event>> eventCalendar = new TreeMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Add sample events
        addEvent("2025-05-15", new Event("Sprint Day 3", "10:00 AM", "Discuss project progress"));
        addEvent("2025-05-16", new Event("Doctor's Appointment", "2:30 PM", "Annual health check-up"));
        addEvent("2025-05-15", new Event("Study session", "2:00 PM", "Discuss about JAVA"));
        addEvent("2025-05-17", new Event("Team Outing", "9:00 AM", "Company picnic"));

        // Display all events
        System.out.println("All Upcoming Events:");
        displayAllEvents();

        // Allow user to add or remove events
        boolean running = true;
        while (running) {
            System.out.println("1. Add Event");
            System.out.println("2. Remove Event");
            System.out.println("3. View Events for a Specific Day");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1/2/3/4): ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume the newline

            switch (choice) {
                case 1 -> {
                    // Add a new event
                    System.out.println("\nEnter a new event details:");
                    System.out.print("Enter event title: ");
                    String newTitle = sc.nextLine();
                    System.out.print("Enter event time: ");
                    String newTime = sc.nextLine();
                    System.out.print("Enter event description: ");
                    String newDescription = sc.nextLine();
                    System.out.print("Enter event date (YYYY-MM-DD): ");
                    String newDate = sc.nextLine();
                    addEvent(newDate, new Event(newTitle, newTime, newDescription));
                    System.out.println("\nEvent added successfully!");
                }
                case 2 -> {
                    // Remove an event
                    System.out.print("\nEnter a date and event title to remove (YYYY-MM-DD, Title): ");
                    String removeDate = sc.nextLine();
                    String removeTitle = sc.nextLine();
                    removeEvent(removeDate, removeTitle);
                    System.out.println("\nEvent removed successfully!");
                }
                case 3 -> {
                    // View events for a specific day
                    System.out.print("\nEnter a date to view events (YYYY-MM-DD): ");
                    String viewDate = sc.nextLine();
                    displayEventsForDate(viewDate);
                }
                case 4 ->
                    // Exit
                        running = false;
                default -> System.out.println("Invalid choice! Please enter 1, 2, 3, or 4.");
            }

            // Display updated events
            System.out.println("\nUpdated Events List:");
            displayAllEvents();
        }

        sc.close();
    }

    // Method to add an event
    public static void addEvent(String date, Event event) {
        eventCalendar.putIfAbsent(date, new ArrayList<>());  // If date doesn't exist, initialize an empty list
        eventCalendar.get(date).add(event);  // Add the event to the date's list
    }

    // Method to remove an event by date and title
    public static void removeEvent(String date, String title) {
        if (eventCalendar.containsKey(date)) {
            List<Event> events = eventCalendar.get(date);
            boolean removed = events.removeIf(event -> event.title.equals(title));  // Remove event by title
            // If no events left for this date, remove the date entry from the TreeMap
            if (removed && events.isEmpty()) {
                eventCalendar.remove(date);
            }
        } else {
            System.out.println("No events found for the specified date.");
        }
    }

    // Method to display events for a specific date
    public static void displayEventsForDate(String date) {
        if (eventCalendar.containsKey(date)) {
            System.out.println("\nEvents on " + date + ":");
            for (Event event : eventCalendar.get(date)) {
                System.out.println(event);
            }
        } else {
            System.out.println("No events found for " + date);
        }
    }

    public static void displayAllEvents() {
        if (eventCalendar.isEmpty()) {
            System.out.println("No events scheduled.");
        } else {
            for (Map.Entry<String, List<Event>> entry : eventCalendar.entrySet()) {
                System.out.println("\nDate: " + entry.getKey());
                for (Event event : entry.getValue()) {
                    System.out.println(event);
                }
            }
        }
    }
}