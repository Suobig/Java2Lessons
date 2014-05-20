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
    final Sync sync;
    int iter;
    
    public SinCounter(String name, int iter, Sync tl) {
        super(name);
        this.iter = iter;
        this.sync = tl;
    }
    
    @Override 
    public void run() {
        for(int i = 0; i < iter; i++) {
            try {
                synchronized (sync) {
                    while (!(sync.signal == Signals.COUNT_SIN)) {
                        sync.wait();
                    }
                    sync.value = Math.sin(sync.value);
                    System.out.printf("%s : %.4f\n", this.getName(), sync.value);
                    sync.switchStatus();
                    sync.notify();
                }
            } catch (InterruptedException interruptedException) {
                Logger.getLogger(this.getName()).
                        log(Level.SEVERE, null, interruptedException);
            } 
        }
    }    
}
