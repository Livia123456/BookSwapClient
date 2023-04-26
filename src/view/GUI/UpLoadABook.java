package view.GUI;

import javax.annotation.processing.RoundEnvironment;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class UpLoadABook implements ActionListener {

    private HomePage homePage;
    private BookMarket bookMarket;
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
        UpLoadABook upLoadABook = new UpLoadABook();
    }
    public UpLoadABook() throws IOException {
        JFrame frame = new JFrame("BookSwap");
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

        BufferedImage book1 = ImageIO.read(new File("files/PP.jpg"));

        // Calculate the new width and height
        int newWidth = 200; // Set your desired width
        int newHeight = (int) Math.round((double) book1.getHeight() / book1.getWidth() * newWidth);

        // Create a new image with the new dimensions
        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, book1.getType());

        // Scale the original image onto the new image
        Graphics2D g2d = resizedImage.createGraphics();
        g2d.drawImage(book1, 0, 0, newWidth, newHeight, null);
        g2d.dispose();

        JLabel bookLabel1 = new JLabel(new ImageIcon(resizedImage));
        bookLabel1.setBounds(-5, 80, 250, 250);

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

        /**
         * Edit info
         */

        JLabel iSBN = new JLabel("ISBN:");
        iSBN.setFont(new Font("Calibri", Font.PLAIN, 14));
        iSBN.setBounds(640, 120, 100, 20);

        JTextField iSBNField = new JTextField();
        iSBNField.setBorder(new LineBorder(Color.GRAY));
        iSBNField.setBounds(740, 122, 260, 20);

        JLabel title = new JLabel("Title*:");
        title.setFont(new Font("Calibri", Font.PLAIN, 14));
        title.setBounds(640, 160, 100, 20);

        JTextField titleField = new JTextField();
        titleField.setBorder(new LineBorder(Color.GRAY));
        titleField.setBounds(740, 162, 260, 20);

        JLabel author = new JLabel("Author:");
        author.setFont(new Font("Calibri", Font.PLAIN, 14));
        author.setBounds(640, 200, 100, 20);

        JTextField authorField = new JTextField();
        authorField.setBorder(new LineBorder(Color.GRAY));
        authorField.setBounds(740, 202, 260, 20);

        JLabel year = new JLabel("Year:");
        year.setFont(new Font("Calibri", Font.PLAIN, 14));
        year.setBounds(640, 240, 100, 20);

        JTextField yearField = new JTextField();
        yearField.setBorder(new LineBorder(Color.GRAY));
        yearField.setBounds(740, 242, 260, 20);

        JLabel edition = new JLabel("Edition:");
        edition.setFont(new Font("Calibri", Font.PLAIN, 14));
        edition.setBounds(640, 280, 100, 20);

        JTextField editionField = new JTextField();
        editionField.setBorder(new LineBorder(Color.GRAY));
        editionField.setBounds(740, 282, 260, 20);

        JLabel publisher = new JLabel("Publisher:");
        publisher.setFont(new Font("Calibri", Font.PLAIN, 14));
        publisher.setBounds(640, 320, 100, 20);

        JTextField publisherField = new JTextField();
        publisherField.setBorder(new LineBorder(Color.GRAY));
        publisherField.setBounds(740, 322, 260, 20);

        JLabel genre = new JLabel("Genre:");
        genre.setFont(new Font("Calibri", Font.PLAIN, 14));
        genre.setBounds(640, 360, 100, 20);

        JComboBox genreComboBox = new JComboBox<>(new String[]{"Fiction", "Data Science", "HCI", "Mathematics", "Language Arts", "Fine Arts", "Physical Education"});
        genreComboBox.setMaximumRowCount(5);
        genreComboBox.setBackground(Color.WHITE);
        genreComboBox.setBounds(735, 360, 272, 24);
        genreComboBox.setVisible(true);

        BufferedImage bookToUplad = ImageIO.read(new File("files/upLoadedBook.png"));

        // Calculate the new width and height
        int newWidth1 = 140; // Set your desired width
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
        bookPanel.setBounds(794, 400, newWidth1+10, newHeight1+10);

        JButton uploadImage = new JButton("Add image");
        uploadImage.setBounds(816, 590, 112, 26);

        JButton uploadToBookMarket = new JButton("Upload to book market");
        uploadToBookMarket.setFont(new Font("Calibri", Font.PLAIN, 14));
        uploadToBookMarket.setBounds(783, 624, 180, 34);

        panel.add(bookSwap);
        panel.add(homeButton);
        panel.add(bookMarketButton);
        panel.add(profileButton);
        panel.add(bookLabel1);
        panel.add(editPersonalInformation);
        panel.add(uploadABook);
        panel.add(myWishList);
        panel.add(myBooks);
        panel.add(signOut);
        panel.add(changePicture);
        panel.add(iSBN);
        panel.add(iSBNField);
        panel.add(title);
        panel.add(titleField);
        panel.add(author);
        panel.add(authorField);
        panel.add(year);
        panel.add(yearField);
        panel.add(edition);
        panel.add(editionField);
        panel.add(publisher);
        panel.add(publisherField);
        panel.add(genre);
        panel.add(genreComboBox);
        bookPanel.add(bookToUpladLabel, BorderLayout.CENTER);
        panel.add(bookPanel);
        panel.add(uploadImage);
        panel.add(uploadToBookMarket);

        frame.setSize(1100, 700);
        frame.setLocationRelativeTo(null);
        frame.add(panel, BorderLayout.CENTER);

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
                bookMarket = new BookMarket();
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
