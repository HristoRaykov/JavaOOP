package ShoppingSpree.person;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Person {
    private String name;
    private int money;
    private List<Product> productList;

    public Person(String name, int money) {
        setName(name);
        setMoney(money);
        setProductList();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() > 1) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        } else {
            this.money = money;
        }
    }

    private List<Product> getProductList() {
        return productList;
    }

    private void setProductList() {
        this.productList = new LinkedList<>();
    }

    public void addProduct(Product product){
        if(product.getCost() > this.getMoney()){
            System.out.println(String.format("%s can't afford %s", getName(), product.getName()));
        }else{
            this.getProductList().add(product);
            spentMoney(product.getCost());
        }
    }

    private void spentMoney(int cost){
        this.money -= cost;
    }


    @Override
    public String toString() {
        if(getProductList().size() > 0) {
            return getName() + " - " + String.join(", ", getProductList().toString().replaceAll("[]\\[]", ""));
        }else{
            return  getName() + " - Nothing bought";
        }
    }

}
