package ro.teamnet.javadays.finance.dao;

import ro.teamnet.javadays.finance.FinanceData;

/**
 * Created with IntelliJ IDEA.
 * User: gerard.dragoi
 * Date: 5/9/12
 * Time: 9:14 AM
 * To change this template use File | Settings | File Templates.
 */
public interface StockInfoDao {
    boolean save(FinanceData financeData) throws DataAccessException;
}
