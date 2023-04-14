package controller;

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

    }
}
