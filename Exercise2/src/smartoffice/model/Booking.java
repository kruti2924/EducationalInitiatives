package smartoffice.model;

import java.time.LocalTime;

public class Booking {
    private int roomId;
    private LocalTime startTime;
    private int durationMinutes;  // booking duration
    private String bookedBy;      // optional (user)

    public Booking(int roomId, LocalTime startTime, int durationMinutes, String bookedBy) {
        this.roomId = roomId;
        this.startTime = startTime;
        this.durationMinutes = durationMinutes;
        this.bookedBy = bookedBy;
    }

    public int getRoomId() {
        return roomId;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public String getBookedBy() {
        return bookedBy;
    }

    public LocalTime getEndTime() {
        return startTime.plusMinutes(durationMinutes);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "Room=" + roomId +
                ", Start=" + startTime +
                ", End=" + getEndTime() +
                ", By='" + bookedBy + '\'' +
                '}';
    }
}

