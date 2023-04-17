package controller;

import view.TerminalUserInterface;

public class GUIController {
    TerminalUserInterface view = new TerminalUserInterface();

    public GUIController() {
        while (true) {
            switch (view.firstPage()) {
                case 1:
                    logIn();
                    mainMenu();
                    break;
                case 2:
                    newUser();
                    mainMenu();
                    break;
            }
        }
    }

    private void newUser() {
    }

    private void logIn() {
        String[] array = view.logIn();
    }

    private void mainMenu() {
        boolean choiceMade = false;
        while (!choiceMade) {
            switch (view.mainMenu()) {
                case 1:
                    //Här sker exekveras kod för sökning av bok.
                    break;
                case 2:
                    //Här exekveras kod som visar användarens uppgifter.
                    //Jag tänker mig något i stil med: view.showUserInfo(User user);
                    break;
                case 0:
                    System.exit(0);
                default:
                    view.showMessage("Something went wrong, try again!");
            }
        }
    }
}
