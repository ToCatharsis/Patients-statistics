package database;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class representing the grafic interface for the project.
 * @author Ivan Ryzhankow, Alina Yermakova
 * @version 1.0.0
 */
public class GUIDatabase extends JFrame 
{
    /**
     * The main frame of the program.
     */
    
    private final JFrame frame = new JFrame();
    
    
    /**
     * Text welcoming a user.
     */
    private final JTextArea text1 = new JTextArea("Witamy w programie obliczającym statystyki dla pacjentów.");
    
    /**
     * Text inviting to choose from the options down below.
     */
    private final JTextArea text2 = new JTextArea("Proszę wybrać jedną z poniższych opcji:");
    
    /**
     * Button to choose only women.
     */
    private final JRadioButton radio1 = new JRadioButton("tylko kobiety");
    
    /**
     * Button to choose only men.
     */
    private final JRadioButton radio2 = new JRadioButton("tylko mężczyzni");
    
    /**
     * Button to choose all patients.
     */
    private final JRadioButton radio3 = new JRadioButton("wszyscy");
    
    /**
     * Text asking if user wants to choose determined weights.
     */
    private  final JTextArea text11 = new JTextArea("Ograniczyć wagę?"); 
    
    /**
     * Option for choosing the range of weights of patients.
     */
    private final SpinnerModel value1 = new SpinnerNumberModel(62, 0, 125, 1);
    
    /**
     * Option for choosing the range of weights of patients.
     */
    private final SpinnerModel value2 = new SpinnerNumberModel(62, 0, 125, 1);
    
    /**
     * Option for choosing the range of height of patients.
     */
    private final SpinnerModel value3 = new SpinnerNumberModel(98, 0, 195, 1);
    
    /**
     * Option for choosing the range of height of patients.
     */
    private final SpinnerModel value4 = new SpinnerNumberModel(98, 0, 195, 1);
    
    /**
     * Option for choosing the minimum of weight of patients.
     */
    private final JSpinner spinnerWagaMin = new JSpinner(value1);
    
    /**
     * Option for choosing the maximum of weight of patients.
     */
    private final JSpinner spinnerWagaMax = new JSpinner(value2); 
    
    /**
     * Text asking if user wants to choose determined heights.
     */
    private  final JTextArea text12 = new JTextArea("Ograniczyć wzrost?");
    
    /**
     * Option for choosing the minimum of height of patients.
     */
    private final JSpinner spinnerWzrostMin = new JSpinner(value3);
    
    /**
     * Option for choosing the maximum of height of patients.
     */
    private final JSpinner spinnerWzrostMax = new JSpinner(value4);
    
    /**
     * Text asking if user wants to choose determined ages.
     */
    private  final JTextArea text13 = new JTextArea("Ograniczyć wiek?");
    
    /**
     * Option for choosing the range of age of patients.
     */
    private final SpinnerModel value5 = new SpinnerNumberModel(50, 0, 100, 1);
    
    /**
     * Option for choosing the range of age of patients.
     */
    private final SpinnerModel value6 = new SpinnerNumberModel(50, 0, 100, 1);
    
    /**
     * Option for choosing the minimum of age of patients.
     */
    private final JSpinner spinnerWiekMin = new JSpinner(value5);
    
    /**
     * Option for choosing the maximum of age of patients.
     */
    private final JSpinner spinnerWiekMax = new JSpinner(value6);
    
    /**
     * Text for bottom line of weight, height or age.
     */
    private  final JTextArea textMin = new JTextArea("min");
    
    /**
     * Text for upper line of weight, height or age.
     */
    private  final JTextArea textMax = new JTextArea("max");
    
    /**
     * Text inviting to choose from the options down below.
     */
    private final JTextArea text3 = new JTextArea("Proszę wybrać parametry, które należy obliczyć");
    
    /**
     * Option for choosing all opions.
     */
    private final JCheckBox checkP = new JCheckBox("Chcę wybrać wszystki możliwe parametry", false);
    
    /**
     * Option for choosing histograms of weight for men and women.
     */
    private final JCheckBox checkWg = new JCheckBox("Chcę porównać histogramy wagi dla kobiet i mężczyzn", false);
    
    /**
     * Option for choosing histograms of height for men and women.
     */
    private final JCheckBox checkWz= new JCheckBox("Chcę porównać histogramy wzrostu dla kobiet i mężczyzn", false);
    
    /**
     * Option for choosing histograms of age for men and women.
     */
    private final JCheckBox checkWk = new JCheckBox("Chcę porównać histogramy wieku dla kobiet i mężczyzny", false);
    
    /**
     * Text inviting to choose options for age.
     */
    private final JTextArea text4 = new JTextArea("Dla wieku chcę obliczyć ...");
    
