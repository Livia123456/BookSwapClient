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
 * @author Livia Tengelin, Olle Huss
 */

public class SearchPage extends PageWithMenu implements ActionListener {

    private JButton searchButton = new JButton("Search");
    private JButton advancedSearchButton = new JButton("Advanced search");
    private JLabel myWishListLabel = new JLabel("My wish list");
    private JPanel wishListPanel;
    private JTextArea searchField;
    private SearchController searchController;
    private JLabel error;
    private JLabel bookLabel1;
    private JLabel bookLabel2;
    private JScrollPane scrollPane;
    private JScrollPane scrollPaneMyWishList;
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
        searchForABookETC.setFont(new Font("Calibri", Font.ITALIC, 18));
        searchForABookETC.setForeground(Color.GRAY);
        searchForABookETC.setBounds(113, 100, 800, 24);

        searchField = new JTextArea();
        searchField.setBorder(new LineBorder(Color.GRAY));
        searchField.setBounds(113, 132, 560, 22);

        //searchButton.setBounds(113, 165, 88, 26);
        searchButton.setBounds(107, 156, 88, 26);
        searchButton.addActionListener(this);

        advancedSearchButton.setFont(new Font("Calibri", Font.ITALIC, 11));
        //advancedSearchButton.setBounds(194, 165, 84, 26);
        advancedSearchButton.setBounds(107, 180, 130, 26);
        advancedSearchButton.addActionListener(this);

        try {
            BufferedImage book1 = ImageIO.read(new File("files/Book1.jpg"));
            BufferedImage book2 = ImageIO.read(new File("files/Book6.png"));

            bookLabel1 = new JLabel(new ImageIcon(book1));
            bookLabel1.setBounds(15, 250, 500, 500);

            bookLabel2 = new JLabel(new ImageIcon(book2));
            bookLabel2.setBounds(680, 135, 400, 500);

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

        if (e.getSource() == searchButton && searchField.getText() != null
                && !searchField.getText().isEmpty()) {
            searchController.search(searchField.getText());

        } else if (e.getSource() == advancedSearchButton) {
            controller.getGui().advanceSearch();
        }
    }

    public void displayResults(Book[] books) {
        try {
            remove(bookLabel1);
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
        scrollPane.setBounds(113, 210, 560, 452);

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
        String str = book.getRelease_date();
        if(str != null && !str.isEmpty() && !str.equals("null")) {
            string += ", " + str;
        }
        str = book.getGenre();
        if(str != null && !str.isEmpty() && !str.equals("null")) {
            string += ", " + str;
        }
        str = book.getEdition();
        if(str != null && !str.isEmpty() && !str.equals("null")) {
            string += ", " + str;
        }
        str = book.getPublisher();
        if(str != null && !str.isEmpty() && !str.equals("null")) {
            string += ", " + str;
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
        error.setBounds(125, 210, 600, 24);

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
