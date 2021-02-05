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
public class Swim extends Entry{
    private String location;
    public Swim(String n, int d, int m, int y, int h, int min, int s, float dist, String location) {
        super(n, d, m, y, h, min, s, dist);
        this.location =location;
    }
    
    public String getLocation(){
        return location;
    }
    
    public String getEntry () {
   String result = getName()+" Swam " + getDistance()  +" km in "
             +getHour()+":"+getMin()+":"+ getSec() +". Location: "+ getLocation() + " on "
             +getDay()+"/"+getMonth()+"/"+getYear()+"\n";
   return result;
  } //getEntry
    
}
