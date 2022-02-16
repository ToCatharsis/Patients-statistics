package database;

import java.util.ArrayList;
import static database.Const.*;
import java.util.Comparator;

/**
 * The class used to count statistics of patient's ages, weights etc.
 * @author Ivan Ryzhankow, Alina Yermakova
 * @version 1.0.0
 */
public  class Statistics 
{
    /**
     * There is no need to make an object, because functions are static.
     */
    private Statistics(){}
    
    /**
     * Counts patients' average age.
     * @param patients The list of patients for which statistics will be count.
     * @return patients' average age.
     */
    public static double averageAge (ArrayList<Patient> patients)
    {
        double amountAge=0;
        
        for (int i=0; i<patients.size(); i++)
        {
            amountAge += patients.get(i).getAge();
        }
 
        return amountAge/patients.size();
    }
    
    /**
     * Counts patients' average weight.
     * @param patients The list of patients for which statistics will be count.
     * @return patients' average weight.
     */
    public static double averageWeight (ArrayList<Patient> patients)
    {
        double amountWeight=0;
        
        for (int i=0; i<patients.size(); i++)
        {
            amountWeight += patients.get(i).getWeight();
        }
        
        return amountWeight/patients.size();
    }
    
    /**
     * Counts patients' average height.
     * @param patients The list of patients for which statistics will be count.
     * @return patients' average height.
     */
    public static double averageHeight (ArrayList<Patient> patients)
    {
        double amountHeight=0;
        
        for (int i=0; i<patients.size(); i++)
        {
            amountHeight += patients.get(i).getHeight();
        }
        
        return amountHeight/patients.size();
    }
    
    /**
     * Counts patients' average ratio of systolic blood pressure measured in the Patient's ankle at 
     * the time of MRI to the systolic blood pressure measured in the Patient's 
     * arm.
     * @param patients The list of patients for which statistics will be count.
     * @return patients' average ratio of systolic blood pressure measured in the Patient's ankle at 
     * the time of MRI to the systolic blood pressure measured in the Patient's 
     * arm.
     */
    public static double averageAnkleArmRatio (ArrayList<Patient> patients)
    {
        double amountAnkleArmRatio=0;
        int counter=0;
        
        for (int i=0; i<patients.size(); i++)
        {
            if (patients.get(i).getAnkleArmRatio() == NA_REPLACEMENT_DOUBLE)
                counter++;
            else
                amountAnkleArmRatio += patients.get(i).getAnkleArmRatio();
        }

        return amountAnkleArmRatio/(patients.size() - counter);
    }
    
    /**
     * Counts patients' average score of the Digit Symbol Substitution Test.
     * @param patients The list of patients for which statistics will be count.
     * @return patients' average score of the Digit Symbol Substitution Test.
     */
    public static double averageDigitSymbolSubstitutionTest (ArrayList<Patient> patients)
    {
        double amountDigitSymbolSubstitutionTest=0;
        int counter=0;
        
        for (int i=0; i<patients.size(); i++)
        {
            if (patients.get(i).getDigitSymbolSubstitutionTest() == NA_REPLACEMENT_INT)
                counter++;
            else
                amountDigitSymbolSubstitutionTest += patients.get(i).getDigitSymbolSubstitutionTest();
        }
        
        return amountDigitSymbolSubstitutionTest/(patients.size() - counter);
    }
    
    /**
     * Counts patients' average count of the number of distinct regions identified on MRI 
     * scan that were suggestive of infarcts.
     * @param patients The list of patients for which statistics will be count.
     * @return patients' average count of the number of distinct regions identified on MRI 
     * scan that were suggestive of infarcts.
     */
    public static double averageNumberInfarcts (ArrayList<Patient> patients)
    {
        double amountNumberInfarcts=0;
        
        for (int i=0; i<patients.size(); i++)
        {
            amountNumberInfarcts += patients.get(i).getNumberInfarcts();
        }
        
        return amountNumberInfarcts/patients.size();
    }

    /**
     * Counts patients' weight standart deviation.
     * @param patients The list of patients for which statistics will be count.
     * @return patients' weight standart deviation.
     */
    public static double standardDeviationWeight (ArrayList<Patient> patients)
    {
        double StandardDeviationWeight = 0;
        for (int i=0; i<patients.size(); i++)
        {
            StandardDeviationWeight += Math.pow(patients.get(i).getWeight() - averageWeight(patients), 2);
        }
        StandardDeviationWeight = Math.sqrt(StandardDeviationWeight / patients.size());
        return StandardDeviationWeight;
    }
    
