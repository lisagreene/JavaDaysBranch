package ro.teamnet.javadays.meet1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created with IntelliJ IDEA.
 * User: gerard.dragoi
 * Date: 4/30/12
 * Time: 10:06 AM
 * To change this template use File | Settings | File Templates.
 */
public class LamePolySample {
    private static final String baseURLFormat = "http://somewebservice.com/nok=%s";

    private final WebAccessor webAccessor;

    public LamePolySample(WebAccessor webAccessor) {
        this.webAccessor = webAccessor;
    }

    public String getNOK(String indicator) {
        final URL theURL = buildURL(indicator);
        return this.webAccessor.getContent(theURL);
    }

    private URL buildURL(String indicator) {
        final String formattedURL = String.format( baseURLFormat, indicator);
        try {
            return  URI.create(URLEncoder.encode(formattedURL)).toURL();
        } catch (MalformedURLException e) {
           throw new WebAccessException(e);
        }
    }

    public static String readContent(InputStream is) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder(2048);
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        reader.close();
        final String result = sb.toString();
        return result;
    }

    public static void main(String[] args) throws Exception {



    }
}
