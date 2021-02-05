// GUI and main program for the Training Record
package com.stir.cscu9t4practical1;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;

public class TrainingRecordGUI extends JFrame implements ActionListener {

    private JTextField name = new JTextField(30);
    private JTextField day = new JTextField(2);
    private JTextField month = new JTextField(2);
    private JTextField year = new JTextField(4);
    private JTextField hours = new JTextField(2);
    private JTextField mins = new JTextField(2);
    private JTextField secs = new JTextField(2);
    private JTextField dist = new JTextField(4);
    private JTextField sprintsORTerrainORLocation = new JTextField(4);
    private JTextField  recoveryTimeORTempo= new JTextField(4);
    private JLabel labn = new JLabel(" Name:");
    private JLabel labd = new JLabel(" Day:");
    private JLabel labm = new JLabel(" Month:");
    private JLabel laby = new JLabel(" Year:");
    private JLabel labh = new JLabel(" Hours:");
    private JLabel labmm = new JLabel(" Mins:");
    private JLabel labs = new JLabel(" Secs:");
    private JLabel labdist = new JLabel(" Distance (km):");
    private JLabel labsprintsORTerrainORLocation = new JLabel("sprints/Terrain/Location");
    private JLabel labrecoveryTimeORTempo = new JLabel("recoveryTime/Tempo");
    private JButton addR = new JButton("AddRun");
    private JButton addC = new JButton("AddCycle");
    private JButton addS = new JButton("AddSwim");
    private JButton lookUpByDate = new JButton("Look Up");
    private JButton FindAllByDate = new JButton("Find By Date");
    private JButton remove = new JButton("Remove");

    private TrainingRecord myAthletes = new TrainingRecord();

    private JTextArea outputArea = new JTextArea(5, 50);

    public static void main(String[] args) {
        TrainingRecordGUI applic = new TrainingRecordGUI();
    } // main

    // set up the GUI 
    public TrainingRecordGUI() {
        super("Training Record");
        setLayout(new FlowLayout());
        add(labn);
        add(name);
        name.setEditable(true);
        add(labd);
        add(day);
        day.setEditable(true);
        add(labm);
        add(month);
        month.setEditable(true);
        add(laby);
        add(year);
        year.setEditable(true);
        add(labh);
        add(hours);
        hours.setEditable(true);
        add(labmm);
        add(mins);
        mins.setEditable(true);
        add(labs);
        add(secs);
        secs.setEditable(true);
        add(labdist);
        add(dist);
        dist.setEditable(true);
        
        
        add(labsprintsORTerrainORLocation);
        add(sprintsORTerrainORLocation);
        sprintsORTerrainORLocation.setEditable(true);
        
        add(labrecoveryTimeORTempo);
        add(recoveryTimeORTempo);
        recoveryTimeORTempo.setEditable(true);
        
        add(addR);
        addR.addActionListener(this);
        
        add(addC);
        addC.addActionListener(this);
        
        add(addS);
        addS.addActionListener(this);
        
        add(lookUpByDate);
        lookUpByDate.addActionListener(this);
        
        
        //adding the find all by date button
        add(FindAllByDate);
        FindAllByDate.addActionListener(this);
        
        add(remove);
        remove.addActionListener(this);
        
        add(outputArea);
        outputArea.setEditable(false);
        setSize(1024, 200);
        setVisible(true);
        blankDisplay();

        // To save typing in new entries while testing, uncomment
        // the following lines (or add your own test cases)
        
    } // constructor

    // listen for and respond to GUI events 
    public void actionPerformed(ActionEvent event) {
        String message = "";
        if (event.getSource() == addR) {
            message = addRun("Run");
        }
        if (event.getSource() == addC) {
            message = addRun("Cycle");
        }
        if (event.getSource() == addS) {
            message = addRun("Swim");
        }
        if (event.getSource() == lookUpByDate) {
            message = lookupEntry();
        }
        if (event.getSource() == FindAllByDate) {
            message = lookupAllEntrys();       
        }if(event.getSource() == remove){
            message = removeEntry();
        }
        outputArea.setText(message);
        blankDisplay();
    } // actionPerformed

    public String addRun(String what) {
        
        
        
        
        try{
        String message = "Record added\n";
        
        if (name.getText().equals("")){         //test to find out if the text field was left blank
            return "please do not leave the name blank";
        }
        
        String n = name.getText();
        
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        
        if(!myAthletes.lookupEntryName(d,m,y,n).equals("No entries found")){    //test to see if two entries were made by the same person on the same day
            return "Please enter a new and unique entry";
        }
        
        float km = java.lang.Float.parseFloat(dist.getText());
        int h = Integer.parseInt(hours.getText());
        int mm = Integer.parseInt(mins.getText());
        int s = Integer.parseInt(secs.getText());
        
        if(what.equals("Run")){
            int sprints = Integer.parseInt(sprintsORTerrainORLocation.getText());
            int recoveryTime =Integer.parseInt(recoveryTimeORTempo.getText());
            Run e = new Run(n, d, m, y, h, mm, s, km, sprints, recoveryTime);
            myAthletes.addRun(e);
        }else if (what.equals("Cycle")){
            String terrain = sprintsORTerrainORLocation.getText();
            String tempo = recoveryTimeORTempo.getText();
            
            Cycle e = new Cycle(n, d, m, y, h, mm, s, km, terrain, tempo);
            myAthletes.addCycle(e);
        }else if (what.equals("Swim")){
            String location = sprintsORTerrainORLocation.getText();
            
            Swim e = new Swim(n, d, m, y, h, mm, s, km, location);
            myAthletes.addSwim(e);
        }
        
        
        
        System.out.println("Adding "+what+" entry to the records");
        return message;
        } catch (NumberFormatException nfe){                //exception if an integer is not entered in the correct place
            return "please enter a number in the date/time/distance boxes";
        }
    }
    
    public String lookupEntry() {
        try{
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        String message = myAthletes.lookupEntry(d, m, y);
        return message;
        
        
        } catch (NumberFormatException nfe){                //exception if an integer is not entered in the correct place
            return "please enter a number in the date boxes";
        }
    }
    
    public String lookupAllEntrys() {
        
        try
        {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        String message = myAthletes.lookupAllEntrys(d, m, y);
        return message;
        
        } catch (NumberFormatException nfe){                //exception if an integer is not entered in the correct place
            return "please enter a number in the date boxes";
        }
    }
    
    public String removeEntry(){
        String n = name.getText();
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        
        String message = myAthletes.removeEntry(n,d,m,y);
        return message;
    }

    public void blankDisplay() {
        name.setText("");
        day.setText("");
        month.setText("");
        year.setText("");
        hours.setText("");
        mins.setText("");
        secs.setText("");
        dist.setText("");
        sprintsORTerrainORLocation.setText("");
        recoveryTimeORTempo.setText("");

    }// blankDisplay
    // Fills the input fields on the display for testing purposes only
    public void fillDisplay(Entry ent) {
        name.setText(ent.getName());
        day.setText(String.valueOf(ent.getDay()));
        month.setText(String.valueOf(ent.getMonth()));
        year.setText(String.valueOf(ent.getYear()));
        hours.setText(String.valueOf(ent.getHour()));
        mins.setText(String.valueOf(ent.getMin()));
        secs.setText(String.valueOf(ent.getSec()));
        dist.setText(String.valueOf(ent.getDistance()));
    }

} // TrainingRecordGUI

