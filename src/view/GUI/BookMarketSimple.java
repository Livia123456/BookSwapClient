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

public class BookMarketSimple implements ActionListener {

    private HomePage homePage;
    private Profile profile;

    private BookMarket bookMarket;
    private JFrame frame = new JFrame("BookSwap");
    private JButton homeButton = new JButton("Home");
    private JButton bookMarketButton = new JButton("Book market");
    private JButton profileButton = new JButton("Profile");
    private JButton searchButton = new JButton("Search");
    private JButton advancedSearchButton = new JButton("Advanced");

    public static void main(String[] args) throws IOException {
        BookMarketSimple bookMarketSimple = new BookMarketSimple();
    }

    public BookMarketSimple() throws IOException {

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
        bookMarketButton.setEnabled(false);

        profileButton.setBounds(289, 48, 60, 16);
        profileButton.addActionListener(this);

        JLabel searchForABookETC = new JLabel("Search for title, author, genre, year, edition, publisher or ISBN...");
        searchForABookETC.setFont(new Font("Calibri", Font.ITALIC, 20));
        searchForABookETC.setForeground(Color.GRAY);
        searchForABookETC.setBounds(119, 100, 800, 24);

        JTextArea searchField = new JTextArea();
        searchField.setBorder(new LineBorder(Color.GRAY));
        searchField.setBounds(119, 132, 606, 22);

        searchButton.setBounds(113, 165, 88, 26);
        searchButton.addActionListener(this);

        advancedSearchButton.setFont(new Font("Calibri", Font.ITALIC, 11));
        advancedSearchButton.setBounds(194, 165, 84, 26);
        advancedSearchButton.addActionListener(this);

        BufferedImage book1 = ImageIO.read(new File("files/Book1.jpg"));
        BufferedImage book2 = ImageIO.read(new File("files/Book2.jpg"));

        JLabel bookLabel1 = new JLabel(new ImageIcon(book1));
        bookLabel1.setBounds(15, 250, 500, 500);

        JLabel bookLabel2 = new JLabel(new ImageIcon(book2));
        bookLabel2.setBounds(600, 250, 550, 500);

        panel.add(bookSwap);
        panel.add(homeButton);
        panel.add(bookMarketButton);
        panel.add(profileButton);
        panel.add(searchForABookETC);
        panel.add(searchField);
        panel.add(searchButton);
        panel.add(advancedSearchButton);
        panel.add(bookLabel1);
        panel.add(bookLabel2);

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
        }

        if (e.getSource() == profileButton) {
            try {
                profile = new Profile();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

        if (e.getSource() == searchButton) {

        }

        if (e.getSource() == advancedSearchButton); {
            try {
                bookMarket = new BookMarket();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
