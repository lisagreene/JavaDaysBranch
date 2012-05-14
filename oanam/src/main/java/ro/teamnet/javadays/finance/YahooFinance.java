package ro.teamnet.javadays.finance;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;

import ro.teamnet.javadays.finance.dao.*;


/**
 * Created with IntelliJ IDEA.
 * User: gerard.dragoi
 * Date: 5/4/12
 * Time: 8:59 AM
 * To change this template use File | Settings | File Templates.
 */
public class YahooFinance implements FinanceService {
    static final String YAHOO_FINANCE_TEMPLATE_URL =
            "http://finance.yahoo.com/d/quotes.csv?s=%s&f=%s";
    private static final File YAHOO_FINANCE_HOME = new File("D:/yahoo/finance/home");


    private final WebAccessor webAccessor;

    private final FinanceDataParser financeDataParser;
    private static final FinanceDataParser DEFAULT_YAHOO_FINANCE_DATA_PARSER =
            new YahooFinanceDataParser();
    


    public YahooFinance(WebAccessor webAccessor) {
        this.webAccessor = webAccessor;
        this.financeDataParser = DEFAULT_YAHOO_FINANCE_DATA_PARSER;
    }

    YahooFinance(WebAccessor webAccessor, FinanceDataParser financeDataParser) {
        this.webAccessor = webAccessor;
        this.financeDataParser = financeDataParser;
    }

    @Override
    public List<FinanceData> getStockData(StockInfo stockInfo) throws FinanceDataUnavailableException {
        final URL url = urlFrom(stockInfo);
        final String content = webAccessor.getContent(url);
        List<FinanceData> financeData = financeDataParser.parse(content);
        return financeData;
    }

    protected URL urlFrom(StockInfo stockInfo) {
        try {
          return URI.create(String.format(YAHOO_FINANCE_TEMPLATE_URL, stockInfo.getSymbol(), stockInfo.getStat())).toURL();
        } catch (MalformedURLException e) {
           throw new WebAccessException(e);
        }
    }

    public static void main(String[] args) {
        /*YahooFinance yahooFinance=new YahooFinance(new DefaultWebAccessor()) {

            @Override
            protected URL urlFrom(String symbol, String stat) {
                throw new WebAccessException("Does the trick");
            }
        };*/
        YahooFinance yahooFinance=new YahooFinance(new DefaultWebAccessor());
        final StockInfoDao stockInfoDao = new FlatFileStockInfoDao(YAHOO_FINANCE_HOME);
        //String[] symbols = new String[]{"YHOO","AAPL","GOOG","MSFT"};
        StockInfo stockInfo = new StockInfo.Builder().symbol("YHOO").symbol("GOOG").symbol("AAPL").symbol("MSFT").build();
        List<FinanceData> financeDataList = yahooFinance.getStockData(stockInfo);
        for (FinanceData financeData:financeDataList){
            System.out.println(financeData);
            stockInfoDao.save(financeData);
        }
    }

}
