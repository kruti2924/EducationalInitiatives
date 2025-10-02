package smartoffice.model;

import smartoffice.observer.Observer;
import smartoffice.observer.Subject;

import java.util.ArrayList;
import java.util.List;

public class MeetingRoom implements Subject {
    private int id;
    private int capacity;
    private int occupancy;
    private Booking booking;
    private List<Observer> observers = new ArrayList<>();

    public MeetingRoom(int id) {
        this.id = id;
        this.capacity = 0;
        this.occupancy = 0;
        this.booking = null;
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

    public int getOccupancy() {
        return occupancy;
    }

    // when occupancy changes → notify observers
    public void setOccupancy(int occupancy) {
        this.occupancy = occupancy;
        if (occupancy >= 2) {
            notifyObservers("Room " + id + " is now occupied");
        } else {
            notifyObservers("Room " + id + " is now unoccupied");
        }
    }

    // Booking handling
    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    // ---------------- Observer methods ----------------
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer obs : observers) {
            obs.update(message);
        }
    }

    @Override
    public String toString() {
        String bookingInfo = (booking != null) ? booking.toString() : "No active booking";
        return "Room " + id + " (Capacity: " + capacity + ", Occupancy: " + occupancy + ", " + bookingInfo + ")";
    }
}
