import countriesfx.models.CallNioReadFile;
import countriesfx.models.Countries;
import countriesfx.models.InfectionCategory;
import countriesfx.models.FilterCountries;
import countriesfx.views.ComboBoxDisplay;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CovidApp extends Application {

    private ComboBoxDisplay comboBoxDisplay;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        comboBoxDisplay = new ComboBoxDisplay();
        CallNioReadFile callNioReadFile = new CallNioReadFile();
        FilterCountries fc = new FilterCountries();
        callNioReadFile.callNio();
        fc.readFileData();
        BorderPane borderPane = new BorderPane();
        setUpBorderPane(borderPane);
        Scene scene = new Scene(borderPane, 1000, 200);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Covid-19");
        stage.show();

    }

    private void setUpBorderPane(BorderPane borderPane){
        HBox hBox = new HBox();
        setUpHBox(hBox);
        borderPane.setTop(hBox);
    }

    private void setUpHBox(HBox hBox) {
        hBox.setSpacing(10);
        ComboBox<InfectionCategory> categories = comboBoxDisplay.getCategories();
        ComboBox<Countries> countryList = comboBoxDisplay.getCountries();
        Text textBox = comboBoxDisplay.getTextBox();
        hBox.getChildren().addAll(categories,countryList, textBox);
        HBox.setMargin(categories, new Insets(20, 5, 5,10));
        HBox.setMargin(countryList, new Insets(20, 5, 5,5));
        HBox.setMargin(textBox, new Insets(20, 5, 5,5));
    }

}
