package controller;



public class ChatController {


    private Controller controller;

    public ChatController(Controller controller){
        this.controller = controller;
    }

    public void sendMessage(Object message){
        controller.getServer().sendMessage(message);
    }
}