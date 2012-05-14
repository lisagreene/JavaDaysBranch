package ro.teamnet.javadays.finance;

import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: gerard.dragoi
 * Date: 5/7/12
 * Time: 9:02 AM
 * To change this template use File | Settings | File Templates.
 */
public class YahooFinanceDataParser implements FinanceDataParser {
    private static final String ALL_COLUMNS = "l1c1va2xj1b4j4dyekjm3m4rr5p5p6s7";
  /*  data['price'] = values[0]
    data['change'] = values[1]
    data['volume'] = values[2]
    data['avg_daily_volume'] = values[3]
    data['stock_exchange'] = values[4]
    data['market_cap'] = values[5]
    data['book_value'] = values[6]
    data['ebitda'] = values[7]
    data['dividend_per_share'] = values[8]
    data['dividend_yield'] = values[9]
    data['earnings_per_share'] = values[10]
    data['52_week_high'] = values[11]
    data['52_week_low'] = values[12]
    data['50day_moving_avg'] = values[13]
    data['200day_moving_avg'] = values[14]
    data['price_earnings_ratio'] = values[15]
    data['price_earnings_growth_ratio'] = values[16]
    data['price_sales_ratio'] = values[17]
    data['price_book_ratio'] = values[18]
    data['short_ratio'] = values[19]*/

    YahooFinanceDataParser() {}

    @Override
    public List<FinanceData> parse(String content) {
        final String s = Preconditions.checkNotNull(content);
        List<FinanceData> financeDataList = new ArrayList<FinanceData>();

        for (String line :  s.split("\n")) {
            line = line.trim();
            FinanceData data = new FinanceData();
            String[] receivedData = line.split(",");
            data.setName(receivedData[0]);
            data.setSymbol(receivedData[1]);
            data.setPrice(receivedData[2]);
            data.setChange(receivedData[3]);
            data.setVolume(receivedData[4]);
            financeDataList.add(data);
        }

        return financeDataList;
    }
}
