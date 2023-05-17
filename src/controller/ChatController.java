package controller;


import model.chat.*;
import view.GUI.pages.ChatPage;

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

    private String[] titleOfUsersBooks;
    private ChatPage chatPage;

    public ChatController(Controller controller){
        this.controller = controller;
    }

    public void chatPageOpened(ChatPage chatPage) {
        this.chatPage = chatPage;
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
        chatsWith = contacts.get(i);
        controller.getServer().sendMessage(new ChatObject(userId, chatsWith.getUserId(), ChatStatus.open));
        updateAvailableBooks(contacts.get(i).getName());//TODO
    }

    private void updateAvailableBooks(String name) {
        titleOfUsersBooks = new String[]{"hej", "hejdå"};
        String books = "";
        for (int i = 0; i < titleOfUsersBooks.length; i++) {
            books += titleOfUsersBooks[i] + "\n";
        }
        chatPage.updateProfilePanel(books, name);
    }

    public void startChatFromSearch(StartChat message) {
        populateChat(message.getContacts());
        chatsWith = message.getChatsWith();
        addChatHistory(message.getMessages());
        updateAvailableBooks(message.getChatsWith().getName());
    }
}