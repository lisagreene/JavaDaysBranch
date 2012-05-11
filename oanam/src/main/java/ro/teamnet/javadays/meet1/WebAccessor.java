package ro.teamnet.javadays.meet1;

import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: gerard.dragoi
 * Date: 5/2/12
 * Time: 9:36 AM
 * To change this template use Fle | Settings | File Templates.
 */
public interface WebAccessor {
    String getContent(URL theURL) throws WebAccessException;

}
