package CountriesFX;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class CallNIO {

    private static String data;

      public void CallNIO(){
        NIOreadFile NIO = new NIOreadFile();
        FilterCountries FC = new FilterCountries();
        NIO.ReadFile();
        FC.FileData();
        System.out.println(FC);
    }

    public void BoxCreator(Stage stage, FilterCountries fc) {
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
