package Retrievedata;

import org.json.simple.JSONArray;

import javax.ws.rs.HttpMethod;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

public class CheckConn {

        public static void main(String[] args) throws UnsupportedEncodingException {
            TestRetreiveData t = new TestRetreiveData();
            WriteData f = new WriteData();
            String urlString = "https://api.covid19api.com/summary";
            final int connectTimeout = 1000;

            try {
                final URL url = new URL(urlString);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setConnectTimeout(connectTimeout);
                connection.setRequestMethod(HttpMethod.GET);
                connection.setRequestProperty("format", "json");
                System.out.println(connection.getResponseCode());
              //  System.out.println(connection.getHeaderFields());

                t.ReadApi(f, connection);
            }
            catch (Exception e) {
                System.out.println(e.toString());
            }

        }
}

