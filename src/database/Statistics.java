/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.ArrayList;

/**
 *
 * @author Ivan Ryzhankow, Alina Yermakova
 */
public class Statistics 
{
    private double averageAge;
    private double averageWeight;
    private double averageHeight;
    private double averageAnkleArmRatio;
    private double averageDigitSymbolSubstitutionTest;
    private double averageNumberInfarcts;
    
    public double getAverageAge() {return averageAge;}
    public double getAverageWeight() {return averageWeight;}
    public double getAverageHeight() {return averageHeight;}
    public double getAverageAnkleArmRatio() {return averageAnkleArmRatio;}
    public double getAverageDigitSymbolSubstitutionTest() {return averageDigitSymbolSubstitutionTest;}
    public double getAverageNumberInfarcts() {return averageNumberInfarcts;}
    
    public void setAverageAge (ArrayList<Patient> patients)
    {
        double amountAge=0;
        
        for (int i=0; i<patients.size(); i++)
        {
            amountAge += patients.get(i).getAge();
        }
        averageAge = amountAge/patients.size();
    }
    
    public void setAverageWeight (ArrayList<Patient> patients)
    {
        double amountWeight=0;
        
        for (int i=0; i<patients.size(); i++)
        {
            amountWeight += patients.get(i).getWeight();
        }
        averageWeight = amountWeight/patients.size();
    }
    
    public void setAverageHeight (ArrayList<Patient> patients)
    {
        double amountHeight=0;
        
        for (int i=0; i<patients.size(); i++)
        {
            amountHeight += patients.get(i).getHeight();
        }
        averageHeight = amountHeight/patients.size();
    }
    
    public void setAverageAnkleArmRatio (ArrayList<Patient> patients)
    {
        double amountAnkleArmRatio=0;
        
        for (int i=0; i<patients.size(); i++)
        {
            amountAnkleArmRatio += patients.get(i).getAnkleArmRatio();
        }
        averageAnkleArmRatio = amountAnkleArmRatio/patients.size();
    }
    
    public void setAverageDigitSymbolSubstitutionTest (ArrayList<Patient> patients)
    {
        double amountDigitSymbolSubstitutionTest=0;
        
        for (int i=0; i<patients.size(); i++)
        {
            amountDigitSymbolSubstitutionTest += patients.get(i).getDigitSymbolSubstitutionTest();
        }
        averageDigitSymbolSubstitutionTest = amountDigitSymbolSubstitutionTest/patients.size();
    }
    
    public void setAverageNumberInfarcts (ArrayList<Patient> patients)
    {
        double amountNumberInfarcts=0;
        
        for (int i=0; i<patients.size(); i++)
        {
            amountNumberInfarcts += patients.get(i).getNumberInfarcts();
        }
        averageNumberInfarcts = amountNumberInfarcts/patients.size();
    }
    
}
