package view.GUI.pages;

import controller.Controller;
import controller.GUIController;
import controller.SearchController;
import model.Book;
import view.GUI.PageWithMenu;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * This class sets uo the GUI for the simple-search function.
 * @author, Livia Tengelin, Olle Huss
 */

public class SearchPage extends PageWithMenu implements ActionListener {

    private JButton searchButton = new JButton("Search");
    private JButton advancedSearchButton = new JButton("Advanced search");
    private JButton myWishList = new JButton("My wish list");
    private JTextArea searchField;
    private SearchController searchController;
    private JLabel error;
    private JLabel bookLabel1;
    private JLabel bookLabel2;
    private JScrollPane scrollPane;
    private JButton[] startChatButtons;
    private StartChatListener startChatListener;
    private Controller controller;

    public SearchPage(Controller controller) {
        super(controller);
        this.searchController = controller.getSearchController();
        this.controller = controller;
        this.startChatListener = new StartChatListener();
        setUp();
    }

    public void setUp() {

        setBackground(Color.WHITE);
        setLayout(null);

        JLabel searchForABookETC = new JLabel("Search for title, author, genre, year, edition, publisher or ISBN...");
        searchForABookETC.setFont(new Font("Calibri", Font.ITALIC, 20));
        searchForABookETC.setForeground(Color.GRAY);
        searchForABookETC.setBounds(119, 100, 800, 24);

        searchField = new JTextArea();
        searchField.setBorder(new LineBorder(Color.GRAY));
        searchField.setBounds(119, 132, 606, 22);

        //searchButton.setBounds(113, 165, 88, 26);
        searchButton.setBounds(735, 132, 88, 26);
        searchButton.addActionListener(this);

        advancedSearchButton.setFont(new Font("Calibri", Font.ITALIC, 11));
        //advancedSearchButton.setBounds(194, 165, 84, 26);
        advancedSearchButton.setBounds(113, 165, 130, 26);
        advancedSearchButton.addActionListener(this);

        try {
            BufferedImage book1 = ImageIO.read(new File("files/Book1.jpg"));
            BufferedImage book2 = ImageIO.read(new File("files/Book2.jpg"));

            bookLabel1 = new JLabel(new ImageIcon(book1));
            bookLabel1.setBounds(15, 250, 500, 500);

            bookLabel2 = new JLabel(new ImageIcon(book2));
            bookLabel2.setBounds(600, 250, 550, 500);
            add(bookLabel1);
            add(bookLabel2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        add(searchForABookETC);
        add(searchField);
        add(searchButton);
        add(advancedSearchButton);

        super.menuSetUp();
        super.setBookMarketButtonFalse();
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == searchButton) {
            searchController.search(searchField.getText());

        } else if (e.getSource() == advancedSearchButton) {
            controller.getGui().advanceSearch();
        }
    }

    public void displayResults(Book[] books) {
        try {
            remove(bookLabel1);
            remove(bookLabel2);
            remove(scrollPane);
            remove(error);
        } catch (Exception e) {}

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setBackground(Color.WHITE);

//        books = new Book[result.getBooks().size()];
//        books = result.getBooks().toArray(new Book[0]);
        startChatButtons = new JButton[books.length];

        for (int i = 0; i < books.length; i++) {
            panel.add(addBook(books[i], i));
        }

        panel.add(Box.createHorizontalGlue());
        panel.add(Box.createVerticalGlue());

        scrollPane = new JScrollPane(panel);
        scrollPane.setBackground(Color.WHITE);
        scrollPane.setBorder(new LineBorder(Color.PINK));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(113, 190, 700, 480);

        scrollPane.revalidate();
        scrollPane.repaint();
        add(scrollPane);
        revalidate();
        repaint();

    }

    private JPanel addBook(Book book, int i) {
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
        button.addActionListener(startChatListener);
        startChatButtons[i] = button;
        if (book.getUploadedBy().getUserId() == controller.getCurrentUser().getUserId()) {
            button.setEnabled(false);
        }

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

    public void displayErrorMessage() {
        try {
            remove(scrollPane);
            remove(error);
        } catch (Exception e) {}

        error = new JLabel("No matching books found");
        error.setFont(new Font("Calibri", Font.ITALIC, 20));
        error.setBounds(125, 190, 600, 24);

        error.revalidate();
        error.repaint();
        add(error);
        revalidate();
        repaint();
    }

    private class StartChatListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < startChatButtons.length; i++) {
                if (e.getSource() == startChatButtons[i]) {
                    searchController.startChatWith(i);
                }
            }
        }
    }
}
