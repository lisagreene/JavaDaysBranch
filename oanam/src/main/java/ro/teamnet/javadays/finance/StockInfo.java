package ro.teamnet.javadays.finance;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: gerard.dragoi
 * Date: 5/7/12
 * Time: 9:26 AM
 * To change this template use File | Settings | File Templates.
 */
public class StockInfo /*implements Serializable*/ {
    private final Set<String> symbols;
    private final String stat;

    public static class Builder{
        private StringBuilder statStringBuilder;
        private Set<String> symbols;

        public Builder() {
            this.statStringBuilder = new StringBuilder("nsl1c1v"); //name + symbol + price + change + volume
            this.symbols = new HashSet<String>();
        }

//        public Builder price() {
//            this.statStringBuilder = this.statStringBuilder.append("l1");
//            return this;
//        }
//
//        public Builder change() {
//            this.statStringBuilder = this.statStringBuilder.append("c1");
//            return this;
//        }
//
//        public Builder volume() {
//            this.statStringBuilder = this.statStringBuilder.append("v");
//            return this;
//        }

        public Builder symbol(String symbol) {
            this.symbols.add(symbol);
            return this;
        }

        public StockInfo build() {
            return new StockInfo(this);
        }
    }

//    public StockInfo(String symbol, String statStringBuilder) {
//        Preconditions.checkArgument(symbol != null && !symbol.trim().isEmpty(), "You must pass a non empty symbol");
//        Preconditions.checkArgument(statStringBuilder != null && !statStringBuilder.trim().isEmpty(), "You must pass a non empty statStringBuilder");
//
//        this.symbols = new HashSet<String>(Arrays.asList(new String[]{symbol}));
//        this.statStringBuilder = statStringBuilder;
//    }

    private StockInfo(Builder builder) {
        Preconditions.checkArgument(builder.symbols != null && !builder.symbols.isEmpty(), "You must pass a non empty symbol array");
        Preconditions.checkArgument(builder.statStringBuilder != null && builder.statStringBuilder.length() > 0 , "You must pass a non empty statStringBuilder");

        for(String symbol:builder.symbols) {
            Preconditions.checkArgument(symbol != null && !symbol.trim().isEmpty(), "You must pass non empty symbols");
        }

        this.symbols = builder.symbols;
        this.stat = builder.statStringBuilder.toString();
    }

    public final String getSymbol() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String symbol : symbols) {
             stringBuilder.append(symbol);
             stringBuilder.append("+");
        }
        return stringBuilder.toString();
    }

    public final String getStat() {
        return stat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StockInfo stockInfo = (StockInfo) o;

        if (!symbols.equals(stockInfo.symbols))
            return false;

        if (!stat.equals(stockInfo.stat))
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(symbols, stat);
    }
}
