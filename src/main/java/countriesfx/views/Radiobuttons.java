package countriesfx.views;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import static countriesfx.apireadata.FilterCountries.*;

public class Radiobuttons {

    private RadioButton Radiob1, Radiob2, Radiob3;
    Radiobdata rb = new Radiobdata();
    private final ToggleGroup toggleGroup;
    private VBox vBox;


    public Radiobuttons() {
        toggleGroup = new ToggleGroup();
        setUpBorderPane1();
    }

    private void setUpBorderPane1(){
        vBox = new VBox(50);
        setUpVBox1();
    }

    private void setUpVBox1() {

        Radiob1 = new RadioButton("Totalconfirmed cases vs Newconfirmed cases");
        Radiob1.setStyle("-fx-font: 14px 'Tahoma';");
        Radiob2 = new RadioButton("Countries by COVID-19 Cases - Top 20");
        Radiob2.setStyle("-fx-font: 14px 'Tahoma';");
        Radiob3 = new RadioButton("Deaths caused by COVID-19 Cases - Top 20");
        Radiob3.setStyle("-fx-font: 14px 'Tahoma';");
        Radiob3.setStyle("-fx-font: 14px 'Tahoma';");
        Radiob1.setToggleGroup(toggleGroup);
        Radiob2.setToggleGroup(toggleGroup);
        Radiob3.setToggleGroup(toggleGroup);
        toggleGroup.selectedToggleProperty().addListener(new CovidRadioListener());
        Label labelBox = new Label("Charts");
        labelBox.setStyle("-fx-font: 16px 'Tahoma';");
        VBox labelVbox = new VBox();
        labelVbox.setAlignment(Pos.CENTER);
        labelVbox.getChildren().add(labelBox);

        vBox.getChildren().addAll(labelVbox, Radiob1, Radiob2, Radiob3);
    }

    public VBox getvBox() {
        return vBox;
    }

    private class CovidRadioListener implements ChangeListener<Toggle> {

        @Override
        public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {

            if(newValue.equals(Radiob1)) {

                Scene scene1 = new Scene(new Group());
                Stage stage = new Stage();
                stage.setTitle("Total confirmed and Total Newconfirmed Cases "+ "On " + getTodayD());
                rb.Piechartdata(scene1, stage);

            }
            else {
                Stage stage = new Stage();
                if(newValue.equals(Radiob2)) {

                    stage.setTitle("Countries by COVID-19 Cases - Top 20 ");
                    rb.Stackedbargraph(stage);
                }
                else {
                    stage.setTitle("Top 20 Covid-19 Countries Deaths Bar-Chart "+ "On "+ getTodayD());
                    rb.DBgraph(stage);
                }
                stage.show();
            }
        }
    }

}