    /**
     * Option for mean of age.
     */
    private final JCheckBox checkWiek1 = new JCheckBox("średnia wartość", false);
    
    /**
     * Option for standart deviation of age.
     */
    private final JCheckBox checkWiek2 = new JCheckBox("odchylenie standardowe", false);
    
    /**
     * Option for histogram of age.
     */
    private final JCheckBox checkWiek3 = new JCheckBox("histogram", false);
    
    /**
     * Option for height median.
     */
    private final JCheckBox checkWiek4 = new JCheckBox("mediana", false);
    
    /**
     * Option for first quartile.
     */
    private final JCheckBox checkWiek5 = new JCheckBox("kwartyl dolny", false);
    
    /**
     * Option for third quartile.
     */
    private final JCheckBox checkWiek6 = new JCheckBox("kwartyl górny", false);
    
    /**
     * Text inviting to choose options for weight.
     */
    private final JTextArea text5 = new JTextArea("Dla wagi chcę obliczyć ...");
    
    /**
     * Option for mean of weight.
     */
    private final JCheckBox checkWaga1 = new JCheckBox("średnia wartość", false);
    
    /**
     * Option for standart deviation of weight.
     */
    private final JCheckBox checkWaga2 = new JCheckBox("odchylenie standardowe", false);
    
    /**
     * Option for histogram of weight.
     */
    private final JCheckBox checkWaga3 = new JCheckBox("histogram", false);
    
    /**
     * Option for height median.
     */
    private final JCheckBox checkWaga4 = new JCheckBox("mediana", false);
    
    /**
     * Option for first quartile.
     */
    private final JCheckBox checkWaga5 = new JCheckBox("kwartyl dolny", false);
    
    /**
     * Option for third quartile.
     */
    private final JCheckBox checkWaga6 = new JCheckBox("kwartyl górny", false);
    
    /**
     * Text inviting to choose options for weight.
     */
    private final JTextArea text6 = new JTextArea("Dla wzrostu chcę obliczyć ...");
    
    /**
     * Option for mean of height.
     */
    private final JCheckBox checkWzrost1 = new JCheckBox("średnia wartość", false);
    
    /**
     * Option for standart deviation of height.
     */
    private final JCheckBox checkWzrost2 = new JCheckBox("odchylenie standardowe", false);
    
    /**
     * Option for histogram of height.
     */
    private final JCheckBox checkWzrost3 = new JCheckBox("histogram", false);
    
    /**
     * Option for height median.
     */
    private final JCheckBox checkWzrost4 = new JCheckBox("mediana", false);
    
    /**
     * Option for first quartile.
     */
    private final JCheckBox checkWzrost5 = new JCheckBox("kwartyl dolny", false);
    
    /**
     * Option for third quartile.
     */
    private final JCheckBox checkWzrost6 = new JCheckBox("kwartyl górny", false);
    
    /**
     * Text inviting to choose options for ratio of systolic blood pressure measured in 
     * the Patients' ankle at the time of MRI to the systolic blood pressure measured in 
     * the Patients' arm.
     */
    private final JTextArea text7 = new JTextArea("Dla stosunku skurczowego ciśnienia krwi pacjenta mierzonego w kostce"
            + "\npacjenta podczas MRI do skurczowego ciśnienia krwi mierzonego w "
            + "\nramieniu pacjenta chcę obliczyć ...");
    
    /**
     * Option for mean of ratio of systolic blood pressure measured in the Patients' 
     * ankle at the time of MRI to the systolic blood pressure measured in the 
     * patients arm.
     */
    private final JCheckBox checkAARatio1 = new JCheckBox("średnia wartość", false);
    
    /**
     * Option for standart deviation of ratio of systolic blood pressure measured in the Patients' 
     * ankle at the time of MRI to the systolic blood pressure measured in the 
     * patients arm.
     */
    private final JCheckBox checkAARatio2 = new JCheckBox("odchylenie standardowe", false);
    
    /**
     * Option for height median.
     */
    private final JCheckBox checkAARatio4 = new JCheckBox("mediana", false);
    
    /**
     * Option for first quartile.
     */
    private final JCheckBox checkAARatio5 = new JCheckBox("kwartyl dolny", false);
    
    /**
     * Option for third quartile.
     */
    private final JCheckBox checkAARatio6 = new JCheckBox("kwartyl górny", false);
    
    /**
     * Text inviting to choose options for score of the Digit Symbol Substitution Test.
     */
    private final JTextArea text8 = new JTextArea("Dla oceny pacjentów z \"The Digit Symbol Substitution Test\" chcę "
            + "\nobliczyć ...");
    
