package model;

public class BookUpdate {

    private final static long serialVersionUID = 1243412L;
    String title;
    String author;
    String isbn;
    String edition;
    String publisher;
    String year;
    String genre;

    public BookUpdate() {}

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getEdition() {
        return edition;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    private class BookUpdateBuilder {
        private BookUpdate newBookInfo;

        public BookUpdateBuilder() {
            newBookInfo = new BookUpdate();
        }

        public BookUpdateBuilder title(String title) {
            newBookInfo.title = title;
            return this;
        }

        public BookUpdateBuilder author(String author) {
            newBookInfo.author = author;
            return this;
        }

        public BookUpdateBuilder isbn(String isbn) {
            newBookInfo.isbn = isbn;
            return this;
        }

        public BookUpdateBuilder edition(String edition) {
            newBookInfo.edition = edition;
            return this;
        }

        public BookUpdateBuilder publisher(String publisher) {
            newBookInfo.publisher = publisher;
            return this;
        }

        public BookUpdateBuilder year(String year) {
            newBookInfo.year = year;
            return this;
        }

        public BookUpdateBuilder genre(String genre) {
            newBookInfo.genre = genre;
            return this;
        }

        public BookUpdate build() {
            return newBookInfo;
        }

    }
}
