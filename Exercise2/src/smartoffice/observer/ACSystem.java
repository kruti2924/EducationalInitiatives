package smartoffice.observer;

public class ACSystem implements Observer {
    private boolean isOn = false;

    @Override
    public void update(String message) {
        if (message.contains("occupied")) {
            isOn = true;
            System.out.println("AC turned ON.");
        } else if (message.contains("unoccupied")) {
            isOn = false;
            System.out.println("AC turned OFF.");
        }
    }

    public boolean isOn() {
        return isOn;
    }
}

