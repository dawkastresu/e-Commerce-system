package Model;

public class Product {

    private Long id;

    private String name;

    private double price;

    private int quantity;

    private ProductType type;

    public enum ProductType {
        COMPUTER, SMARTPHONE, ELECTRONICS
    }

    public Product(Long id, String name, double price, int quantity, ProductType type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.type = type;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return
                "ID: " + id + ", " +
                "Name: " + name + ", " +
                "Price: " + price + ", " +
                "Quantity: " + quantity + ", ";
    }
}
