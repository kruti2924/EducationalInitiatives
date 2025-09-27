package ObserverDesignPattern;

public class ObserverDemo {
    public static void main(String[] args) {
        SocialMediaUser user = new SocialMediaUser();

        Observer phone = new PhoneNotification();
        Observer email = new EmailNotification();

        user.addObserver(phone);
        user.addObserver(email);

        user.postMessage("Just uploaded a new photo!");
        user.postMessage("Check out my latest blog post!");

        user.removeObserver(email);

        user.postMessage("Going live in 5 minutes!");
    }
}
