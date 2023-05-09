package view.GUI.pages;

import controller.Controller;
import model.chat.ChatObject;
import model.chat.ChatStatus;
import model.chat.ChatsWith;
import view.GUI.PageWithMenu;
import view.GUI.ProfilePage;

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
import java.util.ArrayList;

public class ChatPage extends PageWithMenu implements ActionListener{


    private Controller controller;
    private String name;
    private int userId;
    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;
    private JPanel profilePanel;
    private JPanel contactsPanel;
    private ArrayList<ChatsWith> contacts;
    private String[] titleOfUsersBooks;
    private JButton homeButton = new JButton("Home");
    private JButton bookMarketButton = new JButton("Book market");
    private JButton profileButton = new JButton("Profile");
    private JButton chatButton = new JButton("Chat");

    public ChatPage(Controller controller) {
        super(controller);

        this.controller = controller;
        name = controller.getCurrentUser().getName();
        userId = controller.getCurrentUser().getUserId();

        /*
        JButton bookSwapButton = new JButton("BookSwap");
        bookSwapButton.setFont(new Font("Calibri", Font.PLAIN, 18));
        bookSwapButton.setBounds(18, 46, 90, 22);
        bookSwapButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        bookSwapButton.addActionListener(this);

        homeButton.setBounds(116, 48, 60, 16);
        homeButton.addActionListener(this);

        bookMarketButton.setBounds(183, 48, 100, 16);
        bookMarketButton.addActionListener(this);

        profileButton.setBounds(289, 48, 60, 16);
        profileButton.addActionListener(this);

        chatButton.setBounds(356, 48, 60, 16);
        chatButton.setEnabled(false);
        chatButton.addActionListener(this);

        add(bookSwapButton);
        add(homeButton);
        add(bookMarketButton);
        add(profileButton);
        add(chatButton);
        
         */

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setPreferredSize(new Dimension(600, 40));
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));
        buttonsPanel.setBackground(Color.WHITE);

        profilePanel = new JPanel();
        profilePanel.setPreferredSize(new Dimension(200, profilePanel.getHeight()));
        profilePanel.setBorder(BorderFactory.createEmptyBorder(100, 10, 10, 10));
        profilePanel.setLayout(new BoxLayout(profilePanel, BoxLayout.Y_AXIS));
        profilePanel.setBackground(Color.WHITE);

        contactsPanel = new JPanel();
        contactsPanel.setPreferredSize(new Dimension(200, profilePanel.getHeight()));
        contactsPanel.setBorder(BorderFactory.createEmptyBorder(50, 10, 10, 10));
        contactsPanel.setBackground(Color.WHITE);


        contacts = controller.getCurrentUser().getChatsWith();

        for (int i = 0; i < contacts.size(); i++) {
            JButton button = new JButton(contacts.get(i).getName());
            button.setFont(new Font("Arial", Font.PLAIN, 16));
            button.setPreferredSize(new Dimension(180, 40));
            contactsPanel.add(button);
        }

        /*contacts = new String[]{"Olle", "Livve", "Zulle", "Kappe", "Klas den fule", "Jajja"};
        for (int i = 0; i < contacts.length; i++) {
            JButton button = new JButton(contacts[i]);
            button.setFont(new Font("Arial", Font.PLAIN, 16));
            button.setPreferredSize(new Dimension(180, 40));
            contactsPanel.add(button);
        }  */

        //getActiveChats();


        BufferedImage profilePicture;
        try {
            profilePicture = ImageIO.read(new File("files/Avatar.jpg"));
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

        titleOfUsersBooks = new String[]{"Sagan om ringen", "Bilbo", "Snabba Cash", "Fågeln Roger"};
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
        chatScroll.setBorder(BorderFactory.createEmptyBorder(50, 10, 10, 10));
        chatScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        chatScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        chatPanel.add(chatScroll, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputField = new JTextField(30);
        sendButton = new JButton("Send");
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        setLayout(new BorderLayout());
        add(buttonsPanel, BorderLayout.NORTH);

        add(profilePanel, BorderLayout.EAST);
        add(chatPanel, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);
        add(contactsPanel, BorderLayout.WEST);


        //mainFrame.getContentPane().add(mainPanel);

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
        super.menuSetUp();
        super.setChatButtonFalse();
    }


    public void getActiveChats(){

        controller.getChatController().sendMessage
                (new ChatObject(controller.getCurrentUser().getUserId(), 0, ChatStatus.populate));

    }


    private void sendMessage() {

        String message = inputField.getText();
        // controller.getChatController().sendMessage(controller.getCurrentUser().getUserId()), );

        chatArea.append(name + ": " + message + "\n\n");

        inputField.setText("");
    }

    public static void main(String[] args) {
       // ChatPage cP = new ChatPage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

       //Måste fixas men fattar ej hur...
    }
}
