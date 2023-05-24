package controller;


import model.Book;
import model.chat.*;
import view.GUI.pages.ChatPage;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * This class is responsible for the methods associated with the chat-function.
 * @author Kasper Lindberg
 */
public class ChatController {

    private Controller controller;
    private ChatsWith chatsWith;
    private ArrayList<ChatsWith> contacts;
    private int userId;
    private String name;
    private int currentContactId;
    private int buttonIndex;
    //private String[] titleOfUsersBooks;
    private ChatPage chatPage;
    private Loading load;


    public ChatController(Controller controller){
        this.controller = controller;
    }

    public void chatPageOpened(ChatPage chatPage) {
        this.chatPage = chatPage;
        load = new Loading(chatPage);
        name = controller.getCurrentUser().getName();
        userId = controller.getCurrentUser().getUserId();
        contacts = controller.getCurrentUser().getChatsWith();

        ArrayList<String> contactStringList = new ArrayList<>();
        for (ChatsWith cw : contacts) {
            contactStringList.add(cw.getName());
        }

        chatPage.setUp(contactStringList, controller.getCurrentUser().getName());
    }

    public void sendMessage(String message){
        controller.getServer().sendMessage(new MessageObject(userId, chatsWith.getUserId(), message));
        chatPage.messageSent(name, message);

    }

    public void populateChat(ArrayList<ChatsWith> list) {
        if (list.size() != 0) {
            controller.getCurrentUser().setChatsWith(list);
        }
        controller.getGui().getView().chatPage();
    }

    public void addChatHistory(ArrayList<MessageObject> list) {
        String chatArea = "";
        if (list.size() == 0) {
            chatArea = "      New chat with " + chatsWith.getName() + "\n";
        }
        for (int i = list.size() -1; i >= 0; i--) {
            if (list.get(i).getSender() == controller.getCurrentUser().getUserId()) {
                chatArea += (name + ": " + list.get(i).getMessage() + "\n");
            }
            else {
                chatArea += ("             " + chatsWith.getName() + ": " + list.get(i).getMessage() + "\n");
            }
        }
        chatPage.addChatHistory(chatArea);
    }

    public void openChatWith(int i) {
        load.stopLoading();
        buttonIndex = i;
        chatsWith = contacts.get(i);
        currentContactId = chatsWith.getUserId();
        controller.getServer().sendMessage(new ChatObject(userId, chatsWith.getUserId(), ChatStatus.open));
        load.startLoading();
        updateAvailableBooks(contacts.get(i));
    }
    public void updateImage(ImageIcon img) {
        if (img == null) {
            Image originalImage = new ImageIcon("files/user.jpg").getImage();
            Image scaledImage = originalImage.getScaledInstance(180, 180, Image.SCALE_SMOOTH);
            ImageIcon resizedImageIcon = new ImageIcon(scaledImage);
            chatPage.setProfileImage(resizedImageIcon);
        } else {
            chatPage.setProfileImage(img);
        }
    }

    private void uploadProfileImage(int id) {
        if (load.stopLoading()) {
            ImageIcon img = contacts.get(id).getUser().getProfileImage();
            updateImage(img);
        }
    }

    public void addProfileImage(ImageIcon image) {
        for (int i = 0; i < contacts.size(); i++) {
            if (currentContactId == contacts.get(i).getUserId()) {
                contacts.get(i).getUser().setProfileImage(image);
                break;
            }
        }
        uploadProfileImage(buttonIndex);
    }

    private void updateAvailableBooks(ChatsWith chatsWith) {
        ArrayList<Book> titleOfUsersBooks = chatsWith.getUser().getCurrentUsersUploadedBooks();
        String books = "<html>";
        for (int i = 0; i < titleOfUsersBooks.size(); i++) {
            books += titleOfUsersBooks.get(i).getTitle() + "<br/>";
        }
        books += "</html>";
        chatPage.updateProfilePanel(books, chatsWith.getName());
    }

    public void startChatFromSearch(StartChat message) {
        populateChat(message.getContacts());
        chatsWith = message.getChatsWith();
        currentContactId = message.getChatsWith().getUserId();
        updateImage(message.getImage());
        addChatHistory(message.getMessages());
        updateAvailableBooks(chatsWith);
    }

}