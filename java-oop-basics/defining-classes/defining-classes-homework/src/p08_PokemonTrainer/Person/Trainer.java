package p08_PokemonTrainer.Person;

import java.util.ArrayList;
import java.util.List;

public class Trainer {

    private String name;

    private int numberOfBadges;

    private List<Pokemon> pokemonList;

    public Trainer(String name) {
        this.name = name;
        this.numberOfBadges = 0;
        this.pokemonList = new ArrayList<>();
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }
    public void setNumberOfBadges(){
        numberOfBadges++;
    }

    public void setPokemonList(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }
    public String getName(){
        return this.name;
    }
    public int getNumberOfBadges(){
        return this.numberOfBadges;
    }
}
