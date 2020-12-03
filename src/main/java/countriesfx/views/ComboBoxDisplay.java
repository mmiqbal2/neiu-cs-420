package countriesfx.views;
import countriesfx.models.Countries;
import countriesfx.models.InfectionCategory;
import static countriesfx.apireadata.FilterCountries.*;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.StringConverter;
import java.util.*;
import java.util.stream.Collectors;

public class ComboBoxDisplay {
    private ComboBox<InfectionCategory> categories;
    private ComboBox<Countries> countries;
    private final ListView<String> listView;
    private final Map<InfectionCategory, List<Countries>> countriesListMap;
    private final ObservableList<InfectionCategory> countryList;

    public ComboBoxDisplay() {
        countriesListMap = getMappedCountries();
        countryList = observableArrayList(countriesListMap.keySet());
        listView = new ListView<>();
        listView.setMaxHeight(100);
        setUpCategories();
        setUpCountries();
    }

    private static class countriesStringConverter extends StringConverter<Countries> {

        @Override
        public String toString(Countries c) {
            if (c == null)
                return null;
            else
                return c.getCountry();

        }

        @Override
        public Countries fromString(String string) {
            String SEP = ", Country: ";
            int id = Integer.parseInt(string.split(SEP)[1]);
            List<Countries> CountryList = data.stream().filter(Countries -> Countries.equals(id))
                    .limit(1)
                    .collect(Collectors.toList());
            return CountryList.isEmpty() ? null : CountryList.get(0);

        }
    }

    private void setUpCategories() {
        categories = new ComboBox<>();
        categories.getItems().addAll(sortCountryList());
        categories.setPromptText("Select a Category");
        categories.valueProperty().addListener((observable, oldValue, newValue) -> {
            countries.getItems().clear();
            countries.getItems().addAll(countriesListMap.get(newValue));
            countries.setVisible(true);

        });
    }

    private ObservableList<InfectionCategory> sortCountryList() {
        return countryList.sorted(Comparator.comparingInt(InfectionCategory::getStart));
    }

    private void setUpCountries() {
        countries = new ComboBox<>();
        countries.setPromptText("Select a Country");
        countries.setConverter(new countriesStringConverter());
        countries.setVisible(true);
        createCountriesSelectionListener();
        handleComboBoxUpdate();
    }

    private void handleComboBoxUpdate() {
        countries.setButtonCell(new ListCell<>() {
            @Override
            protected void updateItem(Countries c, boolean empty) {
                super.updateItem(c, empty);
                if (empty || c == null) {
                    setText("Select a Country");
                } else {
                    countriesStringConverter converter = new countriesStringConverter();
                    setText(converter.toString(c));
                }
            }
        });
    }

    private void createCountriesSelectionListener() {
        listView.setVisible(false);
        countries.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                String displayText = "Date: " + newValue.getCurrentDate() + "\n"
                        + "Country: " + newValue.getCountry() + "\n"
                        + "New Confirmed: " + newValue.getNewConfirmed() + "\n"
                        + "Total Confirmed: " + newValue.getTotalConfirmed() + "\n"
                        + "NewDeaths: " + newValue.getNewDeaths();
                listView.getItems().clear();
                listView.getItems().addAll(displayText);
                listView.setVisible(true);
            }
        });
    }

    public ComboBox<InfectionCategory> getCategories() {
        return categories;
    }

    public ComboBox<Countries> getCountries() {
        return countries;
    }

    public ListView<String> getListView() {
        return listView;
    }
}

