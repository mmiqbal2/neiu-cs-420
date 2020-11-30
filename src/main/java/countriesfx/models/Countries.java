package countriesfx.models;

import java.util.*;

public class Countries {

    private String CurrentDate;
    private String Country;
    private int NewConfirmed;
    private int TotalConfirmed;
    private int NewDeaths;

    public Countries(String currentDate, String country, int newConfirmed, int totalConfirmed, int newDeaths) {
        CurrentDate = currentDate;
        Country = country;
        NewConfirmed = newConfirmed;
        TotalConfirmed = totalConfirmed;
        NewDeaths = newDeaths;
    }

    public int getNewDeaths() { return NewDeaths; }

    public String getCurrentDate() {
        return CurrentDate;
    }

    public String getCountry() {
        return Country;
    }

    public int getNewConfirmed() {
        return NewConfirmed;
    }
    
    public int getTotalConfirmed() {
        return TotalConfirmed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Countries countries = (Countries) o;
        return  CurrentDate.equals(countries.CurrentDate) &&
                NewConfirmed == countries.NewConfirmed &&
                TotalConfirmed == countries.TotalConfirmed &&
                NewDeaths == countries.NewDeaths &&
                Objects.equals(Country, countries.Country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CurrentDate, Country, NewConfirmed, TotalConfirmed, NewDeaths);
    }


    @Override
    public String toString() {
        return "\nCountries{" +
                "CurrentDate=" + CurrentDate +
                ", County=" + Country +
                ", NewConfirmed=" + NewConfirmed +
                ", TotalConfirmed=" + TotalConfirmed +
                ", NewDeaths=" + NewDeaths +
                "}";
    }

}
