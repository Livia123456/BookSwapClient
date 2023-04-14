package controller;

public class Controller {
    GUIController gui;
    ServerConnection server;

    public Controller() {
        gui = new GUIController();
        server = new ServerConnection("127.0.0.1", 700);
    }
}
