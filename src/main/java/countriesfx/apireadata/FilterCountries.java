package countriesfx.apireadata;

import countriesfx.models.Countries;
import countriesfx.models.InfectionCategory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class FilterCountries {

    public static ArrayList<Countries> data;
    public static int totalNc=0,totalTc=0,totalNd=0;
    public static String todayD;
    public Map<String,Integer> countryList =new HashMap<>();
    public static Map<String,Integer> filteredCountryList =new HashMap<>();
    public  Map<String,Integer> deathList = new HashMap<>();
    public  Map<String,Integer> confirmedList = new HashMap<>();
    public static Map<String,Integer> filteredDeathList = new HashMap<>();
    public static Map<String,Integer> filteredConfirmList = new HashMap<>();

    public void readFileData() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/covid.txt"))) {
            data = new ArrayList<>();
            String date = "", country = "";
            int nc = 0, tc = 0, nd = 0;
            splitted(br, date, country, nc, tc, nd);
            getMapping();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HashMap<InfectionCategory, List<Countries>> getMapping() {
        CountriesMapping countriesMapping = new CountriesMapping();
        return (countriesMapping.countryMap(data));
    }

    private void splitted(BufferedReader br, String date, String country, int nc, int tc, int nd) throws IOException {
        String[] line;
        String coun;
        while ((coun = br.readLine()) != null) {
            line = coun.split(" ");
            for (int i = 0; i < line.length; i++){
            if (!line[i].equals("Date:") && !line[i].equals("Country:") && !line[i].equals("[") && !line[i].equals("]") && !line[i].equals("NewConfirmed:")
                                         && !line[i].equals("TotalConfirmed:") && !line[i].equals(" ")&&!line[i].equals(",") &&!line[i].equals("NewDeaths:")) {
                if (line[i - 1].equals("Date:")) {
                    date = line[i];
                    todayD = line[i];
                } else if (line[i - 1].equals("Country:")) {
                    country = line[i];
                } else if (line[i - 1].equals("NewConfirmed:")) {
                    nc = Integer.parseInt(line[i]);
                    totalNc+=nc;
                } else if (line[i - 1].equals("TotalConfirmed:")) {
                    tc = Integer.parseInt(line[i]);
                    totalTc+=tc;
                } else if (line[i-1].equals("NewDeaths:")) {
                    nd = Integer.parseInt(line[i]);
                    totalNd+=nd;
                }
                else {
                    country = country + " " + line[i];
                }

            }
        }

            deathList.put(country,nd);
            countryList.put(country,tc);
            confirmedList.put(country, nc);

           filteredDeathList = mapSort(deathList);
           filteredCountryList = mapSort(countryList);
           filteredConfirmList = mapSort(confirmedList);
            addToList(date, country, nc, tc, nd);

        }
    }
    private static Map<String, Integer> mapSort(Map<String, Integer> countryList) {

        List<Map.Entry<String, Integer>> list =
                new LinkedList<>(countryList.entrySet());

        Collections.sort(list, new Comparator<>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        Map<String, Integer> mapSorting = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> e : list) {
            mapSorting.put(e.getKey(), e.getValue());
        }
        return mapSorting;
    }


    private void addToList(String date, String country, int nc, int tc, int nd) {
        Countries countries;
        countries = new Countries(date, country, nc, tc, nd);
        data.add(countries);
    }

    public static HashMap<InfectionCategory, List<Countries>> getMappedCountries() {
        FilterCountries filterCountries = new FilterCountries();
        filterCountries.readFileData();
        return filterCountries.getMapping();
    }

    public static String getTodayD() {
        return todayD;
    }

}
