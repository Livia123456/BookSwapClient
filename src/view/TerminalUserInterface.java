package view;

import java.util.ArrayList;
import java.util.Scanner;

public class TerminalUserInterface {

    public String[] logIn(){
        String[] array = new String[2];
        System.out.print("Enter email: ");
        array[0] = getStringInput();
        System.out.print("Enter password: ");
        array[1] = getStringInput();
        return array;
    }

    public int firstPage() {
        System.out.println("Welcome to BookSwap!");
        System.out.println("[1] Log in");
        System.out.println("[2] Register new user");
        return getIntegerInput();
    }

    public int mainMenu() {
        System.out.println("[1] Search for books");
        System.out.println("[2] View your profile");
        System.out.println("[0] Sign out");
        return getIntegerInput();
    }

    public String getStringInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public int getIntegerInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
