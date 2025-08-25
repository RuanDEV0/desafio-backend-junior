import java.time.LocalDateTime;

public class Active {
    private String code;
    private int quantity;
    private double price;
    private double priceTotal = price * quantity;
    private final LocalDateTime dateBuy = LocalDateTime.now();

    public Active(String code, int quantity, double price) {
        this.code = code;
        this.quantity = quantity;
        this.price = price;
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

    @Override
    public String toString() {
        return "Active{" +
                "code='" + code + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", priceTotal=" + priceTotal +
                ", dateBuy=" + dateBuy +
                '}';
    }

    public double getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(double priceTotal) {
        this.priceTotal = priceTotal;
    }
}
