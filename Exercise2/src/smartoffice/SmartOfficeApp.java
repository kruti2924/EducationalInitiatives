package smartoffice;

import smartoffice.command.*;
import smartoffice.model.MeetingRoom;
import smartoffice.observer.ACSystem;
import smartoffice.observer.LightSystem;
import smartoffice.singleton.OfficeConfig;

import java.time.LocalTime;

public class SmartOfficeApp {
    public static void main(String[] args) {
        OfficeConfig config = OfficeConfig.getInstance();

        // Configure 2 rooms
        config.configureRooms(2);
        config.setRoomCapacity(1, 5);
        config.setRoomCapacity(2, 8);

        // Add Light + AC to Room 1
        MeetingRoom room1 = config.getRoom(1);
        room1.addObserver(new LightSystem());
        room1.addObserver(new ACSystem());

        CommandInvoker invoker = new CommandInvoker();

        // Book room 1
        invoker.executeCommand(new BookRoomCommand(1, LocalTime.of(9, 0), 60, "Alice"));

        // Try to book room 1 again
        invoker.executeCommand(new BookRoomCommand(1, LocalTime.of(10, 0), 30, "Bob"));

        // Update occupancy (turns on devices)
        invoker.executeCommand(new OccupancyUpdateCommand(1, 2));

        // Make room empty (turns off devices)
        invoker.executeCommand(new OccupancyUpdateCommand(1, 0));

        // Cancel booking
        invoker.executeCommand(new CancelRoomCommand(1));
    }
}
