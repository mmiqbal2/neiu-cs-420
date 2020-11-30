package countriesfx.apireadata;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Exception {

    void fileexception(FileNotFoundException e) {
        System.out.println("The file was not found");
    }

    public void Ioexception(IOException e) {
        System.out.println("An error occurred.");
    }
}
