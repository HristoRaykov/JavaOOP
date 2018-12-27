package methodOverriding;

public class Rectangle {
    private double sideA;
    private double sideB;

    public Rectangle(double sideA) {
        this.sideA = sideA;
    }

    public Rectangle(double sideA, double sideB){
        this.sideA = sideA;
        this.sideB = sideB;
    }

    protected double getSideA(){
       return this.sideA;
    }

    protected double getSideB(){
        return this.sideB;
    }

    public double calculateArea(){
        return this.sideA * this.sideB;
    }

    public double calculatePerimeter(){
        return this.getSideA() * 2 + this.getSideB() * 2;
    }

}
