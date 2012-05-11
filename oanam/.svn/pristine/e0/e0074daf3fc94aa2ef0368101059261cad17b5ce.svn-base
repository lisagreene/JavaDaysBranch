package ro.teamnet.javadays.meet1;

import com.google.common.base.Preconditions;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

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
    public FinanceData getStockData(String symbol, String stat) throws FinanceDataUnavailableException {
        final URL url = urlFrom(symbol, stat);
        final String content = webAccessor.getContent(url);
        Preconditions.checkArgument(symbol!=null && !symbol.trim().isEmpty(),"You must pass a non empty symbol");
        Preconditions.checkArgument(stat!=null && !stat.trim().isEmpty(),"You must pass a non empty stat");
        return financeDataParser.parse(content);
    }

    protected URL urlFrom(String symbol, String stat) {

        try {
          return URI.create(String.format(YAHOO_FINANCE_TEMPLATE_URL, symbol, stat)).toURL();
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
        FinanceData financeData=yahooFinance.getStockData("GOOG","l1c1v");
        System.out.println(financeData);

    }

}
