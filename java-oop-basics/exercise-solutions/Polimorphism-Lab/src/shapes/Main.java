package shapes;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Shape circle = new Circle(2.5);
        Shape rect = new Rectangle(5.0, 6.0);

        List<Shape> shapes = new ArrayList<>();
        shapes.add(circle);
        shapes.add(rect);

        for (Shape shape : shapes) {
            System.out.println(shape.getArea() + " " + shape.getPerimeter());
        }
    }
}
