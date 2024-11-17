package week7.booklocator;

import java.sql.SQLOutput;
import java.util.Optional;

public class main {
    public static void main(String[] args) {
        Library lib = new Library();
        Book book = new Book("life","Malek",2004200455,Status.Reserved);
        Book secbook = new Book("mama","mia",2002213124,Status.CheckedOut);

        Library.addBook(book);
        Library.addBook(secbook);

        int i = 1;
        Optional<Book> optBook = lib.getBook(i);
        System.out.println(optBook.orElse(new Book("0","0",0,Status.CheckedOut)));
        System.out.println(optBook.orElseGet( ()-> null ));
       // System.out.println(optBook.orElseThrow( ()-> new BookNotFoundException("Book not found") ));

        // EXPCEPTION BEC I CANT CHECK IDK WHAT TO USE WITHOUT TRY CATCH AND IFPRESENT ISN'T WORKING RIGHT
        System.out.println(optBook.orElseThrow(() -> new BookNotFoundException(" not found!")));

    }
}
