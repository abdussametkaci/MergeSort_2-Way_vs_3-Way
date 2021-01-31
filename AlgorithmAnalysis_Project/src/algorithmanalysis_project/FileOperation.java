// This program save test results to a file
package algorithmanalysis_project;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class FileOperation {
    public static void writeFile(String data, String filename){
        try {
            String currentDirectory = System.getProperty("user.dir");
            //System.out.println("The current working directory is " + currentDirectory);
            BufferedWriter out = new BufferedWriter(new FileWriter(currentDirectory + "\\src\\" + filename, true));
            out.write(data);
            out.close();
            //System.out.println("File created successfully");
        } catch (IOException e) {
            System.out.println("File not created");
        }
    }
    
}