    /**
     * Counts patients' height standart deviation.
     * @param patients The list of patients for which statistics will be count.
     * @return patients' height standart deviation.
     */
    public static double standardDeviationHeight (ArrayList<Patient> patients)
    {
        double StandardDeviationHeight = 0;
        for (int i=0; i<patients.size(); i++)
        {
            StandardDeviationHeight += Math.pow(patients.get(i).getHeight() - averageHeight(patients), 2);
        }
        StandardDeviationHeight = Math.sqrt(StandardDeviationHeight / patients.size());
        return StandardDeviationHeight;
    }
    
    /**
     * Counts patients' age standart deviation.
     * @param patients The list of patients for which statistics will be count.
     * @return patients' age standart deviation.
     */
    public static double standardDeviationAge (ArrayList<Patient> patients)
    {
        double StandardDeviationAge = 0;
        for (int i=0; i<patients.size(); i++)
        {
            StandardDeviationAge += Math.pow(patients.get(i).getAge() - averageAge(patients), 2);
        }
        StandardDeviationAge = Math.sqrt(StandardDeviationAge / patients.size());
        return StandardDeviationAge;
    }
  
    /**
     * Counts patients' ratio of systolic blood pressure measured in the Patient's ankle at 
     * the time of MRI to the systolic blood pressure measured in the Patient's 
     * arm standart deviation.
     * @param patients The list of patients for which statistics will be count.
     * @return patients' ratio of systolic blood pressure measured in the Patient's ankle at 
     * the time of MRI to the systolic blood pressure measured in the Patient's 
     * arm standart deviation.
     */
    public static double standardDeviationAnkleArmRatio (ArrayList<Patient> patients)
    {
        double StandardDeviationAnkleArmRatio = 0;
        for (int i=0; i<patients.size(); i++)
        {
            StandardDeviationAnkleArmRatio += Math.pow(patients.get(i).getAnkleArmRatio() - averageAnkleArmRatio(patients), 2);
        }
        StandardDeviationAnkleArmRatio = Math.sqrt(StandardDeviationAnkleArmRatio / patients.size());
        return StandardDeviationAnkleArmRatio;
    }
    
    /**
     * Counts patients' score of the Digit Symbol Substitution Test standart deviation.
     * @param patients The list of patients for which statistics will be count.
     * @return patients' score of the Digit Symbol Substitution Test standart deviation.
     */
    public static double standardDeviationDigitSymbolSubstitutionTest (ArrayList<Patient> patients)
    {
        double StandardDeviationDigitSymbolSubstitutionTest = 0;
        for (int i=0; i<patients.size(); i++)
        {
            StandardDeviationDigitSymbolSubstitutionTest += Math.pow(patients.get(i).getDigitSymbolSubstitutionTest() - averageDigitSymbolSubstitutionTest(patients), 2);
        }
        StandardDeviationDigitSymbolSubstitutionTest = Math.sqrt(StandardDeviationDigitSymbolSubstitutionTest / patients.size());
        return StandardDeviationDigitSymbolSubstitutionTest;
    }
    
    /**
     * Counts patients' count of the number of distinct regions identified on MRI 
     * scan that were suggestive of infarcts standart deviation.
     * @param patients The list of patients for which statistics will be count.
     * @return patients' count of the number of distinct regions identified on MRI 
     * scan that were suggestive of infarcts standart deviation.
     */
    public static double standardDeviationNumberInfarcts (ArrayList<Patient> patients)
    {
        double StandardDeviationNumberInfarcts = 0;
        for (int i=0; i<patients.size(); i++)
        {
            StandardDeviationNumberInfarcts += Math.pow(patients.get(i).getNumberInfarcts() - averageNumberInfarcts(patients), 2);
        }
        StandardDeviationNumberInfarcts = Math.sqrt(StandardDeviationNumberInfarcts / patients.size());
        return StandardDeviationNumberInfarcts;
    }
    
    /**
     * Counts patients' age median.
     * @param patients The list of patients for which statistics will be count.
     * @return patients' age median.
     */
    public static double medianAge (ArrayList<Patient> patients)
    {
        double median;
        ArrayList<Integer> array = new ArrayList<>();
        
        for (int i=0; i<patients.size(); i++)
        {
            array.add(patients.get(i).getAge());
        }
        array.sort(Comparator.naturalOrder());
        
        if (array.size() % 2 == 0)
        {
            int sumMiddleElements = array.get(array.size() / 2) + array.get(array.size() / 2 - 1);
            median = sumMiddleElements / 2;
        }
        else
        {
            median = array.get(array.size() / 2);
        }
        
        return median;
    }
    
