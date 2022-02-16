package database;

/**
 * Class with all consts used in this project.
 * @author Ivan Ryzhankow, Alina Yermakova
 * @version 1.0.0
 */
public class Const 
{
    /**
     * private constuctor, because there is no sense to make objects of this class.
     */
    private Const(){}
    
    /**
     * int value which replaces Na in database.
     */
    public static final int NA_REPLACEMENT_INT = 2000;
    
    /**
     * double value which replaces Na in database.
     */
    public static final double NA_REPLACEMENT_DOUBLE = 2000.0;
    
    /**
     * Lb to kg ratio. Is used to make results more understandable.
     */
    public static final double LB_TO_KG_RATIO = 0.45359237; 
}
