package view.GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MyBooks implements ActionListener {

    private HomePage homePage;
    private AdvancedSearch bookMarket;
    private JFrame frame = new JFrame("BookSwap");
    private JButton homeButton = new JButton("Home");
    private JButton bookMarketButton = new JButton("Book market");
    private JButton profileButton = new JButton("Profile");
    private JButton editPersonalInformation = new JButton("Edit personal information");
    private JButton uploadABook = new JButton("Upload a book");
    private JButton myWishList = new JButton("My wish list");
    private JButton myBooks = new JButton("My books");
    private JButton signOut = new JButton("Sign out");
    private JButton changePicture = new JButton("Change picture");


    public static void main(String[] args) throws IOException {
        MyBooks myBooks = new MyBooks();
    }
    public MyBooks() throws IOException {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);

        JLabel bookSwap = new JLabel("BookSwap");
        bookSwap.setFont(new Font("Calibri", Font.PLAIN, 18));
        bookSwap.setBounds(18, 46, 100, 20);

        homeButton.setBounds(116, 48, 60, 16);
        homeButton.addActionListener(this);

        bookMarketButton.setBounds(183, 48, 100, 16);
        bookMarketButton.addActionListener(this);

        profileButton.setBounds(289, 48, 60, 16);
        profileButton.setEnabled(false);

        BufferedImage profilePicture = ImageIO.read(new File("files/PP.jpg"));

        // Calculate the new width and height
        int newWidth = 200; // Set your desired width
        int newHeight = (int) Math.round((double) profilePicture.getHeight() / profilePicture.getWidth() * newWidth);

        // Create a new image with the new dimensions
        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, profilePicture.getType());

        // Scale the original image onto the new image
        Graphics2D g2d = resizedImage.createGraphics();
        g2d.drawImage(profilePicture, 0, 0, newWidth, newHeight, null);
        g2d.dispose();

        JLabel profilePictureLabel = new JLabel(new ImageIcon(resizedImage));
        profilePictureLabel.setBounds(-5, 80, 250, 250);

        editPersonalInformation.setBounds(286, 120, 200, 26);
        editPersonalInformation.addActionListener(this);

        uploadABook.setBounds(286, 160, 200, 26);
        uploadABook.addActionListener(this);

        myWishList.setBounds(286, 200, 200, 26);
        myWishList.addActionListener(this);

        myBooks.setBounds(286, 240, 200, 26);
        myBooks.addActionListener(this);

        signOut.setBounds(286, 280, 200, 26);
        signOut.addActionListener(this);

        changePicture.setBounds(46, 340, 150, 26);
        changePicture.addActionListener(this);

        panel.add(bookSwap);
        panel.add(homeButton);
        panel.add(bookMarketButton);
        panel.add(profileButton);
        panel.add(profilePictureLabel);
        panel.add(editPersonalInformation);
        panel.add(uploadABook);
        panel.add(myWishList);
        panel.add(myBooks);
        panel.add(signOut);
        panel.add(changePicture);

        JLabel bookMarket = new JLabel(" My books");
        bookMarket.setFont(new Font("Calibri", Font.ITALIC,18));
        Border border = new MatteBorder(0, 0, 1, 0, Color.BLACK);
        bookMarket.setBorder(border);
        bookMarket.setBounds(520, 40, 116, 30);

        /**
         * PANEL1 STARTS
         */

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);

        JTextField resultTitle = new JTextField(20);
        resultTitle.setText(" Title");
        resultTitle.setEnabled(false);
        resultTitle.setBorder(new LineBorder(Color.GRAY));
        resultTitle.setBounds(250, 20, 295, 24);

        JTextField resultAuthor = new JTextField(20);
        resultAuthor.setText(" Author");
        resultAuthor.setEnabled(false);
        resultAuthor.setBorder(new LineBorder(Color.GRAY));
        resultAuthor.setBounds(250, 60, 295, 24);

        JTextField resultGenre = new JTextField(20);
        resultGenre.setText(" Genre");
        resultGenre.setEnabled(false);
        resultGenre.setBorder(new LineBorder(Color.GRAY));
        resultGenre.setBounds(250, 100, 295, 24);

        JTextField resultYear = new JTextField(20);
        resultYear.setText(" Year");
        resultYear.setEnabled(false);
        resultYear.setBorder(new LineBorder(Color.GRAY));
        resultYear.setBounds(250, 140, 295, 24);

        JTextField resultEdition = new JTextField(20);
        resultEdition.setText(" Edition");
        resultEdition.setEnabled(false);
        resultEdition.setBorder(new LineBorder(Color.GRAY));
        resultEdition.setBounds(250, 180, 295, 24);

        JTextField resultPublisher = new JTextField(20);
        resultPublisher.setText(" Publisher");
        resultPublisher.setEnabled(false);
        resultPublisher.setBorder(new LineBorder(Color.GRAY));
        resultPublisher.setBounds(250, 220, 295, 24);

        JTextField resultISBN = new JTextField(20);
        resultISBN.setText(" ISBN");
        resultISBN.setEnabled(false);
        resultISBN.setBorder(new LineBorder(Color.GRAY));
        resultISBN.setBounds(250, 260, 295, 24);

        BufferedImage bookToUplad = ImageIO.read(new File("files/Book4.png"));

        // Calculate the new width and height
        int newWidth1 = 180; // Set your desired width
        int newHeight1 = (int) Math.round((double) bookToUplad.getHeight() / bookToUplad.getWidth() * newWidth1);

        // Create a new image with the new dimensions
        BufferedImage bookToUploadResized = new BufferedImage(newWidth1, newHeight1, bookToUplad.getType());

        // Scale the original image onto the new image
        Graphics2D g2d1 = bookToUploadResized.createGraphics();
        g2d1.drawImage(bookToUplad, 0, 0, newWidth1, newHeight1, null);
        g2d1.dispose();

        JLabel bookToUpladLabel = new JLabel(new ImageIcon(bookToUploadResized));
        bookToUpladLabel.setHorizontalAlignment(JLabel.CENTER);
        bookToUpladLabel.setVerticalAlignment(JLabel.CENTER);

        JPanel bookPanel = new JPanel();
        bookPanel.setBackground(Color.WHITE);
        bookPanel.setBorder(new LineBorder(Color.GRAY, 2, true));
        bookPanel.setBounds(511, 98, newWidth1+10, newHeight1+10);

        panel1.add(resultISBN);
        panel1.add(resultTitle);
        panel1.add(resultAuthor);
        panel1.add(resultGenre);
        panel1.add(resultYear);
        panel1.add(resultEdition);
        panel1.add(resultPublisher);
        bookPanel.add(bookToUpladLabel, BorderLayout.CENTER);
        panel.add(bookPanel);

        JScrollPane scrollPane = new JScrollPane(panel1);
        scrollPane.setBackground(Color.WHITE);
        scrollPane.setBorder(new LineBorder(Color.PINK));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(500, 76, 570, 554);

        panel.add(bookSwap);
        panel.add(homeButton);
        panel.add(bookMarketButton);
        panel.add(profileButton);
        panel.add(bookMarket);
        panel.add(scrollPane);

        frame.setSize(1100, 700);
        frame.setLocationRelativeTo(null);
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == homeButton) {
            try {
                homePage = new HomePage();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

        if (e.getSource() == bookMarketButton) {
            try {
                bookMarket = new AdvancedSearch();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

        if (e.getSource() == editPersonalInformation) {

        }

        if (e.getSource() == uploadABook) {

        }

        if (e.getSource() == myWishList) {

        }

        if (e.getSource() == myBooks) {

        }

        if (e.getSource() == signOut) {

        }
    }
}
