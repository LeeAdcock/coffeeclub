package com.capitalone.coffeeclub.trafficmanager

public class TrafficManager { 0
 
   public static void main(String[] args) { 

       TrafficLight north = new TrafficLight();
       TrafficLight east = new TrafficLight();
       TrafficLight south = new TrafficLight();
       TrafficLight west = new TrafficLight();
       
       System.out.println("north: "+north.toString());
       System.out.println("south: "+south.toString());
       
       north.setGreen(true);
       north.setYellow(true);

       System.out.println("north: "+north.toString());
       System.out.println("south: "+south.toString());
   }
   

   private static class TrafficLight extends Object {
       
       private boolean redIsOn = true;
       private boolean greenIsOn = false;
       private boolean yellowIsOn = false;
       
       boolean isRed() {
           return redIsOn;
       }

       void setRed(boolean isOn) {
           redIsOn = isOn;
           if(redIsOn) {
               setYellow(false);
               setGreen(false);
           }
       }
       
      boolean isYellow() {
           return yellowIsOn;
       }

       void setYellow(boolean isOn) {
           yellowIsOn = isOn;
           if(yellowIsOn) {
               setRed(false);
               setGreen(false);
           }
       }


       boolean isGreen() {
           return greenIsOn;
       }

       void setGreen(boolean isOn) {
           greenIsOn = isOn;
           if(greenIsOn) {
               setRed(false);
               setYellow(false);
           }
       }
       
       public String toString() {
           if(isRed()) { return "RED"; }
           if(isYellow()) { return "YELLOW"; }
           if(isGreen()) { return "GREEN"; }
           return "UNKNOWN"; //TODO Throw illegal state exception?
       }

   }
}