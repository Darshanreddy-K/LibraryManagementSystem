public abstract class Book implements Lendable
{
    private String isbn;
    private String title;
    private String author;
    private boolean isAvaliable;
    private User currentBorrower;


    public Book()
    {
        this.isAvaliable = true;
    }

    public Book(String isbn, String title, String author)
    {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.isAvaliable = true;
    }

    public Book( Book other)
    {
        this.isbn = other.isbn;
        this.title = other.title;
        this.author = other.author;
        this.isAvaliable = true;
    }


    @Override
    public boolean lend(User user)
    {
        if(isAvaliable && user.canBorrowBooks())
        {
            isAvaliable = false;
            currentBorrower = user;
            return true;
        }
        return false;
    }

    @Override
    public void returnItem(User user)
    {
        if(currentBorrower!= null && currentBorrower.equals(user))
        {
            isAvaliable = true;
            currentBorrower = null;
        }
    }

    @Override
    public boolean isAvailable()
    {
        return isAvaliable;
    }

    //Getters
    public  String getIsbn()
    {
        return isbn;
    }

    public String getTitle()
    {
        return title;
    }

    public String getAuthor()
    {
        return author;
    }

    public abstract void displayBookDetails();
}
