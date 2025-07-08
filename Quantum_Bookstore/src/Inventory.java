import java.util.ArrayList;
import java.util.List;

public class Inventory {
    List<Book> inventory = new ArrayList<>();

    public Inventory()
    {
        inventory.add(new PaperBook(25495, "Quantum Physics", "John Doe", "Quantum Press", "2023", 29.99, 10 , 1.5, "Glossy", 5.00));

        inventory.add(new ShowCase(25485, "Advanced Quantum Mechanics", "Jane Smith", "Science Publishers", "2022", 39.99, 5, "A comprehensive guide to quantum mechanics."));

        inventory.add(new EBook(25475, "Quantum Computing Basics", "Alice Johnson", "Tech Books", "2021", 19.99, 20, "pdf", 2.5, true));

        inventory.add(new PaperBook(25465, "Quantum Entanglement", "Bob Brown", "Physics World", "1987", 24.99, 15, 0.8, "Matte", 3.50));

        inventory.add(new ShowCase(25455, "Quantum Field Theory", "Charlie White", "Academic Press", "2019", 44.99, 8));

        inventory.add(new EBook(25445, "Quantum Cryptography", "David Green", "Secure Books", "1999", 34.99, 12, "epub", 1.2, true));

        inventory.add(new EBook(25435, "Modern Physics" , "Tom Juas" , "Refail weal" , "2020" , 65.32 , 20 , "pdf" ,42.1, true));
    }


    public void addBook(Book book) {
        inventory.add(book);
    }


    public List<Book> getInventory() {
        return inventory;
    }

    public List<Book> remove(int noOfYear) {
        int year = 2025; // getYear returns year since 1900
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getYearOfPublish() != null && (year - Integer.parseInt(inventory.get(i).getYearOfPublish())) > noOfYear) {
                inventory.remove(i);
            }
        }
        return inventory;
    }

    double buy(int isbn , int quantity , String email , String address) throws Exception {
        double price = 0;
        Book book = null;
        boolean found = false;
        for(Book b : inventory) {
            if (b.getBookISBN() == isbn) {
                if(b instanceof ShowCase) {
                    throw new Exception("Showcase books cannot be purchased.");
                }
                if (b.getQuantity() < quantity) {
                    throw new Exception("Not enough stock for " + b.getBookName());
                }
                book = b;
                b.setQuantity(b.getQuantity() - quantity);
                price = b.getPrice() * quantity;
                if(b instanceof PaperBook)
                {
                    price += ((PaperBook) b).getShippingCost() * quantity;
                }
                found = true;
                break;
            }
        }

        if (!found) {
            throw new Exception("Book with ISBN " + isbn + " not found.");
        }

        if(book instanceof EBook) {
            MailService.mailService(book, email);
        }
        else if(book instanceof PaperBook) {
            ShippingService.shippingService(book, email);
        }

        return price;
    }
}
