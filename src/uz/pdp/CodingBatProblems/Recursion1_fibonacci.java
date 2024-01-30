package uz.pdp.CodingBatProblems;

import java.util.Scanner;

public class Recursion1_fibonacci {
    public static void main(String[] args) {
        int n;
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        System.out.println(fib(n));
    }

    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);

    }
}

