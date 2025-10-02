package smartoffice;

import smartoffice.command.*;
import smartoffice.model.MeetingRoom;
import smartoffice.observer.ACSystem;
import smartoffice.observer.LightSystem;
import smartoffice.singleton.OfficeConfig;

import java.time.LocalTime;
import java.util.Scanner;

public class SmartOfficeApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        OfficeConfig config = OfficeConfig.getInstance();
        CommandInvoker invoker = new CommandInvoker();

        // --- Step 1: Configure rooms ---
        System.out.print("Enter number of meeting rooms: ");
        int numRooms = sc.nextInt();
        config.configureRooms(numRooms);

        // Set capacities
        for (int i = 1; i <= numRooms; i++) {
            System.out.print("Enter capacity for Room " + i + ": ");
            int capacity = sc.nextInt();
            config.setRoomCapacity(i, capacity);
        }

        // Add Light and AC to all rooms
        for (int i = 1; i <= numRooms; i++) {
            MeetingRoom room = config.getRoom(i);
            room.addObserver(new LightSystem());
            room.addObserver(new ACSystem());
        }

        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- Smart Office Menu ---");
            System.out.println("1. Book Room");
            System.out.println("2. Cancel Booking");
            System.out.println("3. Update Occupancy");
            System.out.println("4. Show Room Status");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Room ID to book: ");
                    int roomId = sc.nextInt();
                    System.out.print("Enter start hour (0-23): ");
                    int hour = sc.nextInt();
                    System.out.print("Enter start minute (0-59): ");
                    int minute = sc.nextInt();
                    System.out.print("Enter duration in minutes: ");
                    int duration = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter user name: ");
                    String user = sc.nextLine();

                    invoker.executeCommand(new BookRoomCommand(roomId, LocalTime.of(hour, minute), duration, user));
                    break;

                case 2:
                    System.out.print("Enter Room ID to cancel booking: ");
                    int cancelRoomId = sc.nextInt();
                    invoker.executeCommand(new CancelRoomCommand(cancelRoomId));
                    break;

                case 3:
                    System.out.print("Enter Room ID to update occupancy: ");
                    int occRoomId = sc.nextInt();
                    System.out.print("Enter number of people: ");
                    int people = sc.nextInt();
                    invoker.executeCommand(new OccupancyUpdateCommand(occRoomId, people));
                    break;

                case 4:
                    System.out.println("\n--- Room Status ---");
                    for (MeetingRoom room : config.getMeetingRooms()) {
                        System.out.println(room);
                    }
                    break;

                case 5:
                    exit = true;
                    System.out.println("Exiting Smart Office App...");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        sc.close();

        // --- Sample Demonstration ---
        System.out.println("\n--- Sample Bookings ---");
        invoker.executeCommand(new BookRoomCommand(1, LocalTime.of(9, 0), 60, "Alice"));
        invoker.executeCommand(new OccupancyUpdateCommand(1, 3));
        invoker.executeCommand(new CancelRoomCommand(1));
    }
}
