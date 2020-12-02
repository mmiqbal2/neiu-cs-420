import countriesfx.views.BorderpaneSetup;
import countriesfx.models.IRetriveData;
import getapidata.TestRetreiveData;
import getapidata.WriteData;
import javafx.application.Application;

import javafx.stage.Stage;

import java.io.IOException;

public class CovidApp extends Application {

    public static void main(String[] args) throws IOException {

        IRetriveData t = new TestRetreiveData();
        new WriteData();
        String urlString = "https://api.covid19api.com/summary";
        t.connection(urlString);
        launch(args);

    }

    public void start(Stage primaryStage) {
        BorderpaneSetup borderpaneSetup = new BorderpaneSetup();
        borderpaneSetup.show();
    }

}
