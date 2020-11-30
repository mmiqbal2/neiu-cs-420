package countriesfx.apireadata;

import countriesfx.models.Countries;
import countriesfx.models.InfectionCategory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CountriesMapping {


    HashMap<InfectionCategory, List<Countries>> cMap = new HashMap<>();

    public HashMap<InfectionCategory,List<Countries>> countryMap(List<Countries> values)
    {
        List<Countries> low = new ArrayList<>();
        List<Countries> high = new ArrayList<>();
        List<Countries> medium = new ArrayList<>();
        getValues(values, low, high, medium);
        cMap.put(InfectionCategory.LOW,low);
        cMap.put(InfectionCategory.MEDIUM,medium);
        cMap.put(InfectionCategory.HIGH,high);
        return cMap;
    }

    private void getValues(List<Countries> values, List<Countries> low, List<Countries> high, List<Countries> medium) {

        for (Countries value : values) {
            if (value.getTotalConfirmed() <= InfectionCategory.LOW.getStop()) {
                low.add(value);
            } else if (value.getTotalConfirmed() > InfectionCategory.MEDIUM.getStart() && value.getTotalConfirmed() <= InfectionCategory.MEDIUM.getStop()) {
                medium.add(value);
            } else if (value.getTotalConfirmed() > InfectionCategory.HIGH.getStart() && value.getTotalConfirmed() <= InfectionCategory.HIGH.getStop()) {
                high.add(value);
            }
        }
    }

}
