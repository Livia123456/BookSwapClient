package controller;

import model.search.AdvancedSearchObject;
import model.search.SearchObject;

/**
 * Responsible for search object to be sent to the sendMessage method (in serverConnection).
 * @author Kasper Lindberg, Livia Tengelin, Olle Huss
 */
public class SearchController {

    private Controller controller;

    public SearchController(Controller controller) {
        this.controller = controller;
    }
    
    public void search(SearchObject searchObject) {

        controller.getServer().sendMessage(searchObject);
    }

    public void search(String isbn, String title, String author, String genre, String year,
                       String edition, String publisher) {
        controller.getServer().sendMessage(new AdvancedSearchObject(isbn, title, author, genre,
                year, edition, publisher));
    }
}
