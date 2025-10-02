package smartoffice.singleton;

import smartoffice.model.MeetingRoom;
import java.util.ArrayList;
import java.util.List;
import smartoffice.util.Logger;

public class OfficeConfig {
    private static OfficeConfig instance;   // singleton instance
    private List<MeetingRoom> meetingRooms; // list of rooms

    // private constructor
    private OfficeConfig() {
        meetingRooms = new ArrayList<>();
    }

    // static method to get instance (lazy initialization)
    public static OfficeConfig getInstance() {
        if (instance == null) {
            instance = new OfficeConfig();
        }
        return instance;
    }

    // configure number of rooms
    public void configureRooms(int count) {
        meetingRooms.clear();
        for (int i = 1; i <= count; i++) {
            meetingRooms.add(new MeetingRoom(i));
        }
        Logger.getInstance().log("Office configured with " + count + " meeting rooms.");
    }

    // set max capacity for a room
    public void setRoomCapacity(int roomId, int capacity) {
        if (roomId > 0 && roomId <= meetingRooms.size()) {
            meetingRooms.get(roomId - 1).setCapacity(capacity);
            Logger.getInstance().log("Room " + roomId + " maximum capacity set to " + capacity + ".");
        } else {
            Logger.getInstance().log("Invalid room number.");
        }
    }

    // get all rooms
    public List<MeetingRoom> getMeetingRooms() {
        return meetingRooms;
    }

    // get specific room by id
    public MeetingRoom getRoom(int roomId) {
        if (roomId > 0 && roomId <= meetingRooms.size()) {
            return meetingRooms.get(roomId - 1);
        }
        return null;
    }
}
