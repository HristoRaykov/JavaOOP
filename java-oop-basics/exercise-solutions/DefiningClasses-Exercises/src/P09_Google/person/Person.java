package P09_Google.person;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private Company company;
    private List<Parent> parents;
    private List<Child> children;
    private Car car;
    private List<Pokemon> pokemons;

    public Person(String name, Company company, Parent parent, Child child, Car car, Pokemon pokemon) {
        this.name = name;
        this.company = company;
        this.parents = new ArrayList<>();
        if(parent != null)
        this.parents.add(parent);
        this.children = new ArrayList<>();
        if(child != null)
        this.children.add(child);
        this.car = car;
        this.pokemons = new ArrayList<>();
        if(pokemon != null)
        this.pokemons.add(pokemon);
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setParents(Parent parent) {
        this.parents.add(parent);
    }

    public void setChildren(Child children) {
        this.children.add(children);
    }

    public void setPokemons(Pokemon pokemons) {
        this.pokemons.add(pokemons);
    }

    public List<Parent> getParents() {
        return parents;
    }

    public List<Child> getChildren() {
        return children;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public String getName() {
        return name;
    }

    public Car getCar() {
        return car;
    }

    public Company getCompany() {
        return company;
    }

}
