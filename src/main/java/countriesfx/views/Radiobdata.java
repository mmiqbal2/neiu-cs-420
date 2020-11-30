package countriesfx.views;

import countriesfx.apireadata.FilterCountries;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.*;

import javafx.stage.Stage;

import java.util.Map;

import static countriesfx.apireadata.FilterCountries.*;
import static countriesfx.apireadata.FilterCountries.filteredConfirmList;

public class Radiobdata {

    void Piechartdata(Scene scene1, Stage stage) {
        stage.setWidth(700);
        stage.setHeight(500);
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("NewConfirmed: "+ totalNc , FilterCountries.totalNc),
                        new PieChart.Data("TotalConfirmed: " + totalTc, FilterCountries.totalTc));
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle(" Global Summary");
        ((Group) scene1.getRoot()).getChildren().add(chart);
        stage.setScene(scene1);
        stage.show();
    }

    void Stackedbargraph(Stage stage) {
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final StackedBarChart<String, Number> bc =
                new StackedBarChart<>(xAxis, yAxis);
        bc.setTitle("Countries by COVID-19 Cases - Top 20 ");
        xAxis.setLabel("Top Countries");
        yAxis.setLabel("Total Cases By Persons");

        XYChart.Series series1 = new XYChart.Series();
        XYChart.Series series2 = new XYChart.Series();
        int count=0;
        series1.setName("Total Confirmed: "+ totalTc);
        series2.setName("New Confirmed: "+ totalNc);
        for (Map.Entry<String,Integer> entry: filteredCountryList.entrySet()) {
            if(count==20) {
                break;
            }
            series2.getData().add(new XYChart.Data(entry.getKey(), filteredConfirmList.get(entry.getKey())));
            series1.getData().add(new XYChart.Data(entry.getKey(), entry.getValue()));
            count++;
        }
        Scene scene2  = new Scene(bc,800,600);
        bc.getData().addAll(series1, series2);
        stage.setScene(scene2);
        stage.show();
    }

    void DBgraph(Stage stage) {
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc =
                new BarChart<>(xAxis, yAxis);
        bc.setTitle("Deaths caused by COVID-19 Cases - Top 20");
        xAxis.setLabel("Countries");
        yAxis.setLabel("Deaths By Persons");

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Total Deaths: " + totalNd );
        int count=0;
        for (Map.Entry<String,Integer> entry: filteredDeathList.entrySet()) {
            if(count==20) {
                break;
            }
            else {
                series1.getData().add(new XYChart.Data(entry.getKey(), entry.getValue()));
                count++;
            }
        }
        Scene scene2  = new Scene(bc,800,600);
        bc.getData().addAll(series1);
        stage.setScene(scene2);
    }

}