    /**
     * Counts patients' weight median.
     * @param patients The list of patients for which statistics will be count.
     * @return patients' weight median.
     */
    public static double medianWeight (ArrayList<Patient> patients)
    {
        double median;
        ArrayList<Double> array = new ArrayList<>();
        
        for (int i=0; i<patients.size(); i++)
        {
            array.add(patients.get(i).getWeight());
        }
        array.sort(Comparator.naturalOrder());
        
        if (array.size() % 2 == 0)
        {
            double sumMiddleElements = array.get(array.size() / 2) + array.get(array.size() / 2 - 1);
            median = sumMiddleElements / 2;
        }
        else
        {
            median = array.get(array.size() / 2);
        }
        
        return median;
    }
    
    /**
     * Counts patients' height median.
     * @param patients The list of patients for which statistics will be count.
     * @return patients' height median.
     */
    public static double medianHeight (ArrayList<Patient> patients)
    {
        double median;
        ArrayList<Double> array = new ArrayList<>();
        
        for (int i=0; i<patients.size(); i++)
        {
            array.add(patients.get(i).getHeight());
        }
        array.sort(Comparator.naturalOrder());
        
        if (array.size() % 2 == 0)
        {
            double sumMiddleElements = array.get(array.size() / 2) + array.get(array.size() / 2 - 1);
            median = sumMiddleElements / 2;
        }
        else
        {
            median = array.get(array.size() / 2);
        }
        
        return median;
    }
    
    /**
     * Counts patients' ratio of systolic blood pressure measured in the Patient's ankle at 
     * the time of MRI to the systolic blood pressure measured in the Patient's 
     * arm median.
     * @param patients The list of patients for which statistics will be count.
     * @return patients' ratio of systolic blood pressure measured in the Patient's ankle at 
     * the time of MRI to the systolic blood pressure measured in the Patient's 
     * arm median.
     */
    public static double medianAnkleArmRatio (ArrayList<Patient> patients)
    {
        double median;
        ArrayList<Double> array = new ArrayList<>();
        
        for (int i=0; i<patients.size(); i++)
        {
            if (patients.get(i).getAnkleArmRatio() != NA_REPLACEMENT_DOUBLE)
            {
                array.add(patients.get(i).getAnkleArmRatio());
            }
        }
        array.sort(Comparator.naturalOrder());
        
        if (array.size() % 2 == 0)
        {
            double sumMiddleElements = array.get(array.size() / 2) + array.get(array.size() / 2 - 1);
            median = sumMiddleElements / 2;
        }
        else
        {
            median = array.get(array.size() / 2);
        }
        
        return median;
    }
    
    /**
     * Counts patients' score of the Digit Symbol Substitution Test median.
     * @param patients The list of patients for which statistics will be count.
     * @return patients' score of the Digit Symbol Substitution Test median.
     */
    public static double medianDigitSymbolSubstitutionTest (ArrayList<Patient> patients)
    {
        double median;
        ArrayList<Integer> array = new ArrayList<>();
        
        for (int i=0; i<patients.size(); i++)
        {
            if (patients.get(i).getDigitSymbolSubstitutionTest()!= NA_REPLACEMENT_INT)
            {
                array.add(patients.get(i).getDigitSymbolSubstitutionTest());
            }
        }
        array.sort(Comparator.naturalOrder());
        
        if (array.size() % 2 == 0)
        {
            double sumMiddleElements = array.get(array.size() / 2) + array.get(array.size() / 2 - 1);
            median = sumMiddleElements / 2;
        }
        else
        {
            median = array.get(array.size() / 2);
        }
        
        return median;
    }
    
    /**
     * Counts patients' count of the number of distinct regions identified on MRI 
     * scan that were suggestive of infarcts median.
     * @param patients The list of patients for which statistics will be count.
     * @return patients' count of the number of distinct regions identified on MRI 
     * scan that were suggestive of infarcts median.
     */
    public static double medianNumberInfarcts (ArrayList<Patient> patients)
    {
        double median;
        ArrayList<Integer> array = new ArrayList<>();
        
        for (int i=0; i<patients.size(); i++)
        {
            array.add(patients.get(i).getNumberInfarcts());
        }
        array.sort(Comparator.naturalOrder());
        
        if (array.size() % 2 == 0)
        {
            double sumMiddleElements = array.get(array.size() / 2) + array.get(array.size() / 2 - 1);
            median = sumMiddleElements / 2;
        }
        else
        {
            median = array.get(array.size() / 2);
        }        
        return median;
    }
    
