package shapes;

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.setRadius(radius);
        this.calculatePerimeter();
        this.calculateArea();
    }

    public final double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    protected void calculatePerimeter() {
        this.setPerimeter(2 * 3.14 * this.getRadius());
    }

    @Override
    protected void calculateArea() {
        this.setArea(3.14 * this.getRadius() * this.getRadius());
    }
}
