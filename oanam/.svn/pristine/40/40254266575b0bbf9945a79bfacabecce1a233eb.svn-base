package ro.teamnet.javadays.meet1;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

/**
 * Created with IntelliJ IDEA.
 * User: gerard.dragoi
 * Date: 5/7/12
 * Time: 9:26 AM
 * To change this template use File | Settings | File Templates.
 */
public class StockInfo /*implements Serializable*/ {
    private final String symbol;
    private final String stat;

    public StockInfo(String symbol, String stat) {
        Preconditions.checkArgument(symbol != null && !symbol.isEmpty());
        Preconditions.checkArgument(stat != null && !stat.isEmpty());

        this.symbol = symbol;
        this.stat = stat;
    }

    public final String getSymbol() {
        return symbol;
    }

    public final String getStat() {
        return stat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StockInfo stockInfo = (StockInfo) o;

        if (!symbol.equals(stockInfo.symbol)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(symbol);
    }
}
