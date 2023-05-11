package view.GUI.pages.profile;

import controller.Controller;
import controller.GUIController;
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
    private Book[] myBooks;
    private JButton[] buttons;
    private GUIController controller;


    public MyBooks(Controller controller, ArrayList<Book> currentUsersUploadedBooks) {
        super(controller);
        this.controller = controller.getGui();
        myBooks = new Book[currentUsersUploadedBooks.size()];
        myBooks = currentUsersUploadedBooks.toArray(myBooks);
        buttons = new JButton[myBooks.length];
        setUp();
    }

    public void setUp() {

        JLabel bookMarket = new JLabel(" My books");
        bookMarket.setFont(new Font("Calibri", Font.ITALIC,18));
        Border border = new MatteBorder(0, 0, 1, 0, Color.BLACK);
        bookMarket.setBorder(border);
        bookMarket.setBounds(520, 40, 116, 30);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setBackground(Color.WHITE);

        for (int i = 0; i < myBooks.length; i++) {
            panel.add(addBook(myBooks[i], i));
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


        JButton button = new JButton("Delete book");
        button.setSize(100, 20);
        button.addActionListener(this);
        buttons[i] = button;

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
        for (int i = 0; i < buttons.length; i++) {
            if (e.getSource() == buttons[i]) {
                controller.removeBook(myBooks[i]);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                controller.myBooks();
            }
        }

    }
}
