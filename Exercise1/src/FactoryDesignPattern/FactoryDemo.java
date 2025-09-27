package FactoryDesignPattern;

public class FactoryDemo {
    public static void main(String[] args) {
        Shape circle = ShapeFactory.getShape("circle");
        circle.draw();

        Shape square = ShapeFactory.getShape("square");
        square.draw();

        Shape rectangle = ShapeFactory.getShape("rectangle");
        rectangle.draw();

        Shape triangle = ShapeFactory.getShape("triangle");
        triangle.draw();
    }
}
