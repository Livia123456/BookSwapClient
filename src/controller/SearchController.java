package controller;

import model.SearchObject;


/**
 * Passes the search object to the sendMessage method (in serverConnection).
 * @author Kasper
 */
public class SearchController {

    private Controller controller;


    public SearchController(Controller controller){
        this.controller = controller;
    }
    
    public void search(SearchObject searchObject){
        controller.getServer().sendMessage(searchObject);
    }

}
