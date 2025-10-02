package smartoffice.observer;

public class LightSystem implements Observer {
    private boolean isOn = false;

    @Override
    public void update(String message) {
        if (message.contains("occupied")) {
            isOn = true;
            System.out.println("Lights turned ON.");
        } else if (message.contains("unoccupied")) {
            isOn = false;
            System.out.println("Lights turned OFF.");
        }
    }

    public boolean isOn() {
        return isOn;
    }
}

