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

public class Profile implements ActionListener {

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
        Profile profile = new Profile();
    }
    public Profile() throws IOException {
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
