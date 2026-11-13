import java.util.List;

public class Client
{
    public static void main(String[] args)
    {
        LibraryManagementSystem lms = new LibraryManagementSystem();

        System.out.println("--- Integrate Book and User Management ---");
        Book book1 = new TextBook("978-0123434434", "DSA", "Vikram", "Computer Science", 10);
        Book book2 = new NovelBook("91-276347934", "Wonderland", "Rose", "Sci-Fi");
        Book book3 = new TextBook("978-0123734434", "LLD", "Bill William", "Computer Science", 6);

        lms.addBook(book1);
        lms.addBook(book2);
        lms.addBook(book3);

        Member member1 = new Member("Darshan", "Darshanreddy810@gmail.com");
        Member member2 = new Member("Vikram", "Vikram@gmail.com");
        Librarian librarian1 = new Librarian("Dimple", "Dimple@gmail.com", "E-15");

        lms.registerUser(member1);
        lms.registerUser(member2);
        lms.registerUser(librarian1);

        lms.displayAllBooks();
        lms.displayRegisteredUsers();

        System.out.println("--- Demonstrate Lending Functionality ---");

        lms.lendBook(member1, book1);

        System.out.println("--- Test Scenario: Borrowing an already lended Book ---");
        lms.lendBook(member2, book1);

        System.out.println("--- Test Scenario: Exceeding borrow limit ---");
        lms.lendBook(member1, book2);
        lms.lendBook(member1, book3);

        System.out.println("--- Manage returns ---");
        lms.returnBook(member1, book1);

        System.out.println("Is book 'DSA' avaliable now?" + book1.isAvailable());

        System.out.println("Test Scenario: Lending returned book to another user");
        lms.lendBook(member2, book1);

        System.out.println("--- Adnvanced Search Features ---");

        System.out.println("Searching book with  Keyword 'DSA' :");
        List<Book> searchResults1 = lms.searchBooks("DSA");
        for(Book book : searchResults1)
        {
            System.out.println("Book Found: " + book.getTitle() + " by Author " + book.getAuthor());
        }

        System.out.println("Searching book with  Keyword 'Rose' and type 'NovelBook' :");
        List<Book> searchResults2 = lms.searchBooks("Rose", "Novel Book");
        for(Book book : searchResults2)
        {
            System.out.println("Book Found: " + book.getTitle() + " by Author " + book.getAuthor());
        }
    }
}