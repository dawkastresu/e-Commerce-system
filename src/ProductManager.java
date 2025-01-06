import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductManager {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Long id) {
        products.removeIf(p -> id.equals(p.getId()));
    }


    //??????????????
    public void updateProduct(Product updatedProduct) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(updatedProduct.getId())) {
                products.set(i, updatedProduct);
                return;
            }
        }
    }

    public Optional<Product> getProduct(Long id) {
        //alternative solution
        //return products.stream().filter(p -> p.getId().equals(id)).findFirst();
        for (Product product : products){
            if (id.equals(product.getId())){
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }
}