    /**
     * Option for mean of score of the Digit Symbol Substitution Test.
     */
    private final JCheckBox checkDSSTest1 = new JCheckBox("średnia wartość", false);
    
    /**
     * Option for standart deviation of score of the Digit Symbol Substitution Test.
     */
    private final JCheckBox checkDSSTest2 = new JCheckBox("odchylenie standardowe", false);
    
    /**
     * Option for height median.
     */
    private final JCheckBox checkDSSTest4 = new JCheckBox("mediana", false);
    
    /**
     * Option for first quartile.
     */
    private final JCheckBox checkDSSTest5 = new JCheckBox("kwartyl dolny", false);
    
    /**
     * Option for third quartile.
     */
    private final JCheckBox checkDSSTest6 = new JCheckBox("kwartyl górny", false);
    
    /**
     * Text inviting to choose options for Patient's count of the number of distinct regions 
     * identified on MRI.
     */
    private final JTextArea text9 = new JTextArea("Dla liczby podejrzanych zawałów u pacjentów chcę "
            + "\nobliczyć ...");
    
    /**
     * Option for mean of number of infarcts.
     */
    private final JCheckBox checkInfarcts1 = new JCheckBox("średnia wartość", false);
    
    /**
     * Option for standart deviation of number of infarcts.
     */
    private final JCheckBox checkInfarcts2 = new JCheckBox("odchylenie standardowe", false);
    
    /**
     * Option for height median.
     */
    private final JCheckBox checkInfarcts4 = new JCheckBox("mediana", false);
    
    /**
     * Option for first quartile.
     */
    private final JCheckBox checkInfarcts5 = new JCheckBox("kwartyl dolny", false);
    
    /**
     * Option for third quartile.
     */
    private final JCheckBox checkInfarcts6 = new JCheckBox("kwartyl górny", false);
    
     /**
     * Is used to make program prettier.
     */
    private final JTextArea text10 = new JTextArea("");
    /**
     * Option for writing down a raport.
     */
    private final JCheckBox check = new JCheckBox("Zapisać raport", false);
    
