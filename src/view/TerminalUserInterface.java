package view;

import java.util.ArrayList;
import java.util.Scanner;

public class TerminalUserInterface {
    private Scanner scanner = new Scanner(System.in);

    public String[] logIn(){
        String[] array = new String[2];
        System.out.print("Enter email: ");
        array[0] = scanner.nextLine();
        System.out.print("Enter password: ");
        array[1] = scanner.nextLine();
        return array;
    }

    public int firstPage() {
        System.out.println("[1] Log in");
        System.out.println("[2] Register new user");
        return scanner.nextInt();
    }
}
