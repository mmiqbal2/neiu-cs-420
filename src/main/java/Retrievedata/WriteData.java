package Retrievedata;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class WriteData {

    File f = new File("src/main/resources/covid.txt");

    public void WriteData(String result) {
        try {
            FileWriter myWriter = new FileWriter(f,true);
            if (f.createNewFile()) {
                System.out.println("File created: " + f.getName());
                myWriter.write(result);
            } else {
                myWriter.write(result);
            }
            myWriter.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

