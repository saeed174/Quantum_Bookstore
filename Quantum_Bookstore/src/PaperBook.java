public class PaperBook extends Book {
    private double weight;
    private String paperType;
    private double shippingCost;

    public PaperBook() {
    }

    public PaperBook(int ISBN, String bookName, String authorName, String publisherName, String yearOfPublish , double price, int quantity , double weight, String paperType, double shippingCost) {
        super(ISBN, bookName, authorName, publisherName, yearOfPublish, price, quantity, true);
        this.weight = weight;
        this.paperType = paperType;
        this.shippingCost = shippingCost;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getPaperType() {
        return paperType;
    }

    public void setPaperType(String paperType) {
        this.paperType = paperType;
    }

    public double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(double shippingCost) {
        this.shippingCost = shippingCost;
    }

    public double calculateTotalPrice() {
        return super.getPrice() + shippingCost;
    }

    @Override
    public String toString()
    {
        return super.toString()
                + " '\', Book Type = PaperBook{" 
                + "weight=" + weight
                + ", paperType='" + paperType + '\''
                + ", shippingCost=" + shippingCost
                + '}';
    }
}
