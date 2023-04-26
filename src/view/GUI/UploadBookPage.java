package view.GUI;

import controller.Controller;
import model.Book;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class UploadBookPage extends JPanel implements ActionListener {
    private Controller controller;
    private JButton homeButton;
    private JButton bookMarketButton;
    private JButton profileButton;
    private JButton upLoadABookButton;
    private JButton searchForABookButton;
    private MainFrame mainFrame;
    private JTextField titleField;
    private JTextField authorField;
    private JTextField yearField;
    private JTextField genreField;

    public UploadBookPage(Controller controller, MainFrame mainFrame) {
        this.controller = controller;
        this.mainFrame = mainFrame;
        setUp();
    }

    public void setUp() {
        setBackground(Color.WHITE);
        setLayout(null);

        JLabel bookSwapBig = new JLabel("UPLOAD BOOK");
        bookSwapBig.setFont(new Font("Calibri", Font.PLAIN, 44));
        bookSwapBig.setBounds(640, 140, 400, 40);
        bookSwapBig.setForeground(Color.GRAY);

        JTextArea textUnderImage = new JTextArea("Lorem ipsum text om hur det funkar här och \nkanske nått " +
                "om miljön Lorem ipsum text om \nhur det funkar här och kanske nått om miljön ");
        Font font = textUnderImage.getFont().deriveFont(Font.ITALIC);
        textUnderImage.setFont(font);
        textUnderImage.setBounds(150, 550, 300, 50);
        textUnderImage.setPreferredSize(new Dimension(300, 50));
        textUnderImage.setEditable(false);
        textUnderImage.setOpaque(false);
        add(textUnderImage);

        JLabel titleLabel = new JLabel("Title:");
        titleLabel.setBounds(650, 220, 100, 20);

        titleField = new JTextField(20);
        //usernameField.setBackground(Color.LIGHT_GRAY);
        titleField.setBorder(new LineBorder(Color.GRAY));
        titleField.setBounds(750, 216, 200, 26);

        JLabel authorLabel = new JLabel("Author:");
        authorLabel.setBounds(650, 260, 100, 20);

        authorField = new JTextField(20);
        //usernameField.setBackground(Color.LIGHT_GRAY);
        authorField.setBorder(new LineBorder(Color.GRAY));
        authorField.setBounds(750, 256, 200, 26);

        JLabel yearLabel = new JLabel("Release year:");
        yearLabel.setBounds(650, 300, 100, 20);
        yearLabel.setForeground(Color.GRAY);

        yearField = new JTextField(20);
        //usernameField.setBackground(Color.LIGHT_GRAY);
        yearField.setBorder(new LineBorder(Color.GRAY));
        yearField.setBounds(750, 296, 200, 26);

        JLabel genreLabel = new JLabel("Genre:");
        genreLabel.setBounds(650, 340, 100, 20);
        genreLabel.setForeground(Color.GRAY);

        genreField = new JTextField(20);
        //usernameField.setBackground(Color.LIGHT_GRAY);
        genreField.setBorder(new LineBorder(Color.GRAY));
        genreField.setBounds(750, 336, 200, 26);


        upLoadABookButton = new JButton("Upload a book");
        upLoadABookButton.setBounds(820, 400, 130, 24);
        upLoadABookButton.addActionListener(this);


        // Load the image into a BufferedImage object
        BufferedImage book;
        try {
            book = ImageIO.read(new File("files/Book2.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Create a JLabel object and set its icon to the loaded image
        JLabel bookLabel1 = new JLabel(new ImageIcon(book));
        bookLabel1.setBounds(15, 150, 600, 500);

        add(bookSwapBig);
        add(bookLabel1);
        add(titleLabel);
        add(titleField);
        add(authorLabel);
        add(authorField);
        add(yearLabel);
        add(yearField);
        add(genreLabel);
        add(genreField);
        add(upLoadABookButton);
        menuSetUp();
    }

    private void menuSetUp() {
        JLabel bookSwap = new JLabel("BookSwap");
        bookSwap.setFont(new Font("Calibri", Font.PLAIN, 16));
        bookSwap.setBounds(24, 46, 100, 20);

        homeButton = new JButton("Home");
        homeButton.setBounds(116, 48, 45, 16);
        homeButton.addActionListener(this);

        bookMarketButton = new JButton("BookMarket");
        bookMarketButton.setBounds(173, 48, 85, 16);
        bookMarketButton.addActionListener(this);

        profileButton = new JButton("Profile");
        profileButton.setBounds(269, 48, 45, 16);
        profileButton.addActionListener(this);

        add(bookSwap);
        add(homeButton);
        add(bookMarketButton);
        add(profileButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == homeButton) {
            controller.getGui().homePage();
        } else if (e.getSource() == bookMarketButton) {

        } else if (e.getSource() == profileButton) {

        }

        else if (e.getSource() == upLoadABookButton) {
            boolean hasTitle = (titleField.getText() != null && !titleField.getText().isEmpty());
            boolean hasAuthor = (authorField.getText() != null && !authorField.getText().isEmpty());
            if(hasTitle && hasAuthor) {
                Book book = new Book.BookBuilder().title(titleField.getText()).author(authorField.getText())
                        .release_date(yearField.getText()).genre(genreField.getText()).build();
                controller.getBookController().uploadBook(book);
            } else {
                JOptionPane.showMessageDialog(null, "You need to enter both title and author");
            }
        }
    }
}
