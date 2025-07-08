class Book
{
    private int ISBN;
    private String bookName;
    private String authorName;
    private String publisherName;
    private double price;
    private int quantity;
    private String yearOfPublish;

    private boolean isAvailable;
    private boolean isShippable;

    public Book() {
    }

    public Book(int ISBN, String bookName, String authorName, String publisherName, String yearOfPublish , double  price, int quantity , boolean isShippable) {
        this.ISBN = ISBN;
        this.bookName = bookName;
        this.authorName = authorName;
        this.publisherName = publisherName;
        this.yearOfPublish = yearOfPublish;
        this.price = price;
        this.quantity = quantity;
        this.isShippable = isShippable;
        this.isAvailable = quantity > 0;  
    }

    public int getBookISBN() {
        return ISBN;
    }

    public void setBookISBN(int bookId) {
        this.ISBN = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isAvailable() {
        if(quantity > 0) {
            isAvailable = true;
        } else {
            isAvailable = false;
        }
        return isAvailable;
    }

    public String getYearOfPublish()
    {
        return yearOfPublish;
    }

    public boolean isShippable() {
        return isShippable;
    }

    public void setShippable(boolean isShippable) {
        this.isShippable = isShippable;
    }

    @Override
    public String toString() {
        return "Details{" +
                "ISBN=" + ISBN +
                ", bookName='" + bookName + '\'' +
                ", authorName='" + authorName + '\'' +
                ", publisherName='" + publisherName + '\'' +
                ", yearOfPublish='" + yearOfPublish + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", isAvailable=" + isAvailable +
                ", isShippable=" + isShippable;
    }

}