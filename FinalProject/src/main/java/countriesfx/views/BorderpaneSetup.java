package countriesfx.views;

import countriesfx.apireadata.CallNioReadFile;
import countriesfx.apireadata.FilterCountries;
import countriesfx.models.Countries;
import countriesfx.models.InfectionCategory;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BorderpaneSetup {
    Scene scene1, scene2;
    private ComboBoxDisplay comboBoxDisplay;
    private Radiobuttons rb;
    private Stage stage;
    Label label = new Label();

    public BorderpaneSetup(){
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
    }

    public   void show(){
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
        VBox vbox = new VBox();
        HBox hBox = new HBox();
        label = new Label("Welcome to my TrackCovid App");
        label.setStyle("-fx-font: 14px 'Tahoma';");
        VBox labelVBox = new VBox();
        labelVBox.getChildren().add(label);
        labelVBox.setAlignment(Pos.CENTER);
        vbox.getChildren().add(labelVBox);
        setUpHBox(hBox);
        Button btn = new Button("Click Here To See Charts");
        Button btn2 = new Button("Back");
        btn2.setOnAction(e -> {

            stage.setScene(scene1);
        });
        VBox btn2Vbox = new VBox();
        btn2Vbox.setAlignment(Pos.CENTER);
        btn2Vbox.setPadding(new Insets(0, 0, 10, 0));
        btn2Vbox.getChildren().add(btn2);
        btn.setOnAction(e -> {
            BorderPane borderPane1 = new BorderPane();
            setUpBorderPane1(borderPane1);
            borderPane1.setBottom(btn2Vbox);
            scene2 = new Scene(borderPane1, 800, 500);
            stage.setScene(scene2);
        });
        vbox.getChildren().add(hBox);

        HBox SBox = new HBox();
        SBox.getChildren().add(comboBoxDisplay.getListView());
        SBox.getChildren().add(btn);
        VBox listVbox = new VBox();
        listVbox.setPadding(new Insets(50.0, 0, 0, 0));
        VBox btnVBox = new VBox();
        btnVBox.getChildren().add(btn);
        btnVBox.setPadding(new Insets(50.0, 0, 0, 0));
        btnVBox.setAlignment(Pos.CENTER);
        listVbox.getChildren().add(comboBoxDisplay.getListView());
        vbox.getChildren().addAll(listVbox, btnVBox);
        borderPane.setCenter(vbox);
    }

    private void setUpHBox(HBox hBox) {
        hBox.setSpacing(10);
        ComboBox<InfectionCategory> categories = comboBoxDisplay.getCategories();
        ComboBox<Countries> countryList = comboBoxDisplay.getCountries();
        hBox.getChildren().addAll(categories,countryList, comboBoxDisplay.getListView());
        HBox.setMargin(categories, new Insets(20, 5, 5,5));
        HBox.setMargin(countryList, new Insets(20, 5, 5,5));

    }

    private void setUpBorderPane1(BorderPane borderPane1){
        VBox vBox = rb.getvBox();
        vBox.setPadding(new Insets(10.0, 0.0, 0,10.0));

        borderPane1.setCenter(vBox);
    }

}
