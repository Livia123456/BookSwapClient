package controller;

import model.UserInfo;
import view.TerminalUserInterface;

public class Controller {
    private GUIController gui;
    private ServerConnection server;
    private RegistrationController registrationController;
    private BookController bookController;
    private TerminalUserInterface terminalUserInterface;

    public Controller() {
        server = new ServerConnection("127.0.0.1", 700, this);
        gui = new GUIController(this);
        registrationController = new RegistrationController(this);
        bookController = new BookController(this);

    }

    public static void main(String[] args) {
        new Controller();
    }

    public void logIn(UserInfo userInfo) {
        server.sendMessage(userInfo);
    }

    public void tryLoggingIn(UserInfo message) {
        gui.tryLoggingIn(message);
    }

    public ServerConnection getServer() {
        return server;
    }

    public GUIController getGui() {
        return gui;
    }

    public RegistrationController getRegistrationController() {
        return registrationController;
    }
}
