package controller;

import view.GUI.pages.ChatPage;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Semaphore;

public class Loading extends Thread{

    private ChatPage chatPage;
    private boolean loading;
    private ImageIcon load1;
    private ImageIcon load2;
    private ImageIcon load3;
    private Semaphore mutex = new Semaphore(1);

    public Loading(ChatPage chatPage){
        this.chatPage = chatPage;

        Image originalImage = new ImageIcon("files/load1.jpg").getImage();
        Image scaledImage = originalImage.getScaledInstance(180, 180, Image.SCALE_SMOOTH);
        load1 = new ImageIcon(scaledImage);
        originalImage = new ImageIcon("files/load2.jpg").getImage();
        scaledImage = originalImage.getScaledInstance(180, 180, Image.SCALE_SMOOTH);
        load2 = new ImageIcon(scaledImage);
        originalImage = new ImageIcon("files/load3.jpg").getImage();
        scaledImage = originalImage.getScaledInstance(180, 180, Image.SCALE_SMOOTH);
        load3 = new ImageIcon(scaledImage);
    }

    public void startLoading(){
        new Thread(this).start();
    }
    public boolean stopLoading(){
        this.loading = false;

        return true;
    }

    public void run() {
        loading = true;
        while(loading) {

            try {
                chatPage.setProfileImage(load1);
                Thread.sleep(200);

                if (loading) {
                    chatPage.setProfileImage(load2);
                    Thread.sleep(200);
                } else{
                    break;
                }
                if (loading) {
                    chatPage.setProfileImage(load3);
                    Thread.sleep(200);
                } else{
                    break;
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

}
