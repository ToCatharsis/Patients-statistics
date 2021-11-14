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
public class Patient extends PatientsList
{
    private int participantID;
    private int age;
    private boolean male;
    private double weight;
    private double height;
    private double ankleArmRatio;
    private int digitSymbolSubstitutionTest;
    private int numberInfarcts;
    
    
    Patient(String participantID, String age, String male, String weight, 
            String height, String ankleArmRatio, 
            String digitSymbolSubstitutionTest, String numberInfarcts) 
    {
        this.participantID = Integer.valueOf(participantID);
        this.age = Integer.valueOf(age);
        this.male = Boolean.valueOf((male == "1" ? "true" : "false"));
        this.weight = Double.valueOf(weight)*0.454;
        this.height = Double.valueOf(height);
        this.ankleArmRatio = Double.valueOf(ankleArmRatio);
        this.digitSymbolSubstitutionTest = Integer.valueOf(digitSymbolSubstitutionTest);
        this.numberInfarcts = Integer.valueOf(numberInfarcts);
    }
    
    Patient(int participantID, int age, int male, double weight, 
            double height, double ankleArmRatio, 
            int digitSymbolSubstitutionTest, int numberInfarcts) 
    {
        this.participantID = Integer.valueOf(participantID);
        this.age = Integer.valueOf(age);
        this.male = Boolean.valueOf((male == 1 ? "true" : "false"));
        this.weight = Double.valueOf(weight)*0.454;
        this.height = Double.valueOf(height);
        this.ankleArmRatio = Double.valueOf(ankleArmRatio);
        this.digitSymbolSubstitutionTest = Integer.valueOf(digitSymbolSubstitutionTest);
        this.numberInfarcts = Integer.valueOf(numberInfarcts);
    }
    

    public int getParticipantID() {return participantID;}
    
    public int getAge() {return age;}
    
    public boolean isMale() {return male;}
    
    public double getWeight() {return weight;}
    
    public double getHeight() {return height;}
    
    public double getAnkleArmRatio() {return ankleArmRatio;}
    
    public int getDigitSymbolSubstitutionTest() {return digitSymbolSubstitutionTest;}
    
    public int getNumberInfarcts() {return numberInfarcts;}
    
    
    public void setParticipantID(int participantID)
    {
        this.participantID = participantID;
    }
    
    public void setAge(int age)
    {
        this.age = age;
    }
    
    public void setMale(boolean male)
    {
        this.male = male;
    }
    
    public void setWeight(double weight)
    {
        this.weight = weight;
    }
    
    public void setHeight(double height)
    {
        this.height = height;
    }
    
    public void setAnkleArmRatio(double ankleArmRatio)
    {
        this.ankleArmRatio = ankleArmRatio;
    }
    
    public void setAnkleArmRatio(int digitSymbolSubstitutionTest)
    {
        this.digitSymbolSubstitutionTest = digitSymbolSubstitutionTest;
    }
    
    public void setNumberInfarcts(int numberInfarcts)
    {
        this.numberInfarcts = numberInfarcts;
    }
    
    
    
    public String toString()
    {
        return "The " + getClass().getSimpleName() + " has ID: " + getParticipantID()
                + ", age of " + getAge() + 
                (isMale() == true ? " and is a male. " : " and is a female. ") +
                "The " + getClass().getSimpleName() + " has weight of " + getWeight() + 
                " kg, is " + getHeight() + " cm height, has " + getAnkleArmRatio()
                + " ratio of systolic blood pressure measured in the ankle at the"
                + " time of MRI to the systolic blood pressure measured in the "
                + "particpant's arm, has Digit Symbol Substitution Test score "
                + getDigitSymbolSubstitutionTest() + " and the number of "
                + "distinct regions identified on MRI scan that were suggestive "
                + "of infarcts is " + getNumberInfarcts();       
    }
}
