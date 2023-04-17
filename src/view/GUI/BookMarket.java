package view.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BookMarket
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("BookSwap");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

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

        JLabel iSBN = new JLabel("ISBN:");
        iSBN.setBounds(77, 135, 100, 20);

        JLabel title = new JLabel("Title:");
        title.setBounds(77, 200, 100, 20);

        JLabel author = new JLabel("Author:");
        author.setBounds(77, 240, 100, 20);

        panel.add(iSBN);
        panel.add(title);
        panel.add(author);


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
