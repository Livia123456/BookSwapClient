package view.GUI;

import javax.swing.*;
import java.awt.*;

public class ProfilePage extends JFrame{

    private JFrame profileFrame;
    private JPanel mainPanel;



    public ProfilePage() {
        setUpProfileFrame();

    }

    public void setUpProfileFrame() {
        // create main window and main leftPanel
        profileFrame = new JFrame("Your profile");
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        //Create text areas and labels to populate leftPanel with
        JLabel nameLabel = new JLabel("Name");
        JTextArea nameText = new JTextArea("yourUserName", 1, 15);
        nameText.setEditable(false);

        JLabel eMailLabel = new JLabel("E-mail");
        JTextArea eMailText = new JTextArea("yourEmailAddress", 1, 15);
        eMailText.setEditable(false);

        JLabel passwordLabel = new JLabel("Password");
        JTextArea passwordText = new JTextArea("yourPassword", 1, 15);
        passwordText.setEditable(false);

        leftPanel.add(nameLabel);
        leftPanel.add(nameText);
        leftPanel.add(eMailLabel);
        leftPanel.add(eMailText);
        leftPanel.add(passwordLabel);
        leftPanel.add(passwordText);
        profileFrame.add(leftPanel);


        profileFrame.setSize(500, 500);
        profileFrame.setVisible(true);
    }


    public static void main(String[] args) {
        new ProfilePage();
    }
}
