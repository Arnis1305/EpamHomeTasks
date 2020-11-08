package classes;

import java.util.ArrayList;
import java.util.Scanner;

public class BookMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookStore ozBy = new BookStore("OZ.by");
        ozBy.addBookToBookStore(new Book(1, "1984", "George Orwell", "Secker & Warburg", (short) 1949, 328, 20,"Hardcover"));
        ozBy.addBookToBookStore(new Book(2, "Animal Farm", "George Orwell", "Secker & Warburg", (short) 1945, 113, 10,"Paperback"));
        ozBy.addBookToBookStore(new Book(3, "Triumphal Arch", "Erich Remarque", "Ballantine Publishing Group", (short) 1945, 455, 16,"Hardcover"));
        ozBy.addBookToBookStore(new Book(4, "Master and Margarita", "Mikhail Bulgakov", "Azbuka", (short) 1966, 480, 10,"Hardcover"));
        ozBy.addBookToBookStore(new Book(5, "The Idiot", "Fyodor Dostoevsky", "Raduga", (short) 1868, 640, 10,"Hardcover"));
        ozBy.addBookToBookStore(new Book(6, "Hotel", "Arthur Hailey", "AST", (short) 1965, 608, 14,"Paperback"));
        ozBy.addBookToBookStore(new Book(7, "The green mile", "Stephen King", "AST", (short) 1996, 448, 13,"Paperback"));

        System.out.println("Sorted list by author name: ");
        ArrayList<Book> listName = ozBy.getAuthorsListByAlphabet();
        for (Book books : listName) {
            System.out.println(books);
        }

        System.out.println("\nEnter author name: ");
        String authorName = scanner.nextLine();
        ArrayList<Book> listOfBooksByAuthorName = ozBy.getListByAuthorName(authorName);
        for (Book books : listOfBooksByAuthorName) {
            System.out.println(books);
        }

        System.out.println("\nEnter book publisher: ");
        String publisherName = scanner.nextLine();
        ArrayList<Book> listOfBooksByPublisher = ozBy.getListByPublisher(publisherName);
        for (Book books : listOfBooksByPublisher) {
            System.out.println(books);
        }

        System.out.println("\nList of books published after this year: ");
        short yearOfPublish = scanner.nextShort();
        ArrayList<Book> listOfBooksByYears = ozBy.getListOfBooksAfterThisYear(yearOfPublish);
        for (Book books : listOfBooksByYears) {
            System.out.println(books);
        }
    }
}