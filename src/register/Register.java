package register;

import java.util.ArrayList;
import java.util.Scanner;

public class Register {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    User[] users = new User[100];

    int count = 0;
    while (true) {
      System.out.println("[ 1 - SignUp ]     [ 2 - SignIn ]  [ 3 - List of users ] ");
      int n = sc.nextInt();

      switch (n) {
        case 1 -> {
          System.out.println("Name: ");
          String name = sc.next();
          System.out.println("Surname: ");
          String surname = sc.next();
          System.out.println("Phone: ");
          String phone = sc.next();
          System.out.println("Email: ");
          String email = sc.next();
          System.out.println("Password: ");
          String password = sc.next();
          User user1 = new User(name, surname, phone, email, password);
          users[count] = user1;
          count++;

          System.out.println("Successfully registered !!!");

        }
        case 2 -> {
          System.out.println("Email: ");
          String email = sc.next();
          System.out.println("Password: ");
          String password = sc.next();
          int index = -1;
          for (int i = 0; i < count; i++) {
            if (users[i].email.equals(email) && users[i].password.equals(password)) {
              index = i;
              break;
            }
          }

          if (index == -1) {
            System.out.println("Incorrect email or password \n");
          } else {
            System.out.println("Successfully login to our app \n");
          }
        }
        case 3 -> {
          for (int i = 0; i < count; i++) {
            System.out.println((i+1)+" - " + users[i].name+ "\n");
          }
        }
        default -> {
          System.out.println("No such command exists! \n"
              + "Choose the correct command! \n");
        }
      }
    }

  }
}
