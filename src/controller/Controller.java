package controller;

public class Controller {
    GUIController gui;
    ServerConnection server;

    public Controller() {
        server = new ServerConnection("127.0.0.1", 700);
        gui = new GUIController();
    }

    public static void main(String[] args) {
        new Controller();
    }
}
