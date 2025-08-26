import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Active {
    private String code;
    private int quantity;
    private double price;
    private double priceTotal;
    private final LocalDate dateBuy = LocalDate.now();

    public Active() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPriceTotal() {
        return quantity * price;
    }

    public void setPriceTotal(double priceTotal) {
        this.priceTotal = priceTotal;
    }

    public String getDateBuy() {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dateBuy.format(pattern);
    }
}
