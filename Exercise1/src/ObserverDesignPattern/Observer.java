package ObserverDesignPattern;
import java.util.ArrayList;
import java.util.List;

//observer interface
interface Observer {
    void update(String message);
}

//subject interface
interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

//concrete subject class
class SocialMediaUser implements Subject {
    private final List<Observer> followers = new ArrayList<>();
    private String latestPost;

    @Override
    public void addObserver(Observer observer) {
        followers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        followers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer follower : followers) {
            follower.update(latestPost);
        }
    }

    public void postMessage(String message) {
        this.latestPost = message;
        notifyObservers();
    }
}

//concrete observer classes
class PhoneNotification implements Observer {
    private String message;

    @Override
    public void update(String message) {
        this.message = message;
        display();
    }

    private void display() {
        System.out.println("Phone Notification: New post - " + message);
    }
}

class EmailNotification implements Observer {
    private String message;

    @Override
    public void update(String message) {
        this.message = message;
        display();
    }

    private void display() {
        System.out.println("Email Notification: New post - " + message);
    }
}

