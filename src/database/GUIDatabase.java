/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author user
 */
public class GUIDatabase extends JFrame
{
    private JButton button = new JButton("Press");
    private JLabel statusLabel = new JLabel("",JLabel.CENTER);
    
    GUIDatabase()
    {
        super("Patient's database");
        setBounds(100, 100, 600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = getContentPane();
        container.setLayout(new FlowLayout(1));
        button.setActionCommand("Press");
        button.addActionListener(new ButtonClickListener());
        container.add(button);
        
        statusLabel.setSize(350,100);
    }    
    
    private class ButtonClickListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
            String command = e.getActionCommand();  
         
            if( command.equals( "Press" ))  
            {
                statusLabel.setText("Ok Button clicked.");
            } 
        }
    }
}
