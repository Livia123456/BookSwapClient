package controller;

import model.UserInfo;
import view.TerminalUserInterface;

public class GUIController {
    TerminalUserInterface view;

    public GUIController() {
        this.view  = new TerminalUserInterface();
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

    private void newUser() {
    }

    private void logIn() {
        String[] array = view.logIn();
        UserInfo userInfo = new UserInfo(array[0], array[1]);
    }
}
