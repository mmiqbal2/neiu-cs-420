import countriesfx.apireadata.CallNioReadFile;
import countriesfx.models.Countries;
import countriesfx.models.InfectionCategory;
import countriesfx.apireadata.FilterCountries;
import countriesfx.views.ComboBoxDisplay;
import countriesfx.views.Radiobuttons;
import countriesfx.models.IRetriveData;
import getapidata.TestRetreiveData;
import getapidata.WriteData;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;

public class CovidApp extends Application {
    Scene scene1, scene2;
    private ComboBoxDisplay comboBoxDisplay;
    private Radiobuttons rb;
    private Stage stage;

    public static void main(String[] args) throws IOException {

        IRetriveData t = new TestRetreiveData();
        new WriteData();
        String urlString = "https://api.covid19api.com/summary";
        t.connection(urlString);
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) {
        rb = new Radiobuttons();
        comboBoxDisplay = new ComboBoxDisplay();
        new ToggleGroup();
        CallNioReadFile callNioReadFile = new CallNioReadFile();
        FilterCountries fc = new FilterCountries();
        callNioReadFile.callNio();
        fc.readFileData();
        BorderPane borderPane = new BorderPane();
        setUpBorderPane(borderPane);
        stage = Scene1(borderPane);
        stage.show();
    }


    private Stage Scene1(BorderPane borderPane) {

        scene1 = new Scene(borderPane, 800, 500);
        Stage stage = new Stage();
        stage.setScene(scene1);
        stage.setTitle("TrackCovid App");
        return stage;

    }


    private void setUpBorderPane(BorderPane borderPane){
        HBox hBox = new HBox();
        setUpHBox(hBox);
        borderPane.setTop(hBox);
        Button btn = new Button("Click Here To See Charts");
        btn.setOnAction(e -> {
            BorderPane borderPane1 = new BorderPane();
            setUpBorderPane1(borderPane1);
            scene2 = new Scene(borderPane1, 800, 500);
            stage.setScene(scene2);
        });

        HBox SBox = new HBox();
        SBox.getChildren().add(comboBoxDisplay.getListView());
        SBox.getChildren().add(btn);
        borderPane.setRight(SBox);

    }

    private void setUpHBox(HBox hBox) {
        hBox.setSpacing(10);
        ComboBox<InfectionCategory> categories = comboBoxDisplay.getCategories();
        ComboBox<Countries> countryList = comboBoxDisplay.getCountries();
        hBox.getChildren().addAll(categories,countryList, comboBoxDisplay.getListView());
        HBox.setMargin(categories, new Insets(20, 5, 5,10));
        HBox.setMargin(countryList, new Insets(20, 5, 5,5));
    }

    private void setUpBorderPane1(BorderPane borderPane1){
        VBox vBox = rb.getvBox();
        borderPane1.setTop(vBox);
    }

}
