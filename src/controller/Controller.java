package controller;

import model.*;
import java.util.ArrayList;

public class Controller {

    private GUIController gui;
    private ServerConnection server;
    private RegistrationController registrationController;
    private BookController bookController;
    private SearchController searchController;
    private ChatController chatController;
    private UserInfo currentUser;


    public Controller() {
        server = new ServerConnection("127.0.0.1", 700, this);
        gui = new GUIController(this);
        registrationController = new RegistrationController(this);
        bookController = new BookController(this);
        searchController = new SearchController(this);
        chatController = new ChatController(this);

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

    public SearchController getSearchController() {
        return searchController;
    }

    public ChatController getChatController(){
        return chatController;
    }

    public RegistrationController getRegistrationController() {
        return registrationController;
    }


    public UserInfo getCurrentUser() { return currentUser; }
    public void setCurrentUser(UserInfo userInfo) { this.currentUser = userInfo; }

    public static void main(String[] args) {
        new Controller();
    }
}
