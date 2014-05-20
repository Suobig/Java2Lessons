/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.feib.popov.lesson1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Антон
 */
public class MyWaitingThread extends Thread {
//    private final Thread tw;
    private final Notifier notifier;
    int iter;
//    public MyWaitingThread(String name, Thread threadToJoin) {
//        super(name);
//        this.tw = threadToJoin;
//    }
    
    public MyWaitingThread(String name, int iter, Notifier n) {
        super(name);
        this.iter = iter;
        this.notifier = n;
    }
    
//    @Override
//    public void run() {
//        try {
//            tw.join();
//        } catch (InterruptedException ex) {
//            Logger.getLogger(MyWaitingThread.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        for (int i = 0; i < 100; i++) {
//            System.out.printf("%s : %d\n", this.getName(), i);
//        }
//    }
            
    @Override
    public void run() {
        try {
            synchronized(notifier) {
                //Условие пробуждения
                while(!(notifier.counter >= notifier.MAX_ITER / 2)) {
                    //Когда объект засыпает, он отдает все свои мониторы.
                    notifier.wait();
                }
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(MyWaitingThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (int i = 0; i < iter; i++) {
            System.out.printf("%s : %d\n", this.getName(), i);
        }
    }
}
