package smartoffice.command;

import smartoffice.model.MeetingRoom;
import smartoffice.singleton.OfficeConfig;

public class CancelRoomCommand implements Command {
    private int roomId;

    public CancelRoomCommand(int roomId) {
        this.roomId = roomId;
    }

    @Override
    public void execute() {
        OfficeConfig config = OfficeConfig.getInstance();
        MeetingRoom room = config.getRoom(roomId);

        if (room == null) {
            System.out.println("Invalid room number.");
            return;
        }

        if (room.getBooking() == null) {
            System.out.println("Room " + roomId + " is not booked. Cannot cancel booking.");
            return;
        }

        room.setBooking(null);
        System.out.println("Booking for Room " + roomId + " cancelled successfully.");
    }
}

