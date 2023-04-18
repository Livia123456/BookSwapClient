package controller;

import model.Book;
import view.TerminalUserInterface;

public class BookController {


    private TerminalUserInterface terminalUserInterface;
    private Book book;
    private Controller controller;

    public BookController(Controller controller){

        this.controller = controller;
        book = new Book("Bibeln", "Jesus kristus m.fl", "0000-01-01",
                "Religion", null);
        uploadBook(book);
    }

    public void uploadBook(Book book){
        controller.getServer().sendMessage(book);

    }


}
