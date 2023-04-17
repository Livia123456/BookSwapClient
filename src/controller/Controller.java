package controller;

import model.UserInfo;

public class Controller {
    private GUIController gui;
    private ServerConnection server;

    public Controller() {
<<<<<<< HEAD
        gui = new GUIController();
        //server = new ServerConnection("127.0.0.1", 700);
=======
        server = new ServerConnection("127.0.0.1", 700, this);
        gui = new GUIController(this);
    }

    public static void main(String[] args) {
        new Controller();
    }

    public void logIn(UserInfo userInfo) {
        server.logIn(userInfo);
    }

    public void tryLoggingIn(UserInfo message) {
        gui.tryLoggingIn(message);
>>>>>>> master
    }
}
