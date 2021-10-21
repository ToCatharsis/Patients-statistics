/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.ArrayList;

/**
 *
 * @author ToCatharsis
 */
public class Database 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        ArrayList<Patient> list = new ArrayList<Patient>();
        Patient patient1 = new Patient("John", "Watson", 30);
        
        list.add(patient1);
        list.size();
        for (int i=0; i<list.size(); i++)
        {
            
        }
    }
    
}
