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

//    private void logInMenu() {
//
//            switch (view.firstPage()) {
//                case 1:
//                    logIn();
//                    break;
//                case 2:
//                    newUser();
//                    break;
//            }
//
//    }

    @Override
    public void run() {
        this.view  = new MainFrame(controller);
        //logInMenu();
    }

    public void newUser(String email) {
        RegistrationController regCon = controller.getRegistrationController();
        Email newEmail = new Email(email);
        regCon.checkIfEmailIsRegistered(newEmail);
    }

    public void logIn(String email, char[] password) {
        UserInfo userInfo = new UserInfo(email.trim(), password.toString().trim());
        controller.logIn(userInfo);
    }
    public void showRegistrationPage(Email message) {
        if(message.isRegistered()) {
            currentEmail = message.getEmail();
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
}
