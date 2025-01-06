import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private Long id;
    private String customerName;
    private List<Product> products;
    private double totalAmount;
    private LocalDateTime orderTime;

    public Order(Long id, String customerName, List<Product> products, double totalAmount) {
        this.id = id;
        this.customerName = customerName;
        this.products = products;
        this.totalAmount = totalAmount;
        this.orderTime = LocalDateTime.now();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Order: " +
                "ID: " + id + "" + "\n" +
                "Customer name: " + customerName + '\n' +
                "Products: " + products + "\n" +
                "Total amount: " + totalAmount + "\n" +
                "Order time: " + orderTime;
    }
}
