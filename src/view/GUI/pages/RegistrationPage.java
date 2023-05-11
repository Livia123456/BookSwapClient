package view.GUI.pages;

import controller.Controller;
import controller.GUIController;
import view.GUI.MainFrame;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class generates the GUI for the sign-up page, letting the user creat an account.
 * @author, Livia Tengelin
 */

public class RegistrationPage extends JPanel implements ActionListener {

    private GUIController controller;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton signUpButton;
    private JLabel errorMessage;
    private JLabel emailLabel;
    private JButton loginButton;
    private boolean emailChecked = false;
    public RegistrationPage(Controller controller) {
        this.controller = controller.getGui();
        setUp();
    }

    public RegistrationPage(Controller controller, String email) {
        this(controller);
        setUpEmail();
        emailField.setText(email);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == signUpButton) {
            boolean emailIsValid = (!emailField.getText().isEmpty() && controller.validEmail(emailField.getText()));

            if (!emailChecked && emailIsValid) { //check email
                controller.newUser(emailField.getText());

            } else if(emailChecked && !emailField.getText().isEmpty()) { //register
                    controller.newRegistration(emailField.getText(), passwordField.getPassword());
            } else {
                String errorText = emailChecked ? "Please enter username and password" : "Please enter valid email address";
                errorMessage.setText(errorText);
            }
        } else if (e.getSource() == loginButton) {
            controller.firstPage();
        }


//        if (e.getSource() == signUpButton && passwordField == null ) { // passwordField.getPassword() == null || new String(passwordField.getPassword()).isEmpty())
//            if(!emailField.getText().isEmpty() && controller.validEmail(emailField.getText())) {
//                controller.newUser(emailField.getText());
//            } else {
//                errorMessage.setText("Please enter valid email address");
//            }
//        } else if (e.getSource() == signUpButton) {
//            if(!emailField.getText().isEmpty()) {
//                controller.newRegistration(emailField.getText(), passwordField.getPassword());
//            } else {
//                errorMessage.setText("Please enter username and password");
//            }
//        }
    }

    public void setErrorMessage(String errorText) {
        errorMessage.setText(errorText);
    }

    public void setUp() {
        setLayout(null);

        emailField = new JTextField(20);
        emailField.setBorder(new LineBorder(Color.GRAY));
        emailField.setBounds(590, 286, 200, 26);

        signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(640, 390, 100, 25);

        loginButton = new JButton("Back");
        loginButton.setBounds(445, 390, 100, 25);

        signUpButton.addActionListener(this);
        signUpButton.addActionListener(this);

        add(emailField);
        add(signUpButton);
        add(loginButton);

    }

    public void setUpEmail()
    {
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

        errorMessage = new JLabel();
        errorMessage.setBounds(590, 330, 200, 20);
        errorMessage.setFont(font);

        signUpButton.addActionListener(this);
        loginButton.addActionListener(this);

        add(welcomeText);
        add(text);
        add(emailLabel);
        add(errorMessage);
    }

    public void setUpUserNamePassword() {
        emailChecked = true;

        JLabel welcomeText = new JLabel("Enter your information");
        Font welcomeFont = welcomeText.getFont().deriveFont(Font.BOLD);
        welcomeText.setFont(welcomeFont);
        welcomeText.setBounds(450, 200, 300, 20);

        JTextArea text = new JTextArea("Password must be at least 6 characters and " +
                "\ncontain one number 0-9 and one letter a-z");
        Font font = text.getFont().deriveFont(Font.ITALIC);
        text.setFont(font);
        text.setBounds(450, 230, 300, 50);
        text.setPreferredSize(new Dimension(300, 50));
        text.setEditable(false);
        text.setRows(2);
        text.setOpaque(false);

        emailLabel = new JLabel("User name");
        emailLabel.setBounds(450, 290, 100, 20);


        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(450, 330, 100, 20);

        passwordField = new JPasswordField(24);
        //passwordField.setBackground(Color.lightGray);
        passwordField.setBorder(new LineBorder(Color.GRAY));
        passwordField.setBounds(590, 325, 200, 30);
        passwordField.setEchoChar('*');

        errorMessage = new JLabel();
        errorMessage.setBounds(450, 365, 300, 20);
        errorMessage.setFont(font);

        add(welcomeText);
        add(text);
        add(emailLabel);
        add(errorMessage);
        add(passwordLabel);
        add(passwordField);
    }
}
