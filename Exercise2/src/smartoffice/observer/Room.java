package smartoffice.observer;

import java.util.ArrayList;
import java.util.List;

public class Room implements Subject {
    private int id;
    private int occupancy = 0;
    private List<Observer> observers = new ArrayList<>();

    public Room(int id) {
        this.id = id;
    }

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

    // update occupancy
    public void setOccupancy(int people) {
        this.occupancy = people;
        if (people >= 2) {
            notifyObservers("Room " + id + " is now occupied");
        } else {
            notifyObservers("Room " + id + " is now unoccupied");
        }
    }

    public int getId() {
        return id;
    }

    public int getOccupancy() {
        return occupancy;
    }
}

