package view.GUI;

import controller.Controller;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class HomePage extends JPanel implements ActionListener
{
    private Controller controller;
    private JButton homeButton;
    private JButton bookMarketButton;
    private JButton profileButton;
    private JButton upLoadABookButton;
    private JButton searchForABookButton;

    public HomePage() {
        setUp();
    }

    public void setUp() {
        setBackground(Color.WHITE);
        setLayout(null);

        JLabel bookSwap = new JLabel("BookSwap");
        bookSwap.setFont(new Font("Calibri", Font.PLAIN, 16));
        bookSwap.setBounds(24, 46, 100, 20);

        homeButton = new JButton("Home");
        homeButton.setBounds(116, 48, 45, 16);
        homeButton.addActionListener(this);

        bookMarketButton = new JButton("BookMarket");
        bookMarketButton.setBounds(173, 48, 85, 16);
        bookMarketButton.addActionListener(this);

        profileButton = new JButton("Profile");
        profileButton.setBounds(269, 48, 45, 16);
        profileButton.addActionListener(this);

        JLabel bookSwapBig = new JLabel("B o o k S w a p");
        bookSwapBig.setFont(new Font("Calibri", Font.PLAIN, 44));
        bookSwapBig.setBounds(390, 140, 400, 40);
        bookSwapBig.setForeground(Color.GRAY);

        upLoadABookButton = new JButton("Upload a book");
        upLoadABookButton.setBounds(480, 200, 130, 24);
        upLoadABookButton.addActionListener(this);

        searchForABookButton = new JButton("Search for a book");
        searchForABookButton.setBounds(470, 236, 150, 24);
        searchForABookButton.addActionListener(this);

        // Load the image into a BufferedImage object
        BufferedImage book1;
        BufferedImage book2;
        try {
            book1 = ImageIO.read(new File("files/Book1.jpg"));
            book2 = ImageIO.read(new File("files/Book2.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Create a JLabel object and set its icon to the loaded image
        JLabel bookLabel1 = new JLabel(new ImageIcon(book1));
        bookLabel1.setBounds(15, 250, 500, 500);

        JLabel bookLabel2 = new JLabel(new ImageIcon(book2));
        bookLabel2.setBounds(580, 250, 600, 500);



        add(bookSwap);
        add(homeButton);
        add(bookMarketButton);
        add(profileButton);
        add(bookSwapBig);
        add(upLoadABookButton);
        add(searchForABookButton);
        add(bookLabel1);
        add(bookLabel2);
        setVisible(false);

//        addMouseListener(new MouseListener() {
//
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                int x = e.getX();
//                int y = e.getY();
//                System.out.println("X: " + x + ", Y: " + y);
//            }
//
//            @Override
//            public void mousePressed(MouseEvent e) {
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent e) {
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//            }
//        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
//        MainFrame mainFrame = new MainFrame();
//        mainFrame.homePage();
    }
}


