package controller;

import model.Book;
import view.TerminalUserInterface;

public class BookController {


    private Book book;
    private Controller controller;

    public BookController(Controller controller){

        this.controller = controller;

    }

    public void uploadBook(Book book){
        controller.getServer().sendMessage(book);

    }


}
