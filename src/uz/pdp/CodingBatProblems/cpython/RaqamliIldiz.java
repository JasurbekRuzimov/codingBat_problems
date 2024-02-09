package uz.pdp.CodingBatProblems.cpython;

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    if (n > 2) {
      System.out.println(-1);
      return;
    }
    if (n == 2) {
      int power = (int) Math.pow(2, n);
      for (int a = 0; a <= power; a++) {
        for (int b = 0; b <= power; b++) {
          if (a * a + b * b == power) {
            System.out.print(a);
            System.out.print(b);
            return;
          }
        }
      }
      System.out.println(-1);
      return;
    }
  }
}