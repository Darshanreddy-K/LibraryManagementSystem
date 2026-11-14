import java.awt.print.Book;

public class Librarian extends User
{
    private String employeeNumber;

    public Librarian(String name, String contactInfo, String employeeNumber)
    {
        super(name, contactInfo);
        this.employeeNumber = employeeNumber;
    }



    @Override
    public void displayDashboard()
    {
        System.out.println("--- Librarian Dashboard ---");
        System.out.println("Name: " + getName());
        System.out.println("Employee Number: " + employeeNumber);
    }

    public boolean canBorrowBooks()
    {
        return true;
    }

    public void addNewBook(Book book)
    {
        //Implementation later
    }

    public void removeBook(Book book)
    {
        //Implementation later
    }
}
