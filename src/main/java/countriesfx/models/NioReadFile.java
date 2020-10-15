package countriesfx.models;

import java.io.*;
import java.util.Scanner;

public class NioReadFile {


    public String ReadFile() {
       FilterCountries NIOtoFC = new FilterCountries();
       String data = "";
       try {
           File path = new File("src" + File.separator + "main" + File.separator + "resources" + File.separator + "covid.txt");

           Scanner myReader = new Scanner(path);
           while (myReader.hasNextLine()) {
                data = myReader.nextLine();
           }
           myReader.close();
       } catch (FileNotFoundException e) {
           System.out.println("An error occurred.");
           e.printStackTrace();
       }


       return data;
   }

    public NioReadFile() {
    }

}


