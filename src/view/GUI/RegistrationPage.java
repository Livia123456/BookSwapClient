package view.GUI;

import controller.Controller;
import controller.GUIController;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationPage extends JPanel implements ActionListener {

    private GUIController controller;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton signUpButton;
    private JLabel errorMessage;
    private JLabel emailLabel;
    //public RegistrationPage() {
    public RegistrationPage(Controller controller) {
        this.controller = controller.getGui();
    }

    public void setUpEmail()
    {
        setLayout(null);

        JLabel welcomeText = new JLabel("Welcome!");
        Font welcomeFont = welcomeText.getFont().deriveFont(Font.BOLD);
        welcomeText.setFont(welcomeFont);
        welcomeText.setBounds(565, 200, 100, 20);

        JLabel text = new JLabel("Please enter your email to continue");
        Font font = text.getFont().deriveFont(Font.ITALIC);
        text.setFont(font);
        text.setBounds(450, 230, 300, 20);

        emailLabel = new JLabel("Email:");
        emailLabel.setBounds(450, 290, 100, 20);

        emailField = new JTextField(20);
        //usernameField.setBackground(Color.LIGHT_GRAY);
        emailField.setBorder(new LineBorder(Color.GRAY));
        emailField.setBounds(590, 286, 200, 26);


//        JLabel passwordLabel = new JLabel("Password:");
//        passwordLabel.setBounds(450, 330, 100, 20);
//
//
//        passwordField = new JPasswordField(24);
//        //passwordField.setBackground(Color.lightGray);
//        passwordField.setBorder(new LineBorder(Color.GRAY));
//        passwordField.setBounds(590, 325, 200, 30);
//        passwordField.setEchoChar('*');
//
//        loginButton = new JButton("Log In");
//        loginButton.setBounds(640, 390, 100, 25);

        signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(445, 390, 100, 25);

        errorMessage = new JLabel();
        errorMessage.setBounds(590, 365, 200, 20);

        add(welcomeText);
        add(text);
        add(emailLabel);
        add(emailField);
        add(errorMessage);
        //add(loginButton);
        add(signUpButton);

        //loginButton.addActionListener(this);
        signUpButton.addActionListener(this);

    }

    public static void main(String[] args) {
//        MainFrame mf = new MainFrame();
//        mf.registration();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signUpButton && passwordField == null) {
            if(!emailField.getText().isEmpty()) {
                controller.newUser(emailField.getText());
            } else {
                errorMessage.setText("Please enter email");
            }
        } else if (e.getSource() == signUpButton) {
            if(!emailField.getText().isEmpty()) {
                controller.newRegistration(emailField.getText(), passwordField.getPassword());
            } else {
                errorMessage.setText("Please enter username and password");
            }
        }
    }

    public void setErrorMessage(String errorText) {
        errorMessage.setText(errorText);
    }

    public void setUpUserNamePassword() {
        setLayout(null);

        JLabel welcomeText = new JLabel("Welcome!");
        Font welcomeFont = welcomeText.getFont().deriveFont(Font.BOLD);
        welcomeText.setFont(welcomeFont);
        welcomeText.setBounds(565, 200, 100, 20);

        JLabel text = new JLabel("Enter your information");
        Font font = text.getFont().deriveFont(Font.ITALIC);
        text.setFont(font);
        text.setBounds(450, 230, 300, 20);

        emailLabel = new JLabel("User name");
        emailLabel.setBounds(450, 290, 100, 20);

        emailField = new JTextField(20);
        //usernameField.setBackground(Color.LIGHT_GRAY);
        emailField.setBorder(new LineBorder(Color.GRAY));
        emailField.setBounds(590, 286, 200, 26);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(450, 330, 100, 20);

        passwordField = new JPasswordField(24);
        //passwordField.setBackground(Color.lightGray);
        passwordField.setBorder(new LineBorder(Color.GRAY));
        passwordField.setBounds(590, 325, 200, 30);
        passwordField.setEchoChar('*');

        signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(445, 390, 100, 25);

        errorMessage = new JLabel();
        errorMessage.setBounds(590, 365, 200, 20);

        add(welcomeText);
        add(text);
        add(emailLabel);
        add(emailField);
        add(errorMessage);
        add(signUpButton);

        signUpButton.addActionListener(this);

        add(passwordLabel);
        add(passwordField);
    }
}
