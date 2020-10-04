package CountriesFX;

import com.sun.javafx.collections.MappingChange;
import com.sun.javafx.collections.SourceAdapterChange;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Category;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.logging.Filter;

public class CovidApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        CallNIO CN = new CallNIO();
        FilterCountries fc = new FilterCountries();
        CN.CallNIO();
        fc.FileData();
        final ComboBox<String> categories = new ComboBox<>();
        categories.setPromptText("Select a Category");
        categories.getItems().addAll(
                fc.getMapping().keySet()
        );

        final ComboBox<Countries> subCategory = new ComboBox<Countries>();
        subCategory.setVisible(false);

        categories.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                subCategory.getItems().clear();
                subCategory.getItems().addAll(
                        fc.getMapping().get(newValue)
                );
                    subCategory.setVisible(true);
            }
        });

        BorderPane pane = new BorderPane();
        pane.setTop(categories);
        pane.setCenter(subCategory);
        Scene scene = new Scene(pane, 300, 300);
        stage.setScene(scene);
        stage.setTitle("Covid-19");
        stage.show();

    }
}
