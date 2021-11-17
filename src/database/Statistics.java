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
        int counter=0;
        
        for (int i=0; i<patients.size(); i++)
        {
            if (patients.get(i).getAnkleArmRatio() == 2000.0)
                counter++;
            else
                amountAnkleArmRatio += patients.get(i).getAnkleArmRatio();
        }
        averageAnkleArmRatio = amountAnkleArmRatio/(patients.size() - counter);
    }
    
    public void setAverageDigitSymbolSubstitutionTest (ArrayList<Patient> patients)
    {
        double amountDigitSymbolSubstitutionTest=0;
        int counter=0;
        
        for (int i=0; i<patients.size(); i++)
        {
            if (patients.get(i).getDigitSymbolSubstitutionTest() == 2000)
                counter++;
            else
                amountDigitSymbolSubstitutionTest += patients.get(i).getDigitSymbolSubstitutionTest();
        }
        averageDigitSymbolSubstitutionTest = amountDigitSymbolSubstitutionTest/(patients.size() - counter);
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
