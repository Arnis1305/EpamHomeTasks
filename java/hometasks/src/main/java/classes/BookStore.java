package classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BookStore {
    private String bookStore;
    private ArrayList<Book> booksList = new ArrayList<>();

    BookStore(String bookStore) {
        this.bookStore = bookStore;
    }

    void addBookToBookStore(Book book) {
        booksList.add(book);
    }

    ArrayList<Book> getAuthorsListByAlphabet() {
        ArrayList<Book> authorsList = new ArrayList<>(booksList);
        Collections.sort(authorsList, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getBookAuthor().compareToIgnoreCase(o2.getBookAuthor());
            }
        });
        return authorsList;
    }

    ArrayList<Book> getListByAuthorName(String authorName) {
        ArrayList<Book> list = new ArrayList<>();
        for (Book books : booksList) {
            if((books.getBookAuthor()).equalsIgnoreCase(authorName)) {
                list.add(books);
            }
        }
        return list;
    }

    ArrayList<Book> getListByPublisher(String publisherName) {
        ArrayList<Book> list = new ArrayList<>();
        for (Book books : booksList){
            if((books.getBookPublisher()).equalsIgnoreCase(publisherName)) {
                list.add(books);
            }
        }
        return list;
    }

    ArrayList<Book> getListOfBooksAfterThisYear(short yearOfPublish) {
        ArrayList<Book> list = new ArrayList<>();
        for (Book books : booksList) {
            if (books.getBookYearOfPublishing() > yearOfPublish) {
                list.add(books);
            }
        }
        return list;
    }
}