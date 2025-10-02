package smartoffice.command;

import smartoffice.model.Booking;
import smartoffice.model.MeetingRoom;
import smartoffice.singleton.OfficeConfig;
import smartoffice.util.Logger;

import java.time.LocalTime;

public class BookRoomCommand implements Command {
    private int roomId;
    private LocalTime startTime;
    private int durationMinutes;
    private String user;

    public BookRoomCommand(int roomId, LocalTime startTime, int durationMinutes, String user) {
        this.roomId = roomId;
        this.startTime = startTime;
        this.durationMinutes = durationMinutes;
        this.user = user;
    }

    @Override
    public void execute() {
        OfficeConfig config = OfficeConfig.getInstance();
        MeetingRoom room = config.getRoom(roomId);

        if (room == null) {
            Logger.getInstance().log("Invalid room number.");
            return;
        }

        if (room.getBooking() != null) {
            Logger.getInstance().log("Room " + roomId + " is already booked. Cannot book again.");
            return;
        }

        Booking booking = new Booking(roomId, startTime, durationMinutes, user);
        room.setBooking(booking);
        Logger.getInstance().log("Room " + roomId + " booked from " + startTime + " for " + durationMinutes + " minutes.");
    }
}

