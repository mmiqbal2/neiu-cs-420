package GetApiData;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.ws.rs.HttpMethod;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class TestRetreiveData {
    public static Object ReadApi;

    public static void ReadApi(WriteData f, HttpURLConnection connection) throws IOException, ParseException {
        if (connection.getResponseCode() == 200) {
            final InputStream inputStream = connection.getInputStream();
            final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            JSONParser parser = new JSONParser();
            JSONObject allRoute = (JSONObject) parser.parse(bufferedReader.readLine());
            JSONArray results = (JSONArray) allRoute.get("Countries");
            returnData(f, results);
        }
    }

    public static void returnData(WriteData f, JSONArray results) {
        String s = "";
        for (Object r: results) {
            JSONObject result = (JSONObject) r;
            s = " Date: " +result.get("Date") +" Country: " +result.get("Country")
                    +" NewConfirmed: " +result.get("NewConfirmed")  +" TotalConfirmed: " +result.get("TotalConfirmed") +"\n";

            f.WriteData(s);
        }
    }

    public static void connection(String urlString) throws IOException, ParseException {
        final int connectTimeout = 1000;
        final URL url = new URL(urlString);
        TestRetreiveData t = new TestRetreiveData();
        WriteData f = new WriteData();

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setConnectTimeout(connectTimeout);
        connection.setRequestMethod(HttpMethod.GET);
        connection.setRequestProperty("format", "json");
        System.out.println(connection.getResponseCode());
//              System.out.println(connection.getHeaderFields());

        t.ReadApi(f, connection);

    }
}
