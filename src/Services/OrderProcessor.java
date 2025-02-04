package Services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class OrderProcessor {

    private List<Order> orders = new ArrayList<>();


    public CompletableFuture<Void> processOrder(Order order) {
        return CompletableFuture.runAsync(() -> {
            // Simulate order processing
            orders.add(order);
            generateInvoice(order);
        });
    }

    private void generateInvoice(Order order) {
        System.out.println
                ("\n" + "----Invoice---------------------------------" + "\n" +
                "Customer name: " + order.getCustomerName() + "\n" +
                "Products: " + "\n" +
                order.getProducts() +
                "Time: " + order.getOrderTime() + "\n" +
                "Total price: " + order.getTotalAmount());
        //zapisz do pliku
    }

    public List<Order> getOrders() {
        return new ArrayList<>(orders);
    }

}