    /**
     * Counts patients' age first quartile.
     * @param patients The list of patients for which statistics will be count.
     * @return patients' age first quartile.
     */
    public static double firstQuartileAge (ArrayList<Patient> patients)
    {
        double quartile;
        ArrayList<Integer> array = new ArrayList<>();
        
        for (int i=0; i<patients.size(); i++)
        {
            array.add(patients.get(i).getAge());
        }
        array.sort(Comparator.naturalOrder());
        
        if ((array.size() / 2) % 2 == 0)
        {
            quartile = (array.get((array.size() / 2) / 2) + array.get((array.size() / 2) - 1)) / 2;
        }
        else
        {
            quartile = array.get((array.size() / 2) / 2);
        }
        
        return quartile;
    }
    
    /**
     * Counts patients' weight first quartile.
     * @param patients The list of patients for which statistics will be count.
     * @return patients' weight first quartile.
     */
    public static double firstQuartileWeight (ArrayList<Patient> patients)
    {
        double quartile;
        ArrayList<Double> array = new ArrayList<>();
        
        for (int i=0; i<patients.size(); i++)
        {
            array.add(patients.get(i).getWeight());
        }
        array.sort(Comparator.naturalOrder());
        
        if ((array.size() / 2) % 2 == 0)
        {
            quartile = (array.get((array.size() / 2) / 2) + array.get((array.size() / 2) - 1)) / 2;
        }
        else
        {
            quartile = array.get((array.size() / 2) / 2);
        }
        
        return quartile;
    }
    
    /**
     * Counts patients' height first quartile.
     * @param patients The list of patients for which statistics will be count.
     * @return patients' height first quartile.
     */
    public static double firstQuartileHeight (ArrayList<Patient> patients)
    {
        double quartile;
        ArrayList<Double> array = new ArrayList<>();
        
        for (int i=0; i<patients.size(); i++)
        {
            array.add(patients.get(i).getHeight());
        }
        array.sort(Comparator.naturalOrder());
        
        if ((array.size() / 2) % 2 == 0)
        {
            quartile = (array.get((array.size() / 2) / 2) + array.get((array.size() / 2) - 1)) / 2;
        }
        else
        {
            quartile = array.get((array.size() / 2) / 2);
        }
        
        return quartile;
    }
    
    /**
     * Counts patients' ratio of systolic blood pressure measured in the Patient's ankle at 
     * the time of MRI to the systolic blood pressure measured in the Patient's 
     * arm first quartile.
     * @param patients The list of patients for which statistics will be count.
     * @return patients' ratio of systolic blood pressure measured in the Patient's ankle at 
     * the time of MRI to the systolic blood pressure measured in the Patient's 
     * arm first quartile.
     */
    public static double firstQuartileAnkleArmRatio (ArrayList<Patient> patients)
    {
        double quartile;
        ArrayList<Double> array = new ArrayList<>();
        
        for (int i=0; i<patients.size(); i++)
        {
            if (patients.get(i).getAnkleArmRatio() != NA_REPLACEMENT_DOUBLE)
            {
                array.add(patients.get(i).getAnkleArmRatio());
            }
        }
        array.sort(Comparator.naturalOrder());
        
        if ((array.size() / 2) % 2 == 0)
        {
            quartile = (array.get((array.size() / 2) / 2) + array.get((array.size() / 2) - 1)) / 2;
        }
        else
        {
            quartile = array.get((array.size() / 2) / 2);
        }
        
        return quartile;
    }
    
    /**
     * Counts patients' score of the Digit Symbol Substitution Test first quartile.
     * @param patients The list of patients for which statistics will be count.
     * @return patients' score of the Digit Symbol Substitution Test first quartile.
     */
    public static double firstQuartileDigitSymbolSubstitutionTest (ArrayList<Patient> patients)
    {
        double quartile;
        ArrayList<Integer> array = new ArrayList<>();
        
        for (int i=0; i<patients.size(); i++)
        {
            if (patients.get(i).getDigitSymbolSubstitutionTest()!= NA_REPLACEMENT_INT)
            {
                array.add(patients.get(i).getDigitSymbolSubstitutionTest());
            }
        }
        array.sort(Comparator.naturalOrder());
        
        if ((array.size() / 2) % 2 == 0)
        {
            quartile = (array.get((array.size() / 2) / 2) + array.get((array.size() / 2) - 1)) / 2;
        }
        else
        {
            quartile = array.get((array.size() / 2) / 2);
        }
        
        return quartile;
    }
    
