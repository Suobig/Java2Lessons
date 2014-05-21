/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.feib.popov.lesson2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author popov
 */
public class MyThread extends Thread {
    private final Lock lock;

    public MyThread(Lock lock, String name) {
        super(name);
        this.lock = lock;
    }
    
    
    public void run() {
        try {
            while(!lock.tryLock(10, TimeUnit.MILLISECONDS)) {
                System.out.println("Waiting...");
            }
            try {
                for (int i = 0; i < 100; i++) {
                    System.out.printf("%s - %d\n", this.getName(), i);
                }
            } finally {
                lock.unlock();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
