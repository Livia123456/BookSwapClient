package view.GUI;

import controller.Controller;

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

public class AdvancedSearch extends PageWithMenu implements ActionListener {
    private JButton searchButton = new JButton("Search");

    public AdvancedSearch(Controller controller) {
        super(controller);
        setUp();
    }

    private JTextField titleField;
    private JTextField authorField;
    private JComboBox genreComboBox;
    private JTextField yearField;
    private JTextField editionField;
    private JTextField iSBNField;
    private JTextField publisherField;

    public void setUp() {

        setBackground(Color.WHITE);
        setLayout(null);

        JLabel advancedSearch = new JLabel("Advanced search");
        advancedSearch.setFont(new Font("Calibri", Font.ITALIC, 22));
        advancedSearch.setForeground(Color.GRAY);
        advancedSearch.setBounds(153, 100, 200, 20);

        JLabel title = new JLabel("Title:");
        title.setFont(new Font("Serif", Font.BOLD, 16));
        title.setBounds(30, 140, 100, 20);

        titleField = new JTextField(20);
        titleField.setBorder(new LineBorder(Color.GRAY));
        titleField.setBounds(153, 200, 300, 24);

        JLabel author = new JLabel("Author:");
        author.setFont(new Font("Serif", Font.BOLD, 16));
        author.setBounds(30, 200, 100, 20);

        authorField = new JTextField(20);
        authorField.setBorder(new LineBorder(Color.GRAY));
        authorField.setBounds(153, 320, 300, 24);

        JLabel genre = new JLabel("Genre:");
        genre.setFont(new Font("Serif", Font.BOLD, 16));
        genre.setBounds(30, 260, 100, 20);

        genreComboBox = new JComboBox<>(new String[]{"Fiction", "Data Science", "HCI", "Mathematics", "Language Arts", "Fine Arts", "Physical Education"});
        genreComboBox.setMaximumRowCount(5);
        genreComboBox.setBackground(Color.WHITE);
        genreComboBox.setBounds(149, 260, 309, 24);
        genreComboBox.setVisible(true);

        JLabel year = new JLabel("Year:");
        year.setFont(new Font("Serif", Font.BOLD, 16));
        year.setBounds(30, 320, 100, 20);

        yearField = new JTextField(20);
        yearField.setBorder(new LineBorder(Color.GRAY));
        yearField.setBounds(153, 379, 300, 24);

        JLabel edition = new JLabel("Edition:");
        edition.setFont(new Font("Serif", Font.BOLD, 16));
        edition.setBounds(30, 380, 100, 20);

        editionField = new JTextField(20);
        editionField.setBorder(new LineBorder(Color.GRAY));
        editionField.setBounds(153, 439, 300, 24);

        JLabel iSBN = new JLabel("ISBN:");
        iSBN.setFont(new Font("Serif", Font.BOLD, 16));
        iSBN.setBounds(30, 500, 100, 20);

        iSBNField = new JTextField(20);
        iSBNField.setEnabled(false);
        iSBNField.setBorder(new LineBorder(Color.GRAY));
        iSBNField.setBounds(153, 138, 300, 24);

        JLabel publisher = new JLabel("Publisher:");
        publisher.setFont(new Font("Serif", Font.BOLD, 16));
        publisher.setBounds(30, 440, 100, 20);

        publisherField = new JTextField(20);
        publisherField.setBorder(new LineBorder(Color.GRAY));
        publisherField.setBounds(153, 499, 300, 24);

        searchButton.setFont(new Font("Calibri", Font.PLAIN, 28));
        searchButton.setBounds(28, 540, 429, 80);
        searchButton.addActionListener(this);

        JLabel bookMarket = new JLabel("Book market");
        bookMarket.setFont(new Font("Calibri", Font.ITALIC,18));
        Border border = new MatteBorder(0, 0, 1, 0, Color.BLACK);
        bookMarket.setBorder(border);
        bookMarket.setBounds(495, 40, 116, 30);

        /**
         * PANEL1 STARTS
         */

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);

