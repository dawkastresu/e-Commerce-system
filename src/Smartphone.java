import java.math.BigDecimal;
import java.util.List;

public class Smartphone extends Product{
    private String color;
    private int batteryCapacity;
    private List<String> accessories;

    public Smartphone(Long id, String name, double price, int quantity, String color, int batteryCapacity) {
        super(id, name, price, quantity, ProductType.SMARTPHONE);
        this.color = color;
        this.batteryCapacity = batteryCapacity;
    }

    public List<String> getAccessories() {
        return accessories;
    }

    public void setAccessories(List<String> accessories) {
        this.accessories = accessories;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void configureOptions(String color, int batteryCapacity, List<String> accessories) {
        this.color = color;
        this.batteryCapacity = batteryCapacity;
        this.accessories = accessories;
    }

    public void configureOptions(String color, int batteryCapacity) {
        this.color = color;
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Color: " + color + '\n' +
                "Battery capacity: " + batteryCapacity + "\n" +
                "Accessories: " + accessories;
    }
}
