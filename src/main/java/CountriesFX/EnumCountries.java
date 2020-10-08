package CountriesFX;

public enum EnumCountries {
    LOW(0,30000),
    MEDIUM(30000, 100000),
    HIGH(100000, 1000000);

    private final int start;
    private final int stop;

    EnumCountries(int start, int stop) {
        this.start = start;
        this.stop = stop;
    }

    public int getStart() {
        return start;
    }

    public int getStop() {
        return stop;
    }
}
