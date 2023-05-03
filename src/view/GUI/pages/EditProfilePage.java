package view.GUI.pages;

import controller.Controller;
import controller.GUIController;
import model.AccountToDelete;
import model.UserInfo;
import view.GUI.ProfilePage;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class EditProfilePage extends ProfilePage implements ActionListener {

    private Controller controller;

    //userInfo buttons
    private JTextField userNameField;
    private JTextField passWordField;
    private JTextField eMailField;
    private JButton update;
    private JButton deleteAccount;


    public EditProfilePage(Controller controller) {
        super(controller);
        this.controller = controller;
        setUp();
    }

    public void setUp() {

        Font labelFont = new Font("Calibri", Font.PLAIN, 14);
        Font fieldFont = new Font("Calibri", Font.ITALIC, 11);

        JLabel userName = new JLabel("User name:");
        userName.setFont(labelFont);
        userName.setBounds(640, 120, 100, 20);

        userNameField = new JTextField(" Current username");
        userNameField.setFont(fieldFont);
        userNameField.setForeground(Color.GRAY);
        userNameField.setBorder(new LineBorder(Color.GRAY));
        userNameField.setBounds(740, 122, 260, 20);

        JLabel password = new JLabel("Password:");
        password.setFont(labelFont);
        password.setBounds(640, 160, 100, 20);

        passWordField = new JTextField();
        passWordField.setBorder(new LineBorder(Color.GRAY));
        passWordField.setBounds(740, 162, 260, 20);

        JLabel eMail = new JLabel("E-mail:");
        eMail.setFont(labelFont);
        eMail.setBounds(640, 200, 100, 20);

        eMailField = new JTextField(" Current e-mail");
        eMailField.setFont(fieldFont);
        eMailField.setForeground(Color.GRAY);
        eMailField.setBorder(new LineBorder(Color.GRAY));
        eMailField.setBounds(740, 202, 260, 20);

        update = new JButton("Update");
        update.setBounds(808, 242, 120, 26);
        update.addActionListener(this);

        deleteAccount = new JButton("Delete account");
        deleteAccount.setFont(new Font("Calibri", Font.BOLD, 10));
        deleteAccount.setBounds(813, 282, 110, 20);
        deleteAccount.addActionListener(this);

        add(userName);
        add(userNameField);
        add(password);
        add(passWordField);
        add(eMail);
        add(eMailField);
        add(update);
        add(deleteAccount);
        super.setUp();
        super.setEditPersonalInformationFalse();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == update) {
            System.out.println("UPDATE");
            String newName = userNameField.getText();
            String newPassword = passWordField.getText();
            String newEmail = eMailField.getText();
            controller.checkNewPersonalInfo(newName, newPassword, newEmail);

        } else if (e.getSource() == deleteAccount) {
            int yesNo = JOptionPane.showConfirmDialog(null, "Are you sure you want to " +
                   "delete your account?", "DELETE ACCOUNT", JOptionPane.YES_NO_OPTION);
           if (yesNo == 1) { //no
               System.out.println(1);
           } else if (yesNo == 0) { //yes
               // Här börjar delete account-exekvering
               UserInfo currentUser = controller.getCurrentUser();
               AccountToDelete accountToDelete = new AccountToDelete(currentUser);
               controller.tellServerToDeleteAccount(accountToDelete);
               controller.getGui().firstPage();
           }
        }

    }

}
