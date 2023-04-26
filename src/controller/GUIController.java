package controller;

import model.Email;
import model.UserInfo;
import view.GUI.MainFrame;

public class GUIController extends Thread {
    private MainFrame view;
    private Controller controller;
    private String currentEmail;

    public GUIController(Controller controller) {
        this.controller = controller;
        start();
    }

    public void tryLoggingIn(UserInfo message) {
        if(message.isCorrectInfo()) {
            view.homePage();
        } else {
            view.getFirstPage().setErrorMessage("Incorrect email or password");
        }
    }

    @Override
    public void run() {
        this.view  = new MainFrame(controller);
        //view.uploadBookPage(); //todo detta är tillfälligt för att jag inte pallar logga in hela tiden :P
    }

    public void newUser(String email) {
        RegistrationController regCon = controller.getRegistrationController();
        Email newEmail = new Email(email);
        regCon.checkIfEmailIsRegistered(newEmail);
    }

    public void logIn(String email, char[] password) {
        UserInfo userInfo = new UserInfo(new Email(email.trim()), new String(password));
        System.out.println(userInfo.getEmail() + "\n" + userInfo.getPassword());
        controller.getServer().sendMessage(userInfo);
        //controller.logIn(userInfo);
    }
    public void showRegistrationPage(Email email) {
        if(email.isRegistered()) {
            currentEmail = email.getEmailAddress();
            view.registerNewUser();
        } else {
            view.getRegistrationPage().setErrorMessage("Email address already in use");
        }

    }

    public void newRegistration(String userName, char[] password) {
        if(!controller.getRegistrationController().validPassword(password)) {
            view.getRegistrationPage().setErrorMessage("Enter valid password");
            return;
        }
        controller.getRegistrationController().newUser(currentEmail, userName, password);

    }

    public boolean validEmail(String email) {
        return controller.getRegistrationController().validEmail(email);
    }

    public void homePage() {
        view.homePage();
    }

    public void bookMarket() {
        view.search();
    }

    public void profilePage() {
        view.editProfile();
    }

    public void advanceSearch() {
        view.advancedSearch();
    }

    public void editProfile() {
        view.editProfile();
    }

    public void uploadBook() {
        view.uploadABook();
    }

    public void myWishList() {
        view.myWishList();
    }

    public void myBooks() {
        view.myBooks();
    }

    public void signOut() {
        //TODO nått måste hända här....
    }
}
