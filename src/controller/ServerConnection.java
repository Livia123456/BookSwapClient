package controller;

import model.*;
import model.chat.ChatObject;
import model.chat.ChatsWith;
import model.chat.MessageObject;
import model.search.AdvancedSearchResult;
import model.search.SearchAble;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class ServerConnection extends Thread{
    private String ip;
    private int port;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private Controller controller;
    private Socket socket;


    public ServerConnection(String ip, int port, Controller controller) {
        this.ip = ip;
        this.port = port;
        this.controller = controller;
        start();
    }

    @Override
    public void run() {
        try {
            socket = new Socket(ip, port);
            oos = new ObjectOutputStream(new DataOutputStream(socket.getOutputStream()));
            ois = new ObjectInputStream(new DataInputStream(socket.getInputStream()));
            oos.writeObject("hello world!!");
            oos.flush();
            new receiverThread().start();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendMessage(Object object) {
        try {
            oos.writeObject(object);
            //oos.writeObject("hello");
            oos.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private class receiverThread extends Thread {
        @Override
        public void run() {

            try {
                Object message;
                while ((message = ois.readObject()) != null) {
                    if (message instanceof UserInfo) {
                        controller.tryLoggingIn((UserInfo) message);

                    }
                    else if (message instanceof String) {
                        System.out.println(message);
                    }
                    else if (message instanceof Email) {
                        controller.getGui().showRegistrationPage((Email) message);
                    } else if (message instanceof Book) {
                        controller.getGui().bookReceived((Book) message);
                    }
                    else if (message instanceof AdvancedSearchResult) {
                        controller.getGui().displayAdvancedSearchResult((AdvancedSearchResult) message);
                    }

                    else if (message instanceof SearchResult) {
                        controller.getGui().displaySearchResult((SearchResult) message);
                    }


                    else if (message instanceof ArrayList<?>) {

                        controller.getChatController().populateChat((ArrayList<ChatsWith>) message);

                    }

                    else if (message instanceof MessageObject){
                        //todo
                    }

                    else if (message instanceof ChatObject){
                        //todo
                    }
                    else if (message instanceof UpdateBookList) {
                        ArrayList<Book> books = ((UpdateBookList) message).getBooks();
                        for (Book b :
                                books) {
                            System.out.println(b.getTitle());
                        }
                        controller.getCurrentUser().setCurrentUsersUploadedBooks(books);
                    }

                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
