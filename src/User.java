public abstract class User {

    private static int idCounter = 0; //Single responsibility principle
    private static int totalusers = 0;
    private final String userId;
    private String name;
    private String contactInfo;

    //Default constructor
    public User()
    {
        this.userId = generateUniqueId();
        totalusers++;
    }

    //Parameterized constructor
    public User(String name, String contactInfo)
    {
        this.userId = generateUniqueId();
        this.name = name;
        this.contactInfo = contactInfo;
        totalusers++;
    }

    //Copy constructor
    //Treated as new registration in the system
    public User(User other)
    {
        this.userId = generateUniqueId();
        this.name = other.name;
        this.contactInfo = other.contactInfo;
        totalusers++;
    }

    //Unique ID generator
    private static String generateUniqueId()
    {
        return "U-" + (++idCounter);
    }

    //Getters and Setters
    public String getUserId()
    {
        return userId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getContactInfo()
    {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo)
    {
        this.contactInfo = contactInfo;
    }

    public static int getTotalUsers()
    {
        return totalusers;
    }

    public abstract void displayDashboard();

    public abstract boolean canBorrowBooks();

}
