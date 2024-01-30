package uz.pdp.CodingBatProblems;

import java.util.Scanner;

public class Recursion1_count7 {

    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        count7(n);
    }

    public static int count7(int n) {
        int a, b = 0;
        while (n > 0) {
            a = n % 10;
            if (a == 7) {
                b++;
            }
            n = n / 10;
        }
        System.out.println(b);
        return 0;


    }
}
