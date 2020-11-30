package getapidata;

import countriesfx.apireadata.Exception;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteData {

    File f = new File("src/main/resources/covid.txt");
    Exception exception = new Exception();
    public void WriteData(String result) {
        try {
            FileWriter myWriter = new FileWriter(f,false);
            if (f.createNewFile()) {
                System.out.println("File created: " + f.getName());
                myWriter.write(result);
            } else {
                myWriter.write(result);
            }
            myWriter.close();

        } catch (IOException e) {
            exception.Ioexception(e);
        }
    }
}
