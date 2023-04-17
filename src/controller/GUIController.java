package controller;

import model.Email;
import model.UserInfo;
import view.GUI.MainFrame;

public class GUIController extends Thread {
    private MainFrame view;
    private Controller controller;

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

    private void newUser() {
//        RegistrationController regCon = controller.getRegistrationController();
//        Email email = new Email();
//        email.setEmail(view.getStringInput("Enter email: "));
//        regCon.validEmail(email);
    }

    public void logIn(String email, char[] password) {
        UserInfo userInfo = new UserInfo(email.trim(), password.toString().trim());
        controller.logIn(userInfo);
    }

    public void newRegistration() {
//        boolean validPassword = false;
//        String password;
//        while (!validPassword) {
//            password = view.getStringInput("Enter password");
//            validPassword = controller.getRegistrationController().validPassword(password);
//        }
//        String name = view.getStringInput("Enter username");

    }
}
