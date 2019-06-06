package p03_OpinionPoll;

public class Person {

    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString(){
        return this.name + " - " + this.age;
    }

}
