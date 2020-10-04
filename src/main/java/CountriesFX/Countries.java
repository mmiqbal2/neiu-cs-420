package CountriesFX;

import java.util.*;

public class Countries {

    private String CurrentDate;
    private String County;
    private int NewConfirmed;
    private int TotalConfirmed;

    public Countries(String currentDate, String country, int newConfirmed, int totalConfirmed) {
        CurrentDate = currentDate;
        County = country;
        NewConfirmed = newConfirmed;
        TotalConfirmed = totalConfirmed;
    }

    public String getCurrentDate() {
        return CurrentDate;
    }

    public void setCurrentDate(String currentDate) {
        CurrentDate = currentDate;
    }

    public String getCounty() {
        return County;
    }

    public void setCounty(String county) {
        County = county;
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
        return CurrentDate == countries.CurrentDate &&
                NewConfirmed == countries.NewConfirmed &&
                TotalConfirmed == countries.TotalConfirmed &&
                Objects.equals(County, countries.County);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CurrentDate, County, NewConfirmed, TotalConfirmed);
    }


    @Override
    public String toString() {
        return "\nCountries{" +
                "CurrentDate=" + CurrentDate +
                ", County='" + County + '\'' +
                ", NewConfirmed=" + NewConfirmed +
                ", TotalConfirmed=" + TotalConfirmed +
                "}";

    }
}
