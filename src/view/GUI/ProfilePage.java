package view.GUI;

import controller.Controller;
import controller.GUIController;
import model.Book;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProfilePage extends PageWithMenu{
 private GUIController controller;

    private ProfilePageListener profilePageListener;
    //profile page buttons
    private JButton editPersonalInformation;
    private JButton uploadABook;
    private JButton myWishList;
    private JButton myBooks;
    private JButton signOut;
    private JButton changePicture;


    public ProfilePage(Controller controller) {
        super(controller);
        this.controller = controller.getGui();
        profilePageListener = new ProfilePageListener();
        //setUp();
    }

    public void setUp() {

        setBackground(Color.WHITE);
        setLayout(null);

        BufferedImage book1;
        try {
            book1 = ImageIO.read(new File("files/gubbe.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Calculate the new width and height
        int newWidth = 200; // Set your desired width
        int newHeight = (int) Math.round((double) book1.getHeight() / book1.getWidth() * newWidth);

        // Create a new image with the new dimensions
        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, book1.getType());

        // Scale the original image onto the new image
        Graphics2D g2d = resizedImage.createGraphics();
        g2d.drawImage(book1, 0, 0, newWidth, newHeight, null);
        g2d.dispose();

        JLabel bookLabel1 = new JLabel(new ImageIcon(resizedImage));
        bookLabel1.setBounds(-5, 80, 250, 250);


        changePicture = new JButton("Change picture"); //????
        changePicture.setBounds(46, 340, 150, 26);

        add(bookLabel1);
        add(changePicture);

        profilePageButtonsSetUp();
        super.menuSetUp();
        super.setProfileButtonFalse();

    }

    public void profilePageButtonsSetUp() {
        editPersonalInformation = new JButton("Edit personal information");
        editPersonalInformation.setBounds(286, 120, 200, 26);
        editPersonalInformation.addActionListener(profilePageListener);

        uploadABook = new JButton("Upload a book");
        uploadABook.setBounds(286, 160, 200, 26);
        uploadABook.addActionListener(profilePageListener);

        myWishList = new JButton("My wish list");
        myWishList.setBounds(286, 200, 200, 26);
        myWishList.addActionListener(profilePageListener);

        myBooks = new JButton("My books");
        myBooks.setBounds(286, 240, 200, 26);
        myBooks.addActionListener(profilePageListener);

        signOut = new JButton("Sign out");
        signOut.setBounds(286, 280, 200, 26);
        signOut.addActionListener(profilePageListener);

        add(editPersonalInformation);
        add(uploadABook);
        add(myWishList);
        add(myBooks);
        add(signOut);
    }

    public void setEditPersonalInformationFalse() {
        this.editPersonalInformation.setEnabled(false);
    }

    public void setUploadABookFalse() {
        this.uploadABook.setEnabled(false);
    }

    public void setMyWishListFalse() {
        this.myWishList.setEnabled(false);
    }

    public void setMyBooksFalse() {
        this.myBooks.setEnabled(false);
    }

    public void setSignOut(JButton signOut) {
        this.signOut = signOut;
    }

    //TESTMETOD: Testa att ta bort bok. Kommunikation sker via terminalen.
    public Book askWhichBookToRemove() {
        Scanner input = new Scanner(System.in);
        ArrayList<Book> books = controller.getController().getCurrentUser().getCurrentUsersUploadedBooks();
        for(int i = 0; i < books.size(); i++) {
            System.out.println(i + ": " + books.get(i).getTitle());
        }
        System.out.print("Enter book: ");
        return books.get(input.nextInt());
    }

    public class ProfilePageListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == editPersonalInformation) {
                controller.editProfile();

            } else if (e.getSource() == uploadABook) {
                controller.uploadBook();
            } else if (e.getSource() == myWishList) {
                controller.myWishList();
            } else if (e.getSource() == myBooks) {
                controller.myBooks();
                //TODO: Böckerna som den inloggade användaren har laddat upp tidigare ska skickas till GUI.
                //Book bookToRemove = askWhichBookToRemove();
                //controller.removeBook(bookToRemove);

            } else if (e.getSource() == signOut) {
                System.out.println("SIGNOUT");
                controller.signOut();
            }
        }
    }
}
