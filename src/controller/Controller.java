package controller;

import model.Email;
import model.UserInfo;
import model.UserInfoUpdate;
import view.TerminalUserInterface;

import java.rmi.server.RMIClassLoaderSpi;

public class Controller {
    private GUIController gui;
    private ServerConnection server;
    private RegistrationController registrationController;
    private BookController bookController;

    private SearchController searchController;


    public Controller() {
        server = new ServerConnection("127.0.0.1", 700, this);
        gui = new GUIController(this);
        registrationController = new RegistrationController(this);
        bookController = new BookController(this);

        searchController = new SearchController(this);

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

    public void checkNewPersonalInfo(String newName, String newPassword, String newEmail) {
        char[] newPasswordArray = newPassword.toCharArray();
        boolean newPasswordIsValid = registrationController.validPassword(newPasswordArray);
        boolean newEmailIsValid = registrationController.validEmail(newEmail);

        if(newEmailIsValid && newPasswordIsValid) {
            UserInfoUpdate newUserInfo = new UserInfoUpdate(new Email(newEmail), newPassword, newName);
            server.sendMessage(newUserInfo);
        } else {
            gui.showErrorMessage("Invalid e-mail or password.");
        }

    }

    public ServerConnection getServer() {
        return server;
    }

    public GUIController getGui() {
        return gui;
    }

    public BookController getBookController() {
        return bookController;
    }

    public RegistrationController getRegistrationController() {
        return registrationController;
    }
}
