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
public class Cycle extends Entry{
    
    private String terrain;
    private String tempo;
            
    public Cycle(String n, int d, int m, int y, int h, int min, int s, float dist, String terrain, String tempo) {
        super(n, d, m, y, h, min, s, dist);
        
        this.terrain = terrain;
        this.tempo = tempo;
    }
    public String getTerrain(){
        return terrain;
    }
    
    public String getTempo(){
        return tempo;
    }
    
    public String getEntry () {
   String result = getName()+" Cycled " + getDistance()  +" km in "
             +getHour()+":"+getMin()+":"+ getSec() +" with "+ getTerrain() + " terrain, and "+ getTempo()+ " tempo, on "
             +getDay()+"/"+getMonth()+"/"+getYear()+"\n";
   return result;
  } //getEntry
}
