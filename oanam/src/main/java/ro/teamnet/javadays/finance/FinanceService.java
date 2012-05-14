package ro.teamnet.javadays.finance;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: gerard.dragoi
 * Date: 5/4/12
 * Time: 10:23 AM
 * To change this template use File | Settings | File Templates.
 */
public interface FinanceService {
    List<FinanceData> getStockData(StockInfo stockInfo) throws FinanceDataUnavailableException;

}
