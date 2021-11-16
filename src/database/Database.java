/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author Ivan Ryzhankow, Alina Yermakova
 */

public class Database 
{

    /**
     * @param args the command line arguments
     */
    
     ArrayList<Patient> patients = new ArrayList<Patient>();
     ArrayList<Patient> patientsMale = new ArrayList<Patient>();
     ArrayList<Patient> patientsFemale = new ArrayList<Patient>();
    
    
    public void readFile(ArrayList<Patient> patients) throws Exception
    {
        int i1, i2, i3, i4, i5;
        double d1, d2, d3;
        FileReader fr = new FileReader("Dataset/Dataset.txt");
        Scanner scan = new Scanner(fr);
        
        while (scan.hasNext())
        {     
            i1 = Integer.valueOf(scan.next());
            i2 = Integer.valueOf(scan.next());
            i3 = Integer.valueOf(scan.next());
            d1 = Double.valueOf(scan.next());
            d2 = Double.valueOf(scan.next());
            d3 = Double.valueOf(scan.next());
            i4 = Integer.valueOf(scan.next());
            i5 = Integer.valueOf(scan.next());
            
            patients.add(new Patient(i1, i2, i3, d1, d2, d3, i4, i5));
        }
        fr.close();     
    }
    
    public void readFileMale(ArrayList<Patient> patientsMale) throws Exception
    {
        int i1, i2, i3, i4, i5;
        double d1, d2, d3;
        FileReader fr = new FileReader("Dataset/Dataset.txt");
        Scanner scan = new Scanner(fr);
        
        while (scan.hasNext())
        {     
            i1 = Integer.valueOf(scan.next());
            i2 = Integer.valueOf(scan.next());
            i3 = Integer.valueOf(scan.next());
            d1 = Double.valueOf(scan.next());
            d2 = Double.valueOf(scan.next());
            d3 = Double.valueOf(scan.next());
            i4 = Integer.valueOf(scan.next());
            i5 = Integer.valueOf(scan.next());
            
            if (i3 != 1)
                continue;
            
            patientsMale.add(new Patient(i1, i2, i3, d1, d2, d3, i4, i5));
        }
        fr.close();     
    }
    
    public void readFileFemale(ArrayList<Patient> patientsFemale) throws Exception
    {
        int i1, i2, i3, i4, i5;
        double d1, d2, d3;
        FileReader fr = new FileReader("Dataset/Dataset.txt");
        Scanner scan = new Scanner(fr);
        
        while (scan.hasNext())
        {     
            i1 = Integer.valueOf(scan.next());
            i2 = Integer.valueOf(scan.next());
            i3 = Integer.valueOf(scan.next());
            d1 = Double.valueOf(scan.next());
            d2 = Double.valueOf(scan.next());
            d3 = Double.valueOf(scan.next());
            i4 = Integer.valueOf(scan.next());
            i5 = Integer.valueOf(scan.next());
            
            if (i3 == 1)
                continue;
            
            patientsFemale.add(new Patient(i1, i2, i3, d1, d2, d3, i4, i5));
        }
        fr.close();     
    }    
    
    
    public static void main(String[] args) throws Exception
    {        
        Database database = new Database();  
        Statistics statistics = new Statistics();
        Statistics statisticsMale = new Statistics();
        Statistics statisticsFemale = new Statistics();
        
        database.readFile(database.patients); 
        database.readFileMale(database.patientsMale);
        database.readFileFemale(database.patientsFemale);        
        
        for (int i=0; i<database.patientsFemale.size(); i++)
        {
            //System.out.println(database.patientsFemale.get(i).toString());
        } 
        
        statistics.setAverageAge(database.patients);
        statistics.setAverageHeight(database.patients);
        statistics.setAverageWeight(database.patients);
        System.out.println(statistics.getAverageAge());
        System.out.println(statistics.getAverageHeight());
        System.out.println(statistics.getAverageWeight());
    }    
}


