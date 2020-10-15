package countriesfx.models;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ComboBox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CallNioReadFile {

    private static String data;

      public void callNio(){
        NioReadFile nReadf = new NioReadFile();
        FilterCountries filterCountries = new FilterCountries();
        nReadf.ReadFile();
        filterCountries.readFileData();
    }

    public CallNioReadFile() {
    }
}
