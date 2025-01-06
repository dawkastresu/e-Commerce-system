import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> items = new ArrayList<>();

    public void addProduct(Product product) {
        items.add(product);
    }

    public void removeProduct(Product product) {
        items.remove(product);
    }

    public List<Product> getItems() {
        return new ArrayList<>(items);
    }

// alternative
//    public void getItems() {
//        items.forEach(v -> System.out.println(v));
//    }

    public double getTotalPrice() {
        double counter = 0.0;
        for (Product item : items) {
            counter += item.getPrice();
        }
        return counter;
    }

// alternative
//    public BigDecimal getTotalPrice() {
//        return items.stream()
//                .map(Product::getPrice)
//                .reduce(BigDecimal.ZERO, BigDecimal::add);
//    }

    public void clear() {
        items.clear();
    }
}
