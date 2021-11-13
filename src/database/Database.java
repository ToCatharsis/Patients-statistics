/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.BufferedReader;
import java.io.Reader;
import java.util.ArrayList;

/**
 *
 * @author Ivan Ryzhankow
 */
public class Database 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Patient patient1 = new Patient(1, 72, "1", 173.0, 169.0, 1.0303, 25, 1);
        Patient patient2 = new Patient(2, 82, "0", 139.0, 170.0, 1.1104, 51, 3);
        
        PatientsList list = new PatientsList();
        list.patients.add(patient1);
        list.patients.add(patient2);
        
        for (int i=0; i<list.patients.size(); i++)
        {
            System.out.println(list.patients.get(i).toString());
        }
    }    
}


