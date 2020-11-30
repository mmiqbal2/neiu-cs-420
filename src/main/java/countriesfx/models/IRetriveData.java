package countriesfx.models;

import getapidata.WriteData;

import java.io.IOException;
import java.net.HttpURLConnection;

public interface IRetriveData {
    void readApi(WriteData f, HttpURLConnection connection) throws IOException;
    void connection (String urlString) throws IOException ;
}
