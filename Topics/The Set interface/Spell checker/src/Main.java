import java.util.*;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int dictionarySize = scanner.nextInt();
        Set<String> dictionary = new HashSet<>();

        for (int i = 0; i < dictionarySize; i++) {
            dictionary.add(scanner.next().toLowerCase(Locale.ROOT));
        }

        int inputSize = scanner.nextInt();
        scanner.nextLine();
        Set<String> input = new HashSet<>();
        for (int i = 0; i < inputSize; i++) {
            input.addAll(List.of(scanner.nextLine().toLowerCase(Locale.ROOT).split(" ")));
        }

        input.removeAll(dictionary);
        input.forEach(System.out::println);

    }
}