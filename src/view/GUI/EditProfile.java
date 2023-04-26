package view.GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class EditProfile implements ActionListener {

    private HomePage homePage;
    private BookMarket bookMarket;
    private JFrame frame = new JFrame("BookSwap");
    private JButton homeButton = new JButton("Home");
    private JButton bookMarketButton = new JButton("Book market");
    private JButton profileButton = new JButton("Profile");

    public static void main(String[] args) throws IOException {

        EditProfile editProfile = new EditProfile();
    }
    public EditProfile() throws IOException {

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

        JButton editPersonalInformation = new JButton("Edit personal information");
        editPersonalInformation.setBounds(286, 120, 200, 26);
        editPersonalInformation.setEnabled(false);

        JButton uploadABook = new JButton("Upload a book");
        uploadABook.setBounds(286, 160, 200, 26);

        JButton myWishList = new JButton("My wish list");
        myWishList.setBounds(286, 200, 200, 26);

        JButton myBooks = new JButton("My books");
        myBooks.setBounds(286, 240, 200, 26);

        JButton signOut = new JButton("Sign out");
        signOut.setBounds(286, 280, 200, 26);

        JButton changePicture = new JButton("Change picture");
        changePicture.setBounds(46, 340, 150, 26);


        /**
         * Edit info
         */

        JLabel userName = new JLabel("User name:");
        userName.setFont(new Font("Calibri", Font.PLAIN, 14));
        userName.setBounds(640, 120, 100, 20);

        JTextField userNameField = new JTextField(" Current username");
        userNameField.setFont(new Font("Calibri", Font.ITALIC, 11));
        userNameField.setForeground(Color.GRAY);
        userNameField.setBorder(new LineBorder(Color.GRAY));
        userNameField.setBounds(740, 122, 260, 20);

        JLabel password = new JLabel("Password:");
        password.setFont(new Font("Calibri", Font.PLAIN, 14));
        password.setBounds(640, 160, 100, 20);

        JTextField passWordField = new JTextField();
        passWordField.setBorder(new LineBorder(Color.GRAY));
        passWordField.setBounds(740, 162, 260, 20);

        JLabel eMail = new JLabel("E-mail:");
        eMail.setFont(new Font("Calibri", Font.PLAIN, 14));
        eMail.setBounds(640, 200, 100, 20);

        JTextField eMailField = new JTextField(" Current e-mail");
        eMailField.setFont(new Font("Calibri", Font.ITALIC, 11));
        eMailField.setForeground(Color.GRAY);
        eMailField.setBorder(new LineBorder(Color.GRAY));
        eMailField.setBounds(740, 202, 260, 20);

        JButton update = new JButton("Update");
        update.setBounds(808, 242, 120, 26);

        JButton deleteAccount = new JButton("Delete account");
        deleteAccount.setFont(new Font("Calibri", Font.BOLD, 10));
        deleteAccount.setBounds(813, 282, 110, 20);

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
        panel.add(userName);
        panel.add(userNameField);
        panel.add(password);
        panel.add(passWordField);
        panel.add(eMail);
        panel.add(eMailField);
        panel.add(update);
        panel.add(deleteAccount);

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
            frame.setVisible(false);
        }

        if (e.getSource() == bookMarketButton) {
            try {
                bookMarket = new BookMarket();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            frame.setVisible(false);
        }

    }
}
