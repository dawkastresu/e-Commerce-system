import java.util.Scanner;

public class CommandLineInterface {
    private ProductManager productManager;
    private Cart cart;
    private OrderProcessor orderProcessor;
    private Scanner scanner;

    public CommandLineInterface(ProductManager productManager, OrderProcessor orderProcessor) {
        this.productManager = productManager;
        this.orderProcessor = orderProcessor;
        this.cart = new Cart();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\n1. View Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Place Order");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewProducts();
                    break;
                case 2:
                    addToCart();
                    break;
                case 3:
                    viewCart();
                    break;
                case 4:
                    placeOrder();
                    break;
                case 5:
                    System.out.println("Thank you for shopping with us!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void viewProducts() {
        System.out.println("""
                
                Available Products:
                """);
        productManager.getAllProducts().forEach(System.out::println);
    }

    private void addToCart() {
        productManager.getAllProducts().  //Show products list with id
            forEach(v -> System.out.println(v.getName() + " | " + v.getPrice() + " | " + v.getId()));
        System.out.print("Enter product ID to add to cart: ");
        Long id = scanner.nextLong();
        productManager.getProduct(id).
                ifPresentOrElse(product -> {
                    cart.addProduct(product);
                    System.out.println("Product added to cart.");
                },
                () -> System.out.println("Product not found.")
        );
    }

    private void viewCart() {
        System.out.println("Your Cart:");
        cart.getItems().forEach(System.out::println);
        System.out.println("Total: $" + cart.getTotalPrice());
    }

    private void placeOrder() {
        if (cart.getItems().isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }

        System.out.print("Enter your name: ");
        String customerName = scanner.nextLine();

        Order order = new Order(System.currentTimeMillis(), customerName, cart.getItems(), cart.getTotalPrice());
        orderProcessor.processOrder(order).thenRun(() -> {
            System.out.println("Order placed successfully!");
            cart.clear();
        });
    }
}