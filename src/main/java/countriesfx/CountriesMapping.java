package countriesfx;

import java.util.*;

public class CountriesMapping {


    HashMap<EnumCountries,List<Countries>> cMap = new HashMap<>();

    public HashMap<EnumCountries,List<Countries>> countryMap(List<Countries> values)
    {
        List<Countries> low = new ArrayList<>();
        List<Countries> high = new ArrayList<>();
        List<Countries> medium = new ArrayList<>();
        getvalues(values, low, high, medium);
        cMap.put(EnumCountries.LOW,low);
        cMap.put(EnumCountries.MEDIUM,medium);
        cMap.put(EnumCountries.HIGH,high);

        return cMap;
    }

    private void getvalues(List<Countries> values, List<Countries> low, List<Countries> high, List<Countries> medium) {

        for(int i = 0; i< values.size(); i++)
        {
            if(values.get(i).getTotalConfirmed()<=EnumCountries.LOW.getStop())
            {
                low.add(values.get(i));
            }
            else if(values.get(i).getTotalConfirmed()>EnumCountries.MEDIUM.getStart() && values.get(i).getTotalConfirmed()<=EnumCountries.MEDIUM.getStop())
            {
                medium.add(values.get(i));
            }
            else if (values.get(i).getTotalConfirmed()>EnumCountries.HIGH.getStart() && values.get(i).getTotalConfirmed() <= EnumCountries.HIGH.getStop())
            {
                high.add(values.get(i));
            }
        }
    }

}
