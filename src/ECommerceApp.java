public class ECommerceApp {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        OrderProcessor orderProcessor = new OrderProcessor();


        productManager.addProduct(new Computer(1L, "Gaming Laptop", 5400, 10, "Intel i7", 16));
        productManager.addProduct(new Computer(142323L, "Vivobook", 3200, 21, "Intel i5", 8));
        productManager.addProduct(new Smartphone(13232L, "iPhone 14", 3700, 26, "White", 2300));
        productManager.addProduct(new Smartphone(53244L, "Xiaomi 12T", 1800, 54, "Czarny", 5000));

        CommandLineInterface cli = new CommandLineInterface(productManager, orderProcessor);
        cli.start();
    }
}