package view.GUI;

import controller.Controller;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Search extends PageWithMenu implements ActionListener {

    private JButton searchButton = new JButton("Search");
    private JButton advancedSearchButton = new JButton("Advanced");

    public Search(Controller controller) {
        super(controller);
    }

//    public void setUp() {
//
//        setBackground(Color.WHITE);
//        setLayout(null);
//
//        JLabel searchForABookETC = new JLabel("Search for title, author, genre, year, edition, publisher or ISBN...");
//        searchForABookETC.setFont(new Font("Calibri", Font.ITALIC, 20));
//        searchForABookETC.setForeground(Color.GRAY);
//        searchForABookETC.setBounds(119, 100, 800, 24);
//
//        JTextArea searchField = new JTextArea();
//        searchField.setBorder(new LineBorder(Color.GRAY));
//        searchField.setBounds(119, 132, 606, 22);
//
//        searchButton.setBounds(113, 165, 88, 26);
//        searchButton.addActionListener(this);
//
//        advancedSearchButton.setFont(new Font("Calibri", Font.ITALIC, 11));
//        advancedSearchButton.setBounds(194, 165, 84, 26);
//        advancedSearchButton.addActionListener(this);
//
//        BufferedImage book1 = ImageIO.read(new File("files/Book1.jpg"));
//        BufferedImage book2 = ImageIO.read(new File("files/Book2.jpg"));
//
//        JLabel bookLabel1 = new JLabel(new ImageIcon(book1));
//        bookLabel1.setBounds(15, 250, 500, 500);
//
//        JLabel bookLabel2 = new JLabel(new ImageIcon(book2));
//        bookLabel2.setBounds(600, 250, 550, 500);
//
//        panel.add(bookSwap);
//        panel.add(homeButton);
//        panel.add(bookMarketButton);
//        panel.add(profileButton);
//        panel.add(searchForABookETC);
//        panel.add(searchField);
//        panel.add(searchButton);
//        panel.add(advancedSearchButton);
//        panel.add(bookLabel1);
//        panel.add(bookLabel2);
//
//        frame.setSize(1100, 700);
//        frame.setLocationRelativeTo(null);
//        frame.add(panel, BorderLayout.CENTER);
//        frame.setVisible(true);
//    }
    @Override
    public void actionPerformed(ActionEvent e) {


        if (e.getSource() == searchButton) {

        }

        if (e.getSource() == advancedSearchButton); {

        }
    }
}