package Encapsulation;

public class Person {

    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getAge() {
        return this.age;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Person(String name, String lastName, int age, double salary) {

        if(name.length() < 3){
            throw new IllegalArgumentException("First name cannot be less than 3 symbols");
        }else{
            this.firstName = name;
        }
        if(lastName.length() < 3){
            throw new IllegalArgumentException("Last name cannot be less than 3 symbols");
        }else{
            this.lastName = lastName;
        }
        if(age < 1){
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }else{
            this.age = age;
        }
        if(salary < 460){
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }else{
            this.salary = salary;
        }

    }

    public void increaseSalary(double bonus) {
        if (this.age > 30) {
            this.salary += this.salary * (bonus / 100.0);
        } else {
            this.salary += this.salary * (bonus / 200.0);

        }
    }

    @Override
    public String toString() {
        return getFirstName() + " " + getLastName() + " get " + getSalary() + " leva";
    }
}
