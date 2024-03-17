import java.util.Scanner;



public class Main2 {
    private static int factorial(int i) {
        int b = 1;
        for (int j = 1; j <= i; j++) {
            b *= j;
        }

        return b;
    }
    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Biror son kiriting");
        n = scanner.nextInt();
        double a = 0;
        for (int i = 1; ; i++) {
            a = Math.pow(2,i) / factorial(i);
            if (a > n) {
                System.out.println(i +" - index ");
                break;
            }

        }
    }
}


























































































