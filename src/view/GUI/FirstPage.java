package view.GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FirstPage {
    public void setUp(String[] args)
    {
        JFrame frame = new JFrame("BookSwap");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel welcomeText = new JLabel("Welcome!");
        Font welcomeFont = welcomeText.getFont().deriveFont(Font.BOLD);
        welcomeText.setFont(welcomeFont);
        welcomeText.setBounds(565, 200, 100, 20);

        JLabel text = new JLabel("Please sign in or create an account to continue");
        Font font = text.getFont().deriveFont(Font.ITALIC);
        text.setFont(font);
        text.setBounds(450, 230, 300, 20);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(450, 290, 100, 20);

        JTextField usernameField = new JTextField(20);
        //usernameField.setBackground(Color.LIGHT_GRAY);
        usernameField.setBorder(new LineBorder(Color.GRAY));
        usernameField.setBounds(590, 286, 200, 26);


        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(450, 330, 100, 20);


        JPasswordField passwordField = new JPasswordField(24);
        //passwordField.setBackground(Color.lightGray);
        passwordField.setBorder(new LineBorder(Color.GRAY));
        passwordField.setBounds(590, 325, 200, 30);
        passwordField.setEchoChar('*');

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(640, 390, 100, 25);

        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(445, 390, 100, 25);

        panel.add(welcomeText);
        panel.add(text);
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(signUpButton);
        frame.setSize(1200, 700);
        frame.setLocationRelativeTo(null);
        frame.add(panel);

        frame.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                System.out.println("X: " + x + ", Y: " + y);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        frame.setVisible(true);
    }
}