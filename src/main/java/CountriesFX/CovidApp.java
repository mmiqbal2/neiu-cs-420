package CountriesFX;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CovidApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        CallNIO CN = new CallNIO();
        FilterCountries fc = new FilterCountries();
        CN.CallNIO();
        fc.FileData();


        final ComboBox<EnumCountries> categories = CN.firstBox(fc);

        final ComboBox<Countries> subCategory = CN.secondBox(fc, categories);

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
