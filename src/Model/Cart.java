package Model;

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

    public double getTotalPrice() {
        double counter = 0.0;
        for (Product item : items) {
            counter += item.getPrice();
        }
        return counter;
    }

    public void clear() {
        items.clear();
    }
}
