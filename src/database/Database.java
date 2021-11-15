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
 * @author Ivan Ryzhankow
 */

public class Database 
{

    /**
     * @param args the command line arguments
     */
    
     ArrayList<Patient> patients = new ArrayList<Patient>();  
    
    
    public static void readFile(ArrayList<Patient> patients) throws Exception
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
            
            /*
            System.out.println(i1+ " " + i2 + " " + i3 + " " + d1 + " " + d2 +
                    " " + d3 + " " + i4 + " " + i5);
            */
        }
        fr.close();     
    }
    
    
    public static void main(String[] args) throws Exception
    {        
        Database database = new Database();        
        database.readFile(database.patients);        
        
        for (int i=0; i<database.patients.size(); i++)
        {
            System.out.println(database.patients.get(i).toString());
        }        
    }    
}


