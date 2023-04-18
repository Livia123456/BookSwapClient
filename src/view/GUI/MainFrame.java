package view.GUI;

import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.text.CompactNumberFormat;

public class MainFrame extends JFrame {
    private Controller controller;
    private FirstPage firstPage;
    private HomePage homePage;
    private JPanel currentPanel;

    //public MainFrame() {
    public MainFrame(Controller controller) {
        this.controller = controller;
        firstPage = new FirstPage(controller);
        homePage = new HomePage();
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
}
