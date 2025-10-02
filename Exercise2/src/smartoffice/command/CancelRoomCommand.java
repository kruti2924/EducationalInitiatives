package smartoffice.command;

import smartoffice.model.MeetingRoom;
import smartoffice.singleton.OfficeConfig;
import smartoffice.util.Logger;

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
            Logger.getInstance().log("Invalid room number.");
            return;
        }

        if (room.getBooking() == null) {
            Logger.getInstance().log("Room " + roomId + " is not booked. Cannot cancel booking.");
            return;
        }

        room.setBooking(null);
        Logger.getInstance().log("Booking for Room " + roomId + " cancelled successfully.");
    }
}

