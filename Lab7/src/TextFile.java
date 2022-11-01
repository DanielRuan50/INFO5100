import javax.swing.*;
import java.io.*;

public class TextFile {

    public void writeTextFile(JTextArea display, String fileName) {     // writeTextFile()
        try {
            FileWriter outStream = new FileWriter (fileName);           //Create object outStream of FileWriter class


            outStream.write (display.getText());                        // write display into fileName
            outStream.close();
        } catch (IOException e) {                                       //catch error
            display.setText("IOERROR: " + e.getMessage() + "\n");
            e.printStackTrace();
        }
    }

    public void readTextFile(JTextArea display, String fileName) {        // readTextFile()
        try {
            BufferedReader inStream                                      // Create and open the stream
                    = new BufferedReader (new FileReader(fileName));
            String line = inStream.readLine();                           // Read one line
            int i = 0;
            while (line != null && i < 5) {                               // While more text no more than five lines
                display.append(line + "\n");                             // add a line and \n
                line = inStream.readLine();                              // Read one line
                i++;                                                     //next line
            }
            inStream.close();                                             // Close the stream
        } catch (FileNotFoundException e) {                               //catch error
            display.setText("IOERROR: "+ fileName +" NOT found\n");
            e.printStackTrace();
        } catch (IOException e) {
            display.setText("IOERROR: " + e.getMessage() + "\n");
            e.printStackTrace();
        }
    }

    public void readTextFile1(JTextArea display, String fileName) {         // readTextFile1()
        try {
            BufferedReader inStream                                       // Create and open the stream
                    = new BufferedReader (new FileReader(fileName));
            String line = inStream.readLine();                           // Read one line
            int i = 0;

            while (line != null && i < 5) {                             // While more text no more than five lines
                String[] str = line.split(",");                     // split by ,
                for(int j = 0; j < 3; j++) {
                    if(j == 2){
                        display.append(str[j]);
                        display.append("\n");                            // add a line and \n
                        break;
                    }
                    display.append(str[j] + ",");                        // add a field and ,

                }
                line = inStream.readLine();                            // Read next line
                i++;
            }
            inStream.close();                                              // Close the stream
        } catch (FileNotFoundException e) {                               //catch error
            display.setText("IOERROR: "+ fileName +" NOT found\n");
            e.printStackTrace();
        } catch (IOException e) {
            display.setText("IOERROR: " + e.getMessage() + "\n");
            e.printStackTrace();
        }
    }
}
