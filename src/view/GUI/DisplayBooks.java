package view.GUI;

import model.Book;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class DisplayBooks {
    public static JPanel addBook(Book book) { JPanel panel = new JPanel();
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
}
