import java.util.ArrayList;

class Book {
    int bookId;
    String title;
    String author;
    boolean isAvailable;

    Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    void displayInfo() {
        System.out.println("Book ID: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Availability: " + (isAvailable ? "Available" : "Not Available"));
    }

    void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Book is not available.");
        }
    }

    void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Book was not borrowed.");
        }
    }
}

class ReferenceBook extends Book {
    int edition;

    ReferenceBook(int bookId, String title, String author, int edition) {
        super(bookId, title, author);
        this.edition = edition;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Edition: " + edition);
    }
}

class FictionBook extends Book {
    String genre;

    FictionBook(int bookId, String title, String author, String genre) {
        super(bookId, title, author);
        this.genre = genre;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Genre: " + genre);
    }
}

class Periodical extends ReferenceBook {
    String issueFrequency;

    Periodical(int bookId, String title, String author, int edition, String issueFrequency) {
        super(bookId, title, author, edition);
        this.issueFrequency = issueFrequency;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Issue Frequency: " + issueFrequency);
    }
}

class Library {
    ArrayList<Book> books;

    Library() {
        books = new ArrayList<>();
    }

    void addBook(Book book) {
        books.add(book);
    }

    void borrowBook(int bookId) {
        for (Book book : books) {
            if (book.bookId == bookId) {
                book.borrowBook();
                return;
            }
        }
        System.out.println("Book with ID " + bookId + " not found.");
    }

    void returnBook(int bookId) {
        for (Book book : books) {
            if (book.bookId == bookId) {
                book.returnBook();
                return;
            }
        }
        System.out.println("Book with ID " + bookId + " not found.");
    }

    void showLibrary() {
        System.out.println("Library Books:");
        for (Book book : books) {
            book.displayInfo();
            System.out.println();
        }
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Library library = new Library();

        // Adding books to the library
        ReferenceBook refBook = new ReferenceBook(1, "a", "anand", 2);
        FictionBook ficBook = new FictionBook(2, "b", "ben", "Fantasy");
        Periodical periodical = new Periodical(3, "c", "chen", 5, "Weekly");

        library.addBook(refBook);
        library.addBook(ficBook);
        library.addBook(periodical);

        // Display all books
        library.showLibrary();

        // Borrow and return books
        System.out.println("Borrowing Book ID 1:");
        library.borrowBook(1);

        System.out.println("Returning Book ID 1:");
        library.returnBook(1);

        System.out.println("Borrowing Book ID 2:");
        library.borrowBook(2);

        // Display library status
        library.showLibrary();
    }
}
