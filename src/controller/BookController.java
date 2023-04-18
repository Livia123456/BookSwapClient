package controller;

import model.Book;
import view.TerminalUserInterface;

public class BookController {


    private Book book;
    private Controller controller;

    public BookController(Controller controller){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.controller = controller;
        book = new Book("Bibeln", "Jesus kristus m.fl", "0001-01-01",
                "Religion", null);
        uploadBook(book);
    }

    public void uploadBook(Book book){
        controller.getServer().sendMessage(book);

    }


}
