package view.GUI;

import controller.Controller;
import model.chat.ChatsWith;
import view.GUI.pages.*;
import view.GUI.pages.profile.EditProfilePage;
import view.GUI.pages.profile.MyBooks;
import view.GUI.pages.profile.MyWishList;
import view.GUI.pages.profile.UpLoadABook;

import javax.swing.*;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    private Controller controller;
    private FirstPage firstPage;
    private HomePage homePage;
    private ChatPage chatPage;
    private RegistrationPage registrationPage;
    private EditProfilePage editProfilePage;
    private AdvancedSearch advancedSearch;
    private SearchPage search;
    private MyWishList myWishList;
    private MyBooks myBooks;
    private UpLoadABook upLoadABook;

    public MainFrame(Controller controller) {
        this.controller = controller;
        firstPage = new FirstPage(controller, this);
        setUp();
        homePage();
        // firstPage();
    }

    private void setUp() {
        setTitle("BookSwap");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        //setExtendedState(JFrame.MAXIMIZED_BOTH);//??
        setSize(1200, 700);
        setLocationRelativeTo(null);
        setContentPane(firstPage);
        setVisible(true);
    }


    public FirstPage getFirstPage() {
        return firstPage;
    }

    public void homePage() {
        homePage = new HomePage(controller,this);
        homePage.setVisible(true);
        getContentPane().removeAll();
        setContentPane(homePage);
        getContentPane().revalidate();
        getContentPane().repaint();
    }

    public void chatPage() {
     /*   chatPage = new ChatPage(controller);
        chatPage.setVisible(true);
        getContentPane().removeAll();
        setContentPane(chatPage);
        getContentPane().revalidate();
        getContentPane().repaint(); */
    }

    public void firstPage() {
        firstPage = new FirstPage(controller, this);
        firstPage.setVisible(true);
        getContentPane().removeAll();
        setContentPane(firstPage);
        getContentPane().revalidate();
        getContentPane().repaint();
    }

    public void registration(String email) {
        firstPage.setVisible(false);
        registrationPage = new RegistrationPage(controller, email);
        //registrationPage.setUpEmail();
        registrationPage.setVisible(true);
        getContentPane().removeAll();
        setContentPane(registrationPage);
        getContentPane().revalidate();
        getContentPane().repaint();
    }



    public void registerNewUser() {
        registrationPage = new RegistrationPage(controller);
        registrationPage.setUpUserNamePassword();
        getContentPane().removeAll();
        setContentPane(registrationPage);
        getContentPane().revalidate();
        getContentPane().repaint();
    }

    public void advancedSearch() {
        advancedSearch = new AdvancedSearch(controller);
        advancedSearch.setVisible(true);
        setSize(1100, 700);
        setLocationRelativeTo(null);
        setVisible(true);
        getContentPane().removeAll();
        setContentPane(advancedSearch);
        getContentPane().revalidate();
        getContentPane().repaint();
    }

    public void search() {
        search = new SearchPage(controller);
        search.setVisible(true);

        setSize(1100, 700);
        setLocationRelativeTo(null);
        setVisible(true);

        getContentPane().removeAll();
        setContentPane(search);
        getContentPane().revalidate();
        getContentPane().repaint();
    }

    public void editProfile() {
        setSize(1100, 700);

        editProfilePage = new EditProfilePage(controller);
        editProfilePage.setVisible(true);

        getContentPane().removeAll();
        setContentPane(editProfilePage);
        getContentPane().revalidate();
        getContentPane().repaint();
    }

    public void myWishList() {
        setSize(1100, 700);

        myWishList = new MyWishList(controller);
        myWishList.setVisible(true);

        getContentPane().removeAll();
        setContentPane(myWishList);
        getContentPane().revalidate();
        getContentPane().repaint();
    }

    public void myBooks() {
        setSize(1100, 700);

        myBooks = new MyBooks(controller);
        myBooks.setVisible(true);

        //setLocationRelativeTo(null);
        //setVisible(true);

        getContentPane().removeAll();
        setContentPane(myBooks);
        getContentPane().revalidate();
        getContentPane().repaint();
    }

    public void uploadABook() {
        upLoadABook = new UpLoadABook(controller);
        upLoadABook.setVisible(true);

        setSize(1100, 700);
        setLocationRelativeTo(null);

        getContentPane().removeAll();
        setContentPane(upLoadABook);
        getContentPane().revalidate();
        getContentPane().repaint();
    }

    public void uploadChats(ArrayList<ChatsWith> chatsWith){
        chatPage.uploadActiveChats(chatsWith);
    }

    public RegistrationPage getRegistrationPage() {
        return registrationPage;
    }

    public void bookSuccessfullyUploaded() {
        upLoadABook.uploadSuccessful();
    }

    public void bookUnableToUpload() {
        upLoadABook.uploadUnsuccessful();
    }
}


