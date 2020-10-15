package countriesfx.models;

import java.util.*;

public class Countries {

    private String CurrentDate;
    private String Country;
    private int NewConfirmed;
    private int TotalConfirmed;

    public Countries(String currentDate, String country, int newConfirmed, int totalConfirmed) {
        CurrentDate = currentDate;
        Country = country;
        NewConfirmed = newConfirmed;
        TotalConfirmed = totalConfirmed;
    }

    public String getCurrentDate() {
        return CurrentDate;
    }

    public void setCurrentDate(String currentDate) {
        CurrentDate = currentDate;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public int getNewConfirmed() {
        return NewConfirmed;
    }

    public void setNewConfirmed(int newConfirmed) {
        NewConfirmed = newConfirmed;
    }

    public int getTotalConfirmed() {
        return TotalConfirmed;
    }

    public void setTotalConfirmed(int totalConfirmed) {
        TotalConfirmed = totalConfirmed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Countries countries = (Countries) o;
        return CurrentDate.equals(countries.CurrentDate) &&
                NewConfirmed == countries.NewConfirmed &&
                TotalConfirmed == countries.TotalConfirmed &&
                Objects.equals(Country, countries.Country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CurrentDate, Country, NewConfirmed, TotalConfirmed);
    }


    @Override
    public String toString() {
        return "\nCountries{" +
                "CurrentDate=" + CurrentDate +
                ", County='" + Country + '\'' +
                ", NewConfirmed=" + NewConfirmed +
                ", TotalConfirmed=" + TotalConfirmed +
                "}";

    }
}
