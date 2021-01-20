/*
Name:    TempConverter
Purpose: To demonstrate and exercise the uses of
         GUI components in java.
Author:  Tyron Corpuz
Date:    November 9th, 2020.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;

public class TempConverter extends JFrame
{
    //declare the stating dimensions of the window
    private int win_wid = 500;
    private int win_hei = 200;
    
    private JLabel fahrenLab, celsiusLab;
    private JTextField fahrenField, celsiusField;
    
    private JButton convertBut, clearBut;
    
    //create the constructor
    public TempConverter()
    {
        //set the title of the window
        this.setTitle("Convert Temperature");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(win_wid, win_hei);
        initWin();
        
        
        this.setVisible(true);
    }
    
    public boolean checkValid()
    {
        String userAnswerString = fahrenField.getText();
        double userAnswerDouble;
        
        try
        {
            userAnswerDouble = Double.parseDouble(userAnswerString);
        }
        catch(NumberFormatException nfe)
        {
            String errorMessage = "You have entered an invalid value";
            JOptionPane.showMessageDialog(null, errorMessage, "Error", 1, null);
            return false;
        }
        return true;
    }
    
    public void processTemp()
    {
        String userAnswerString = fahrenField.getText();
        double userAnswerDouble = Double.parseDouble(userAnswerString);
        double convertedAnswerDouble;
        String convertedAnswerString;
        
        convertedAnswerDouble = ((userAnswerDouble-32)*5)/9;
        DecimalFormat decFor  = new DecimalFormat("0.00");
        convertedAnswerString = decFor.format(convertedAnswerDouble);
        
        celsiusField.setText(convertedAnswerString);
    }
    
    public void initWin()
    {
        int titleFontSize = 25;
        int labFontSize = 15;
        
        Font titleFont = new Font("Arial", Font.BOLD, titleFontSize);
        Font labFont   = new Font("Arial", Font.BOLD, labFontSize);
        
        //create a panel for it to be automatically centered
        JPanel northPan  = new JPanel();
        JLabel titleLab = new JLabel("Convert to Celsius");
        
        //set the font
        titleLab.setFont(titleFont);
        titleLab.setForeground(Color.blue);
        
        //add it to the north panel
        northPan.add(titleLab);
        this.add(northPan, BorderLayout.NORTH);
        
        JPanel centerPan = new JPanel(new GridLayout(2,2));
        fahrenLab = new JLabel("Enter Fahrenheit temp.  ");
        fahrenLab.setFont(labFont);
        fahrenLab.setHorizontalAlignment(JLabel.RIGHT);
        centerPan.add(fahrenLab);
        fahrenField = new JTextField();
        fahrenField.setFont(labFont);
        centerPan.add(fahrenField);
        
        celsiusLab = new JLabel("Celsius temp.  ");
        celsiusLab.setFont(labFont);
        celsiusLab.setHorizontalAlignment(JLabel.RIGHT);
        centerPan.add(celsiusLab);
        celsiusField = new JTextField();
        celsiusField.setFont(labFont);
        centerPan.add(celsiusField);
        
        this.add(centerPan, BorderLayout.CENTER);
        
        JPanel southPan = new JPanel();
        convertBut = new JButton("Convert");
        convertBut.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                checkValid();
                processTemp();
            }
        });
        
        convertBut.setFont(labFont);
        
        clearBut = new JButton("Clear");
        clearBut.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                clear();
            }
        });
        clearBut.setFont(labFont);
        
        southPan.add(convertBut);
        southPan.add(clearBut);
        this.add(southPan, BorderLayout.SOUTH);
    }
    
    public void clear()
    {
        String clearAnswer = "";
        fahrenField.setText(clearAnswer);
        celsiusField.setText(clearAnswer);
    }
    
    public static void main(String [] args)
    {
        new TempConverter();
    }   
}
