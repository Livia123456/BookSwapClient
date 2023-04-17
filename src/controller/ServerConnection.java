package controller;

import model.UserInfo;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

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

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void logIn(UserInfo userInfo) {
        try {
            oos.writeObject(userInfo);
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
                        //System.out.println("Userinfo received");
                    }
                    if (message instanceof String) {
                        System.out.println(message);

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
