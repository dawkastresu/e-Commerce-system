import java.math.BigDecimal;

public class Computer extends Product{
    private String processor;
    private int ramGB;

    public Computer(Long id, String name, BigDecimal price, int quantity, String processor, int ramGB) {
        super(id, name, price, quantity, ProductType.COMPUTER);
        this.processor = processor;
        this.ramGB = ramGB;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public int getRamGB() {
        return ramGB;
    }

    public void setRamGB(int ramGB) {
        this.ramGB = ramGB;
    }

    public void configureSpecs(String processor, int ramGB) {
        this.processor = processor;
        this.ramGB = ramGB;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Processor: " + processor + '\n' +
                "Ram GB: " + ramGB;
    }
}
