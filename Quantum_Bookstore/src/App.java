import java.time.*;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<Book> inventory = new Inventory().inventory;
        

        System.out.println("Date: " + LocalDate.now());
        System.out.println("Time: " + LocalTime.now());
        System.out.println("\t\t\tWelcome to the Quantum Book Store!\n");

        System.out.println("Let me Show You Our Books that only published after the year 2000:\n");
        for (int i = 0 ; i < inventory.size() ; i++) {
            if (inventory.get(i).getYearOfPublish() != null && Integer.parseInt(inventory.get(i).getYearOfPublish()) < 2000) {
                inventory.remove(i);
            }
        }


        System.out.println("Here is our inventory of books:\n");

        System.out.printf("%-30s %-20s %-20s\n", "Book Name", "Author", "ISBN");
        System.out.println("--------------------------------------------------------------------------");
        for (Book book : inventory) {
            System.out.printf("%-30s %-20s %-20s\n",
                book.getBookName(),
                book.getAuthorName(),
                book.getBookISBN()
            );
        }
        
        System.out.println("\n\nYour Shopping Details : \n");

        Cart user = new Cart();
        user.add(inventory, "Quantum Physics", 5);
        // expect to print error message
        user.add(inventory, "Advanced Quantum Mechanics", 5);
        //expect to trow exception because qantity needed greater than exist
        try
        {
            user.add(inventory, "Quantum Computing Basics", 25);
        }
        catch(IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
        user.add(inventory, "Quantum Entanglement", 5);
        // there are not found because it published before 2000
        user.add(inventory, "Quantum Cryptography", 10);
        user.add(inventory, "Modern Physics", 10);

        user.buy();

    }
}
