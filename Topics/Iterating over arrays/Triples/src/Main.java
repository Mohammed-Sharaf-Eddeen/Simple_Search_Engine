import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        //{0 1 2 3 4 5}
        //size = 6
        int i = 0;
        int triples = 0;
        while (true) {
            if (size - i < 3) {
                break;
            }
            int firstElement = array[i];
            int secondElement = array[i + 1];
            int thirdElement = array[i + 2];

            if ((firstElement + 1) == secondElement && (secondElement + 1) == thirdElement) {
                triples++;
            }

            i++;
        }
        System.out.println(triples);
    }

}
