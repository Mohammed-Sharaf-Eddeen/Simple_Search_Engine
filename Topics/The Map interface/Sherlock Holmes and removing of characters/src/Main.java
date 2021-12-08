import java.util.*;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        String wordOne = scanner.next().trim().toLowerCase(Locale.ROOT);
        Map<Character, Integer> charMapOne = new HashMap<>();
        wordOne.chars()
                .forEach(i -> {
                    charMapOne.putIfAbsent((char) i, 0);
                    charMapOne.put((char) i, charMapOne.get((char) i) + 1);
                });

        String wordTwo = scanner.next().trim().toLowerCase(Locale.ROOT);
        Map<Character, Integer> charMapTwo = new HashMap<>();
        wordTwo.chars()
                .forEach(i -> {
                    charMapTwo.putIfAbsent((char) i, 0);
                    charMapTwo.put((char) i, charMapTwo.get((char) i) + 1);
                });


        int toBeRemoved = 0;
        for (Character ch : charMapOne.keySet()) {
            if (charMapTwo.containsKey(ch)) {
                toBeRemoved += Math.abs(charMapOne.get(ch) - charMapTwo.get(ch));
            } else {
                toBeRemoved += charMapOne.get(ch);
            }
        }

        for (Character ch : charMapTwo.keySet()) {
            if (!charMapOne.containsKey(ch)) {
                toBeRemoved += charMapTwo.get(ch);
            }
        }

        System.out.println(toBeRemoved);

    }
}