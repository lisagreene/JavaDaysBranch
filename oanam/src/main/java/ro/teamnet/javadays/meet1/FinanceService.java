package ro.teamnet.javadays.meet1;

/**
 * Created with IntelliJ IDEA.
 * User: gerard.dragoi
 * Date: 5/4/12
 * Time: 10:23 AM
 * To change this template use File | Settings | File Templates.
 */
public interface FinanceService {
    FinanceData getStockData(String symbol, String stat) throws FinanceDataUnavailableException;

}
