package view;

import java.util.ArrayList;
import java.util.Scanner;

public class TerminalUserInterface {
    //private Scanner scanner = new Scanner(System.in);

    public String[] logIn(){
        String[] array = new String[2];
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter email: ");
        if (scanner.hasNext()) {
            String str = scanner.nextLine();
            //System.out.println(str);
            array[0] = str;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter password: ");
        if (sc.hasNext()) {
            String str = sc.nextLine();
            //System.out.println(str);
            array[1] = str;
        }
        return array;
    }

    public int firstPage() {
        System.out.println("[1] Log in");
        System.out.println("[2] Register new user");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public void menu() {
        System.out.println("Visa förstasidan här!");
    }
}
