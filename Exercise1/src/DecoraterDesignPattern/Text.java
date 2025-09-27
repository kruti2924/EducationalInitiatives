package DecoraterDesignPattern;

//component
interface Text {
    String format();
}

//concrete component
class SimpleText implements Text {
    private final String content;

    public SimpleText(String content) {
        this.content = content;
    }

    @Override
    public String format() {
        return content;
    }
}

//decorator
abstract class TextDecorator implements Text {
    protected final Text decoratedText;

    public TextDecorator(Text text) {
        this.decoratedText = text;
    }
}

//concrete decorators
class BoldDecorator extends TextDecorator {
    public BoldDecorator(Text text) { super(text); }

    @Override
    public String format() {
        return "<b>" + decoratedText.format() + "</b>";
    }
}

class ItalicDecorator extends TextDecorator {
    public ItalicDecorator(Text text) { super(text); }

    @Override
    public String format() {
        return "<i>" + decoratedText.format() + "</i>";
    }
}



