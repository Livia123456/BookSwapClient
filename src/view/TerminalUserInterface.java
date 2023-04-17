package view;

import java.util.ArrayList;
import java.util.Scanner;

public class TerminalUserInterface {
<<<<<<< HEAD
=======
    //private Scanner scanner = new Scanner(System.in);
>>>>>>> master

    public String[] logIn(){
        String[] array = new String[2];
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter email: ");
<<<<<<< HEAD
        array[0] = getStringInput();
        System.out.print("Enter password: ");
        array[1] = getStringInput();
=======
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
>>>>>>> master
        return array;
    }

    public int firstPage() {
        System.out.println("Welcome to BookSwap!");
        System.out.println("[1] Log in");
        System.out.println("[2] Register new user");
<<<<<<< HEAD
        return getIntegerInput();
    }

    public int mainMenu() {
        System.out.println("[1] View your profile");
        System.out.println("[2] Search for books");
        System.out.println("[3] Upload book");
        System.out.println("[0] Sign out");
        return getIntegerInput();
    }

    public String getStringInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public int getIntegerInput() {
=======
>>>>>>> master
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

<<<<<<< HEAD
    public void showMessage(String message) {
        System.out.println(message);
=======
    public void menu() {
        System.out.println("Visa förstasidan här!");
>>>>>>> master
    }
}
