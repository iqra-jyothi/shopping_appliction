public class Cart {private int id;
    private  int quantity;
    private String name;
    private double price;
    private double totalPrice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Cart(int id, int quantity, String name, double price, double totalPrice) {
        this.id = id;
        this.quantity = quantity;
        this.name = name;
        this.price = price;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
