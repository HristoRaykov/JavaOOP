package p08_PokemonTrainer;

import p08_PokemonTrainer.Person.Pokemon;
import p08_PokemonTrainer.Person.Trainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashSet<Trainer> trainers = new LinkedHashSet<>();

        fillWithTrainers(reader, trainers);
        String line;

        line = reader.readLine();

        while (!"End".equals(line)) {
            if(line.equals("Fire") || line.equals("Water") || line.equals("Electricity")) {
                checkForElements(trainers, line);
            }
            line = reader.readLine();
        }

        printResult(trainers);
    }

    private static void fillWithTrainers(BufferedReader reader, LinkedHashSet<Trainer> trainers) throws IOException {
        String line = reader.readLine();

        while (!"Tournament".equals(line)) {
            String[] commandArgs = line.split(" ");
            String trainerName = commandArgs[0];
            String pokemonName = commandArgs[1];
            String pokemonElement = commandArgs[2];
            long pokemonHealth = Long.parseLong(commandArgs[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            boolean trainerIsPresent = false;
            for (Trainer trainer : trainers) {
                if (trainer.getName().equals(trainerName)) {
                    trainerIsPresent = true;
                    trainer.getPokemonList().add(pokemon);
                    break;
                }
            }
            if (!trainerIsPresent) {
                Trainer trainer = new Trainer(trainerName);

                trainer.getPokemonList().add(pokemon);
                trainers.add(trainer);
            }

            line = reader.readLine();
        }
    }

    private static void printResult(LinkedHashSet<Trainer> trainers) {
        for (Trainer trainer : trainers) {
            trainer.setPokemonList(trainer.getPokemonList().stream().filter(p -> p.getHealth() > 0).collect(Collectors.toList()));
        }

        trainers.stream().sorted(Comparator.comparing(Trainer::getNumberOfBadges, Comparator.reverseOrder())).forEach(t -> {
            System.out.printf("%s %d %d%n", t.getName(), t.getNumberOfBadges(), t.getPokemonList().size());
        });
    }

    private static void checkForElements(HashSet<Trainer> trainers, String line) {
        for (Trainer trainer : trainers) {
            boolean elementIsFound = false;
            for (Pokemon pokemon : trainer.getPokemonList()) {
                if (pokemon.getElement().equals(line)) {
                    elementIsFound = true;
                    trainer.setNumberOfBadges();
                    break;
                }
            }
            if (!elementIsFound) {
                for (int i = trainer.getPokemonList().size() - 1 ; i >= 0; i--) {
                    trainer.getPokemonList().get(i).setHealth();
                    if(trainer.getPokemonList().get(i).getHealth() <= 0){
                        trainer.getPokemonList().remove(i);
                    }
                }
            }
        }
    }
}
