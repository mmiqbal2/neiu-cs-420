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
        CN.BoxCreator(stage, fc);

    }

}
