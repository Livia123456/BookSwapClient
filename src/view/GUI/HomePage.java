package view.GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class HomePage
{
    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("BookSwap");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);


        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);

        JLabel bookSwap = new JLabel("BookSwap");
        bookSwap.setFont(new Font("Calibri", Font.PLAIN, 16));
        bookSwap.setBounds(24, 46, 100, 20);

        JButton homeButton = new JButton("Home");
        homeButton.setBounds(116, 48, 45, 16);

        JButton bookMarketButton = new JButton("BookMarket");
        bookMarketButton.setBounds(173, 48, 85, 16);

        JButton profileButton = new JButton("Profile");
        profileButton.setBounds(269, 48, 45, 16);

        JLabel bookSwapBig = new JLabel("B o o k S w a p");
        bookSwapBig.setFont(new Font("Calibri", Font.PLAIN, 44));
        bookSwapBig.setBounds(390, 140, 400, 40);
        bookSwapBig.setForeground(Color.GRAY);

        JButton upLoadABookButton = new JButton("Upload a book");
        upLoadABookButton.setBounds(480, 200, 130, 24);

        JButton searchForABookButton = new JButton("Search for a book");
        searchForABookButton.setBounds(470, 236, 150, 24);

        // Load the image into a BufferedImage object
        BufferedImage book1 = ImageIO.read(new File("files/Book1.jpg"));
        BufferedImage book2 = ImageIO.read(new File("files/Book2.jpg"));

        // Create a JLabel object and set its icon to the loaded image
        JLabel bookLabel1 = new JLabel(new ImageIcon(book1));
        bookLabel1.setBounds(15, 250, 500, 500);

        JLabel bookLabel2 = new JLabel(new ImageIcon(book2));
        bookLabel2.setBounds(580, 250, 600, 500);


        panel.add(bookSwap);
        panel.add(homeButton);
        panel.add(bookMarketButton);
        panel.add(profileButton);
        panel.add(bookSwapBig);
        panel.add(upLoadABookButton);
        panel.add(searchForABookButton);
        panel.add(bookLabel1);
        panel.add(bookLabel2);

        frame.setSize(1100, 700);
        frame.setLocationRelativeTo(null);
        frame.add(panel);

        frame.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                System.out.println("X: " + x + ", Y: " + y);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        frame.setVisible(true);
    }
}
