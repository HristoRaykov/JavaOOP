package P09_Google;

import P09_Google.person.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();

        Map<String, Person> personMap = new HashMap<>();

        while (!"end".equalsIgnoreCase(line)) {
            String[] commandArgs = line.split(" ");
            String personName = commandArgs[0];

            Person person = null;
            Car car = null;
            Child child = null;
            Company company = null;
            Parent parent = null;
            Pokemon pokemon = null;

            switch (commandArgs[1]) {
                case "company":
                    String companyName = commandArgs[2];
                    String department = commandArgs[3];
                    double salary = Double.parseDouble(commandArgs[4]);
                    company = new Company(companyName, department, salary);
                    break;
                case "pokemon":
                    String pokemonName = commandArgs[2];
                    String pokemonType = commandArgs[3];
                    pokemon = new Pokemon(pokemonName, pokemonType);
                    break;
                case "parents":
                    String parentName = commandArgs[2];
                    String parentDate = commandArgs[3];
                    parent = new Parent(parentName, parentDate);
                    break;
                case "children":
                    String childName = commandArgs[2];
                    String childDate = commandArgs[3];
                    child = new Child(childName, childDate);
                    break;
                case "car":
                    String carModel = commandArgs[2];
                    int carSpeed = Integer.parseInt(commandArgs[3]);
                    car = new Car(carModel, carSpeed);
                    break;
            }

            if (!personMap.containsKey(personName)) {
                person = new Person(personName, company, parent, child, car, pokemon);
                personMap.put(personName, person);
            } else {
                if (company != null) {
                    personMap.get(personName).setCompany(company);
                }
                if (car != null) {
                    personMap.get(personName).setCar(car);
                }
                if (child != null) {
                    personMap.get(personName).setChildren(child);
                }
                if (parent != null) {
                    personMap.get(personName).setParents(parent);
                }
                if (pokemon != null) {
                    personMap.get(personName).setPokemons(pokemon);
                }
            }
            line = reader.readLine();
        }
        String getPerson = reader.readLine();
        System.out.println(personMap.get(getPerson).getName() + "\nCompany: ");
        if(personMap.get(getPerson).getCompany() != null){
            System.out.println(personMap.get(getPerson).getCompany());
        }
        System.out.println("Car:");
        if(personMap.get(getPerson).getCar() != null){
            System.out.println(personMap.get(getPerson).getCar());
        }

        System.out.println("Pokemon:");
        if(personMap.get(getPerson).getPokemons().size() > 0) {
            personMap.get(getPerson).getPokemons().forEach(System.out::println);
        }
        System.out.println("Parents:");
        if(personMap.get(getPerson).getParents().size() > 0) {
            personMap.get(getPerson).getParents().forEach(System.out::println);
        }
        System.out.println("Children:");
        if(personMap.get(getPerson).getChildren().size() > 0) {
            personMap.get(getPerson).getChildren().forEach(System.out::println);
        }
    }
}