    /**
     * Start the program with chosen options.
     */
    private final JButton button = new JButton("GO!");
    
    
    /**
     * The constructor of this class which represent the GUI of the project.
     * @throws Exception 
     */
    public GUIDatabase() throws Exception
    {
        super("Patient's database");
        this.setBounds(100, 100, 600, 850);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagConstraints c = new GridBagConstraints();

        Container container = this.getContentPane();
        container.setLayout(new GridBagLayout());
        container.setBackground(new Color(245,255,255));
        
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 3;
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = new Insets(0,0,10,0);
        container.add(text1, c);
        
        c.gridy = 1;
        c.insets = new Insets(0,0,0,0);
        container.add(text2, c);
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        c.insets = new Insets(0,0,5,0);
        container.add(radio1, c);
        c.gridx = 1;
        c.gridy = 2;
        container.add(radio2, c);
        c.gridx = 2;
        c.gridy = 2;
        container.add(radio3, c);
        radio3.setSelected(true);
        ButtonGroup bgroup = new ButtonGroup();
        bgroup.add(radio1);
        bgroup.add(radio2);
        bgroup.add(radio3);

        c.insets = new Insets(0,0,0,0);
        c.gridwidth = 3;
        c.gridy = 3;
        c.gridx = 0;
        container.add(text11, c);
        c.gridx = 1;
        container.add(text12, c);
        c.gridx = 2;
        container.add(text13, c);
        
        c.gridy = 4;
        c.gridx = 3;
        container.add(textMin, c);
        c.gridx = 0;
        container.add(spinnerWagaMin, c);
        c.gridx = 1;
        container.add(spinnerWzrostMin, c);
        c.gridx = 2;
        container.add(spinnerWiekMin, c);
        spinnerWagaMin.setValue(0);
        spinnerWiekMin.setValue(0);
        spinnerWzrostMin.setValue(0);

        c.gridy = 5;
        c.insets = new Insets(0,0,10,0);
        c.gridx = 3;
        container.add(textMax, c);
        c.gridx = 0;
        container.add(spinnerWagaMax, c);
        c.gridx = 1;
        container.add(spinnerWzrostMax, c);
        c.gridx = 2;
        container.add(spinnerWiekMax, c);
        spinnerWagaMax.setValue(125);
        spinnerWiekMax.setValue(100);
        spinnerWzrostMax.setValue(195);
        
        c.gridx = 0;
        c.gridy = 6;
        c.gridwidth = 3;
        c.insets = new Insets(0,0,3,0);
        container.add(text3, c);
        text3.setBackground(new Color(245,255,255));
        text3.setFont(new Font("Arial", Font.BOLD, 12));
        c.gridy = 7;
        container.add(checkP, c);
        c.insets = new Insets(0,0,0,0);
        c.gridy = 8;
        container.add(checkWg, c);
        c.gridy = 9;
        container.add(checkWz, c);
        c.insets = new Insets(0,0,5,0);
        c.gridy = 10;
        container.add(checkWk, c);
        
        c.gridx = 0;
        c.gridy = 11;
        c.gridwidth = 3;
        c.insets = new Insets(0,0,0,0);
        container.add(text4, c);
        text4.setBackground(new Color(245,255,255));
        text4.setFont(new Font("Arial", Font.PLAIN, 12));
        c.gridy = 12;
        c.gridwidth = 3;
        container.add(checkWiek1, c);
        c.gridx = 1;
        c.gridy = 12;
        container.add(checkWiek2, c);
        c.gridx = 2;
        c.gridy = 12;
        container.add(checkWiek3, c);
        
        c.gridx = 0;
        c.gridy = 13;
        c.gridwidth = 3;
        c.insets = new Insets(5,0,0,0);
        container.add(text5, c);
        text5.setBackground(new Color(245,255,255));
        text5.setFont(new Font("Arial", Font.PLAIN, 12));
        c.insets = new Insets(0,0,0,0);
        c.gridy = 14;
        c.gridwidth = 3;
        container.add(checkWaga1, c);
        c.gridx = 1;
        c.gridy = 14;
        container.add(checkWaga2, c);
        c.gridx = 2;
        c.gridy = 14;
        container.add(checkWaga3, c);
        c.gridy = 15;
        c.gridx = 0;
        c.gridwidth = 3;
        container.add(checkWaga4, c);
        c.gridx = 1;
        c.gridy = 15;
        container.add(checkWaga5, c);
        c.gridx = 2;
        c.gridy = 15;
        container.add(checkWaga6, c);
        
        c.gridx = 0;
        c.gridy = 16;
        c.gridwidth = 3;
        c.insets = new Insets(5,0,0,0);
        container.add(text6, c);
        text6.setBackground(new Color(245,255,255));
        text6.setFont(new Font("Arial", Font.PLAIN, 12));
        c.insets = new Insets(0,0,0,0);
        c.gridy = 17;
        c.gridwidth = 3;
        container.add(checkWzrost1, c);
        c.gridx = 1;
        c.gridy = 17;
        container.add(checkWzrost2, c);
        c.gridx = 2;
        c.gridy = 17;
        container.add(checkWzrost3, c);
        c.gridy = 18;
        c.gridx = 0;
        c.gridwidth = 3;
        container.add(checkWzrost4, c);
        c.gridx = 1;
        c.gridy = 18;
        container.add(checkWzrost5, c);
        c.gridx = 2;
        c.gridy = 18;
        container.add(checkWzrost6, c);
        
        c.gridx = 0;
        c.gridy = 19;
        c.gridwidth = 3;
        c.insets = new Insets(5,0,0,0);
        container.add(text7, c);
        text7.setBackground(new Color(245,255,255));
        text7.setFont(new Font("Arial", Font.PLAIN, 12));
        c.insets = new Insets(0,0,0,0);
        c.gridy = 20;
        c.gridwidth = 3;
        container.add(checkAARatio1, c);
        c.gridx = 1;
        c.gridy = 20;
        container.add(checkAARatio2, c);
        c.gridy = 21;
        c.gridx = 0;
        c.gridwidth = 3;
        container.add(checkAARatio4, c);
        c.gridx = 1;
        c.gridy = 21;
        container.add(checkAARatio5, c);
        c.gridx = 2;
        c.gridy = 21;
        container.add(checkAARatio6, c);
        
        c.gridx = 0;
        c.gridy = 22;
        c.gridwidth = 3;
        c.insets = new Insets(5,0,0,0);
        container.add(text8, c);
        text8.setBackground(new Color(245,255,255));
        text8.setFont(new Font("Arial", Font.PLAIN, 12));
        c.insets = new Insets(0,0,0,0);
        c.gridy = 23;
        c.gridwidth = 3;
        container.add(checkDSSTest1, c);
        c.gridx = 1;
        c.gridy = 23;
        container.add(checkDSSTest2, c);
        c.gridy = 24;
        c.gridx = 0;
        c.gridwidth = 3;
        container.add(checkDSSTest4, c);
        c.gridx = 1;
        c.gridy = 24;
        container.add(checkDSSTest5, c);
        c.gridx = 2;
        c.gridy = 24;
        container.add(checkDSSTest6, c);
        
        c.gridx = 0;
        c.gridy = 25;
        c.gridwidth = 3;
        c.insets = new Insets(5,0,0,0);
        container.add(text9, c);
        text9.setBackground(new Color(245,255,255));
        text9.setFont(new Font("Arial", Font.PLAIN, 12));
        c.insets = new Insets(0,0,0,0);
        c.gridy = 26;
        c.gridwidth = 1;
        container.add(checkInfarcts1, c);
        c.gridx = 1;
        c.gridy = 26;
        container.add(checkInfarcts2, c);
        c.gridy = 27;
        c.gridx = 0;
        c.gridwidth = 1;
        container.add(checkInfarcts4, c);
        c.gridx = 1;
        c.gridy = 27;
        container.add(checkInfarcts5, c);
        c.gridx = 2;
        c.gridy = 27;
        container.add(checkInfarcts6, c);

        c.gridx = 0;
        c.gridy = 28;
        c.gridwidth = 3;
        c.insets = new Insets(5,0,0,0);
        container.add(text10, c);

        c.gridy = 29;
        c.gridwidth = 3;
        c.insets = new Insets(0,0,0,0);
        container.add(check, c);
        
        Font font1 = new Font("Arial", Font.BOLD, 16);
        Font font2 = new Font("Arial", Font.BOLD, 12);
        Font font3 = new Font("Arial", Font.PLAIN, 12);
        Color color = new Color(245,255,255);
        
        text1.setBackground(color);
        text1.setFont(font1);
        text2.setBackground(color);
        text2.setFont(font2);
        radio1.setFont(font3);
        radio2.setFont(font3);
        radio3.setFont(font3);
        text11.setBackground(color);
        text11.setFont(font3);
        text12.setBackground(color);
        text12.setFont(font3);
        text13.setBackground(color);
        text13.setFont(font3);
        textMin.setBackground(color);
        textMin.setFont(font3);
        textMax.setBackground(color);
        textMax.setFont(font3);
        spinnerWagaMin.setFont(font3);
        spinnerWagaMax.setFont(font3);
        spinnerWiekMin.setFont(font3);
        spinnerWiekMax.setFont(font3);
        spinnerWzrostMin.setFont(font3);
        spinnerWzrostMax.setFont(font3);
        checkP.setFont(font3);
        checkWg.setFont(font3);
        checkWz.setFont(font3);
        checkWk.setFont(font3);
        checkWzrost1.setFont(font3);
        checkWzrost2.setFont(font3);
        checkWzrost3.setFont(font3);
        checkWzrost4.setFont(font3);
        checkWzrost5.setFont(font3);
        checkWzrost6.setFont(font3);
        checkWiek1.setFont(font3);
        checkWiek2.setFont(font3);
        checkWiek3.setFont(font3);
        checkWiek4.setFont(font3);
        checkWiek5.setFont(font3);
        checkWiek6.setFont(font3);
        checkWaga1.setFont(font3);
        checkWaga2.setFont(font3);
        checkWaga3.setFont(font3);
        checkWaga4.setFont(font3);
        checkWaga5.setFont(font3);
        checkWaga6.setFont(font3);
        checkAARatio1.setFont(font3);
        checkAARatio2.setFont(font3);
        checkAARatio4.setFont(font3);
        checkAARatio5.setFont(font3);
        checkAARatio6.setFont(font3);
        checkDSSTest1.setFont(font3);
        checkDSSTest2.setFont(font3);
        checkDSSTest4.setFont(font3);
        checkDSSTest5.setFont(font3);
        checkDSSTest6.setFont(font3);
        checkInfarcts1.setFont(font3);
        checkInfarcts2.setFont(font3);
        checkInfarcts4.setFont(font3);
        checkInfarcts5.setFont(font3);
        checkInfarcts6.setFont(font3);
        
        button.setActionCommand("Press");
        button.addActionListener(new ButtonClickListener());
        button.setBackground(Color.blue);
        c.gridx = 0;
        c.gridy = 30;
        c.gridwidth = 3;
        c.anchor = GridBagConstraints.CENTER;
        container.add(button, c);
        button.setBackground(Color.blue);
    } 
    
