/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stir.cscu9t4practical1;

/**
 *
 * @author Ben
 */
public class Run extends Entry{
    
    private int sprints;
    private int recoveryTime;
    
    public Run(String n, int d, int m, int y, int h, int min, int s, float dist,int sprints, int recoveryTime) {
        super(n, d, m, y, h, min, s, dist);
        this.sprints = sprints;
        this.recoveryTime = recoveryTime;
    }
    
    public int getSprints(){
        return sprints;
    }
    
    public int getRecoveryTime(){
        return recoveryTime;
    }
    
    public String getEntry () {
   String result = getName()+" ran " + getDistance()  +" km in "
             +getHour()+":"+getMin()+":"+ getSec() +" in "+ getSprints() + " run(s) with"+ getRecoveryTime()+ " recovery time, on "
             +getDay()+"/"+getMonth()+"/"+getYear()+"\n";
   return result;
  } //getEntry
    
}
