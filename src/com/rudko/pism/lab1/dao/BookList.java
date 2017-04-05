package com.rudko.pism.lab1.dao;

import com.rudko.pism.lab1.entity.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack on 18/03/17.
 */
public class BookList {
    private static List<Book> books;

    static {
        books = new ArrayList<>();
        add(new Book("The legend of Sleepy Hollow", "W. Irving", 1899));
        add(new Book("Theatre", "Makbeth", 1767));
        add(new Book("Tom Soier", "Mark Twain", 1890));
    }

    public static List<Book> getBooks(){
        return books;
    }

    public static void add(Book b){
        b.setId(books.size());
        books.add(b);
    }

    /**
     * Deletes book from list in according to id. Because id equals book number
     * in the list, method just calls List.remove(int index) instead of using
     * the iterator for search and delete. After removing boos after removed one
     * change their IDs to right
     * @param id id of the book that has to be deleted
     * @return true if book is found and deleted
     */
    public static boolean deleteBook(int id){
        if(id >= books.size()) {
            return false;
        }
        books.remove(id);
        for (int i = id; i < books.size(); i++) {
            books.get(i).setId(i);
        }
        return true;
    }
}
