package view.GUI;

import controller.Controller;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstPage extends JPanel implements ActionListener {
    private Controller controller;
    private MainFrame mainFrame;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton signUpButton;
    private JLabel errorMessage;
    public FirstPage(Controller controller, MainFrame mainFrame) {
        this.controller = controller;
        this.mainFrame = mainFrame;
        setUp();
    }

    public void setUp()
    {
        setLayout(null);

        JLabel welcomeText = new JLabel("Welcome!");
        Font welcomeFont = welcomeText.getFont().deriveFont(Font.BOLD);
        welcomeText.setFont(welcomeFont);
        welcomeText.setBounds(565, 200, 100, 20);

        JLabel text = new JLabel("Please sign in or create an account to continue");
        Font font = text.getFont().deriveFont(Font.ITALIC);
        text.setFont(font);
        text.setBounds(450, 230, 300, 20);

        JLabel emailLabel = new JLabel("Email:");
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

        loginButton = new JButton("Log In");
        loginButton.setBounds(640, 390, 100, 25);

        signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(445, 390, 100, 25);

        errorMessage = new JLabel();
        errorMessage.setBounds(590, 365, 200, 20);

        add(welcomeText);
        add(text);
        add(emailLabel);
        add(emailField);
        add(passwordLabel);
        add(passwordField);
        add(errorMessage);
        add(loginButton);
        add(signUpButton);

        loginButton.addActionListener(this);
        signUpButton.addActionListener(this);

//        addMouseListener(new MouseListener() {
//
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                int x = e.getX();
//                int y = e.getY();
//                System.out.println("X: " + x + ", Y: " + y);
//            }
//
//            @Override
//            public void mousePressed(MouseEvent e) {
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent e) {
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//            }
//        });
    }

    public static void main(String[] args) {
        //new FirstPage(controller);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            if(!emailField.getText().isEmpty() && passwordField.getPassword().length > 0) {
                controller.getGui().logIn(emailField.getText(), passwordField.getPassword());
            } else {
                errorMessage.setText("Enter email and password");
            }
        } else if (e.getSource() == signUpButton) {
            mainFrame.registration();
        }

    }

    public void setErrorMessage(String errorText) {
        errorMessage.setText(errorText);
    }

}