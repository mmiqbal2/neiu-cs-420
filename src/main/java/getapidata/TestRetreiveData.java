package getapidata;
import countriesfx.models.IRetriveData;
import org.json.JSONObject;
import javax.ws.rs.HttpMethod;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestRetreiveData  implements IRetriveData {
    public List<String> titles;
    public List<String> results;

    public void readApi(WriteData f, HttpURLConnection connection) throws IOException {
        if (connection.getResponseCode() == 200) {
            final InputStream inputStream = connection.getInputStream();
            final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            Stream<String> lines = bufferedReader.lines();

            this.titles = lines
                    .map(line -> new JSONObject(line).getJSONArray("Countries"))
                    .map(jsonArray -> {
                        results = new ArrayList<>();
                        for (int i = 0; i < jsonArray.length(); i++) {
                            results.add("\n" +"Date: " + jsonArray.getJSONObject(i).get("Date").toString()+ " ");
                            results.add("Country: " +jsonArray.getJSONObject(i).get("Country").toString()+" ");
                            results.add("NewConfirmed: "+jsonArray.getJSONObject(i).get("NewConfirmed").toString()+" ");
                            results.add("TotalConfirmed: "+ jsonArray.getJSONObject(i).get("TotalConfirmed").toString()+" ");
                            results.add("NewDeaths: "+ jsonArray.getJSONObject(i).get("NewDeaths").toString() +" ");
                        }
                        f.WriteData(results.toString());
                        return results;

                    })
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList());
        }
    }

        public void connection (String urlString) throws IOException {

            final int connectTimeout = 1000;
            final URL url = new URL(urlString);
            WriteData f = new WriteData();

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(connectTimeout);
            connection.setRequestMethod(HttpMethod.GET);
            connection.setRequestProperty("format", "json");
            this.readApi(f, connection);

        }

}
