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
public class SinCounter extends Thread {
    final TrafficLights tl;
    int iter;
    
    public SinCounter(String name, int iter, TrafficLights tl) {
        super(name);
        this.iter = iter;
        this.tl = tl;
    }
    
    @Override 
    public void run() {
        for(int i = 0; i < iter; i++) {
            try {
                synchronized (tl) {
                    while (!(tl.signal == Signals.COUNT_SIN)) {
                        tl.wait();
                    }
                    tl.value = Math.sin(tl.value);
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
