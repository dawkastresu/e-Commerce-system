package Services;

import java.util.function.Predicate;

public class Discount {

    public String description;

    public Predicate<Double> condition; // Warunek promocji

    public double percentage;


    public double applyDiscount(double totalPrice) {
        if (condition.test(totalPrice)) {
            return totalPrice * (1 - percentage / 100);
        }
        return totalPrice;
    }
}