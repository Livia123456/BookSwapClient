package view.GUI.pages;

import controller.ChatController;
import controller.Controller;
import model.Book;

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
    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;
    private JPanel profilePanel;
    private JLabel bookTitle;
    private JLabel theUsersBooksLabel;
    private Component glue = Box.createVerticalGlue();
    private JPanel contactsPanel;
    private ArrayList<JButton> buttons;
    private JButton but;
    private JButton homeButton = new JButton("Home");
    private JButton bookMarketButton = new JButton("Book Market");
    private JButton profileButton = new JButton("Profile");
    private JButton chatButton = new JButton("Chat");
    private JButton bookSwapButton;
    private JLabel profilePictureLabel;
    private JLabel profilePicture;
    private JLabel profilePicLabel;
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
        //contactsPanel.setBorder(BorderFactory.createEmptyBorder(50, 10, 10, 10));
        contactsPanel.setBackground(Color.WHITE);


        Image originalImage = controller.getCurrentUser().getProfileImage().getImage();
        Image scaledImage = originalImage.getScaledInstance(180, 180, Image.SCALE_SMOOTH);
        ImageIcon resizedImageIcon = new ImageIcon(scaledImage);
        profilePicLabel = new JLabel(resizedImageIcon);
        profilePicLabel.setAlignmentY(Component.TOP_ALIGNMENT);
        contactsPanel.add(profilePicLabel);



        for (int i = 0; i < contacts.size(); i++) {

            but = new JButton(contacts.get(i));
            but.addActionListener(this);
            but.setFont(new Font("Arial", Font.PLAIN, 16));
            but.setPreferredSize(new Dimension(180, 40));
            buttons.add(but);
            contactsPanel.add(buttons.get(i));
        }


       BufferedImage profilePicture;
        try {
            profilePicture = ImageIO.read(new File("files/user.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int newWidth = 180;
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
        profilePanel.add(glue);

        theUsersBooksLabel = new JLabel("Books available:");
        theUsersBooksLabel.setFont(new Font("Calibri", Font.BOLD, 18));

        profilePanel.add(theUsersBooksLabel);
        profilePanel.add(glue);



        JPanel chatPanel = new JPanel(new BorderLayout());
        chatArea = new JTextArea(20, 30);
        chatArea.setEditable(false);

        JScrollPane chatScroll = new JScrollPane(chatArea);
        //chatScroll.setBorder(BorderFactory.createEmptyBorder(50, 10, 10, 10));
        chatScroll.setBorder(BorderFactory.createEmptyBorder(160, 80, 60, 80));
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

        profilePanel.setVisible(false);

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

    public void addChatHistory(String chat){
        chatArea.setText(chat);
    }

    public void setProfileImage(ImageIcon message) {
        profilePictureLabel.setIcon(message);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < buttons.size(); i++) {
            JButton button = buttons.get(i);

            if (e.getSource() == button) {
                chatController.openChatWith(i);
               // chatArea.setText("");
                button.setEnabled(false);
            } else {
                button.setEnabled(true);
            }
            button.setFocusPainted(false);
        }
    }

    public void messageSent(String name, String message) {
        chatArea.append(name + ": " + message + "\n");
        inputField.setText("");
    }

    public void updateProfilePanel(String books, String name) {
        try {
            profilePanel.remove(theUsersBooksLabel);
            profilePanel.remove(profileNameLabel);
            profilePanel.remove(bookTitle);
            profilePanel.remove(glue);
        } catch (Exception e) {}

        profileNameLabel = new JLabel(name, SwingConstants.CENTER);
        profileNameLabel.setAlignmentY(Component.TOP_ALIGNMENT);
        profileNameLabel.setFont(new Font("Arial", Font.BOLD, 24));
        profilePanel.add(profileNameLabel);
        profilePanel.add(theUsersBooksLabel);

        bookTitle = new JLabel(books, SwingConstants.LEFT);
        bookTitle.setFont(new Font("Calibri", Font.ITALIC, 16));
        profilePanel.add(bookTitle);
        profilePanel.add(glue);
        profilePanel.revalidate();
        profilePanel.repaint();
        profilePanel.setVisible(true);
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
