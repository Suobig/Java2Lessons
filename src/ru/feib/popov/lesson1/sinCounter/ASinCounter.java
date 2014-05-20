/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.feib.popov.lesson1.sinCounter;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Антон
 */
public class ASinCounter extends Thread {
    final TrafficLights tl;
    int iter;
    
    public ASinCounter(String name, int iter, TrafficLights cs) {
        super(name);
        this.tl = cs;
        this.iter = iter;
    }
    
    @Override 
    public void run() {       
        for(int i = 0; i < iter; i++) {
            try {
                 synchronized (tl) {
                     while (!(tl.signal == Signals.COUNT_ASIN)) {
                         tl.wait();
                     }
                     tl.value = Math.asin(tl.value);
                     System.out.printf("%s : %.4f\n", this.getName(), tl.value);
                     tl.switchStatus();
                     tl.notify();
                 }
             } catch (InterruptedException interruptedException) {
                 Logger.getLogger(this.getName()).
                         log(Level.SEVERE, null, interruptedException);
             } 
        }
    }   
}
