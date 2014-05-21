/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.feib.popov.lesson1.Integral.Math;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author popov
 */
public class Integral {
    public static final int STEPS = 500_000_000;
    
    private Integral() {};
       
    protected static double singleThreadCount(MathFunction func, double a, 
            double b, int steps, IntegralProgress p) {
        
        double h = (b - a) / steps;
        double summa = 0D;
        int procent = 0;
        CountValues cv = new CountValues(steps);
        long threadId = Thread.currentThread().getId();
        
        for(long i = 0; i < steps; i ++) {
            double x = a + h * i + h / 2;
            double y = func.f(x);
            summa += y * h;
            
            if(p != null) {
                int newProcent = (int)((100 * i) / steps);
                if(newProcent - procent >= p.getStep()) {
                    procent = newProcent;
                    cv.counted = i;
                    p.showProgress(threadId, cv);
                }
            }
        } 
        return summa;
    }
    
    public static  double singleThreadCount(MathFunction func, double a, 
            double b) {
        return singleThreadCount(func, a, b, STEPS, null);
    }
    
    public static  double singleThreadCount(MathFunction func, double a, 
            double b, IntegralProgress p) {
        return singleThreadCount(func, a, b, STEPS, p);
    }
    
    public static double multiThreadCount(MathFunction func, 
            double a, double b, int numThreads) { 
        ThreadSync sync = new ThreadSync(numThreads);
        Notifier notifier = new Notifier();
        
        double h = (b - a) / numThreads;
        for (int i = 0; i < numThreads; i++) {
            double c = a + i * h;
            double d = c + h;
            
            Thread t = new IntegralThread(func, c, d, STEPS / numThreads, 
                    sync, notifier);
            t.start();
        }
        
        while(!sync.isFinished()) {
            synchronized(notifier) {
                try {
                    notifier.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Integral.class.getName()).
                            log(Level.SEVERE, null, ex);
                }
            }
        }        
        return sync.getSumm();
   }
    
    public static double multiThreadCount(MathFunction func, 
            double a, double b, int numThreads, IntegralProgress p) { 
        ThreadSync sync = new ThreadSync(numThreads);
        Notifier notifier = new Notifier();
        
        double h = (b - a) / numThreads;
        for (int i = 0; i < numThreads; i++) {
            double c = a + i * h;
            double d = c + h;
            
            Thread t = new IntegralThread(func, c, d, STEPS / numThreads, 
                    sync, notifier, p);
            t.start();
        }
        
        while(!sync.isFinished()) {
            synchronized(notifier) {
                try {
                    notifier.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Integral.class.getName()).
                            log(Level.SEVERE, null, ex);
                }
            }
        }        
        return sync.getSumm();
   }
}

class IntegralThread extends Thread {
    private final MathFunction func;
    private final double a;
    private final double b;
    private final int steps;
    private final ThreadSync sync;
    private final Notifier n;
    private final IntegralProgress p;

    public IntegralThread(MathFunction func, double a, double b, 
            int steps, ThreadSync sync, Notifier n) {
        this(func, a, b, steps, sync, n, null);
    }
    
    public IntegralThread(MathFunction func, double a, double b, 
            int steps, ThreadSync sync, Notifier n, IntegralProgress p) {
        this.func = func;
        this.a = a;
        this.b = b;
        this.steps = steps;
        this.n = n;
        this.sync = sync;
        this.p = p;
    }
    
    @Override
    public void run() {
        double y = Integral.singleThreadCount(func, a, b, steps, p);
        sync.add(this.getId(), y);
        synchronized(n) {
            n.notify();
        }
    }   
}

class ThreadSync {
    private final int size;
    private volatile double summ = 0;
    private final Stack<Long> stack = new Stack<>();
    
    public ThreadSync(int size) {
        this.size = size;
    }
    
    public synchronized void add(long id, double value) {
        stack.add(id);
        summ += value;
    }
    
    public double getSumm() {
        return summ;
    }
    
    public boolean isFinished() {
        return stack.size() == size;
    }
}

class Notifier {}