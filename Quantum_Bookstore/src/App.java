import java.time.*;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Inventory inventory = new Inventory();
        List<Book> inventoryList = inventory.inventory;
        

        System.out.println("Date: " + LocalDate.now());
        System.out.println("Time: " + LocalTime.now());
        System.out.println("\t\t\tWelcome to the Quantum Book Store!\n");

        System.out.println("Here is our inventory of books:\n");

        System.out.printf("%-30s %-20s %-12s %-20s\n", "Book Name", "Author", "ISBN" , "Publish year");
        System.out.println("------------------------------------------------------------------------------------");
        for (Book book : inventoryList) {
            System.out.printf("%-30s %-20s %-12s     %-20s\n",
                book.getBookName(),
                book.getAuthorName(),
                book.getBookISBN(),
                book.getYearOfPublish()
            );
        }
        
        Book newBook = new PaperBook(12345, "Advanced Quantum Mechanics", "Alice Smith", "Quantum Press", "2023", 59.99, 10, 1.5, "Glossy", 5.00);

        inventory.addBook(newBook);

        inventoryList = inventory.remove(25);
        System.out.println("\nBooks published before 2000 have been removed from the inventory.\n");

        System.out.printf("%-30s %-20s %-12s %-20s\n", "Book Name", "Author", "ISBN" , "Publish year");
        System.out.println("------------------------------------------------------------------------------------");
        for (Book book : inventoryList) {
            System.out.printf("%-30s %-20s %-12s     %-20s\n",
                book.getBookName(),
                book.getAuthorName(),
                book.getBookISBN(),
                book.getYearOfPublish()
            );
        }

        double paidAmount = 0;
        try
        {
            paidAmount = inventory.buy(25435 , 2 , "saeednabawy28@gmail.com" , "Egypt");
            System.out.println("\nYou have successfully purchased the book.");
            System.out.println("Paid Amount: " + paidAmount);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // try wuth unvalid quantity
        try
        {
            paidAmount = inventory.buy(25495 , 13 , "saeednabawy28@gmail.com" , "Egypt");
            System.out.println("\nYou have successfully purchased the book.");
            System.out.println("Paid Amount: " + paidAmount);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // try with showcase book
        try
        {
            paidAmount = inventory.buy(25485 , 13 , "saeednabawy28@gmail.com" , "Egypt");
            System.out.println("\nYou have successfully purchased the book.");
            System.out.println("Paid Amount: " + paidAmount);
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // try with unvalid ISBN
        try
        {
            paidAmount = inventory.buy(9999 , 13 , "saeednabawy28@gmail.com" , "Egypt");
            System.out.println("\nYou have successfully purchased the book.");
            System.out.println("Paid Amount: " + paidAmount);
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }




    }
}
