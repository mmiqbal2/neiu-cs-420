package countriesfx.views;

import countriesfx.models.Countries;
import countriesfx.models.InfectionCategory;

import static countriesfx.models.FilterCountries.*;
import static javafx.collections.FXCollections.observableArrayList;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.text.Text;
import javafx.util.StringConverter;

import java.util.*;

public class ComboBoxDisplay {
    private ComboBox<InfectionCategory> categories;
    private ComboBox<Countries> countries;
    private Text textBox;
    private final Map<InfectionCategory, List<Countries>> countriesListMap;
    private final ObservableList<InfectionCategory> countryList;

    public ComboBoxDisplay(){
        countriesListMap = getMappedCountries();
        countryList = observableArrayList(countriesListMap.keySet());
        textBox = new Text();
        setUpCategories();
        setUpCountries();
    }

    private class countriesStringConverter extends StringConverter<Countries>{
        private final String SEP = ", Country: ";

        @Override
        public String toString(Countries c) {
            if  (c == null)
                return null;
            else
                return c.getCountry();


        }

        @Override
        public Countries fromString(String string) {
            int id = Integer.parseInt(string.split(SEP)[1]);
            for (Countries c : data)
                if (c.getCountry().equals(id)) {
                    return c;
                }
                return null;
            }

    }

    private void setUpCategories(){
        categories = new ComboBox<>();
        categories.getItems().addAll(sortcountryList());
        categories.setPromptText("Select a Category");
        categories.valueProperty().addListener(new ChangeListener<InfectionCategory>() {
            @Override
            public void changed(ObservableValue<? extends InfectionCategory> observable, InfectionCategory oldValue, InfectionCategory newValue) {
                textBox.setVisible(false);
                countries.getItems().clear();
                countries.getItems().addAll(countriesListMap.get(newValue));
                countries.setVisible(true);
            }
        });
    }

    private ObservableList<InfectionCategory> sortcountryList(){
        return countryList.sorted(new Comparator<InfectionCategory>() {
            @Override
            public int compare(InfectionCategory o1, InfectionCategory o2) {
                if(o1.getStart() < o2.getStart())
                    return -1;
                else if(o1.getStart() > o2.getStart())
                    return 1;
                else
                    return 0;
            }
        });

    }

    private void setUpCountries(){
        countries = new ComboBox<>();
        countries.setPromptText("Select a Country");
        countries.setConverter(new countriesStringConverter());
        countries.setVisible(true);
        createCountriesSelectionListener();
        handleComboBoxUpdate();
    }

    private void handleComboBoxUpdate(){
        countries.setButtonCell(new ListCell<>(){
            @Override
            protected void updateItem(Countries c, boolean empty){
                super.updateItem(c, empty);
                if(empty || c == null){
                    setText("Select a Country");
                }
                else{
                    countriesStringConverter converter = new countriesStringConverter();
                    setText(converter.toString(c));
                }
            }
        });
    }

    private void createCountriesSelectionListener(){
        countries.valueProperty().addListener(new ChangeListener<Countries>() {
            @Override
            public void changed(ObservableValue<? extends Countries> observable, Countries oldValue, Countries newValue) {
                if(newValue != null){
                    String displayText = "Date: " + newValue.getCurrentDate() + "\n"
                            + "Country: " + newValue.getCountry() + "\n"
                            + "New Confirmed: "+ newValue.getNewConfirmed() + "\n"
                            +"Total Confirmed: "+ newValue.getTotalConfirmed();
                    textBox.setText(displayText);
                    textBox.setVisible(true);
                }
            }
        });
    }

    public ComboBox<InfectionCategory> getCategories() {
        return categories;
    }


    public ComboBox<Countries> getCountries() {
        return countries;
    }

    public Text getTextBox() {
        return textBox;
    }
}
