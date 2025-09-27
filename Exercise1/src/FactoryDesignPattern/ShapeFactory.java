package FactoryDesignPattern;

class Circle implements Shape {
    public void draw() { System.out.println("Drawing Circle"); }
}

class Square implements Shape {
    public void draw() { System.out.println("Drawing Square"); }
}

class Rectangle implements Shape {
    public void draw() { System.out.println("Drawing Rectangle"); }
}

class Triangle implements Shape {
    public void draw() { System.out.println("Drawing Triangle"); }
}

public class ShapeFactory {
    public static Shape getShape(String type) {
        if ("circle".equalsIgnoreCase(type)) {
            return new Circle();
        } else if ("square".equalsIgnoreCase(type)) {
            return new Square();
        } else if ("rectangle".equalsIgnoreCase(type)) {
            return new Rectangle();
        } else if ("triangle".equalsIgnoreCase(type)) {
            return new Triangle();
        }
        throw new IllegalArgumentException("Unknown shape type");
    }
}

