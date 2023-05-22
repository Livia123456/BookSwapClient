package view.GUI.pages;

import controller.Controller;
import controller.GUIController;
import controller.SearchController;
import model.*;
import model.Book;
import model.search.AdvancedSearchResult;
import view.GUI.PageWithMenu;

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

/**
 * Class responsible for setting up the components for the Advanced Search.
 * @author, Livia Tengelin, Olle Huss
 */

public class AdvancedSearch extends PageWithMenu implements ActionListener {
    private JButton searchButton = new JButton("Search");
    private Controller controller;
    private JScrollPane scrollPane;
    private Book[] books;
    private JButton[] startChatButtons;
    private StartChatListener startChatListener;
    private JTextField titleField;
    private JTextField authorField;
    private JComboBox genreComboBox;
    private JTextField yearField;
    private JTextField editionField;
    private JTextField iSBNField;
    private JTextField publisherField;
    private JPanel bookPanel;
    private SearchController searchController;

    public AdvancedSearch(Controller controller) {
        super(controller);
        this.controller = controller;
        this.searchController = controller.getSearchController();
        startChatListener = new StartChatListener();
        setUp();
    }

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
        titleField.setBounds(153, 139, 300, 24);

        JLabel author = new JLabel("Author:");
        author.setFont(new Font("Serif", Font.BOLD, 16));
        author.setBounds(30, 200, 100, 20);

        authorField = new JTextField(20);
        authorField.setBorder(new LineBorder(Color.GRAY));
        authorField.setBounds(153, 199, 300, 24);

        JLabel genre = new JLabel("Genre:");
        genre.setFont(new Font("Serif", Font.BOLD, 16));
        genre.setBounds(30, 260, 100, 20);

        genreComboBox = new JComboBox<>(new String[]{"-","Fiction", "Data Science", "HCI", "Mathematics",
                "Language Arts", "Fine Arts", "Physical Education", "Religion"});
        genreComboBox.setMaximumRowCount(5);
        genreComboBox.setBackground(Color.WHITE);
        genreComboBox.setBounds(149, 260, 309, 24);
        genreComboBox.setVisible(true);

        JLabel year = new JLabel("Year:");
        year.setFont(new Font("Serif", Font.BOLD, 16));
        year.setBounds(30, 320, 100, 20);

        yearField = new JTextField(20);
        yearField.setBorder(new LineBorder(Color.GRAY));
        yearField.setBounds(153, 319, 300, 24);

        JLabel edition = new JLabel("Edition:");
        edition.setFont(new Font("Serif", Font.BOLD, 16));
        edition.setBounds(30, 380, 100, 20);

        editionField = new JTextField(20);
        editionField.setBorder(new LineBorder(Color.GRAY));
        editionField.setBounds(153, 379, 300, 24);

        JLabel publisher = new JLabel("Publisher:");
        publisher.setFont(new Font("Serif", Font.BOLD, 16));
        publisher.setBounds(30, 440, 100, 20);

        publisherField = new JTextField(20);
        publisherField.setBorder(new LineBorder(Color.GRAY));
        publisherField.setBounds(153, 439, 300, 24);

        JLabel iSBN = new JLabel("ISBN:");
        iSBN.setFont(new Font("Serif", Font.BOLD, 16));
        iSBN.setBounds(30, 500, 100, 20);

        iSBNField = new JTextField(20);
        iSBNField.setEnabled(false);
        iSBNField.setBorder(new LineBorder(Color.GRAY));
        iSBNField.setBounds(153, 499, 300, 24);

        searchButton.setFont(new Font("Calibri", Font.PLAIN, 28));
        searchButton.setBounds(28, 540, 429, 80);
        searchButton.addActionListener(this);

        JLabel bookMarket = new JLabel("Book market");
        bookMarket.setFont(new Font("Calibri", Font.ITALIC,18));
        Border border = new MatteBorder(0, 0, 1, 0, Color.BLACK);
        bookMarket.setBorder(border);
        bookMarket.setBounds(495, 40, 116, 30);


        scrollPane = new JScrollPane();
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
    }


    public void displayResults(Book[] books) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setBackground(Color.WHITE);

        //books = new Book[result.getBooks().size()];
        //books = result.getBooks().toArray(new Book[0]);
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
        scrollPane.setBounds(486, 76, 570, 554);

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

        if (e.getSource() == searchButton) {
            remove(scrollPane);
            //displaySearchResult();
            //displayErrorMessage();

            boolean noIsbn = (iSBNField.getText() == null || iSBNField.getText().isEmpty());
            boolean noTitle = (titleField.getText() == null || titleField.getText().isEmpty());
            boolean noAuthor = (authorField.getText() == null || authorField.getText().isEmpty());
            boolean noGenre = (genreComboBox.getSelectedItem().equals("-"));
            boolean noYear = (yearField.getText() == null ||yearField.getText().isEmpty());
            boolean noEdition = (editionField.getText() == null || editionField.getText().isEmpty());
            boolean noPublisher = (publisherField.getText() == null || publisherField.getText().isEmpty());
            boolean emptyFields = (noIsbn && noTitle && noAuthor && noGenre && noYear && noEdition && noPublisher);
            if (!emptyFields) {
                controller.getSearchController().search(iSBNField.getText(), titleField.getText(), authorField.getText(),
                        genreComboBox.getSelectedItem().toString(), yearField.getText(), editionField.getText(),
                        publisherField.getText());
            }
        }
    }

    public void displayErrorMessage() {
        JLabel message = new JLabel(" No matching books found");
        message.setAlignmentY(Component.TOP_ALIGNMENT);
        message.setFont(new Font("Calibri", Font.PLAIN, 18));

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.add(message);

        scrollPane = new JScrollPane(panel);
        scrollPane.setBackground(Color.WHITE);
        scrollPane.setBorder(new LineBorder(Color.PINK));
        scrollPane.setBounds(486, 76, 570, 554);

        scrollPane.revalidate();
        scrollPane.repaint();
        add(scrollPane);
        revalidate();
        repaint();
    }

    private class StartChatListener implements ActionListener{
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
