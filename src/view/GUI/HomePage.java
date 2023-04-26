package view.GUI;

import com.sun.tools.javac.Main;
import controller.Controller;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class HomePage extends PageWithMenu implements ActionListener
{
    private Controller controller;
    private JButton upLoadABookButton;
    private JButton searchForABookButton;
    private MainFrame mainFrame;

    public HomePage(Controller controller, MainFrame mainFrame) {
        super(controller);
        this.controller = controller;
        this.mainFrame = mainFrame;
        setUp();
    }

    public void setUp() {
        setBackground(Color.WHITE);
        setLayout(null);

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

        add(bookSwapBig);
        add(upLoadABookButton);
        add(searchForABookButton);
        add(bookLabel1);
        add(bookLabel2);
        super.menuSetUp();
        super.setHomeButtonFalse();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == upLoadABookButton) {
            mainFrame.uploadBookPage();
        } else if (e.getSource() == searchForABookButton) {

        }
    }
}


