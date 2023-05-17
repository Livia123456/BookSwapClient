package controller;

import model.*;
import model.chat.*;
import model.search.*;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;


/**
 * This class is responsible for the connection to the server-side of the program. It provides
 * methods to both send and retrieve objects, and for directing these objects to where they belong.
 * @author Livia Tengelin, Kasper Lindberg
 */
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
                        ArrayList<?> list = (ArrayList<?>) message;
                        if (!list.isEmpty()) {
                            Object obj = list.get(0);

                            if (obj instanceof ChatsWith) {
                                controller.getChatController().populateChat((ArrayList<ChatsWith>) message);
                            }
                            else if (obj instanceof MessageObject) {
                                controller.getChatController().addChatHistory((ArrayList<MessageObject>) message);
                            }
                        }
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
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
