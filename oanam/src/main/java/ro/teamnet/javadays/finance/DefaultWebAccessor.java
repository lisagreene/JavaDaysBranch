package ro.teamnet.javadays.finance;

import com.google.common.io.CharStreams;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: gerard.dragoi
 * Date: 5/4/12
 * Time: 9:33 AM
 * To change this template use File | Settings | File Templates.
 */
public class DefaultWebAccessor implements WebAccessor {
    @Override
    public String getContent(URL theURL) throws WebAccessException {

        try {
            return CharStreams.toString(new InputStreamReader(theURL.openStream()));
        } catch (IOException e) {
            throw new WebAccessException(e);
        }
    }



    public static void main(String[] args) throws Exception{
        final URL theURL = URI.create("http://finance.yahoo.com/d/quotes.csv?s=GOOG&f=l1c1va2xj1b4j4dyekjm3m4rr5p5p6s7").toURL();
        System.out.println(new DefaultWebAccessor().getContent(theURL));
    }
}
