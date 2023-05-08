package controller;

import model.*;
import view.GUI.MainFrame;

import javax.swing.*;

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
            controller.setCurrentUser(message);
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

    public void showErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(null, errorMessage);
    }

    public boolean validEmail(String email) {
        return controller.getRegistrationController().validEmail(email);
    }

    public void homePage() {
        view.homePage();
    }

    public void chatPage() {
        view.chatPage();
    }

    public void bookMarket() {
        view.search();
    }


    public void profilePage() {
        view.editProfile();
    }

    public void search(String search){
        controller.getSearchController().search(new SearchObject(search));
    }

    public void chat() {
       // controller.getChatController().sendMessage(new MessageObject());  //todo: gör klart
    }

    //todo: skapa även openChat() -> för ChatObjects

    public void advanceSearch() {
        view.advancedSearch();
    }

    public void editProfile() {
        view.editProfile();
    }

    public void uploadBook() {
        view.uploadABook();
    }

    public void firstPage() { view.firstPage(); }

    public void myWishList() {
        view.myWishList();
    }

    public void myBooks() {

        view.myBooks();
    }

    public Controller getController() {
        return controller;
    }

    public void signOut() {
        controller.getGui().firstPage();
    }

    public void bookReceived(Book book) {
        if (book.isUploaded()) {
            view.bookSuccessfullyUploaded();
        } else {
            view.bookUnableToUpload();
        }
    }

    public void removeBook(Book book) {
        BookToDelete bookToDelete = new BookToDelete(book.getBook_id());
        controller.getServer().sendMessage(bookToDelete);
    }


    public void displayAdvancedSearchResult(AdvancedSearchResult result) {
        System.out.println("Sökresultat mottaget");
        if(result.getBooks().size() == 0) {
            //show error message

        } else {
            //display books
        }

    }
}
