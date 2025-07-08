public class ShowCase extends Book{
    private String description;

    public ShowCase() {
    }

    public ShowCase(int ISBN, String bookName, String authorName, String publisherName, String yearOfPublish, double price, int quantity, String description) {
        super(ISBN, bookName, authorName, publisherName, yearOfPublish, price, quantity, false);
        this.description = description;
    }

    public ShowCase(int ISBN, String bookName, String authorName, String publisherName, String yearOfPublish, double price, int quantity) {
        super(ISBN, bookName, authorName, publisherName, yearOfPublish, price, quantity, false);
        this.description = "No description available.";
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    

    @Override
    public String toString() {
        return super.toString()
                + " '\', Book Type = ShowCase{"
                + "description='" + description + '\''
                + '}';
    }
    
}
