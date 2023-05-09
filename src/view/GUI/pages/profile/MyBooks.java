package view.GUI.pages.profile;

import controller.Controller;
import model.AdvancedSearchResult;
import model.Book;
import view.GUI.ProfilePage;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MyBooks extends ProfilePage implements ActionListener {
    private JScrollPane scrollPane;

    public MyBooks(Controller controller, ArrayList<Book> currentUsersUploadedBooks) {
        super(controller);
        setUp(currentUsersUploadedBooks);
    }

    public void setUp(ArrayList<Book> currentUsersUploadedBooks) {

        JLabel bookMarket = new JLabel(" My books");
        bookMarket.setFont(new Font("Calibri", Font.ITALIC,18));
        Border border = new MatteBorder(0, 0, 1, 0, Color.BLACK);
        bookMarket.setBorder(border);
        bookMarket.setBounds(520, 40, 116, 30);

        /**
         * PANEL1 STARTS
         */
        /*
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

        BufferedImage bookToUpload = null;
        try {
            bookToUpload = ImageIO.read(new File("files/Book4.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Calculate the new width and height
        int newWidth1 = 180; // Set your desired width
        int newHeight1 = (int) Math.round((double) bookToUpload.getHeight() / bookToUpload.getWidth() * newWidth1);

        // Create a new image with the new dimensions
        BufferedImage bookToUploadResized = new BufferedImage(newWidth1, newHeight1, bookToUpload.getType());

        // Scale the original image onto the new image
        Graphics2D g2d1 = bookToUploadResized.createGraphics();
        g2d1.drawImage(bookToUpload, 0, 0, newWidth1, newHeight1, null);
        g2d1.dispose();

        JLabel bookToUploadLabel = new JLabel(new ImageIcon(bookToUploadResized));
        bookToUploadLabel.setHorizontalAlignment(JLabel.CENTER);
        bookToUploadLabel.setVerticalAlignment(JLabel.CENTER);

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
        bookPanel.add(bookToUploadLabel, BorderLayout.CENTER);
        add(bookPanel);

        JScrollPane scrollPane = new JScrollPane(panel1);
        scrollPane.setBackground(Color.WHITE);
        scrollPane.setBorder(new LineBorder(Color.PINK));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(500, 76, 570, 554);

        add(bookMarket);
        add(scrollPane);

         */

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setBackground(Color.WHITE);

        for (Book book : currentUsersUploadedBooks) {
            panel.add(addBook(book));
        }

        panel.add(Box.createHorizontalGlue());
        panel.add(Box.createVerticalGlue());

        scrollPane = new JScrollPane(panel);
        scrollPane.setBackground(Color.WHITE);
        scrollPane.setBorder(new LineBorder(Color.PINK));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(486, 76, 570, 554);

        scrollPane.revalidate();
        scrollPane.repaint();
        add(scrollPane);
        revalidate();
        repaint();

        super.setUp();
        super.setMyBooksFalse();
    }


    private JPanel addBook(Book book) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setBackground(Color.WHITE);

        JLabel title = new JLabel(book.getTitle() + " ");
        title.setFont(new Font("Calibri", Font.ITALIC,18));
        title.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.LINE_AXIS));
        textPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        textPanel.setBackground(Color.WHITE);

        JPanel text = new JPanel();
        text.setLayout(new BoxLayout(text, BoxLayout.PAGE_AXIS));
        text.setAlignmentX(Component.LEFT_ALIGNMENT);
        text.setBackground(Color.WHITE);

        if(book.getIsbn() != null && !book.getIsbn().isEmpty()) {
            JLabel ISBN = new JLabel(" ISBN: " + book.getIsbn());
            ISBN.setFont(new Font("Serif", Font.PLAIN, 14));
            ISBN.setForeground(Color.GRAY);
            text.add(ISBN);
            text.add(Box.createRigidArea(new Dimension(0,3)));
        }

        String string = " av " + book.getAuthor();
        if(book.getRelease_date() != null && !book.getRelease_date().isEmpty()) {
            string += ", " + book.getRelease_date();
        }
        if(book.getGenre() != null && !book.getGenre().isEmpty()) {
            string += ", " + book.getGenre();
        }
        if(book.getEdition() != null && !book.getEdition().isEmpty()) {
            string += ", " + book.getEdition();
        }
        if(book.getPublisher() != null && !book.getPublisher().isEmpty()) {
            string += ", " + book.getPublisher();
        }

        JLabel description = new JLabel(string);
        description.setFont(new Font("Serif", Font.PLAIN, 14));
        text.add(description);


        JButton button = new JButton("Start chat");
        button.setSize(100, 20);

        panel.add(Box.createRigidArea(new Dimension(0,5)));
        panel.add(title);
        panel.add(Box.createRigidArea(new Dimension(0,7)));
        textPanel.add(text);
        textPanel.add(Box.createHorizontalGlue());
        textPanel.add(button);
        panel.add(textPanel);
        panel.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));


        return panel;
    }


    @Override
    public void actionPerformed(ActionEvent e) {


    }
}
