package ro.teamnet.javadays.meet1;

/**
 * Created with IntelliJ IDEA.
 * User: gerard.dragoi
 * Date: 5/4/12
 * Time: 9:18 AM
 * To change this template use File | Settings | File Templates.
 */
public class FinanceData {

    private String symbol;
    private String price;
    private String change;
    private String volume;

    public void setPrice(String price) {
        this.price = price;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getPrice() {
        return this.price;
    }

    public String getChange() {
        return this.change;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getVolume() {
        return this.volume;
    }

    @Override
    public String toString() {
        return "FinanceData{" +
                "price='" + price + '\'' +
                ", change='" + change + '\'' +
                ", volume='" + volume + '\'' +
                '}';
    }
}
