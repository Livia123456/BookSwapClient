package view.GUI;

import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.text.CompactNumberFormat;

public class MainFrame extends JFrame {
    private Controller controller;
    private FirstPage firstPage;
    private HomePage homePage;
    private UploadBookPage uploadBookPage;
    private RegistrationPage registrationPage;
    private JPanel currentPanel;

    //public MainFrame() {
    public MainFrame(Controller controller) {
        this.controller = controller;
        firstPage = new FirstPage(controller, this);
        homePage = new HomePage(controller, this);
        registrationPage = new RegistrationPage(controller);
        registrationPage.setUpEmail();
        uploadBookPage = new UploadBookPage(controller, this);
        setUp();
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
        firstPage.setVisible(false);
        homePage.setVisible(true);
        getContentPane().removeAll();
        setContentPane(homePage);
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
    public void uploadBookPage() {
        getContentPane().removeAll();
        setContentPane(uploadBookPage);
        getContentPane().revalidate();
        getContentPane().repaint();
    }

    public RegistrationPage getRegistrationPage() {
        return registrationPage;
    }
}


