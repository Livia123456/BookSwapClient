package controller;

import model.*;
import model.chat.ChatObject;
import model.chat.ChatStatus;
import model.chat.ChatsWith;
import model.chat.MessageObject;
import model.search.AdvancedSearchResult;
import model.search.SearchObject;
import view.GUI.MainFrame;
import view.GUI.pages.ChatPage;

import javax.swing.*;
import java.util.ArrayList;


/**
 * This class is responsible for populating and for communicating with the GUI of the program.
 * @author Livia Tengelin, Olle Huss, Sebastian Zulj, Kasper Lindberg
 */
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
    }

    public void newUser(String email) {
        RegistrationController regCon = controller.getRegistrationController();
        Email newEmail = new Email(email);
        regCon.checkIfEmailIsRegistered(newEmail);
    }

    public void logIn(String email, char[] password) {
        UserInfo userInfo = new UserInfo(new Email(email.trim()), new String(password));
        controller.getServer().sendMessage(userInfo);
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
        controller.getServer().sendMessage(new ChatObject(controller.getCurrentUser().getUserId(),
                0, ChatStatus.populate));
    }

    public void bookMarket() {
        controller.getSearchController().search("");
        view.search();
    }


    public void profilePage() {
        view.editProfile();
    }

//    public void search(String search){
//        controller.getSearchController().search(new SearchObject(search));
//    }

    public void chat() {  //todo: gör klart koppling till gui
      //  controller.getChatController().sendMessage(new MessageObject());
    }

   /* public void chatObject(){
        controller.getChatController().
    } */


    public void advanceSearch() {
        view.advancedSearch();
    }

    public void editProfile() {
        view.editProfile();
    }

    public void uploadBook() {
        view.uploadABook();
    }

    public void editBook(Book book) {
        view.editBook(book);
    }

    public void firstPage() { view.firstPage(); }

    public void myWishList() {
        view.myWishList();
    }

    public void myBooks() {

        view.myBooks(controller.getCurrentUser().getCurrentUsersUploadedBooks());
    }

    public Controller getController() {
        return controller;
    }

    public MainFrame getView() {
        return view;
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

    public void bookUpdateRecieved(BookUpdate book) {
        if(book.infoIsChanged()) {
            view.changeSuccessful();
        } else {
            view.changeFailed();
        }

    }

    public void removeBook(Book book) {
        BookToDelete bookToDelete = new BookToDelete(book.getBook_id());
        controller.getServer().sendMessage(bookToDelete);
    }


    public void displayAdvancedSearchResult(Book[] books) {
        if(books.length == 0) {
            view.getAdvancedSearch().displayErrorMessage();

        } else {
            view.getAdvancedSearch().displayResults(books);
        }
    }

    public void displaySearchResult(Book[] books) {
        if(books.length == 0) {
            view.getSearch().displayErrorMessage();

        } else {
            view.getSearch().displayResults(books);
        }
    }

    public void chatHistory(ArrayList<MessageObject> messages) {
        if (!(view.getContentPane() instanceof ChatPage)) { //TODO fuckar detta??

        }
    }

}
