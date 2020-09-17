package Retrievedata;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.*;
import java.net.HttpURLConnection;

class TestRetreiveData {
    public static Object ReadApi;

    public static void ReadApi(WriteData f, HttpURLConnection connection) throws IOException, ParseException {
        if (connection.getResponseCode() == 200) {
                final InputStream inputStream = connection.getInputStream();
                final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                JSONParser parser = new JSONParser();
                JSONObject allRoute = (JSONObject) parser.parse(bufferedReader.readLine());
                JSONArray results = (JSONArray) allRoute.get("Countries");
                System.out.println(results);
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

}
