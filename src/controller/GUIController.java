package controller;

import model.UserInfo;
import view.TerminalUserInterface;

public class GUIController extends Thread {
    private TerminalUserInterface view;
    private Controller controller;

    public GUIController(Controller controller) {
        this.view  = new TerminalUserInterface();
        this.controller = controller;
        start();
    }

    public void tryLoggingIn(UserInfo message) {
        if(message.isCorrectInfo()) {
            view.menu();
        } else {
            System.out.println("Incorrect email or password");
            logInMenu();
        }
    }

    private void logInMenu() {

            switch (view.firstPage()) {
                case 1:
                    logIn();
                    break;
                case 2:
                    newUser();
                    break;
            }

    }

    @Override
    public void run() {
        logInMenu();
    }

    private void newUser() {
    }

    private void logIn() {
        String[] array = view.logIn();
        UserInfo userInfo = new UserInfo(array[0].trim(), array[1].trim());
//        System.out.println(userInfo.getEmail());
//        System.out.println(userInfo.getPassword());
        controller.logIn(userInfo);
    }
}
