package p04_CompanyRoster;

public class Person {

    public final static int DEFAULT_AGE = -1;

    private String name;
    private int age;


    public Person(String name) {
        this(name, DEFAULT_AGE);
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
