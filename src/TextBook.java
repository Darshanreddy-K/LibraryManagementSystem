public class TextBook extends Book
{
    private String subject;
    private int edition;

    public TextBook(String isbn, String title, String author, String subject, int edition)
    {
        super(isbn, title, author);
        this.subject = subject;
        this.edition = edition;
    }

    @Override
    public void displayBookDetails() {
        System.out.println("isbn: "+ this.getIsbn());
        System.out.println("Title: " + this.getTitle());
        System.out.println("Author: " + this.getAuthor());
        System.out.println("Subject: "+ this.subject);
        System.out.println("Edition: "+ this.edition);
    }
}
