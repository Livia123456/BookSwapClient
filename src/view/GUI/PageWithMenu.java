package view.GUI;

import controller.Controller;
import controller.GUIController;
import view.GUI.pages.ChatPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PageWithMenu extends JPanel {

    private GUIController controller;
    private MenuActionListener menuActionListener;
    private JButton bookSwapButton;
    private JButton homeButton;
    private JButton bookMarketButton;
    private JButton profileButton;
    private JButton chatButton;

    public PageWithMenu(Controller controller) {
        this.controller = controller.getGui();
        menuActionListener = new MenuActionListener();
    }

    public void menuSetUp() {
        JLabel bookSwap = new JLabel("BookSwap");
        bookSwap.setFont(new Font("Calibri", Font.PLAIN, 18));
        bookSwap.setBounds(24, 46, 100, 20);

        bookSwapButton = new JButton("BookSwap");
        bookSwapButton.setFont(new Font("Calibri", Font.PLAIN, 18));
        bookSwapButton.setBounds(18, 46, 90, 22);
        bookSwapButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        bookSwapButton.addActionListener(menuActionListener);

        homeButton = new JButton("Home");
        homeButton.setBounds(116, 48, 60, 16);
        homeButton.addActionListener(menuActionListener);

        bookMarketButton = new JButton("BookMarket");
        bookMarketButton.setBounds(183, 48, 100, 16);
        bookMarketButton.addActionListener(menuActionListener);

        profileButton = new JButton("Profile");
        profileButton.setBounds(289, 48, 60, 16);
        //profileButton.setEnabled(false);
        profileButton.addActionListener(menuActionListener);

        chatButton = new JButton("Chat");
        chatButton.setBounds(356, 48, 60, 16);
        chatButton.addActionListener(menuActionListener);

        add(bookSwap);
        add(homeButton);
        add(bookMarketButton);
        add(profileButton);
        add(chatButton);
    }

    public void setHomeButtonFalse() {
        this.homeButton.setEnabled(false);
    }

    public void setBookMarketButtonFalse() {
        this.bookMarketButton.setEnabled(false);
    }

    public void setProfileButtonFalse() {
        this.profileButton.setEnabled(false);
    }

    public class MenuActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == homeButton || e.getSource() == bookSwapButton) {
                controller.homePage();
            } else if (e.getSource() == bookMarketButton) {
                controller.bookMarket();
            } else if (e.getSource() == profileButton) {
                controller.profilePage();
            } else if (e.getSource() == chatButton) {
                controller.chatPage();
            }
        }
    }
}
