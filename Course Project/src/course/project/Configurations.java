 package course.project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Configurations {
    private int waterLevel, robustaLevel, arabicaLevel, servedCups;

    public Configurations() {
         try {
            File configFile = new File("config.txt");
            Scanner reader = new Scanner(configFile);
            int[] values = new int[4];
            
            for (int i = 0; i < 4; i++) {
                String line = reader.nextLine();
                
                for (int j = 0; j < line.length(); j++) {
                    if (line.charAt(j) == '=') {
                        values[i] = Integer.parseInt(line.substring(j + 2));
                        break;
                    }
                }
            }
            
            waterLevel = values[0];
            robustaLevel = values[1];
            arabicaLevel = values[2];
            servedCups = values[3];
        }
        catch(FileNotFoundException ex) {
            try {
                File file = new File("config.txt");
                if (file.createNewFile()) {
                    JOptionPane.showMessageDialog(null, "Configurations file was not found, a new one is created!");
                }
            } 
            catch (IOException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                System.exit(0);
            }
        }
    }
    
    public void update(int waterLevel, int robustaLevel, int arabicaLevel, int servedCups) {
        this.waterLevel = waterLevel;
        this.robustaLevel = robustaLevel;
        this.arabicaLevel = arabicaLevel;
        this.servedCups = servedCups;
        
        File configFile = new File("config.txt");
        FileWriter fileWriter = null;
        try{
            fileWriter = new FileWriter(configFile);
            fileWriter.write("Water level = " + waterLevel + "\n");
            fileWriter.write("Robusta level = " + robustaLevel + "\n");
            fileWriter.write("Arabica level = " + arabicaLevel + "\n");
            fileWriter.write("Number of served cups = " + servedCups + "\n");
        }
        catch(FileNotFoundException ex) {
            try {
                File file = new File("config.txt");
                if (file.createNewFile()) {
                    JOptionPane.showMessageDialog(null, "Configurations file was not found, a new one is created!");
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
                    JOptionPane.showMessageDialog(null, "Could not close the configurations file!");
                    System.exit(0);
                }
            }
        }
    }

    public int getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(int waterLevel) {
        this.waterLevel = waterLevel;
    }

    public int getRobustaLevel() {
        return robustaLevel;
    }

    public void setRobustaLevel(int robustaLevel) {
        this.robustaLevel = robustaLevel;
    }

    public int getArabicaLevel() {
        return arabicaLevel;
    }

    public void setArabicaLevel(int arabicaLevel) {
        this.arabicaLevel = arabicaLevel;
    }

    public int getServedCups() {
        return servedCups;
    }

    public void setServedCups(int servedCups) {
        this.servedCups = servedCups;
    }
}
