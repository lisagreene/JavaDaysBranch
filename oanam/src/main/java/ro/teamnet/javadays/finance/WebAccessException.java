package ro.teamnet.javadays.finance;

/**
 * Created with IntelliJ IDEA.
 * User: gerard.dragoi
 * Date: 5/2/12
 * Time: 9:37 AM
 * To change this template use File | Settings | File Templates.
 */
public class WebAccessException extends RuntimeException {

    public WebAccessException(String message) {
        super(message);    //To change body of overridden methods use File | Settings | File Templates.
    }

    public WebAccessException(String message, Throwable cause) {
        super(message, cause);    //To change body of overridden methods use File | Settings | File Templates.
    }

    public WebAccessException(Throwable cause) {
        super(cause);    //To change body of overridden methods use File | Settings | File Templates.
    }

    protected WebAccessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