        JTextField resultISBN = new JTextField(20);
        resultISBN.setText(" ISBN");
        resultISBN.setEnabled(false);
        resultISBN.setBorder(new LineBorder(Color.GRAY));
        resultISBN.setBounds(250, 20, 295, 24);

        JTextField resultTitle = new JTextField(20);
        resultTitle.setText(" Title");
        resultTitle.setEnabled(false);
        resultTitle.setBorder(new LineBorder(Color.GRAY));
        resultTitle.setBounds(250, 60, 295, 24);

        JTextField resultAuthor = new JTextField(20);
        resultAuthor.setText(" Author");
        resultAuthor.setEnabled(false);
        resultAuthor.setBorder(new LineBorder(Color.GRAY));
        resultAuthor.setBounds(250, 100, 295, 24);

        JTextField resultGenre = new JTextField(20);
        resultGenre.setText(" Genre");
        resultGenre.setEnabled(false);
        resultGenre.setBorder(new LineBorder(Color.GRAY));
        resultGenre.setBounds(250, 140, 295, 24);

        JTextField resultYear = new JTextField(20);
        resultYear.setText(" Year");
        resultYear.setEnabled(false);
        resultYear.setBorder(new LineBorder(Color.GRAY));
        resultYear.setBounds(250, 180, 295, 24);

        JTextField resultEdition = new JTextField(20);
        resultEdition.setText(" Edition");
        resultEdition.setEnabled(false);
        resultEdition.setBorder(new LineBorder(Color.GRAY));
        resultEdition.setBounds(250, 220, 295, 24);

        JTextField resultPublisher = new JTextField(20);
        resultPublisher.setText(" Publisher");
        resultPublisher.setEnabled(false);
        resultPublisher.setBorder(new LineBorder(Color.GRAY));
        resultPublisher.setBounds(250, 260, 295, 24);

        BufferedImage bookToUplad = null;
        try {
            bookToUplad = ImageIO.read(new File("files/Book3.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Calculate the new width and height
        int newWidth1 = 200; // Set your desired width
        int newHeight1 = (int) Math.round((double) bookToUplad.getHeight() / bookToUplad.getWidth() * newWidth1);

        // Create a new image with the new dimensions
        BufferedImage bookToUploadResized = new BufferedImage(newWidth1, newHeight1, bookToUplad.getType());

        // Scale the original image onto the new image
        Graphics2D g2d1 = bookToUploadResized.createGraphics();
        g2d1.drawImage(bookToUplad, 0, 0, newWidth1, newHeight1, null);
        g2d1.dispose();

        JLabel bookToUploadLabel = new JLabel(new ImageIcon(bookToUploadResized));
        bookToUploadLabel.setHorizontalAlignment(JLabel.CENTER);
        bookToUploadLabel.setVerticalAlignment(JLabel.CENTER);

        JPanel bookPanel = new JPanel();
        bookPanel.setBackground(Color.WHITE);
        bookPanel.setBorder(new LineBorder(Color.GRAY, 2, true));
        bookPanel.setBounds(505, 98, newWidth1+10, newHeight1+10);

        panel1.add(resultISBN);
        panel1.add(resultTitle);
        panel1.add(resultAuthor);
        panel1.add(resultGenre);
        panel1.add(resultYear);
        panel1.add(resultEdition);
        panel1.add(resultPublisher);
        bookPanel.add(bookToUploadLabel, BorderLayout.CENTER);
        add(bookPanel);

        JScrollPane scrollPane = new JScrollPane(panel1);
        scrollPane.setBackground(Color.WHITE);
        scrollPane.setBorder(new LineBorder(Color.PINK));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(486, 76, 570, 554);


        add(advancedSearch);
        add(iSBN);
        add(iSBNField);
        add(title);
        add(titleField);
        add(author);
        add(authorField);
        add(genre);
        add(genreComboBox);
        add(year);
        add(yearField);
        add(edition);
        add(editionField);
        add(publisher);
        add(publisherField);
        add(bookMarket);
        add(scrollPane);
        add(searchButton);
        super.menuSetUp();
        super.setBookMarketButtonFalse();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == searchButton) {

        }

    }
}