    /**
     * Counts patients' count of the number of distinct regions identified on MRI 
     * scan that were suggestive of infarcts first quartile.
     * @param patients The list of patients for which statistics will be count.
     * @return patients' count of the number of distinct regions identified on MRI 
     * scan that were suggestive of infarcts first quartile.
     */
    public static double firstQuartileNumberInfarcts (ArrayList<Patient> patients)
    {
        double quartile;
        ArrayList<Integer> array = new ArrayList<>();
        
        for (int i=0; i<patients.size(); i++)
        {
            array.add(patients.get(i).getNumberInfarcts());
        }
        array.sort(Comparator.naturalOrder());
        
        if ((array.size() / 2) % 2 == 0)
        {
            quartile = (array.get((array.size() / 2) / 2) + array.get((array.size() / 2) - 1)) / 2;
        }
        else
        {
            quartile = array.get((array.size() / 2) / 2);
        }
        
        return quartile;
    }
    
    /**
     * Counts patients' age third quartile.
     * @param patients The list of patients for which statistics will be count.
     * @return patients' age third quartile.
     */
    public static double thirdQuartileAge (ArrayList<Patient> patients)
    {
        double quartile;
        ArrayList<Integer> array = new ArrayList<>();
        
        for (int i=0; i<patients.size(); i++)
        {
            array.add(patients.get(i).getAge());
        }
        array.sort(Comparator.naturalOrder());
        
        if ((array.size() / 2) % 2 == 0)
        {
            if (array.size() % 2 == 0)
            {
                quartile = (array.get((array.size() / 2) + ((array.size() / 2) / 2)) + array.get((array.size() / 2) + ((array.size() / 2) / 2) - 1)) / 2;
            }
            else
            {
                quartile = (array.get((array.size() / 2) + ((array.size() / 2) / 2)) + array.get((array.size() / 2) + ((array.size() / 2) / 2) + 1)) / 2;
            }
        }
        else
        {
            quartile = array.get((array.size() / 2) + ((array.size() / 2) / 2));
        }
        
        return quartile;
    }
    
    /**
     * Counts patients' weight third quartile.
     * @param patients The list of patients for which statistics will be count.
     * @return patients' weight third quartile.
     */
    public static double thirdQuartileWeight (ArrayList<Patient> patients)
    {
        double quartile;
        ArrayList<Double> array = new ArrayList<>();
        
        for (int i=0; i<patients.size(); i++)
        {
            array.add(patients.get(i).getWeight());
        }
        array.sort(Comparator.naturalOrder());
        
        if ((array.size() / 2) % 2 == 0)
        {
            if (array.size() % 2 == 0)
            {
                quartile = (array.get((array.size() / 2) + ((array.size() / 2) / 2)) + array.get((array.size() / 2) + ((array.size() / 2) / 2) - 1)) / 2;
            }
            else
            {
                quartile = (array.get((array.size() / 2) + ((array.size() / 2) / 2)) + array.get((array.size() / 2) + ((array.size() / 2) / 2) + 1)) / 2;
            }
        }
        else
        {
            quartile = array.get((array.size() / 2) + ((array.size() / 2) / 2));
        }
        
        return quartile;
    }
    
    /**
     * Counts patients' height third quartile.
     * @param patients The list of patients for which statistics will be count.
     * @return patients' height third quartile.
     */
    public static double thirdQuartileHeight (ArrayList<Patient> patients)
    {
        double quartile;
        ArrayList<Double> array = new ArrayList<>();
        
        for (int i=0; i<patients.size(); i++)
        {
            array.add(patients.get(i).getHeight());
        }
        array.sort(Comparator.naturalOrder());
        
        if ((array.size() / 2) % 2 == 0)
        {
            if (array.size() % 2 == 0)
            {
                quartile = (array.get((array.size() / 2) + ((array.size() / 2) / 2)) + array.get((array.size() / 2) + ((array.size() / 2) / 2) - 1)) / 2;
            }
            else
            {
                quartile = (array.get((array.size() / 2) + ((array.size() / 2) / 2)) + array.get((array.size() / 2) + ((array.size() / 2) / 2) + 1)) / 2;
            }
        }
        else
        {
            quartile = array.get((array.size() / 2) + ((array.size() / 2) / 2));
        }
        
        return quartile;
    }
    
