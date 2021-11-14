/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author Ivan Ryzhankow
 */
public class Database 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception
    {        
        PatientsList list = new PatientsList();        
        list.readFile(list.patients);        
        
        for (int i=0; i<list.patients.size(); i++)
        {
            System.out.println(list.patients.get(i).toString());
        }        
    }    
}


