package GetApiData;

import org.json.simple.parser.ParseException;

import javax.ws.rs.HttpMethod;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

public class CheckConn {

    public static void main(String[] args) throws IOException, ParseException {
        TestRetreiveData t = new TestRetreiveData();
        WriteData f = new WriteData();
        String urlString = "https://api.covid19api.com/summary";
        t.connection(urlString);

    }
}
