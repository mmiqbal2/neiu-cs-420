import countriesfx.CallNIO;
import countriesfx.Countries;
import countriesfx.EnumCountries;
import countriesfx.FilterCountries;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class CovidApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        CallNIO callNIO = new CallNIO();
        FilterCountries fc = new FilterCountries();
        callNIO.CallNIO();
        fc.FileData();


        final ComboBox<EnumCountries> categories = callNIO.firstBox(fc);

        final ComboBox<Countries> subCategory = callNIO.secondBox(fc, categories);

        BorderPane pane = new BorderPane();
        pane.setTop(categories);
        pane.setCenter(subCategory);
        Scene scene = new Scene(pane, 300, 300);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Covid-19");
        stage.show();

    }


}
