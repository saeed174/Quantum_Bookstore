import java.util.ArrayList;
import java.util.List;

public class Inventory {
    List<Book> inventory = new ArrayList<>();

    public Inventory()
    {
        inventory.add(new PaperBook(25495, "Quantum Physics", "John Doe", "Quantum Press", "2023", 29.99, 10 , 1.5, "Glossy", 5.00));

        inventory.add(new ShowCase(25485, "Advanced Quantum Mechanics", "Jane Smith", "Science Publishers", "2022", 39.99, 5, "A comprehensive guide to quantum mechanics."));

        inventory.add(new EBook(25475, "Quantum Computing Basics", "Alice Johnson", "Tech Books", "2021", 19.99, 20, "pdf", 2.5, true));

        inventory.add(new PaperBook(25465, "Quantum Entanglement", "Bob Brown", "Physics World", "2020", 24.99, 15, 0.8, "Matte", 3.50));

        inventory.add(new ShowCase(25455, "Quantum Field Theory", "Charlie White", "Academic Press", "2019", 44.99, 8));

        inventory.add(new EBook(25445, "Quantum Cryptography", "David Green", "Secure Books", "1999", 34.99, 12, "epub", 1.2, true));

        inventory.add(new EBook(25435, "Modern Physics" , "Tom Juas" , "Refail weal" , "2020" , 65.32 , 20 , "pdf" ,42.1, true));
    }
}
