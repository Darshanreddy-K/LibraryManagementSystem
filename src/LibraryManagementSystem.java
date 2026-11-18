import java.util.ArrayList;
import java.util.List;

public class LibraryManagementSystem
{
    private List<Book> bookInventory = new ArrayList<>();
    private List<User> registeredUsers = new ArrayList<>();

    public void addBook(Book book)
    {
        bookInventory.add(book);
    }

    public void registerUser(User user)
    {
        registeredUsers.add(user);
    }

    public boolean lendBook(Member member, Book book)
    {
        if(book.lend(member))
        {
            System.out.print(member.getName() + " can borrow books.");
            member.incrementBorrowedCount();
            System.out.println(member.getName()+ " borrowed successfully.");
            return true;
        }
        else
        {
            if(book.isAvailable())
            {
                System.out.println(member.getName()+ " can't borrow this book. Limit reached.");
            }
            else {
                System.out.println(member.getName()+ " can't borrow this book. Book unavailable.");
            }
            return false;
        }
    }

    public void returnBook(Member member, Book book)
    {
        book.returnItem(member);
        if(book.isAvailable())
        {
            member.decrementBorrowedCount();
            System.out.println(member.getName()+ " returned book " + book.getTitle() + " successfully.");
        }
        else
        {
            System.out.println("Return failed: This book was not checked out by " + member.getName());
        }
    }

    public List<Book> searchBooks(String criteria)
    {
        List<Book> results = new  ArrayList<>();
        String query = criteria.toLowerCase();

        for(Book book : bookInventory)
        {
            if(book.getTitle().toLowerCase().contains(query) || book.getAuthor().toLowerCase().contains(query))
            {
                results.add(book);
            }
        }
        return results;
    }

    public List<Book> searchBooks(String criteria, String type)
    {
        List<Book> results = new ArrayList<>();
        String query = criteria.toLowerCase();
        String targetType = type.toLowerCase();

        for(Book book : bookInventory)
        {
            boolean matchesCriteria = book.getTitle().toLowerCase().contains(query) ||
                    book.getAuthor().toLowerCase().contains(query);
            boolean matchesType = false;
            if(targetType.equals("textbook") && book instanceof TextBook)
            {
                matchesType = true;
            }
            else if(targetType.equals("novel book") && book instanceof NovelBook)
            {
                matchesType = true;
            }

            if(matchesCriteria && matchesType)
            {
                results.add(book);
            }
        }
        return results;
    }

    public void displayAllBooks()
    {
        System.out.println("--- Library Book Inventory ---");
        for(Book book:bookInventory)
        {
            book.displayBookDetails();
            System.out.println("Availability : " + book.isAvailable());
            System.out.println("-----------------------------------");
        }
    }

    public void displayRegisteredUsers()
    {
        System.out.println("--- Library Registered Users ---");
        for(User user: registeredUsers)
        {
            user.displayDashboard();
            System.out.println("-------------------------------------");
        }
    }



}
