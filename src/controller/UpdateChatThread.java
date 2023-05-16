package controller;

import model.chat.ChatObject;
import model.chat.ChatStatus;

public class UpdateChatThread extends Thread {

    private int user1;
    private int user2;
    private boolean isRunning;
    private Controller controller;
    public UpdateChatThread(int userId, int receiverID, Controller controller) {
        this.user1 = userId;
        this.user2 = receiverID;
        this.controller = controller;
    }

    @Override
    public void run() {
        isRunning = true;
        while (isRunning) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            controller.getChatController().sendMessage(new ChatObject(user1, user2, ChatStatus.open));
        }
    }

    public void stopThread() {
        isRunning = false;
    }
}
