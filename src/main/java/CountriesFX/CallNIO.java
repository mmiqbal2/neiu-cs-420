package CountriesFX;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ComboBox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CallNIO {

    private static String data;

      public void CallNIO(){
        NIOreadFile NIO = new NIOreadFile();
        FilterCountries FC = new FilterCountries();
        NIO.ReadFile();
        FC.FileData();
        System.out.println(FC);
    }

     ComboBox<Countries> secondBox(FilterCountries fc, ComboBox<EnumCountries> categories) {
        final ComboBox<Countries> subCategory = new ComboBox<Countries>();
        subCategory.setVisible(false);

        categories.valueProperty().addListener(new ChangeListener<EnumCountries>() {
            @Override
            public void changed(ObservableValue<? extends EnumCountries> observable, EnumCountries oldValue, EnumCountries newValue) {
                subCategory.getItems().clear();
                subCategory.getItems().addAll(
                        fc.getMapping().get(newValue)
                );
                subCategory.setVisible(true);
            }
        });
        return subCategory;
    }

     ComboBox<EnumCountries> firstBox(FilterCountries fc) {
        final ComboBox<EnumCountries> categories = new ComboBox<>();
        categories.setPromptText("Select a Category");
        List sortedKeys = new ArrayList(fc.getMapping().keySet());
        Collections.sort(sortedKeys);
        categories.getItems().addAll(sortedKeys);
        return categories;
    }
}
