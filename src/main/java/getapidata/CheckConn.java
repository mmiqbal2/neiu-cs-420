package getapidata;

import org.json.simple.parser.ParseException;

import java.io.IOException;

public class CheckConn {

    public static void main(String[] args) throws IOException, ParseException {
        TestRetreiveData t = new TestRetreiveData();
        WriteData f = new WriteData();
        String urlString = "https://api.covid19api.com/summary";
        t.connection(urlString);

    }
}
