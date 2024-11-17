package week7.booklocator;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class Library {
    private static HashMap<Integer ,Book> books;

    Library() {
        books = new HashMap<>();
    }

    public static void addBook(Book book) {
        books.put(book.getISBN(),book);
    }

    Optional<Book> getBook(int ISBN) {
        return Optional.ofNullable(books.get(ISBN));
    }

}
