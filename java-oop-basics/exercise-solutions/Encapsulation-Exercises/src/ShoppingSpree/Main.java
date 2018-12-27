package ShoppingSpree;

import ShoppingSpree.person.Person;
import ShoppingSpree.person.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Person> personMap = new LinkedHashMap<>();
        Map<String, Product> productsAndPrices = new HashMap<>();

        try {
            getAllPeople(reader, personMap);
            getAllProducts(reader, productsAndPrices);
            buyProduct(reader, personMap, productsAndPrices);
            getPrintPeople(personMap);

        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }

    private static void buyProduct(BufferedReader reader, Map<String, Person> personMap, Map<String, Product> productsAndPrices) throws IOException {
        String line;
        while (!"end".equalsIgnoreCase(line = reader.readLine())) {
            String[] commandArgs = line.split(" ");

            if (personMap.containsKey(commandArgs[0]) && productsAndPrices.containsKey(commandArgs[1])) {
                if(productsAndPrices.get(commandArgs[1]).getCost() <= personMap.get(commandArgs[0]).getMoney()){
                    personMap.get(commandArgs[0]).addProduct(productsAndPrices.get(commandArgs[1]));
                    System.out.println(commandArgs[0] + " bought " + commandArgs[1]);
                }else{
                    System.out.println(String.format("%s can't afford %s", commandArgs[0], commandArgs[1]));
                }
            }
        }
    }

    private static void getAllProducts(BufferedReader reader, Map<String, Product> productsAndPrices) throws IOException {
        String[] products = reader.readLine().split(";");
        for (String product : products) {
            String[] pp = product.split("=");

                Product product1 = new Product(pp[0], Integer.parseInt(pp[1]));
                productsAndPrices.put(product1.getName(), product1);
        }
    }

    private static void getAllPeople(BufferedReader reader, Map<String, Person> personMap) throws IOException {
        String[] peopleAndMoney = reader.readLine().split(";");

        for (String s : peopleAndMoney) {
            String[] pm = s.split("=");

                Person person = new Person(pm[0], Integer.parseInt(pm[1]));
                personMap.putIfAbsent(person.getName(), null);
                personMap.put(pm[0], person);
        }
    }

    private static void getPrintPeople(Map<String, Person> personMap) {
        for (Map.Entry<String, Person> stringPersonEntry : personMap.entrySet()) {
            System.out.println(stringPersonEntry.getValue());
        }
    }
}
