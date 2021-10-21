/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author ToCatharsis
 */
public class Patient extends List
{
    private String name;
    private String surname;
    private int age;
    
    Patient() {}
    
    Patient(String name, String surname, int age) 
    {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
    
    void information()
    {
        System.out.println("Name: " + name + "\n" + "Surname: " + surname + "\n"
                           + "Age: " + age + "\n");
    }
}
