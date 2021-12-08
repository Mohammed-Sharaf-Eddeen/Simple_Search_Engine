import java.util.*;

class MapUtils {

    public static SortedMap<String, Integer> wordCount(String[] strings) {
        // write your code here
        SortedMap<String, Integer> wordFrequency = new TreeMap<>();
        for (String str : strings) {
            if (wordFrequency.containsKey(str)) {
                wordFrequency.put(str, wordFrequency.get(str) + 1);
            } else {
                wordFrequency.put(str, 1);
            }
        }
        return wordFrequency;
    }

    public static void printMap(Map<String, Integer> map) {
        // write your code here
        map.forEach((key, val) -> System.out.println(key + " : " + val));
    }

}

/* Do not change code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        MapUtils.printMap(MapUtils.wordCount(words));
    }
}