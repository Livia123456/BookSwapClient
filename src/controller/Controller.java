package controller;

import model.AccountToDelete;
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
    private UserInfo currentUser;


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

    /**
     * Method that checks if new account credentials are valid. If not, error message is displayed.
     * If valid, a newUserInfo instance is sent to system server. Once it reaches the server
     * the database will be updated.
     * @param newName
     * @param newPassword
     * @param newEmail
     */
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

    public void tellServerToDeleteAccount(AccountToDelete accountToDelete) {
        server.sendMessage(accountToDelete);
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

    public UserInfo getCurrentUser() { return currentUser; }
    public void setCurrentUser(UserInfo userInfo) { this.currentUser = userInfo; }
}
