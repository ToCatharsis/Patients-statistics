package database;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;

import static database.Const.*;


/**
 * The main class of the project with main function and functions to read data from database.
 * Has a list of patients.
 * @author Ivan Ryzhankow, Alina Yermakova
 * @version 1.0.0
 */

public class Database 
{

    /**
     * The list of patients read from database.
     */    
     ArrayList<Patient> patients = new ArrayList<>();
    
     /**
      * Function used to read data from file and to write it down to the list of patients.
      * Written data may be sorted by weight, height and age.
      * @param patients ArrayList to which data of patients will be written.
      * @param minWg The lowest weight of the patients.
      * @param maxWg The highest weight of the patients.
      * @param minWz The lowest height of the patients.
      * @param maxWz The highest height of the patients.
      * @param minWk The lowest age of the patients.
      * @param maxWk The highest age of the patients.
      */
    public void readFile(ArrayList<Patient> patients, double minWg, double maxWg, 
             double minWz, double maxWz, int minWk, int maxWk) 
    {
        FileReader fr = null;
        try 
        {
            // i1 - participantID
            // i2 - age
            // i3 - male
            // i4 - digitSymbolSubstitutionTest
            // i5 - numberInfarcts
            // d1 - weight
            // d2 - height
            // d3 - ankleArmRatio
            int i1, i2, i3, i4, i5;
            double d1, d2, d3;
            String s;
             
            fr = new FileReader("Dataset/Dataset.txt");
            Scanner scan = new Scanner(fr);
            while (scan.hasNext())
            {
                i1 = Integer.valueOf(scan.next());
                i2 = Integer.valueOf(scan.next());
                i3 = Integer.valueOf(scan.next());
                d1 = Double.valueOf(scan.next());
                d2 = Double.valueOf(scan.next());
                s = scan.next();
                if (s.equals("NA"))
                    d3 = NA_REPLACEMENT_DOUBLE;
                else
                    d3 = Double.valueOf(s);
                s = scan.next();
                if (s.equals("NA"))
                    i4 = NA_REPLACEMENT_INT;
                else
                    i4 = Integer.valueOf(s);
                i5 = Integer.valueOf(scan.next());
                 
                if (d1*LB_TO_KG_RATIO>=minWg && d1*LB_TO_KG_RATIO<=maxWg && d2>=minWz && d2<=maxWz && i2>=minWk 
                    && i2<=maxWk) 
                {
                    patients.add(new Patient(i1, i2, i3, d1, d2, d3, i4, i5));
                }
            }        
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println(e.getMessage());
        } 
        finally 
        {
           try           
           {
               fr.close();
           } 
           catch (IOException e) 
           {
               System.out.println(e.getMessage());
           }
        }
    }
    
    /**
     * Function used to read data from file and to write it down to the list of patients soretd by sex.
     * Written data may be sorted by weight, height and age.
     * @param patients ArrayList to which data of patients will be written.
     * @param sex The sex of patients we need.
     * @param minWg The lowest weight of the patients.
     * @param maxWg The highest weight of the patients.
     * @param minWz The lowest height of the patients.
     * @param maxWz The highest height of the patients.
     * @param minWk The lowest age of the patients.
     * @param maxWk The highest age of the patients.
     */
    public void readFileSex(ArrayList<Patient> patients, String sex, double minWg, 
             double maxWg, double minWz, double maxWz, int minWk, int maxWk)
    {
        // i1 - participantID
        // i2 - age
        // i3 - male
        // i4 - digitSymbolSubstitutionTest
        // i5 - numberInfarcts
        // d1 - weight
        // d2 - height
        // d3 - ankleArmRatio
        int i1, i2, i3, i4, i5;
        double d1, d2, d3;
        String s;
        FileReader fr = null;
        try
        {
            fr = new FileReader("Dataset/Dataset.txt");
            Scanner scan = new Scanner(fr);
        
            while (scan.hasNext())
            {     
                i1 = Integer.valueOf(scan.next());
                i2 = Integer.valueOf(scan.next());
                i3 = Integer.valueOf(scan.next());
                d1 = Double.valueOf(scan.next());
                d2 = Double.valueOf(scan.next());
                s = scan.next();
                if (s.equals("NA"))
                    d3 = NA_REPLACEMENT_DOUBLE;
                else
                    d3 = Double.valueOf(s);
                s = scan.next();
                if (s.equals("NA"))
                    i4 = NA_REPLACEMENT_INT;
                else
                    i4 = Integer.valueOf(s);
                i5 = Integer.valueOf(scan.next());

                if (d1*LB_TO_KG_RATIO>=minWg && d1*LB_TO_KG_RATIO<=maxWg && d2>=minWz && d2<=maxWz && i2>=minWk 
                        && i2<=maxWk) 
                {
                    if (i3 == 1 && "Male".equals(sex))
                    {patients.add(new Patient(i1, i2, i3, d1, d2, d3, i4, i5));}
                    if (i3 == 0 && "Female".equals(sex))
                    {patients.add(new Patient(i1, i2, i3, d1, d2, d3, i4, i5));}
                }
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            try 
            {
                fr.close();
            } 
            catch (IOException e) 
            {
                System.out.println(e.getMessage());
            }
        }
    }
    
    /**
     * The main function of the project, which represents the work of the program.
     * @param args Arguments which can be written before staring the programm, but not used.
     */
    public static void main(String[] args)
    {        
        Database database = new Database();  
        try
        {
            GUIDatabase app = new GUIDatabase();
            app.setVisible(true);
         
            database.readFileSex(database.patients, "Male", 0, 125, 0, 195, 0, 120);       
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }    
}


