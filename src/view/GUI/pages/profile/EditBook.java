package view.GUI.pages.profile;

import controller.Controller;
import model.Book;
import model.BookUpdate;
import view.GUI.ProfilePage;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The class sets up the GUI and letting the user insert info about a book it wants to upload.
 * @author, Livia Tengelin, Olle Huss
 */

public class EditBook extends ProfilePage implements ActionListener {
    private JTextField iSBNField;
    private JTextField titleField;
    private JTextField authorField;
    private JTextField yearField;
    private JTextField editionField;
    private JTextField publisherField;
    private JComboBox genreComboBox;

    private JButton uploadImage;
    private JButton editBook;
    private Controller controller;
    private JLabel errorMessage;
    private int bookId;

    public EditBook(Controller controller, Book book) {
        super(controller);
        this.controller = controller;
        this.bookId = book.getBook_id();
        setUp();
        populateTexfieldsWithBookInfo(book);
    }

    public void setUp() {


        /**
         * Edit info
         */
        Font font = new Font("Calibri", Font.PLAIN, 14);

        JLabel iSBN = new JLabel("ISBN:");
        iSBN.setForeground(Color.GRAY);
        iSBN.setFont(font);
        iSBN.setBounds(640, 120, 100, 20);

        iSBNField = new JTextField();
        iSBNField.setBorder(new LineBorder(Color.GRAY));
        iSBNField.setBounds(740, 122, 260, 20);

        JLabel title = new JLabel("Title:");
        title.setFont(font);
        title.setBounds(640, 160, 100, 20);

        titleField = new JTextField();
        titleField.setBorder(new LineBorder(Color.GRAY));
        titleField.setBounds(740, 162, 260, 20);

        JLabel author = new JLabel("Author:");
        author.setFont(font);
        author.setBounds(640, 200, 100, 20);

        authorField = new JTextField();
        authorField.setBorder(new LineBorder(Color.GRAY));
        authorField.setBounds(740, 202, 260, 20);

        JLabel year = new JLabel("Year:");
        year.setFont(font);
        year.setForeground(Color.GRAY);
        year.setBounds(640, 240, 100, 20);

        yearField = new JTextField();
        yearField.setBorder(new LineBorder(Color.GRAY));
        yearField.setBounds(740, 242, 260, 20);

        JLabel edition = new JLabel("Edition:");
        edition.setFont(font);
        edition.setForeground(Color.GRAY);
        edition.setBounds(640, 280, 100, 20);

        editionField = new JTextField();
        editionField.setBorder(new LineBorder(Color.GRAY));
        editionField.setBounds(740, 282, 260, 20);

        JLabel publisher = new JLabel("Publisher:");
        publisher.setFont(font);
        publisher.setForeground(Color.GRAY);
        publisher.setBounds(640, 320, 100, 20);

        publisherField = new JTextField();
        publisherField.setBorder(new LineBorder(Color.GRAY));
        publisherField.setBounds(740, 322, 260, 20);

        JLabel genre = new JLabel("Genre:");
        genre.setFont(new Font("Calibri", Font.PLAIN, 14));
        genre.setForeground(Color.GRAY);
        genre.setBounds(640, 360, 100, 20);

        genreComboBox = new JComboBox<>(new String[]{"-","Fiction", "Data Science", "HCI", "Mathematics",
                "Language Arts", "Fine Arts", "Physical Education", "Religion"});
        genreComboBox.setMaximumRowCount(5);
        genreComboBox.setBackground(Color.WHITE);
        genreComboBox.setBounds(735, 360, 272, 24);
        genreComboBox.setVisible(true);

        errorMessage = new JLabel("");
        errorMessage.setFont(new Font("Calibri", Font.ITALIC, 14));
        errorMessage.setBounds(660, 400, 340, 50);

        editBook = new JButton("Update book");
        editBook.setFont(new Font("Calibri", Font.PLAIN, 14));
        editBook.setBounds(783, 624, 180, 34);


        editBook.addActionListener(this);

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
        add(errorMessage);


        add(editBook);
        super.setUp();
        super.setUploadABookFalse();

    }

    public void populateTexfieldsWithBookInfo(Book book) {
        titleField.setText(book.getTitle());
        authorField.setText(book.getAuthor());
        if(book.getIsbn() != null) {
            iSBNField.setText(book.getIsbn());
        }
        if(book.getEdition() != null) {
            editionField.setText(book.getEdition());
        }
        if(book.getPublisher() != null) {
            publisherField.setText(book.getPublisher());
        }
        if(book.getRelease_date() != null) {
            yearField.setText(book.getRelease_date());
        }
        if(book.getGenre() != null) {
            genreComboBox.setSelectedItem(book.getGenre());
        }
    }

    public void setErrorMessageText(String message) {

        errorMessage.setText(message);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == editBook) {

            boolean hasTitle = (titleField.getText() != null && !titleField.getText().isEmpty());
            boolean hasAuthor = (authorField.getText() != null && !authorField.getText().isEmpty());
            if(hasTitle && hasAuthor) {
                BookUpdate book = new BookUpdate.BookUpdateBuilder().title(titleField.getText()).author(authorField.getText())
                        .year(yearField.getText()).genre(genreComboBox.getSelectedItem().toString())
                        .isbn(iSBNField.getText()).edition(editionField.getText()).
                        publisher(publisherField.getText()).uploadedBy(controller.getCurrentUser()).bookId(bookId).build();
                controller.getBookController().updateBook(book);
            } else {
                errorMessage.setText("You need to enter both title and author");
            }

        } else if (e.getSource() == uploadImage) {

        }

    }

    public void uploadSuccessful() {
        iSBNField.setText("");
        titleField.setText("");
        authorField.setText("");
        yearField.setText("");
        editionField.setText("");
        publisherField.setText("");
        genreComboBox.setSelectedIndex(0);
        errorMessage.setText("Book successfully uploaded");
    }

    public void uploadUnsuccessful() {
        errorMessage.setText("Unable to upload book");
    }
}
