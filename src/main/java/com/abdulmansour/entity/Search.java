package com.abdulmansour.entity;

public class Search {
    private String searchValue;

    public Search() {};

    public Search(String searchValue) {
        this.searchValue = searchValue;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }
}
