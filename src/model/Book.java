package model;

import javax.swing.*;
import java.io.Serializable;

/**
 * Class to store information about a book.
 * @author Sebastian Zulj, Kasper Lindberg
 */

public class Book implements Serializable {

    private final static long serialVersionUID = 1L;
    private String title;
    private String author;
    private String release_date;
    private String genre;
    private ImageIcon image;
    private UserInfo uploadedBy;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    public UserInfo getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(UserInfo uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

    /**
     * Builder class to create a book-object.
     * @author Livia Tengelin
     */
    public static class BookBuilder {

        private Book book;

        public BookBuilder() {
            book = new Book();
        }
        public BookBuilder title(String title) {
            book.title = title;
            return this;
        }
        public BookBuilder author(String author) {
            book.author = author;
            return this;
        }
        public BookBuilder release_date(String release_date) {
            book.release_date = release_date;
            return this;
        }
        public BookBuilder genre(String genre) {
            book.genre = genre;
            return this;
        }

        public BookBuilder image(ImageIcon image) {
            book.image = image;
            return this;
        }
        public BookBuilder uploadedBy(UserInfo uploadedBy) {
            book.uploadedBy = uploadedBy;
            return this;
        }

        public Book build() {
            return book;
        }

    }
}