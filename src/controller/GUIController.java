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
        }
    }

    private void logInMenu() {
        while (true) {
            switch (view.firstPage()) {
                case 1:
                    logIn();
                    break;
                case 2:
                    newUser();
                    break;
            }
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
        controller.logIn(new UserInfo(array[0], array[1]));
    }
}
