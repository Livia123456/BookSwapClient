package model;

import javax.swing.*;
import java.io.Serializable;

public class Book implements Serializable {

    private final static long serialVersionUID = 1L;
    private String title;
    private String author;
    private String release_date;
    private String genre;
    private ImageIcon image;


    public Book(String title, String author, String release_date, String genre, ImageIcon image){

        this.title = title;
        this.author = author;
        this.release_date = release_date;
        this.genre = genre;
        this.image = image;

    }



}
