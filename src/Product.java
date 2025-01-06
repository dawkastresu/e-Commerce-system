import java.math.BigDecimal;

public class Product {
    private Long id;
    private String name;
    private BigDecimal price;
    private int quantity;
    private ProductType type;

    public enum ProductType {
        COMPUTER, SMARTPHONE, ELECTRONICS
    }

    public Product(Long id, String name, BigDecimal price, int quantity, ProductType type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.type = type;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
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
                "ID: " + id + "\n" +
                "Name: " + name + '\n' +
                "Price: " + price + "\n" +
                "Quantity: " + quantity + "\n" +
                "Type: " + type;
    }
}
