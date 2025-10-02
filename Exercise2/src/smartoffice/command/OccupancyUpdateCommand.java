package smartoffice.command;

import smartoffice.model.MeetingRoom;
import smartoffice.singleton.OfficeConfig;

public class OccupancyUpdateCommand implements Command {
    private int roomId;
    private int people;

    public OccupancyUpdateCommand(int roomId, int people) {
        this.roomId = roomId;
        this.people = people;
    }

    @Override
    public void execute() {
        OfficeConfig config = OfficeConfig.getInstance();
        MeetingRoom room = config.getRoom(roomId);

        if (room == null) {
            System.out.println("Invalid room number.");
            return;
        }

        room.setOccupancy(people);
    }
}
