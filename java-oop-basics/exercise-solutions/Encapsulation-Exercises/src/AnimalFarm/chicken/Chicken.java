package AnimalFarm.chicken;

import java.text.DecimalFormat;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        setName(name);
        setAge(age);
    }

    public double getEggsPerDay() {
        return calculateProductPerDay(getAge());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.equals(" ") || name.length() < 1 ) {
            throw new IllegalArgumentException("Name cannot be empty.");
        } else {
            this.name = name;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        } else {
            this.age = age;
        }
    }

    private double calculateProductPerDay(int age) {
        if(age <= 6){
            return 2;
        }else if(age > 6 && age < 12){
            return 1;
        }else{
            return 0.75;
        }
    }
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return String.format("Chicken %s (age %d) can produce %s eggs per day.", this.getName(), this.getAge(), df.format(getEggsPerDay()));
    }
}
