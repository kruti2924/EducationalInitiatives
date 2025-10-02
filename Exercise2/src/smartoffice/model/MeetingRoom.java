package smartoffice.model;

public class MeetingRoom {
    private int id;
    private int capacity;

    public MeetingRoom(int id) {
        this.id = id;
        this.capacity = 0; // default
    }

    public int getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Room " + id + " (Capacity: " + capacity + ")";
    }
}