    /**
     * The class which recognizes clicks on the buttons in class GUIDatabase.
     */
    private class ButtonClickListener implements ActionListener 
    {
        /**
         * The function representing the actions of the program in answer to user's actions.
         * @param e ActionEvent which was generated by user.
         */
        public void actionPerformed(ActionEvent e)
        {  
            Database database = new Database();  
            String message = "";
            int k = 1;
            String sex = "";
            if (radio1.isSelected())
            {
                try {
                    message += "Dla analizy zostały wybrane tylko kobiety";
                    sex = "Tylko kobiety";
                    database.readFileSex(database.patients, "Female", (Integer) spinnerWagaMin.getValue(),
                            (Integer) spinnerWagaMax.getValue(), (Integer) spinnerWzrostMin.getValue(), (Integer) spinnerWzrostMax.getValue(),
                            (Integer) spinnerWiekMin.getValue(), (Integer) spinnerWiekMax.getValue());
                } catch (Exception ex) {
                    Logger.getLogger(GUIDatabase.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (database.patients.size() == 0) {
                    message += "Żaden pacjent nie pasuje do wybranych kryteriów";
                    k = 0;
                }
            }
            else if (radio2.isSelected())
            {
                try {
                    message += "Dla analizy zostali wybrane tylko mężczyzny";
                    sex = "Tylko mężczyzny";
                    database.readFileSex(database.patients, "Male", (Integer) spinnerWagaMin.getValue(),
                            (Integer) spinnerWagaMax.getValue(), (Integer) spinnerWzrostMin.getValue(), (Integer) spinnerWzrostMax.getValue(),
                            (Integer) spinnerWiekMin.getValue(), (Integer) spinnerWiekMax.getValue());
                } catch (Exception ex) {
                    Logger.getLogger(GUIDatabase.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (database.patients.size() == 0) {
                    message += "Żaden pacjent nie pasuje do wybranych kryteriów";
                    k = 0;
                }
            }
            else if (radio3.isSelected())
            {
                message += "Dla analizy zostali wybrane wszyscy";
                sex = "Wszyscy pacjenci";
                
                database.readFile(database.patients, (Integer) spinnerWagaMin.getValue(),
                            (Integer) spinnerWagaMax.getValue(), (Integer) spinnerWzrostMin.getValue(), (Integer) spinnerWzrostMax.getValue(),
                            (Integer) spinnerWiekMin.getValue(), (Integer) spinnerWiekMax.getValue());
                if (database.patients.size() == 0) {
                    message += "Żaden pacjent nie pasuje do wybranych kryteriów";
                    k = 0;
                }
            }
            else 
            {
                message += "Proszę wybrać jedną opcję: \ntylko kobiety LUB tylko mężczyzny LUB wszyscy";
                k = 0;
            }
            if (k == 1)
            {
                if (checkP.isSelected()==false && checkWiek1.isSelected()==false && checkWiek2.isSelected()==false && checkWiek3.isSelected()==false && checkWaga1.isSelected()==false 
                        && checkWaga2.isSelected()==false && checkWaga3.isSelected()==false && checkWzrost1.isSelected()==false && checkWzrost2.isSelected()==false 
                        && checkWzrost3.isSelected()==false && checkAARatio1.isSelected()==false && checkAARatio2.isSelected()==false && checkDSSTest1.isSelected()==false 
                        && checkDSSTest2.isSelected()==false && checkInfarcts1.isSelected()==false && checkInfarcts2.isSelected()==false 
                        && checkWg.isSelected()==false && checkWz.isSelected()==false && checkWk.isSelected()==false)
                {
                    message += "\nProszę wybrać conajmniej jeden parametr dla analizy";
                }
                message += ((checkWiek1.isSelected() ||  checkP.isSelected()) ?  ("\n- Średnia wartość wieku: " + Statistics.averageAge(database.patients)) : "");
                message += ((checkWiek2.isSelected() ||  checkP.isSelected()) ?  ("\n- Odchylenie standardowe wieku: " + Statistics.standardDeviationAge(database.patients)) : "");
                message += ((checkWiek4.isSelected() ||  checkP.isSelected()) ?  ("\n- Mediana dla wieku: " + Statistics.medianAge(database.patients)) : "");
                message += ((checkWiek5.isSelected() ||  checkP.isSelected()) ?  ("\n- Kwartyl górny dla wieku: " + Statistics.firstQuartileAge(database.patients)) : "");
                message += ((checkWiek6.isSelected() ||  checkP.isSelected()) ?  ("\n- Kwartyl dolny dla wieku: " + Statistics.thirdQuartileAge(database.patients)) : "");
                
                message += ((checkWaga1.isSelected() ||  checkP.isSelected()) ?  ("\n- Średnia wartość wagi: " + Statistics.averageWeight(database.patients)) : "");
                message += ((checkWaga2.isSelected() ||  checkP.isSelected()) ?  ("\n- Odchylenie standardowe wagi: " + Statistics.standardDeviationWeight(database.patients)) : "");
                message += ((checkWaga4.isSelected() ||  checkP.isSelected()) ?  ("\n- Mediana dla wagi: " + Statistics.medianWeight(database.patients)) : "");
                message += ((checkWaga5.isSelected() ||  checkP.isSelected()) ?  ("\n- Kwartyl górny dla wagi: " + Statistics.firstQuartileWeight(database.patients)) : "");
                message += ((checkWaga6.isSelected() ||  checkP.isSelected()) ?  ("\n- Kwartyl dolny dla wagi: " + Statistics.thirdQuartileWeight(database.patients)) : "");
                
                message += ((checkWzrost1.isSelected() ||  checkP.isSelected()) ?  ("\n- Średnia wartość wzrostu: " + Statistics.averageHeight(database.patients)) : "");
                message += ((checkWzrost2.isSelected() ||  checkP.isSelected()) ?  ("\n- Odchylenie standardowe wzrostu: " + Statistics.standardDeviationHeight(database.patients)) : "");
                message += ((checkWzrost4.isSelected() ||  checkP.isSelected()) ?  ("\n- Mediana dla wzrostu: " + Statistics.medianHeight(database.patients)) : "");
                message += ((checkWzrost5.isSelected() ||  checkP.isSelected()) ?  ("\n- Kwartyl górny dla wzrostu: " + Statistics.firstQuartileHeight(database.patients)) : "");
                message += ((checkWzrost6.isSelected() ||  checkP.isSelected()) ?  ("\n- Kwartyl dolny dla wzrostu: " + Statistics.thirdQuartileHeight(database.patients)) : "");
                
                message += ((checkAARatio1.isSelected() ||  checkP.isSelected()) ?  ("\n- Średnia wartość stosunku skurczowego ciśnienia krwi pacjenta "
                        + "mierzonego w kostce pacjenta podczas MRI do skurczowego ciśnienia \n"
                        + "krwi mierzonego w ramieniu pacjenta: " + Statistics.averageAnkleArmRatio(database.patients)) : "");
                message += ((checkAARatio2.isSelected() ||  checkP.isSelected()) ?  ("\n- Odchylenie standardowe stosunku skurczowego ciśnienia krwi pacjenta "
                        + "mierzonego w kostce pacjenta podczas MRI do skurczowego ciśnienia "
                        + "\nkrwi mierzonego w ramieniu pacjenta: " + Statistics.standardDeviationAnkleArmRatio(database.patients)) : "");
                message += ((checkWiek4.isSelected() ||  checkP.isSelected()) ?  ("\n- Mediana dla stosunku skurczowego ciśnienia krwi pacjenta "
                        + "mierzonego w kostce pacjenta podczas MRI do skurczowego ciśnienia "
                        + "\nkrwi mierzonego w ramieniu pacjenta: " + Statistics.medianAnkleArmRatio(database.patients)) : "");
                message += ((checkWiek5.isSelected() ||  checkP.isSelected()) ?  ("\n- Kwartyl górny dla stosunku skurczowego ciśnienia krwi pacjenta "
                        + "mierzonego w kostce pacjenta podczas MRI do skurczowego ciśnienia "
                        + "\nkrwi mierzonego w ramieniu pacjenta: " + Statistics.firstQuartileAnkleArmRatio(database.patients)) : "");
                message += ((checkWiek6.isSelected() ||  checkP.isSelected()) ?  ("\n- Kwartyl dolny dla stosunku skurczowego ciśnienia krwi pacjenta "
                        + "mierzonego w kostce pacjenta podczas MRI do skurczowego ciśnienia "
                        + "\nkrwi mierzonego w ramieniu pacjenta: " + Statistics.thirdQuartileAnkleArmRatio(database.patients)) : "");
                
                message += ((checkDSSTest1.isSelected() ||  checkP.isSelected()) ?  ("\n- Średnia wartość oceny pacjentów z \"The Digit Symbol Substitution Test\": " 
                        + Statistics.averageDigitSymbolSubstitutionTest(database.patients)) : "");
                message += ((checkDSSTest2.isSelected() ||  checkP.isSelected()) ?  ("\n- Odchylenie standardowe oceny pacjentów z \"The Digit Symbol Substitution Test\": " 
                        + Statistics.standardDeviationDigitSymbolSubstitutionTest(database.patients)) : "");
                message += ((checkDSSTest4.isSelected() ||  checkP.isSelected()) ?  ("\n- Mediana dla oceny pacjentów z \"The Digit Symbol Substitution Test\": " 
                        + Statistics.medianDigitSymbolSubstitutionTest(database.patients)) : "");
                message += ((checkDSSTest5.isSelected() ||  checkP.isSelected()) ?  ("\n- Kwartyl górny dla oceny pacjentów z \"The Digit Symbol Substitution Test\": "  + Statistics.firstQuartileDigitSymbolSubstitutionTest(database.patients)) : "");
                message += ((checkDSSTest6.isSelected() ||  checkP.isSelected()) ?  ("\n- Kwartyl dolny dla oceny pacjentów z \"The Digit Symbol Substitution Test\": "  + Statistics.thirdQuartileDigitSymbolSubstitutionTest(database.patients)) : "");
                
                message += ((checkInfarcts1.isSelected() ||  checkP.isSelected()) ?  ("\n- Średnia wartość liczby podejrzanych zawałów u pacjentów: " + Statistics.averageNumberInfarcts(database.patients)) : "");
                message += ((checkInfarcts2.isSelected() ||  checkP.isSelected()) ?  ("\n- Odchylenie standardowe liczby podejrzanych zawałów u pacjentów: " + Statistics.standardDeviationNumberInfarcts(database.patients)) : "");
                message += ((checkInfarcts4.isSelected() ||  checkP.isSelected()) ?  ("\n- Mediana dla liczby podejrzanych zawałów u pacjentów: " + Statistics.medianNumberInfarcts(database.patients)) : "");
                message += ((checkInfarcts5.isSelected() ||  checkP.isSelected()) ?  ("\n- Kwartyl górny dla liczby podejrzanych zawałów u pacjentów: " + Statistics.firstQuartileNumberInfarcts(database.patients)) : "");
                message += ((checkInfarcts6.isSelected() ||  checkP.isSelected()) ?  ("\n- Kwartyl dolny dla liczby podejrzanych zawałów u pacjentów: " + Statistics.thirdQuartileNumberInfarcts(database.patients)) : "");
            }
            
            if (checkWiek3.isSelected() ||  checkP.isSelected())
            {
                new Histogram().display(database.patients, sex, "Wiek");
            }
            if (checkWaga3.isSelected() ||  checkP.isSelected())
            {
                new Histogram().display(database.patients, sex, "Waga");
            }
            if (checkWzrost3.isSelected() ||  checkP.isSelected())
            {
                new Histogram().display(database.patients, sex, "Wzrost");
            }
            
            if (checkWg.isSelected() ||  checkP.isSelected())
            {
                try {
                    new HistogramFM().display("Waga", (Integer) spinnerWagaMin.getValue(),
                            (Integer) spinnerWagaMax.getValue(), (Integer) spinnerWzrostMin.getValue(), (Integer) spinnerWzrostMax.getValue(),
                            (Integer) spinnerWiekMin.getValue(), (Integer) spinnerWiekMax.getValue());
                } catch (Exception ex) {
                    Logger.getLogger(GUIDatabase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (checkWz.isSelected() ||  checkP.isSelected())
            {
                try {
                    new HistogramFM().display("Wzrost", (Integer) spinnerWagaMin.getValue(),
                            (Integer) spinnerWagaMax.getValue(), (Integer) spinnerWzrostMin.getValue(), (Integer) spinnerWzrostMax.getValue(),
                            (Integer) spinnerWiekMin.getValue(), (Integer) spinnerWiekMax.getValue());
                } catch (Exception ex) {
                    Logger.getLogger(GUIDatabase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (checkWk.isSelected() ||  checkP.isSelected())
            {
                try {
                    new HistogramFM().display("Wiek", (Integer) spinnerWagaMin.getValue(),
                            (Integer) spinnerWagaMax.getValue(), (Integer) spinnerWzrostMin.getValue(), (Integer) spinnerWzrostMax.getValue(),
                            (Integer) spinnerWiekMin.getValue(), (Integer) spinnerWiekMax.getValue());
                } catch (Exception ex) {
                    Logger.getLogger(GUIDatabase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            JOptionPane.showMessageDialog(null, message, "Raport", JOptionPane.PLAIN_MESSAGE);
            
            if (check.isSelected())
            {
                FileWriter writer = null;
                try {
                    int a = 0;
                    int n = 0;
                    String name = System.getProperty("user.dir") + "/Raport" + n + ".txt";
                    File file = new File(name);
                    while (a == 0) {
                        if (file.exists()) 
                        {
                            n++;
                            name = System.getProperty("user.dir") + "/Raport" + n + ".txt";
                            file = new File(name);
                        }
                        else{
                            try {
                                file.createNewFile();
                            } 
                            catch (IOException ex) {
                                Logger.getLogger(GUIDatabase.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            a = 1;
                            System.out.println("Raport został zapisany "+file.getName());
                        }
                    }
                    writer = new FileWriter(file);
                    writer.write(message);
                    writer.flush();
                    writer.close();
                } catch (IOException ex) {
                    Logger.getLogger(GUIDatabase.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        writer.close();
                    } catch (IOException ex) {
                        Logger.getLogger(GUIDatabase.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    
    }
}
    



