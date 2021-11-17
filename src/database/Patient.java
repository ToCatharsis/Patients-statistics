package database;

/**
 * A general Patient has an ID, an age, is male or female, has weight, height, 
 * a ratio of systolic blood pressure measured in the Patient's ankle 
 * at the time of MRI to the systolic blood pressure measured in the Patient's 
 * arm, a score of the Digit Symbol Substitution Test and a count of the number 
 * of distinct regions identified on MRI scan that were suggestive of infarcts.
 * A parameter male can be "true" if Patient is a male or "false" if  Patient is 
 * a female. 
 * @author Ivan Ryzhankow, Alina Yermakova
 * @version 1.0.0
 */
public class Patient
{
    /**
     * The Patient's ID.
     */
    private int participantID;
    
    /**
     * The Patient's age. 
     */
    private int age;
    
    /**
     * The Patient's sex. May be "true" or "false".
     */
    private boolean male;
    
    /**
     * The Patient's weight (in kg). 
     */
    private double weight;
    
    /**
     * The Patient's height (in cm). 
     */
    private double height;
    
    /**
     * The Patient's ratio of systolic blood pressure measured in the Patient's 
     * ankle at the time of MRI to the systolic blood pressure measured in the 
     * Patient's arm. 
     */
    private double ankleArmRatio;
    
    /**
     * The Patient's score of the Digit Symbol Substitution Test. 
     */
    private int digitSymbolSubstitutionTest;
    
    /**
     * The Patient's count of the number of distinct regions identified on MRI 
     * scan that were suggestive of infarcts. 
     */
    private int numberInfarcts;
    
    /**
     * Creates a new Patient with the ID, age, sex, weight, height, ratio of 
     * systolic blood pressure measured in the Patient's ankle at the time of 
     * MRI to the systolic blood pressure measured in the Patient's arm, score 
     * of the Digit Symbol Substitution Test and count of the number of 
     * distinct regions identified on MRI scan that were suggestive of infarcts.
     * @param participantID Patient's ID.
     * @param age Patient's age.
     * @param male Patient's sex (is Patient a male?).
     * @param weight Patient's weight.
     * @param height Patient's height.
     * @param ankleArmRatio ratio of systolic blood pressure measured in the 
     * Patient's ankle at the time of MRI to the systolic blood pressure 
     * measured in the Patient's arm.
     * @param digitSymbolSubstitutionTest Patient's score of the Digit Symbol 
     * Substitution Test.
     * @param numberInfarcts Patient's count of the number of distinct regions 
     * identified on MRI scan that were suggestive of infarcts.
     */
    Patient(int participantID, int age, int male, double weight, 
            double height, double ankleArmRatio, 
            int digitSymbolSubstitutionTest, int numberInfarcts) 
    {
        this.participantID = participantID;
        this.age = age;
        this.male = Boolean.valueOf((male == 1 ? "true" : "false"));
        this.weight = weight*0.454;
        this.height = height;
        this.ankleArmRatio = ankleArmRatio;
        this.digitSymbolSubstitutionTest = digitSymbolSubstitutionTest;
        this.numberInfarcts = numberInfarcts;
    }
    

    /**
     * Gets the ID of this Patient.
     * @return this Patient's ID.
     */
    public int getParticipantID() {return participantID;}
    
    /**
     * Gets the age of this Patient.
     * @return this Patient's age.
     */
    public int getAge() {return age;}
    
    /**
     * Gets the sex of this Patient.
     * @return this Patient's sex ("true" if male and "false" if female).
     */
    public boolean isMale() {return male;}
    
    /**
     * Gets the weight of this Patient.
     * @return this Patient's weight.
     */
    public double getWeight() {return weight;}
    
    /**
     * Gets the height of this Patient.
     * @return this Patient's height.
     */
    public double getHeight() {return height;}
    
    /**
     * Gets ratio of systolic blood pressure measured in the Patient's ankle at 
     * the time of MRI to the systolic blood pressure measured in the Patient's 
     * arm.
     * @return this Patient's ratio of systolic blood pressure measured in the 
     * Patient's ankle at the time of MRI to the systolic blood pressure 
     * measured in the Patient's arm.
     */
    public double getAnkleArmRatio() {return ankleArmRatio;}
    
    /**
     * Gets Patient's score of the Digit Symbol Substitution Test.
     * @return this Patient's score of the Digit Symbol Substitution 
     * Test.
     */
    public int getDigitSymbolSubstitutionTest() {return digitSymbolSubstitutionTest;}
    
    /**
     * Gets Patient's count of the number of distinct regions identified on MRI 
     * scan that were suggestive of infarcts.
     * @return this Patient's count of the number of distinct regions identified
     * on MRI scan that were suggestive of infarcts
     */
    public int getNumberInfarcts() {return numberInfarcts;}
    
    
    /**
     * Changes the ID of this Patient.
     * @param participantID This Patient's new ID.
     */
    public void setParticipantID(int participantID)
    {
        this.participantID = participantID;
    }
    
    /**
     * Changes the age of this Patient.
     * @param age This Patient's new age.
     */
    public void setAge(int age)
    {
        this.age = age;
    }
    
    /**
     * Changes the sex of this Patient.
     * @param male This Patient's new sex ("true" if male and "false" if female).
     */
    public void setMale(boolean male)
    {
        this.male = male;
    }
    
    /**
     * Changes the weight of this Patient.
     * @param weight This Patient's new weight.
     */
    public void setWeight(double weight)
    {
        this.weight = weight;
    }
    
     /**
     * Changes the height of this Patient.
     * @param height This Patient's new height.
     */
    public void setHeight(double height)
    {
        this.height = height;
    }
    
     /**
     * Changes the ratio of systolic blood pressure measured in the Patient's 
     * ankle at the time of MRI to the systolic blood pressure measured in the 
     * Patient's arm.
     * @param ankleArmRatio This Patient's new ratio of systolic blood pressure
     * measured in the Patient's ankle at the time of MRI to the systolic blood 
     * pressure measured in the Patient's arm.
     */
    public void setAnkleArmRatio(double ankleArmRatio)
    {
        this.ankleArmRatio = ankleArmRatio;
    }
    
    /**
     * Changes the Patient's score of the Digit Symbol Substitution Test.
     * @param digitSymbolSubstitutionTest This Patient's score of the Digit 
     * Symbol Substitution Test.
     */
    public void setDigitSymbolSubstitutionTest(int digitSymbolSubstitutionTest)
    {
        this.digitSymbolSubstitutionTest = digitSymbolSubstitutionTest;
    }
    
    /**
     * Changes the Patient's count of the number of distinct regions identified 
     * on MRI scan that were suggestive of infarcts.
     * @param numberInfarcts This Patient's count of the number of distinct 
     * regions identified on MRI scan that were suggestive of infarcts.
     */
    public void setNumberInfarcts(int numberInfarcts)
    {
        this.numberInfarcts = numberInfarcts;
    }
    
    /**
     * Gets all the parameters of this Patient.
     * @return all CPatient's's parameters in way easy recognizable by a human.
     */
    @Override
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
