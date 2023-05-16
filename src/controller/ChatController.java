package controller;


import model.chat.ChatsWith;
import model.chat.MessageObject;

import java.util.ArrayList;

/**
 * This class is responsible for the methods associated with the chat-function.
 * @author Kasper Lindberg
 */
public class ChatController {

    private Controller controller;

    public ChatController(Controller controller){
        this.controller = controller;
    }

    public void sendMessage(Object message){
        controller.getServer().sendMessage(message);
    }

    public void populateChat(ArrayList<ChatsWith> list) {
        if (list.size() == 0) {
            controller.getGui().getView().chatPage();
        }
        controller.getCurrentUser().setChatsWith(list);
        controller.getGui().getView().chatPage();
    }

    public void getChatHistory(ArrayList<MessageObject> list) {

        controller.getGui().getView().getChatPage().addChatHistory(list);
    }
}