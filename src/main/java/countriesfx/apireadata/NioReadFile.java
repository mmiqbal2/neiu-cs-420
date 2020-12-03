package countriesfx.apireadata;

import java.io.*;
import java.util.Scanner;

public class NioReadFile {

    Exception exception = new Exception();

    public String ReadFile() {
       String data = "";
       try {
           File path = new File("src" + File.separator + "main" + File.separator + "resources" + File.separator + "covid.txt");

           Scanner myReader = new Scanner(path);
           while (myReader.hasNextLine()) {
                data = myReader.nextLine();
           }
           myReader.close();
       } catch (FileNotFoundException e) {
           exception.fileexception(e);
       }
       return data;
   }

    public NioReadFile() {
    }

}


