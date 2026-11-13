public class Member extends User
{
    private int borrowedBooksCount;
    private static final int MAX_BORROW_LIMIT = 2;

    //Constructor to initialize member
    public Member()
    {
        super();
        this.borrowedBooksCount = 0;
    }

    public Member(String name, String contactInfo)
    {
        super(name, contactInfo);
        this.borrowedBooksCount = 0;
    }

    //Override the abstract methods
    @Override
    public void displayDashboard()
    {
        System.out.println("--- Members Dashboard ---");
        System.out.println("Name: " + getName());
        System.out.println("Books Borrowed: " +  borrowedBooksCount);
    }

    @Override
    public boolean canBorrowBooks()
    {
        return borrowedBooksCount < MAX_BORROW_LIMIT;
    }

    //Increment, Decrement borrowedBooksCount
    public void incrementBorrowedCount()
    {
        borrowedBooksCount++;
    }

    public void decrementBorrowedCount()
    {
        borrowedBooksCount--;
    }

    public int getBorrowedBooksCount()
    {
        return borrowedBooksCount;
    }


}
