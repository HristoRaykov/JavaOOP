package P09_Google.person;

public class Company {
    private String name;
    private String departament;
    private double salary;

    public Company(String name, String departament, double salary) {
        this.name = name;
        this.departament = departament;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", this.name, this.departament, this.salary);
    }
}
