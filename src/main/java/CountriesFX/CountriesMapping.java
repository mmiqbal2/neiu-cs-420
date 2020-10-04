package CountriesFX;

import java.util.*;

public class CountriesMapping {


    HashMap<String,List<Countries>> cMap = new HashMap<>();

    public HashMap<String,List<Countries>> countryMap(List<Countries> values)
    {
        List<Countries> low = new ArrayList<>();
        List<Countries> high = new ArrayList<>();
        List<Countries> medium = new ArrayList<>();
        getvalues(values, low, high, medium);
        cMap.put("LOW",low);
        cMap.put("MEDIUM",medium);
        cMap.put("HIGH",high);
        System.out.println(cMap);

        return cMap;
    }

    private void getvalues(List<Countries> values, List<Countries> low, List<Countries> high, List<Countries> medium) {
        for(int i = 0; i< values.size(); i++)
        {
            if(values.get(i).getTotalConfirmed()<=30000)
            {
                low.add(values.get(i));
            }
            else if(values.get(i).getTotalConfirmed()>30000 && values.get(i).getTotalConfirmed()<=100000)
            {
                medium.add(values.get(i));
            }
            else if (values.get(i).getTotalConfirmed()>100000)
            {
                high.add(values.get(i));
            }
        }
    }

}
