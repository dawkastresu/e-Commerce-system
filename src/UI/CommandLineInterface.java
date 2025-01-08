package UI;

import Model.*;
import Services.Discount;
import Services.Order;
import Services.OrderProcessor;
import Services.ProductManager;

import java.awt.*;
import java.util.Scanner;

public class CommandLineInterface {

    private ProductManager productManager;

    private Cart cart;

    private OrderProcessor orderProcessor;

    private Scanner scanner;

    private Discount discount;


    public CommandLineInterface(ProductManager productManager, OrderProcessor orderProcessor) {
        this.productManager = productManager;
        this.orderProcessor = orderProcessor;
        this.cart = new Cart();
        this.scanner = new Scanner(System.in);
        this.discount = new Discount();
    }

    public void start() {
        //wczytac produkty z pliku.csv
        while (true) {
            System.out.println("\n1. Przeglądaj produkty");
            System.out.println("2. Dodaj do koszyka");
            System.out.println("3. Wyświetl zawartość koszyka");
            System.out.println("4. Złóż zamówienie");
            System.out.println("5. Skonfiguruj sprzęt");
            System.out.println("6. Tryb administratora");
            System.out.println("5. Exit");
            System.out.print("Wybierz opcję: ");

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
                    configSpecs();
                    return;
                default:
                    System.out.println("Wybrana opcja niedostępna, spróbuj jeszcze raz.");
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
            forEach(v -> System.out.println(v.getName() + " | cena: " + v.getPrice() + " | ID: " + v.getId()));
        System.out.print("Wprowadź ID produktu, aby dodać go do koszyka: ");
        Long id = scanner.nextLong();
        productManager.getProduct(id).
                ifPresentOrElse(product -> {
                    //dodac do pliku
                    cart.addProduct(product);
                    System.out.println("Produkt " + product + " dodany do koszyka");
                },
                () -> System.out.println("Nie znaleziono takiego produktu")
        );
    }

    private void viewCart() {
        System.out.println("Twój koszyk:");
        cart.getItems().forEach(System.out::println);
        System.out.println("Cena nałkowita: " + cart.getTotalPrice());
    }

    private void placeOrder() {
        if (cart.getItems().isEmpty()) {
            System.out.println("Twój koszyk jest pusty.");
            return;
        }

        System.out.print("Wprowadź imię: ");
        String customerName = scanner.nextLine();

        Order order = new Order(System.currentTimeMillis(), customerName, cart.getItems(), cart.getTotalPrice());
        orderProcessor.processOrder(order).thenRun(() -> {
            System.out.println("Zamowienie złożone pomyślnie!");
            cart.clear();
        });
    }

    private void configSpecs() {
        System.out.println("Wybierz rodzaj: ");
        System.out.println("1. Komputer");
        System.out.println("2. Smartfon");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                configComputer();
                break;
            case 2:
                configSmartphone();
                break;
            default:
                System.out.println("Wybrana opcja niedostępna, spróbuj jeszcze raz.");
        }
    }

    private void configComputer() {
        double basePrice = 2000;

        System.out.println("Wybierz Procesor: ");
        for (Processor processor : Processor.values()) {
            System.out.println(processor.ordinal() + 1 + ". " + processor + " - Cena: " + processor.getPrice() + " PLN");
        }
        int processorChoice = scanner.nextInt();
        Processor selectedProcessor = Processor.values()[processorChoice - 1];

        System.out.println("Wybierz pamięć RAM:");
        for (RAM ram : RAM.values()) {
            System.out.println(ram.ordinal() + 1 + ". " + ram + " - Cena: " + ram.getPrice() + " PLN");
        }
        int ramChoice = scanner.nextInt();
        RAM selectedRam = RAM.values()[ramChoice - 1];

        double totalPrice = basePrice + selectedProcessor.getPrice() + selectedRam.getPrice();

        Computer computer = new Computer(selectedProcessor, selectedRam);

        cart.addProduct(computer);

        System.out.println("\nSkonfigurowany komputer:");
        System.out.println("Procesor: " + computer.getProcessor() + "\n" +
                            "RAM: " + computer.getRamGB());
        System.out.println("Całkowita cena: " + totalPrice + " PLN");
    }

    private void configSmartphone() {
        double basePrice = 1200;

        System.out.println("Wybierz Kolor: ");
        for (Colors color : Colors.values()) {
            System.out.println(color.ordinal() + 1 + ". " + color + " - Cena: " + color.getPrice() + " PLN");
        }
        int colorChoice = scanner.nextInt();
        Colors selectedColor = Colors.values()[colorChoice - 1];

        System.out.println("Wybierz pojemność baterii:");
        for (BatteryCapacity battery : BatteryCapacity.values()) {
            System.out.println(battery.ordinal() + 1 + ". " + battery + " - Cena: " + battery.getPrice() + " PLN");
        }
        int batteryChoice = scanner.nextInt();
        BatteryCapacity selectedBattery = BatteryCapacity.values()[batteryChoice - 1];

        System.out.println("Wybierz akcesoria:");
        for (Accessories accessory : Accessories.values()) {
            System.out.println(accessory.ordinal() + 1 + ". " + accessory + " - Cena: " + accessory.getPrice() + " PLN");
        }
        int accessoryChoice = scanner.nextInt();
        Accessories selectedAccessories = Accessories.values()[accessoryChoice - 1];

        double totalPrice = basePrice + selectedColor.getPrice() + selectedBattery.getPrice() + selectedAccessories.getPrice();

        Smartphone smartphone = new Smartphone(selectedColor, selectedBattery, selectedAccessories);

        cart.addProduct(smartphone);

        System.out.println("\nSkonfigurowany smartfon:");
        System.out.println("Kolor: " + smartphone.getColor() + "\n" +
                            "Pojemność baterii: " + smartphone.getBatteryCapacity() + "\n" +
                            "Akcesoria: " + smartphone.getAccessories());
        System.out.println("Całkowita cena: " + totalPrice + " PLN");
    }

}