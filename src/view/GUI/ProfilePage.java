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

/**
 * Class responsible for setting up the main components for the Profile page.
 * @author, Livia Tengelin, Olle Huss
 */

public class ProfilePage extends PageWithMenu{
 private GUIController controller;

    private ProfilePageListener profilePageListener;
    //profile page buttons
    private JButton editPersonalInformation;
    private JButton uploadABook;
    private JButton myBooks;
    private JButton signOut;
    private JButton changePicture;
    private JLabel profileImage;


    public ProfilePage(Controller controller) {
        super(controller);
        this.controller = controller.getGui();
        profilePageListener = new ProfilePageListener();
        //setUp();
    }

    public void setUp() {

        setBackground(Color.WHITE);
        setLayout(null);

        profileImage = new JLabel();
        profileImage.setBounds(10, 80, 250, 250);

        try {
            if (controller.getController().getCurrentUser().getProfileImage() == null){
                BufferedImage defaultImage = ImageIO.read(new File("files/user.jpg"));

                int newWidth = 200;
                int newHeight = (int) Math.round((double) defaultImage.getHeight() / defaultImage.getWidth() * newWidth);

                BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, defaultImage.getType());

                Graphics2D g2d = resizedImage.createGraphics();
                g2d.drawImage(defaultImage, 0, 0, newWidth, newHeight, null);
                g2d.dispose();

                profileImage = new JLabel(new ImageIcon(resizedImage));
            }
            else {
                ImageIcon image = new ImageIcon(controller.getController().getCurrentUser().getProfileImage().getImage());
                profileImage.setIcon(image);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        changePicture = new JButton("Change picture"); //????
        changePicture.setBounds(46, 340, 150, 26);
        changePicture.addActionListener(profilePageListener);

        add(profileImage);
        add(changePicture);

        profilePageButtonsSetUp();
        super.menuSetUp();
        super.setProfileButtonFalse();

    }

    public void profilePageButtonsSetUp() {
        editPersonalInformation = new JButton("Edit personal information");
        editPersonalInformation.setBounds(286, 120, 200, 32);
        editPersonalInformation.addActionListener(profilePageListener);

        uploadABook = new JButton("Upload a book");
        uploadABook.setBounds(286, 170, 200, 32);
        uploadABook.addActionListener(profilePageListener);

        myBooks = new JButton("My books");
        myBooks.setBounds(286, 220, 200, 32);
        myBooks.addActionListener(profilePageListener);

        signOut = new JButton("Sign out");
        signOut.setBounds(286, 270, 200, 32);
        signOut.addActionListener(profilePageListener);

        add(editPersonalInformation);
        add(uploadABook);
        add(myBooks);
        add(signOut);
    }


    public void setEditPersonalInformationFalse() {
        this.editPersonalInformation.setEnabled(false);
    }

    public void setUploadABookFalse() {
        this.uploadABook.setEnabled(false);
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
            } else if (e.getSource() == myBooks) {
                controller.myBooks();
            } else if (e.getSource() == signOut) {
                System.out.println("SIGNOUT");
                controller.signOut();
            }
            else if (e.getSource() == changePicture) {

                JFileChooser fileChooser = new JFileChooser();
                BufferedImage image = null;
                int returnVal = fileChooser.showOpenDialog(controller.getView());

                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    System.out.println(file);
                    try {
                        image = ImageIO.read(file);
                        int width = 200;
                        int height = 200;
                        ImageIcon img = new ImageIcon(image.getScaledInstance(width, height, Image.SCALE_SMOOTH));
                        controller.getController().getCurrentUser().setProfileImage(img);
                        profileImage.setIcon(img);
                        add(profileImage);
                        revalidate();
                        repaint();

                        controller.getController().getServer().sendMessage(img);

                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }



            }
        }
    }
}
