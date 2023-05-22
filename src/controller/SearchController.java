package controller;

import model.Book;
import model.chat.ChatObject;
import model.chat.ChatStatus;
import model.search.AdvancedSearchObject;
import model.search.AdvancedSearchResult;
import model.search.SearchObject;
import model.search.SearchResult;
import view.GUI.pages.AdvancedSearch;

/**
 * Responsible for search object to be sent to the sendMessage method (in serverConnection).
 * @author Kasper Lindberg, Livia Tengelin, Olle Huss
 */
public class SearchController {

    private Controller controller;
    private SearchResult searchResult;
    private Book[] books;

    public SearchController(Controller controller) {
        this.controller = controller;
    }
    
    public void search(String search) {

        controller.getServer().sendMessage(new SearchObject(search));
    }

    public void search(String isbn, String title, String author, String genre, String year,
                       String edition, String publisher) {
        if(genre.equals("-") || genre.equals("--")) {
            genre = "";
        }
        controller.getServer().sendMessage(new AdvancedSearchObject(isbn, title, author, genre,
                year, edition, publisher));
    }

    public void displaySearchResult(SearchResult result) {
        this.searchResult = result;
        books = new Book[result.getBooks().size()];
        books = result.getBooks().toArray(new Book[0]);
        controller.getGui().displaySearchResult(books);
    }

    public void displaySearchResult(AdvancedSearchResult result) {
        //this.searchResult = result;
        books = new Book[result.getBooks().size()];
        books = result.getBooks().toArray(new Book[0]);
        controller.getGui().displayAdvancedSearchResult(books);
    }

    public void startChatWith(int i) {
        int user1 = controller.getCurrentUser().getUserId();
        int user2 = books[i].getUploadedBy().getUserId();
        controller.getServer().sendMessage(new ChatObject(user1, user2, ChatStatus.newChat));
        //TODO starta chat
        //books[i].getUploadedBy(); nånting sånt
    }
}
