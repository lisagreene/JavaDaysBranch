package ro.teamnet.javadays.finance.dao;

import com.google.common.base.Preconditions;
import ro.teamnet.javadays.finance.FinanceData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: gerard.dragoi
 * Date: 5/9/12
 * Time: 9:50 AM
 * To change this template use File | Settings | File Templates.
 */
public class FlatFileStockInfoDao implements StockInfoDao {

    private final File rootDir;

    private static final String STOCK_HISTORY_FILE = "stock_info_history.csv";

    private final File historyFile;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    private static final String STOCK_INFO_RECORD_FORMAT =
            "%s,%s,%s,%s,%s,%s\n";

    public FlatFileStockInfoDao(File rootDir) {

        this.rootDir = checkDirectoryExistsOrCreateIt(rootDir);
        this.historyFile = new File(rootDir, STOCK_HISTORY_FILE);
    }

    private File checkDirectoryExistsOrCreateIt(File rooDir) {
        Preconditions.checkNotNull(rooDir);
        rooDir.mkdirs();
        return rooDir;
    }

    @Override
    public boolean save(FinanceData financeData) throws DataAccessException {
        return doSaveInfFile(financeData, this.historyFile);

    }

    private boolean doSaveInfFile(FinanceData financeData, File historyFile) {
        boolean success;
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(this.historyFile, true);
            String data = String.format(STOCK_INFO_RECORD_FORMAT,
                    dateFormat.format(new Date()), financeData.getSymbol(),
                    financeData.getPrice(), financeData.getChange(),
                    financeData.getVolume(), financeData.getName());
            fileWriter.write(data);

            fileWriter.flush();
            success = true;
        } catch (IOException e) {
            throw new DataAccessException(e);
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException shouldNotReachHere) {
                    //e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        }
        return success;
    }


    public static void main(String[] args) {
        final FlatFileStockInfoDao flatFileStockInfoDao = new FlatFileStockInfoDao(new File("D:/etc/file  txt"));
        System.out.println(flatFileStockInfoDao.rootDir);
    }
}
