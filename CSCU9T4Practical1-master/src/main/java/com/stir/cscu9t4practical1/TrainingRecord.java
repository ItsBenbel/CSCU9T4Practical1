// An implementation of a Training Record as an ArrayList
package com.stir.cscu9t4practical1;




import java.util.*;


public class TrainingRecord {
    private List<Run> trR;
    private List<Cycle> trC;
    private List<Swim> trS;
    
    public TrainingRecord() {
        trR = new ArrayList<Run>();
        trC = new ArrayList<Cycle>();
        trS = new ArrayList<Swim>();
        
    } //constructor
    
    // add a record to the list
   public void addRun(Run e){
       trR.add(e);    
   } // addClass
   public void addCycle(Cycle e){
       trC.add(e);    
   } // addClass
   public void addSwim(Swim e){
       trS.add(e);    
   } // addClass
   
   

   
   // look up the entry of a given day and month
   public String lookupEntry (int d, int m, int y) {
       ListIterator<Run> iter = trR.listIterator();
       String result = "No entries found";
       while (iter.hasNext()) {
          Run current = iter.next();
          if (current.getDay()==d && current.getMonth()==m && current.getYear()==y) 
             result = current.getEntry();           
            }
       
       ListIterator<Cycle> iter2 = trC.listIterator();

       while (iter2.hasNext()) {
          Cycle current = iter2.next();
          if (current.getDay()==d && current.getMonth()==m && current.getYear()==y) 
             result = current.getEntry();           
            }
       
       ListIterator<Swim> iter3 = trS.listIterator();

       while (iter3.hasNext()) {
          Swim current = iter3.next();
          if (current.getDay()==d && current.getMonth()==m && current.getYear()==y) {
             result = current.getEntry();           
            }
       }
       return result;
   } // lookupEntry
   
   public String lookupEntryName (int d, int m, int y, String name) {   //THIS METHOD IS USED TO CHECK THAT ATHLETES DO AT MOST ONE RUN PER DAY
       ListIterator<Run> iter = trR.listIterator();
       String result = "No entries found";
       while (iter.hasNext()) {
          Run current = (Run) iter.next();
          if (current.getDay()==d && current.getMonth()==m && current.getYear()==y && current.getName().equals(name)) {
             result = current.getEntry();           
          }  
       }
       
       ListIterator<Cycle> iter2 = trC.listIterator();
       while (iter2.hasNext()) {
          Cycle current = (Cycle) iter2.next();
          if (current.getDay()==d && current.getMonth()==m && current.getYear()==y && current.getName().equals(name)) {
             result = current.getEntry();           
          }
       }
       
       ListIterator<Swim> iter3 = trS.listIterator();
       while (iter3.hasNext()) {
          Swim current = (Swim) iter3.next();
          if (current.getDay()==d && current.getMonth()==m && current.getYear()==y && current.getName().equals(name)) {
             result = current.getEntry();           
          }
       }
       return result;
   } // lookupEntry
   
   // look up the entry of a given day and month
   public String lookupAllEntrys (int d, int m, int y) {
       ListIterator<Run> iter = trR.listIterator();
       String result = "";
       while (iter.hasNext()) {
          Run current = iter.next();
          if (current.getDay()==d && current.getMonth()==m && current.getYear()==y) 
             result = result+ current.getEntry();           //THE CHANGE TO ALLOW MULTIPLE RECORDS TO BE RETURNED
            }
       
       ListIterator<Cycle> iter2 = trC.listIterator();
       while (iter2.hasNext()) {
          Cycle current = (Cycle) iter2.next();
          if (current.getDay()==d && current.getMonth()==m && current.getYear()==y) {
             result = result +current.getEntry();           
          }
       }
       
       ListIterator<Swim> iter3 = trS.listIterator();
       while (iter3.hasNext()) {
          Swim current = (Swim) iter3.next();
          if (current.getDay()==d && current.getMonth()==m && current.getYear()==y) {
             result = result +current.getEntry();           
          }
       }
       if(result.equals("")){
           result = "No entries found";     //CHANGE TO ALLOW NO ENTRIES FOUND WHEN SEARCHING FOR MULTIPLE ENTRIES
       }
       return result;
   } // lookupEntry
   
   public String removeEntry(String n, int d, int m, int y){
      ListIterator<Run> iter = trR.listIterator();
       String result = "No entries found";
       while (iter.hasNext()) {
          Run current = (Run) iter.next();
          if (current.getDay()==d && current.getMonth()==m && current.getYear()==y && current.getName().equals(n)) {
             iter.remove(); 
             result = "entry removed";
          }  
       }
       
       ListIterator<Cycle> iter2 = trC.listIterator();
       while (iter2.hasNext()) {
          Cycle current = (Cycle) iter2.next();
          if (current.getDay()==d && current.getMonth()==m && current.getYear()==y && current.getName().equals(n)) {
             iter2.remove();     
             result = "entry removed";
          }
       }
       
       ListIterator<Swim> iter3 = trS.listIterator();
       while (iter3.hasNext()) {
          Swim current = (Swim) iter3.next();
          if (current.getDay()==d && current.getMonth()==m && current.getYear()==y && current.getName().equals(n)) {
             iter3.remove();
             result = "entry removed";
          }
       }
       return result;
   }
   
   
   // Count the number of entries
   public int getNumberOfEntries(){
       return trR.size()+trC.size()+trS.size();
   }
   // Clear all entries
   public void clearAllEntries(){
       trR.clear();
       trC.clear();
       trS.clear();
   }
   
} // TrainingRecord