    /**
     * Counts patients' ratio of systolic blood pressure measured in the Patient's ankle at 
     * the time of MRI to the systolic blood pressure measured in the Patient's 
     * arm third quartile.
     * @param patients The list of patients for which statistics will be count.
     * @return patients' ratio of systolic blood pressure measured in the Patient's ankle at 
     * the time of MRI to the systolic blood pressure measured in the Patient's 
     * arm third quartile.
     */
    public static double thirdQuartileAnkleArmRatio (ArrayList<Patient> patients)
    {
        double quartile;
        ArrayList<Double> array = new ArrayList<>();
        
        for (int i=0; i<patients.size(); i++)
        {
            if (patients.get(i).getAnkleArmRatio() != NA_REPLACEMENT_DOUBLE)
            {
                array.add(patients.get(i).getAnkleArmRatio());
            }
        }
        array.sort(Comparator.naturalOrder());
        
        if ((array.size() / 2) % 2 == 0)
        {
            if (array.size() % 2 == 0)
            {
                quartile = (array.get((array.size() / 2) + ((array.size() / 2) / 2)) + array.get((array.size() / 2) + ((array.size() / 2) / 2) - 1)) / 2;
            }
            else
            {
                quartile = (array.get((array.size() / 2) + ((array.size() / 2) / 2)) + array.get((array.size() / 2) + ((array.size() / 2) / 2) + 1)) / 2;
            }
        }
        else
        {
            quartile = array.get((array.size() / 2) + ((array.size() / 2) / 2));
        }
        
        return quartile;
    }
    
    /**
     * Counts patients' score of the Digit Symbol Substitution Test third quartile.
     * @param patients The list of patients for which statistics will be count.
     * @return patients' score of the Digit Symbol Substitution Test third quartile.
     */
    public static double thirdQuartileDigitSymbolSubstitutionTest (ArrayList<Patient> patients)
    {
        double quartile;
        ArrayList<Integer> array = new ArrayList<>();
        
        for (int i=0; i<patients.size(); i++)
        {
            if (patients.get(i).getAnkleArmRatio() != NA_REPLACEMENT_INT)
            {
                array.add(patients.get(i).getDigitSymbolSubstitutionTest());
            }
        }
        array.sort(Comparator.naturalOrder());
        
        if ((array.size() / 2) % 2 == 0)
        {
            if (array.size() % 2 == 0)
            {
                quartile = (array.get((array.size() / 2) + ((array.size() / 2) / 2)) + array.get((array.size() / 2) + ((array.size() / 2) / 2) - 1)) / 2;
            }
            else
            {
                quartile = (array.get((array.size() / 2) + ((array.size() / 2) / 2)) + array.get((array.size() / 2) + ((array.size() / 2) / 2) + 1)) / 2;
            }
        }
        else
        {
            quartile = array.get((array.size() / 2) + ((array.size() / 2) / 2));
        }
        
        return quartile;
    }
    
    /**
     * Counts patients' count of the number of distinct regions identified on MRI 
     * scan that were suggestive of infarcts third quartile.
     * @param patients The list of patients for which statistics will be count.
     * @return patients' count of the number of distinct regions identified on MRI 
     * scan that were suggestive of infarcts third quartile.
     */
    public static double thirdQuartileNumberInfarcts (ArrayList<Patient> patients)
    {
        double quartile;
        ArrayList<Integer> array = new ArrayList<>();
        
        for (int i=0; i<patients.size(); i++)
        {
            array.add(patients.get(i).getNumberInfarcts());
        }
        array.sort(Comparator.naturalOrder());
        
        if ((array.size() / 2) % 2 == 0)
        {
            if (array.size() % 2 == 0)
            {
                quartile = (array.get((array.size() / 2) + ((array.size() / 2) / 2)) + array.get((array.size() / 2) + ((array.size() / 2) / 2) - 1)) / 2;
            }
            else
            {
                quartile = (array.get((array.size() / 2) + ((array.size() / 2) / 2)) + array.get((array.size() / 2) + ((array.size() / 2) / 2) + 1)) / 2;
            }
        }
        else
        {
            quartile = array.get((array.size() / 2) + ((array.size() / 2) / 2));
        }
        
        return quartile;
    }
}

