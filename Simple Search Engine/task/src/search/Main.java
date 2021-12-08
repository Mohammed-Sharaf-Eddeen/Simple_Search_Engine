package search;

import search.strategies.AllSearchStrategy;
import search.strategies.AnySearchStrategy;
import search.strategies.NoneSearchStrategy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static List<String> people = new ArrayList<>();
    public static Map<String, List<Integer>> invertedIndex = new HashMap<>();
    static File dataFile = null;
    static Scanner lineReader;

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (Objects.equals(args[i], "--data")) {
                dataFile = new File(args[i + 1]);
                break;
            }
        }

        try {
            lineReader = new Scanner(dataFile);
            while (lineReader.hasNextLine()) {
                String line = lineReader.nextLine().trim();
                people.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            lineReader.close();
        }

        try {
            lineReader = new Scanner(dataFile);
            int lineNumber = 0;
            while (lineReader.hasNextLine()) {
                Scanner wordReader = new Scanner(lineReader.nextLine().toLowerCase(Locale.ROOT));
                while (wordReader.hasNext()) {
                    String word = wordReader.next();
                    List<Integer> indexes = new ArrayList<>();
                    indexes.add(lineNumber);
                    invertedIndex.merge(word, indexes, (oldList, newList) ->
                            Stream.concat(oldList.stream(), newList.stream())
                                    .collect(Collectors.toList()));
                }
                lineNumber++;
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            lineReader.close();
        }

        System.out.println(invertedIndex);

        boolean finished = false;
        while (!finished) {
            showMenu();
            int menuOption = scanner.nextInt();

            switch(menuOption) {
                case 0:
                    finished = true;
                    System.out.println("\nBye!");
                    break;
                case 1:
                    searchOption();
                    break;
                case 2:
                    printOption();
                    break;
                default:
                    System.out.println("\nIncorrect option! Try again.");
                    break;
            }
        }
    }

    static void searchOption() {
        System.out.println("\nSelect a matching strategy: ALL, ANY, NONE");
        scanner.nextLine();
        String searchStrategySelected = scanner.nextLine().trim();
        SearchStrategyContext ssc = null;

        switch(searchStrategySelected) {
            case "ANY":
                ssc = new SearchStrategyContext(new AnySearchStrategy());
                break;
            case "ALL":
                ssc = new SearchStrategyContext(new AllSearchStrategy());
                break;
            case "NONE":
                ssc = new SearchStrategyContext(new NoneSearchStrategy());
                break;
        }

        System.out.println("\nEnter a name or email to search all suitable people.");
        String searchKeywords = scanner.nextLine().trim().toLowerCase(Locale.ROOT);

        List<Integer> linePositions = ssc.search(searchKeywords);
        if (linePositions.size() != 0) {
            System.out.println("\nFound people: ");
            for (Integer n : linePositions) {
                System.out.println(people.get(n));
            }
        } else {
            System.out.println("No matching people found.");
        }

    }

    static void showMenu() {
        System.out.println("\n=== Menu ===\n" +
                "1. Find a person\n" +
                "2. Print all people\n" +
                "0. Exit");
    }

    static void printOption() {
        for (String person : people) {
            System.out.println(person);
        }
    }
}
