package view.GUI.pages;

import controller.ChatController;
import controller.Controller;
import model.chat.MessageObject;

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

/**
 * Class responsible for the chat-GUI.
 * @author Livia Tengelin, Olle Huss
 */

public class ChatPage extends JPanel implements ActionListener {

    private Controller controller;
    private ChatController chatController;
    //private String name;
    //private ChatsWith chatsWith;
    //private int userId;

    //private ArrayList<ChatsWith> contacts;
    //private String[] titleOfUsersBooks;
    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;
    private JPanel profilePanel;
    private JLabel bookTitle;
    private Component glue = Box.createVerticalGlue();
    private JPanel contactsPanel;
    private ArrayList<JButton> buttons;
    private JButton but;

    private JButton homeButton = new JButton("Home");
    private JButton bookMarketButton = new JButton("Book market");
    private JButton profileButton = new JButton("Profile");
    private JButton chatButton = new JButton("Chat");
    private JButton bookSwapButton;
    private JLabel profilePictureLabel;
    private JLabel profileNameLabel;


    public ChatPage(Controller controller) {
        //super(controller);

        this.controller = controller;
        this.chatController = controller.getChatController();
        this.buttons = new ArrayList<>();

    }
    public void setUp(ArrayList<String> contacts, String name) {
        MenuActionListener mal = new MenuActionListener();
        bookSwapButton = new JButton("BookSwap");
        bookSwapButton.setFont(new Font("Calibri", Font.PLAIN, 18));
        bookSwapButton.setBounds(18, 46, 90, 22);
        bookSwapButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        bookSwapButton.addActionListener(mal);

        homeButton.setBounds(116, 48, 60, 16);
        homeButton.addActionListener(mal);

        bookMarketButton.setBounds(183, 48, 100, 16);
        bookMarketButton.addActionListener(mal);

        profileButton.setBounds(289, 48, 60, 16);
        profileButton.addActionListener(mal);

        chatButton.setBounds(356, 48, 60, 16);
        chatButton.setEnabled(false);
        //chatButton.addActionListener(mal);

        add(bookSwapButton);
        add(homeButton);
        add(bookMarketButton);
        add(profileButton);
        add(chatButton);


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

        for (int i = 0; i < contacts.size(); i++) {

            but = new JButton(contacts.get(i));
            but.addActionListener(this);
            but.setFont(new Font("Arial", Font.PLAIN, 16));
            but.setPreferredSize(new Dimension(180, 40));
            buttons.add(but);
            contactsPanel.add(buttons.get(i));
        }




        //Profilepic
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

        profilePictureLabel = new JLabel(new ImageIcon(resizedImage));
        profilePictureLabel.setAlignmentY(Component.TOP_ALIGNMENT);
        profilePanel.add(profilePictureLabel);

        profilePanel.add(Box.createRigidArea(new Dimension(0, 10)));


        profileNameLabel = new JLabel(name, SwingConstants.CENTER);
        profileNameLabel.setAlignmentY(Component.TOP_ALIGNMENT);
        profileNameLabel.setFont(new Font("Arial", Font.BOLD, 24));
        profilePanel.add(profileNameLabel);

        JLabel space = new JLabel(" ");

        profilePanel.add(space);

        JLabel theUsersBooksLabel = new JLabel("Books available:");
        theUsersBooksLabel.setFont(new Font("Calibri", Font.BOLD, 18));

        profilePanel.add(theUsersBooksLabel);

        //titleOfUsersBooks = new String[0];
        /*
        for (int i = 0; i < titleOfUsersBooks.length; i++) {
            JLabel bookTitle = new JLabel(titleOfUsersBooks[i]);
            bookTitle.setFont(new Font("Calibri", Font.ITALIC, 16));
            profilePanel.add(bookTitle);
        }
        */
        profilePanel.add(Box.createVerticalGlue());



        JPanel chatPanel = new JPanel(new BorderLayout());
        chatArea = new JTextArea(20, 50);
        chatArea.setEditable(false);

        JScrollPane chatScroll = new JScrollPane(chatArea);
        chatScroll.setBorder(BorderFactory.createEmptyBorder(50, 10, 10, 10));
        chatScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        chatScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        chatPanel.add(chatScroll, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputField = new JTextField(30);
        sendButton = new JButton("Send");
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        setLayout(new BorderLayout());
        add(buttonsPanel, BorderLayout.NORTH);
        add(bookSwapButton);

        add(profilePanel, BorderLayout.EAST);
        add(chatPanel, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);
        add(contactsPanel, BorderLayout.WEST);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                chatController.sendMessage(inputField.getText());
            }
        });


        inputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {
                boolean validMessage = inputField.getText() != null && !inputField.getText().isEmpty()
                                        && !inputField.getText().isBlank();
                if (e.getKeyCode() == KeyEvent.VK_ENTER && validMessage) {
                    chatController.sendMessage(inputField.getText());
                }
            }
        });
    }

    //public void addChatHistory(ArrayList<MessageObject> list){
    public void addChatHistory(String chat){
        chatArea.setText(chat);
    }

    public void setProfileImage(ImageIcon message) {
        profilePictureLabel.setIcon(message);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < buttons.size(); i++) {

            if (e.getSource() == buttons.get(i)) {
                chatController.openChatWith(i);
                return;

            }
        }

    }

    public void messageSent(String name, String message) {
        chatArea.append(name + ": " + message + "\n");
        inputField.setText("");
    }

    public void updateBooks(String books) {
        try {
            profilePanel.remove(bookTitle);
            profilePanel.remove(glue);
        } catch (Exception e) {}
        bookTitle = new JLabel(books);
        bookTitle.setFont(new Font("Calibri", Font.ITALIC, 16));
        profilePanel.add(bookTitle);
        profilePanel.add(glue);
        profilePanel.revalidate();
        profilePanel.repaint();
    }



    public class MenuActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == homeButton || e.getSource() == bookSwapButton) {
                controller.getGui().homePage();
            } else if (e.getSource() == bookMarketButton) {
                controller.getGui().bookMarket();
            } else if (e.getSource() == profileButton) {
                controller.getGui().profilePage();
            } else if (e.getSource() == chatButton) {
                controller.getGui().chatPage();
            }
        }
    }

}
