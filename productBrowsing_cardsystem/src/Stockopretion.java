import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Stockopretion {
    public void add(ArrayList<Product> products, Scanner sc) {
        System.out.println("Enter Product ID:");
        int id = sc.nextInt();
        sc.nextLine(); // Consume newline left-over
        System.out.println("Enter Product Name:");
        String name = sc.nextLine();
        System.out.println("Enter Product Price:");
        double price = sc.nextDouble();
        System.out.println("Enter Product Stock:");
        int stock = sc.nextInt();

        Product product = new Product(stock, price, name, id);
        products.add(product);
        System.out.println("Product added successfully: " );
    }

    public void ViewAllProduct(ArrayList<Product> products) {
        if (products.isEmpty()) {
            System.out.println("No products available.");
        } else {
            System.out.println("Available Products:");
            Iterator<Product>iterator=products.iterator();
            while(iterator.hasNext())
            {
                Product p=iterator.next();
                System.out.println(p);
            }
        }
    }

    public void addToCart(ArrayList<Cart> cart, ArrayList<Product> products, Scanner sc) {
        System.out.println("Enter Product ID to add to cart:");
        int productId = sc.nextInt();
        System.out.println("Enter Quantity:");
        int quantity = sc.nextInt();
        boolean productFound = false;
        Iterator<Product>iterator=products.iterator();
        while(iterator.hasNext())
        {
            Product p=iterator.next();
            if(p.getId()==productId)
            {
                productFound=true;
                if(p.getStock()>=quantity)
                {
                    double totalprize=p.getPrice()*quantity;
                    Cart c=new Cart(p.getId(),quantity,p.getName(),p.getPrice(),totalprize);
                    cart.add(c);
                    p.setStock(p.getStock()-quantity);
                    System.out.println("Product added to cart successfully: " + c);
                }
            }

        }
        if(!productFound) {
            System.out.println("Product with ID " + productId + " not found.");
        } else {
            System.out.println("Product with ID " + productId + " is out of stock or insufficient quantity.");
        }
    }

    public void viewcart(ArrayList<Cart> cart) {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
            System.out.println("Items in Cart:");
            for (Cart c : cart) {
                System.out.println(c);
            }
        }
    }

    public void updatecart(ArrayList<Cart> cart, ArrayList<Product> products, Scanner sc) {
        System.out.println("enter the product id to update");
        int productId = sc.nextInt();
        boolean productFound = false;
        Iterator<Cart>iterator=cart.iterator();
        while(iterator.hasNext())
        {
            Cart c=iterator.next();
            if(c.getId()==productId) {
                productFound = true;
                System.out.println("Enter new quantity:");
                int newQuantity = sc.nextInt();
                boolean stockAvailable = false;
                int diff=newQuantity- c.getQuantity();
                int curentqun=c.getQuantity();
                if (diff>0) {
                    Iterator<Product> productIterator = products.iterator();
                    while (productIterator.hasNext()) {
                        Product p = productIterator.next();
                        if (p.getId() == c.getId()) {
                            if (p.getStock() > diff) {
                                stockAvailable = true;
                                double totalprixe = p.getPrice() * newQuantity;
                                c.setQuantity(newQuantity);
                                c.setTotalPrice(totalprixe);
                                p.setStock(p.getStock() - diff);
                                System.out.println("Cart updated successfully: " + c);
                            }
                            else {
                                System.out.println("Insufficient stock available for the requested quantity.");
                            }
                        }

                    }
                }
                else if (diff<0) {

                    Iterator<Product> productIterator = products.iterator();
                    while (productIterator.hasNext()) {
                        Product p = productIterator.next();
                        if (p.getId() == c.getId()) {
//
                            double totalprixe = p.getPrice() * newQuantity;
                            c.setQuantity(newQuantity);
                            c.setTotalPrice(totalprixe);
                            p.setStock(p.getStock() + diff);
                            System.out.println("Cart updated successfully: " + c);
//                          }
                        }

                    }
                }
                else{
                    System.out.println("No change in quantity.");
                }
            }
            if(!productFound)
            {
                System.out.println("Product with ID " + productId + " not found in cart.");
            }
        }
    }

    public void deletecart(ArrayList<Cart> cart, ArrayList<Product> products, Scanner sc) {
        System.out.println("Enter the product ID to delete:");
        int productId = sc.nextInt();
        boolean productFound = false;

        Iterator<Cart> cartIterator = cart.iterator();
        while (cartIterator.hasNext()) {
            Cart c = cartIterator.next();
            if (c.getId() == productId) {
                productFound = true;

                // Restore the stock to products
                for (Product p : products) {
                    if (p.getId() == productId) {
                        p.setStock(p.getStock() + c.getQuantity());
                        break;
                    }
                }

                cartIterator.remove(); // Safely remove from cart
                System.out.println("Product deleted successfully from cart: " + c);
                break; // No need to continue loop
            }
        }

        if (!productFound) {
            System.out.println("Product with ID " + productId + " not found in cart.");
        }
    }

    public void totalbill(ArrayList<Cart> cart) {
        double to=0;
        if(cart.isEmpty())
        {
            System.out.println("no item total bill is 0");
        }
        for(Cart c:cart)
        {
            to+=c.getTotalPrice();
        }
        System.out.println("the total bill is"+to);
    }
}
