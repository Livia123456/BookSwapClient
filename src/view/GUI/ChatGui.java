package view.GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ChatGui extends JFrame {

    private String name;
    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;
    private JPanel profilePanel;
    private JPanel contactsPanel;
    private String[] contacts;
    private String[] titleOfUsersBooks;

    public ChatGui() {

        name = "Olle Bolle";

        setTitle("Chat");

        profilePanel = new JPanel();
        profilePanel.setPreferredSize(new Dimension(200, profilePanel.getHeight()));
        profilePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        profilePanel.setLayout(new BoxLayout(profilePanel, BoxLayout.Y_AXIS));

        contactsPanel = new JPanel();
        contactsPanel.setPreferredSize(new Dimension(200, profilePanel.getHeight()));
        contactsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        //contactsPanel.setLayout(new BoxLayout(contactsPanel, BoxLayout.Y_AXIS));

        /*JScrollPane contactsScroll = new JScrollPane();
        contactsScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        contactsScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        contactsPanel.add(contactsScroll, BorderLayout.CENTER);*/

        contacts = new String[]{"Olle", "Livve", "Zulle", "Kappe", "Klas den fule"};
        for (int i = 0; i < contacts.length; i++) {
            JButton button = new JButton(contacts[i]);
            button.setFont(new Font("Arial", Font.BOLD, 16));
            button.setPreferredSize(new Dimension(180, 40));
            contactsPanel.add(button);
        }

        BufferedImage profilePicture;
        try {
            profilePicture = ImageIO.read(new File("files/PP1.JPG"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int newWidth = 179;
        int newHeight = (int) Math.round((double) profilePicture.getHeight() / profilePicture.getWidth() * newWidth);

        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, profilePicture.getType());

        Graphics2D g2d = resizedImage.createGraphics();
        g2d.drawImage(profilePicture, 0, 0, newWidth, newHeight, null);
        g2d.dispose();

        JLabel profilePictureLabel = new JLabel(new ImageIcon(resizedImage));
        profilePictureLabel.setAlignmentY(Component.TOP_ALIGNMENT);
        profilePanel.add(profilePictureLabel);

        profilePanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JLabel profileNameLabel = new JLabel(name, SwingConstants.CENTER);
        profileNameLabel.setAlignmentY(Component.TOP_ALIGNMENT);
        profileNameLabel.setFont(new Font("Arial", Font.BOLD, 24));
        profilePanel.add(profileNameLabel);

        JLabel space = new JLabel(" ");

        profilePanel.add(space);

        JLabel theUsersBooksLabel = new JLabel("Books available:");
        theUsersBooksLabel.setFont(new Font("Calibri", Font.BOLD, 18));

        profilePanel.add(theUsersBooksLabel);

        titleOfUsersBooks = new String[]{"Sagan om kingen", "Bilbo", "Snabba Cash", "Fågeln Roger"};
        for (int i = 0; i < titleOfUsersBooks.length; i++) {
            JLabel bookTitle = new JLabel(titleOfUsersBooks[i]);
            bookTitle.setFont(new Font("Calibri", Font.ITALIC, 16));
            profilePanel.add(bookTitle);
        }
        profilePanel.add(Box.createVerticalGlue());

        JPanel chatPanel = new JPanel(new BorderLayout());
        chatArea = new JTextArea(20, 50);
        chatArea.setText("New chat with user.getName()?...\n\n");
        chatArea.setEditable(false);

        JScrollPane chatScroll = new JScrollPane(chatArea);
        chatScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        chatScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        chatPanel.add(chatScroll, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputField = new JTextField(30);
        sendButton = new JButton("Send");
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(profilePanel, BorderLayout.EAST);
        mainPanel.add(chatPanel, BorderLayout.CENTER);
        mainPanel.add(inputPanel, BorderLayout.SOUTH);
        mainPanel.add(contactsPanel, BorderLayout.WEST);
        getContentPane().add(mainPanel);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                sendMessage();
            }
        });


        inputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    sendMessage();
                }
            }
        });

        setSize(800, 800);
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void sendMessage() {

        String message = inputField.getText();

        chatArea.append(name + ": " + message + "\n\n");

        inputField.setText("");
    }

    public static void main(String[] args) {
        ChatGui gui = new ChatGui();
    }
}