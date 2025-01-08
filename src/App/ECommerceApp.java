package App;

import Model.Computer;
import Model.Smartphone;
import Services.Discount;
import Services.OrderProcessor;
import Services.ProductManager;
import UI.CommandLineInterface;

public class ECommerceApp {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        OrderProcessor orderProcessor = new OrderProcessor();

        CommandLineInterface cli = new CommandLineInterface(productManager, orderProcessor);
        cli.start();
    }
}