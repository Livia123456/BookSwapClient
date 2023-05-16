package controller;

import model.Book;

/**
 * This class is responsible for handling methods concerning book objects on the client-side.
 * @author Kasper Lindberg
 */
public class BookController { //TODO fixa så att null aldrig visas (eller sparas) när böcker listas

    private Controller controller;

    public BookController(Controller controller) {
        this.controller = controller;
    }

    public void uploadBook(Book book) {
        controller.getServer().sendMessage(book);

    }


}
