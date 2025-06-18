import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        System.out.println("shoppig mall");
        Stockopretion op=new Stockopretion();
ArrayList<Cart> cart = new ArrayList<>();
        while(true)
        {
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Update cart Product");
            System.out.println("4. Delete cart Product");
            System.out.println("6.add to card");
            System.out.println("7. View Cart");
            System.out.println("8.tottal bill");
            System.out.println("5. Exit");
            System.out.println("enter the choice");
            int choice = sc.nextInt();
            switch (choice)
            {
                case 1:op.add(products,sc);
                break;
                case 2:op.ViewAllProduct(products);
                break;
                case 3:
                   op.updatecart(cart,products,sc);
                    break;
                case 4:
                    op.deletecart(cart,products,sc);

                    break;
                case 5:
                    System.out.println("Exiting the application.");
                    sc.close();
                    return; // Exit the loop and terminate the program
                case 6:
                   op.addToCart(cart,products,sc);
                    break;
                case 7:op.viewcart(cart);
                break;
                case 8:op.totalbill(cart);
                break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}