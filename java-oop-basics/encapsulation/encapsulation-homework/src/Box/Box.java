package Box;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }
    private void setLength(double length){
        if(length < 1){
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }else{
            this.length = length;
        }
    }
    private void setWidth(double width){
        if(width < 1){
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }else{
            this.width = width;
        }
    }
    private void setHeight(double height){
        if(height < 1){
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }else{
            this.height = height;
        }
    }


    public double getSurfaceArea(){
       return surfaceArea(this.length, this.width, this.height);
    }

    public double getLateralSurfaceArea(){
        return lateralSurfaceArea(this.length, this.width, this.height);
    }

    public double getVolume(){
        return volume(this.length, this.width, this.height);
    }

    private double surfaceArea(double length, double width, double height) {
        double area = 2 * (length * width) + 2 * (length * height) + 2 * (height * width);
        return area;
    }

    private double lateralSurfaceArea(double length, double width, double height){
        double area = 2 * (length * height) + 2 * (width * height);
        return area;
    }

    private double volume(double length, double width, double height){
        double volume = length * height * width;
        return volume;
    }

}
