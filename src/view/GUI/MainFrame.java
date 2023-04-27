package view.GUI;

import controller.Controller;
import view.GUI.pages.*;

import javax.swing.*;

public class MainFrame extends JFrame {
    private Controller controller;
    private FirstPage firstPage;
    private HomePage homePage;
    private UploadBookPage uploadBookPage;
    private RegistrationPage registrationPage;
    private EditProfilePage editProfilePage;
    private AdvancedSearch advancedSearch;
    private Search search;
    private MyWishList myWishList;

    private MyBooks myBooks;
    private UpLoadABook upLoadABook;
    private JPanel currentPanel;

    //public MainFrame() {
    public MainFrame(Controller controller) {
        this.controller = controller;
        firstPage = new FirstPage(controller, this);
        homePage = new HomePage(controller, this);
        registrationPage = new RegistrationPage(controller);
        registrationPage.setUpEmail();
        //uploadBookPage = new UploadABookPage(controller, this);
        advancedSearch = new AdvancedSearch(controller);
        myBooks = new MyBooks(controller);
        search = new Search(controller);
        myWishList = new MyWishList(controller);
        upLoadABook = new UpLoadABook(controller);
        setUp();
        //homePage();
        //editProfile();
    }

    private void setUp() {
        setTitle("BookSwap");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH);//??
        setSize(1200, 700);
        setLocationRelativeTo(null);
        setContentPane(firstPage);
        setVisible(true);
    }

    public static void main(String[] args) {
        //new MainFrame();
    }

    public FirstPage getFirstPage() {
        return firstPage;
    }

    public void homePage() {
        //firstPage.setVisible(false);
        homePage = new HomePage(controller,this);
        homePage.setVisible(true);
        getContentPane().removeAll();
        setContentPane(homePage);
        getContentPane().revalidate();
        getContentPane().repaint();
    }

    public void firstPage() {
        //firstPage.setVisible(false);
        firstPage = new FirstPage(controller, this);
        firstPage.setVisible(true);
        getContentPane().removeAll();
        setContentPane(firstPage);
        getContentPane().revalidate();
        getContentPane().repaint();
    }

    public void registration() {
        firstPage.setVisible(false);
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
//    public void uploadBookPage() { //gammal......!!!!
//        getContentPane().removeAll();
//        setContentPane(uploadBookPage);
//        getContentPane().revalidate();
//        getContentPane().repaint();
//        uploadBookPage.repaint();
//
//    }

    public void advancedSearch() {
        advancedSearch = new AdvancedSearch(controller);
        advancedSearch.setVisible(true);
        setSize(1100, 700);
        setLocationRelativeTo(null);
        //add(panel, BorderLayout.CENTER);
        setVisible(true);
        getContentPane().removeAll();
        setContentPane(advancedSearch);
        getContentPane().revalidate();
        getContentPane().repaint();
    }

    public void search() {
        search = new Search(controller);
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
//        setLocationRelativeTo(null);
//        add(panel, BorderLayout.CENTER);
//        setVisible(true);
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

//        setLocationRelativeTo(null);
//        setVisible(true);

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

    public RegistrationPage getRegistrationPage() {
        return registrationPage;
    }
}


