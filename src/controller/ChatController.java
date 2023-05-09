package controller;


import model.chat.ChatsWith;

import java.util.ArrayList;

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
}