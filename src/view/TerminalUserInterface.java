package view;

import controller.BookController;
import controller.Controller;

import java.util.ArrayList;
import java.util.Scanner;

public class TerminalUserInterface {
    //private Scanner scanner = new Scanner(System.in);

    private BookController bookController;
    private Controller controller;

    public TerminalUserInterface(Controller controller) {
        this.controller = controller;
    }

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

    public void uploadBook() {
        String title = getStringInput("Enter title: ");
        String author = getStringInput("Enter author: ");

        //bookController = new BookController();


    }


    public String getStringInput(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
