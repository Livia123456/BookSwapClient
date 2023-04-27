package model;

import java.io.Serializable;

/**
 * Class that creates and represents a search object.
 * @author Kasper
 */
public class SearchObject implements SearchAble, Serializable {

    private String searchString;

    public SearchObject(String searchString){
        this.searchString = searchString;
    }


    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }
}
