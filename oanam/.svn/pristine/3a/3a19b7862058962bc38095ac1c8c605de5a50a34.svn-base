package ro.teamnet.javadays.meet1.dao;

import com.google.common.base.Preconditions;
import ro.teamnet.javadays.meet1.FinanceData;

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

    private static final String STOCK_HISTORY_FILE = "stock_info_history.txt";

    private final File historyFile;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

    private static final String STOCK_INFO_RECORD_FORMAT =
            "%s,%s,%s,%s,%s";

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
            fileWriter.write(String.format(STOCK_INFO_RECORD_FORMAT,
                    dateFormat.format(new Date()), financeData.getSymbol(), financeData.getPrice(),
                    financeData.getChange(), financeData.getVolume()));

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
