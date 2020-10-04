package CountriesFX;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FilterCountries {

    NIOreadFile file = new NIOreadFile();
    public static ArrayList<Countries> data;


    public static void FileData(){
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/covid.txt"))) {
            data = new ArrayList<>();
            String date="", country="";
            int nc =0, tc = 0;
            splitted(br, date, country, nc, tc);
//            CountriesMapping countriesMapping = new CountriesMapping();
//            countriesMapping.countryMap(data);
            getMapping();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static HashMap<String,List<Countries>> getMapping(){
        CountriesMapping countriesMapping = new CountriesMapping();
        return (countriesMapping.countryMap(data));

    }

    private static void splitted(BufferedReader br, String date, String country, int nc, int tc) throws IOException {
        String[] line;
        String coun;
        while ((coun=br.readLine()) != null) {
            line = coun.split(" ");
            for(int i=0;i<line.length;i++) {
                if (!line[i].equals("Date:") && !line[i].equals("Country:") && !line[i].equals("NewConfirmed:") && !line[i].equals("TotalConfirmed:") && !line[i].equals("")) {
                    if (line[i-1].equals("Date:")) {
                        date = line[i];
                    }
                    else if (line[i-1].equals("Country:")) {
                        country = line[i];
                    }
                    else if (line[i-1].equals("NewConfirmed:")) {
                        nc = Integer.parseInt(line[i]);
                    }
                    else if(line[i-1].equals("TotalConfirmed:")) {
                        tc = Integer.parseInt(line[i]);
                    }
                    else {
                        country= country +" " +line[i];
                    }

                }
            }
            AddtoList(date, country, nc, tc);
        }
    }

    private static void AddtoList(String date, String country, int nc, int tc) {
        Countries countries;
        countries = new Countries(date, country, nc, tc);
        data.add(countries);
    }

}
