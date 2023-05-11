package controller;

import model.Book;

public class BookController {

    private Controller controller;

    public BookController(Controller controller) {
        this.controller = controller;
    }

    public void uploadBook(Book book) {
        controller.getServer().sendMessage(book);

    }


}
