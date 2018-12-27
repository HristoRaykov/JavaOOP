package StackOfStrings;

import java.util.ArrayList;
import java.util.List;

public class StackOfStrings {
    private List<String> data = new ArrayList<>();

    public void push(String element){
        data.add(element);
    }
    public String pop(){
        if(!this.data.isEmpty()) {
            String element = data.get(data.size() - 1);
            data.remove(data.size() - 1);
            return element;
        }
        return null;
    }

    public String peek(){
        if(!this.data.isEmpty()) {
            return data.get(data.size() - 1);
        }
        return null;
    }

    public boolean isEmpty(){
        return data.size() > 0;
    }
}
