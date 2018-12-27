package shapes;

public class Rectangle extends Shape {
    private double height;
    private double width;

    public Rectangle(double height, double width) {
       this.setHeight(height);
       this.setWidth(width);
       this.calculatePerimeter();
       this.calculateArea();
    }

    private final double getHeight() {
        return height;
    }

    private void setHeight(double height) {
        this.height = height;
    }

    private final double getWidth() {
        return width;
    }

    private void setWidth(double width) {
        this.width = width;
    }

    @Override
    protected void calculatePerimeter() {
        this.setPerimeter((this.getHeight() * 2) + (this.getWidth() * 2));
    }

    @Override
    protected void calculateArea() {
        this.setArea(this.getHeight() * this.getWidth());
    }
}
