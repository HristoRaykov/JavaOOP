package methodOverriding;

public class Square extends Rectangle {

    public Square(double sideA) {
        super(sideA);
    }

    @Override
    public double calculateArea() {
        return this.getSideA() * this.getSideA();
    }

    @Override
    public double calculatePerimeter() {
        return this.getSideA() * 4;
    }
}
