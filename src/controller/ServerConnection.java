package controller;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class ServerConnection extends Thread{
    private String ip;
    private int port;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    public ServerConnection(String ip, int port) {
        this.ip = ip;
        this.port = port;
        start();
    }

    @Override
    public void run() {
        try (Socket socket = new Socket(ip, port)) {
            oos = new ObjectOutputStream(new DataOutputStream(socket.getOutputStream()));
            ois = new ObjectInputStream(new DataInputStream(socket.getInputStream()));
            oos.writeObject("hello world!!");

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
