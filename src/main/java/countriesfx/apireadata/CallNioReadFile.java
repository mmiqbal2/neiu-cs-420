package countriesfx.apireadata;


public class CallNioReadFile {

      public void callNio(){
        NioReadFile nReadf = new NioReadFile();
        FilterCountries filterCountries = new FilterCountries();
        nReadf.ReadFile();
        filterCountries.readFileData();
    }

    public CallNioReadFile() {
    }
}
