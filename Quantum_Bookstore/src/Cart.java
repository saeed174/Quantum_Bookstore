import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    Map<Book,Integer> cart;
    public Cart()
    {
        cart = new HashMap<>();
    }

    void add(List<Book> inventory , String bookTitle , int quant)
    {
        boolean found = false;
        for(Book b : inventory)
        {
            if (b.getBookName().equals(bookTitle)) {
                if(b instanceof ShowCase)
                {
                    System.out.println("The book " + b.getBookName() +"  is not for sale.");
                    return;
                }
                if(cart.containsKey(b) && b.getQuantity() <= quant)
                {
                    cart.put(b, cart.get(b) + quant);
                    b.setQuantity(b.getQuantity()-quant);
                    found = true;
                }
                else if(b.getQuantity() >= quant)
                {
                    cart.put(b, quant);
                    b.setQuantity(b.getQuantity()-quant);
                    found = true;
                }
                else
                {
                    throw new IllegalArgumentException("Quantity you needed does not exist");
                }
            }
        }
        if(!found)
        {
            System.out.println("There are not book with this name.");
        }
    }

    void remove(String bookTitle)
    {
        if(cart.isEmpty())
        {
            System.out.println("The Cart is already Empty.");
            return;
        }
        else
        {
            boolean found = false;
            for (Book b : cart.keySet())
            {
                if (b.getBookName().equals(bookTitle))
                {
                    found = true;
                    cart.remove(b);
                    break;
                }
            }

            if(found)
            {
                System.out.println("Book are removed  from your cart.");
            }
            else
            {
                System.out.println("Book aren`t exist in your cart.");
            }
        }
    }

    void buy()
    {
        double price = 0;
        double shippingPrice = 0;
        for (Book b : cart.keySet())
        {
            price += b.getPrice() * cart.get(b);
            if(b instanceof PaperBook)
            {
                shippingPrice += ((PaperBook) b).getShippingCost();
            }
        }
        System.out.println("The price of books : " + price);
        System.out.println("The price of Shipping : " + shippingPrice);
        System.out.println("The Total amount to be paid : " + (price + shippingPrice));

    }
}
