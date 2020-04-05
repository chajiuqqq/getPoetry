package com.chajiu.pojo;

import java.util.List;

public class SearchResult {
    private List<Category> categories;
    private List<Poetry> poetries;
    private List<PoetryAuthor> authors;


    @Override
    public String toString() {
        return "SearchResult{" +
                "\n\tcategories=" + categories +
                "\n\tpoetries=" + poetries +
                "\n\tauthors=" + authors +
                '}';
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Poetry> getPoetries() {
        return poetries;
    }

    public void setPoetries(List<Poetry> poetries) {
        this.poetries = poetries;
    }

    public List<PoetryAuthor> getAuthors() {
        return authors;
    }

    public void setAuthors(List<PoetryAuthor> authors) {
        this.authors = authors;
    }
}
