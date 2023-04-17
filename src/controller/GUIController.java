package controller;

import model.UserInfo;
import view.TerminalUserInterface;

<<<<<<< HEAD
public class GUIController {
    TerminalUserInterface view = new TerminalUserInterface();

    public GUIController() {
        while (true) {
=======
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

>>>>>>> master
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
<<<<<<< HEAD
        }
=======

>>>>>>> master
    }

    @Override
    public void run() {
        logInMenu();
    }

    private void newUser() {
    }

    private void logIn() {
        String[] array = view.logIn();
<<<<<<< HEAD
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
                case 3:
                    //Här exekveras kod för uppladdning av böcker
                    break;
                case 0:
                    System.exit(0);
                default:
                    view.showMessage("Something went wrong, try again!");
            }
        }
=======
        UserInfo userInfo = new UserInfo(array[0].trim(), array[1].trim());
//        System.out.println(userInfo.getEmail());
//        System.out.println(userInfo.getPassword());
        controller.logIn(userInfo);
>>>>>>> master
    }
}
