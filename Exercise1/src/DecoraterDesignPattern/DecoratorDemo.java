package DecoraterDesignPattern;

public class DecoratorDemo {
    public static void main(String[] args) {
        Text myText = new SimpleText("Hello, World!");
        myText = new BoldDecorator(myText);       // Add bold
        myText = new ItalicDecorator(myText);     // Add italic

        System.out.println(myText.format());
    }
}
