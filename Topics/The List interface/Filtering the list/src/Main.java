import java.util.*;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        while (scanner.hasNext()) {
            list.add(scanner.nextInt());
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            if (i % 2 == 0) {
                continue;
            }
            System.out.print(list.get(i) + " ");
        }
    }
}