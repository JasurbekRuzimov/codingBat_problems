package uz.pdp.CodingBatProblems;

import java.util.Scanner;

public class Recursion1_count8 {

    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        count8(n);
    }

    public static int count8(int n) {
        int a, b = 0;
        while (n > 0) {
            a = n % 10;
            if (a == 8) {
                b++;
            }
            n = n / 10;
        }
        System.out.println(b);
        return 0;


    }
}
