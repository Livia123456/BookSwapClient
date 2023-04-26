package view.GUI;

import controller.Controller;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class UpLoadABook extends ProfilePage implements ActionListener {
    private JTextField iSBNField;
    private JTextField titleField;
    private JTextField authorField;
    private JTextField yearField;
    private JTextField editionField;
    private JTextField publisherField;
    private JComboBox genreComboBox;

    private JButton uploadImage;
    private JButton uploadToBookMarket;

    public UpLoadABook(Controller controller) {
        super(controller);
    }

    public void setUp() {


        /**
         * Edit info
         */


        JLabel iSBN = new JLabel("ISBN:");
        iSBN.setFont(new Font("Calibri", Font.PLAIN, 14));
        iSBN.setBounds(640, 120, 100, 20);

        iSBNField = new JTextField();
        iSBNField.setBorder(new LineBorder(Color.GRAY));
        iSBNField.setBounds(740, 122, 260, 20);

        JLabel title = new JLabel("Title*:");
        title.setFont(new Font("Calibri", Font.PLAIN, 14));
        title.setBounds(640, 160, 100, 20);

        titleField = new JTextField();
        titleField.setBorder(new LineBorder(Color.GRAY));
        titleField.setBounds(740, 162, 260, 20);

        JLabel author = new JLabel("Author:");
        author.setFont(new Font("Calibri", Font.PLAIN, 14));
        author.setBounds(640, 200, 100, 20);

        authorField = new JTextField();
        authorField.setBorder(new LineBorder(Color.GRAY));
        authorField.setBounds(740, 202, 260, 20);

        JLabel year = new JLabel("Year:");
        year.setFont(new Font("Calibri", Font.PLAIN, 14));
        year.setBounds(640, 240, 100, 20);

        yearField = new JTextField();
        yearField.setBorder(new LineBorder(Color.GRAY));
        yearField.setBounds(740, 242, 260, 20);

        JLabel edition = new JLabel("Edition:");
        edition.setFont(new Font("Calibri", Font.PLAIN, 14));
        edition.setBounds(640, 280, 100, 20);

        editionField = new JTextField();
        editionField.setBorder(new LineBorder(Color.GRAY));
        editionField.setBounds(740, 282, 260, 20);

        JLabel publisher = new JLabel("Publisher:");
        publisher.setFont(new Font("Calibri", Font.PLAIN, 14));
        publisher.setBounds(640, 320, 100, 20);

        publisherField = new JTextField();
        publisherField.setBorder(new LineBorder(Color.GRAY));
        publisherField.setBounds(740, 322, 260, 20);

        JLabel genre = new JLabel("Genre:");
        genre.setFont(new Font("Calibri", Font.PLAIN, 14));
        genre.setBounds(640, 360, 100, 20);

        genreComboBox = new JComboBox<>(new String[]{"Fiction", "Data Science", "HCI", "Mathematics", "Language Arts", "Fine Arts", "Physical Education"});
        genreComboBox.setMaximumRowCount(5);
        genreComboBox.setBackground(Color.WHITE);
        genreComboBox.setBounds(735, 360, 272, 24);
        genreComboBox.setVisible(true);

        BufferedImage bookToUpload = null;
        try {
            bookToUpload = ImageIO.read(new File("files/upLoadedBook.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Calculate the new width and height
        int newWidth1 = 140; // Set your desired width
        int newHeight1 = (int) Math.round((double) bookToUpload.getHeight() / bookToUpload.getWidth() * newWidth1);

        // Create a new image with the new dimensions
        BufferedImage bookToUploadResized = new BufferedImage(newWidth1, newHeight1, bookToUpload.getType());

        // Scale the original image onto the new image
        Graphics2D g2d1 = bookToUploadResized.createGraphics();
        g2d1.drawImage(bookToUpload, 0, 0, newWidth1, newHeight1, null);
        g2d1.dispose();

        JLabel bookToUpladLabel = new JLabel(new ImageIcon(bookToUploadResized));
        bookToUpladLabel.setHorizontalAlignment(JLabel.CENTER);
        bookToUpladLabel.setVerticalAlignment(JLabel.CENTER);

        JPanel bookPanel = new JPanel();
        bookPanel.setBackground(Color.WHITE);
        bookPanel.setBorder(new LineBorder(Color.GRAY, 2, true));
        bookPanel.setBounds(794, 400, newWidth1+10, newHeight1+10);

        uploadImage = new JButton("Add image");
        uploadImage.setBounds(816, 590, 112, 26);

        uploadToBookMarket = new JButton("Upload to book market");
        uploadToBookMarket.setFont(new Font("Calibri", Font.PLAIN, 14));
        uploadToBookMarket.setBounds(783, 624, 180, 34);


        add(iSBN);
        add(iSBNField);
        add(title);
        add(titleField);
        add(author);
        add(authorField);
        add(year);
        add(yearField);
        add(edition);
        add(editionField);
        add(publisher);
        add(publisherField);
        add(genre);
        add(genreComboBox);
        bookPanel.add(bookToUpladLabel, BorderLayout.CENTER);
        add(bookPanel);
        add(uploadImage);
        add(uploadToBookMarket);
        super.setUp();
        super.setUploadABookFalse();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == uploadToBookMarket) {

        } else if (e.getSource() == uploadImage) {

        }

    }
}
