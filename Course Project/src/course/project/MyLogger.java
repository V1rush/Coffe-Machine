package course.project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class MyLogger {
    public static void log(String message) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        File logFile = new File("log.txt");
        FileWriter fileWriter = null;
        try{
            fileWriter = new FileWriter(logFile, true);
            fileWriter.write(formattedDateTime + " | " + message + ".\n");
        }
        catch(FileNotFoundException ex) {
            try {
                File file = new File("log.txt");
                if (file.createNewFile()) {
                    JOptionPane.showMessageDialog(null, "Log file was not found, a new one is created!");
                }
            } 
            catch (IOException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        catch(IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
        finally{
            if(fileWriter != null){
                try{
                    fileWriter.close();
                }
                catch(IOException ex){
                    JOptionPane.showMessageDialog(null, "Could not close the log file!");
                    System.exit(0);
                }
            }
        }
    }
}