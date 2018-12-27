import java.util.*;

public class p08_HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, Integer> power = new HashMap<>();

        ArrayList<String> keys = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"));
        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14);

        for (int i = 0; i < values.size(); i++) {
            power.put(keys.get(i), values.get(i));
        }

        LinkedHashMap<String, Integer> players = new LinkedHashMap<>(); // name + sum
        HashMap<String, List<String>> usersCards = new HashMap<>(); //username + cards

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("JOKER")) {
                break;
            }
            String[] arguements = input.split(": ");
            String name = arguements[0];
            String[] cards1 = arguements[1].split(", ");
            HashSet<String> cards = new HashSet<>();
            Collections.addAll(cards, cards1);

            int sum = 0;
            for (String card : cards) {
                String cardPower;
                String cardValue;
                if (card.length() == 2) {
                    cardPower = String.valueOf(card.charAt(0));
                    cardValue = String.valueOf(card.charAt(1));
                } else {
                    cardPower = String.valueOf(card.charAt(0)) + String.valueOf(card.charAt(1));
                    cardValue = String.valueOf(card.charAt(2));
                }

                usersCards.putIfAbsent(name, new LinkedList<>());

                if (!usersCards.get(name).contains(card)) {
                    int p = 0;
                    if (power.containsKey(cardPower)) {
                        p = power.get(cardPower);
                    }
                    int value = 0;
                    switch (cardValue) {
                        case "C":
                            value = 1;
                            break;
                        case "D":
                            value = 2;
                            break;
                        case "H":
                            value = 3;
                            break;
                        case "S":
                            value = 4;
                            break;
                    }
                    sum += p * value;
                }
                usersCards.get(name).add(card);
            }
            players.putIfAbsent(name, 0);
            players.put(name, players.get(name) + sum);
        }

        for (String s : players.keySet()) {
            System.out.printf("%s: %d\n", s, players.get(s));
        }

    }
}
