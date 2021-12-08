
class Problem {
    public static void main(String[] args) {

        String operationType = args[0];
        int n1 = Integer.parseInt(args[1]);
        int n2 = Integer.parseInt(args[2]);

        switch (operationType) {
            case "+":
                System.out.println(n1 + n2);
                break;
            case "-":
                System.out.println(n1 - n2);
                break;
            case "*":
                System.out.println(n1 * n2);
                break;
            default:
                System.out.println("Unknown operator");
                break;

        }

    }
}
