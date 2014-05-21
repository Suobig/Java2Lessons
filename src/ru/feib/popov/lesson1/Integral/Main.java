/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.feib.popov.lesson1.Integral;
import java.util.*;
import ru.feib.popov.lesson1.Integral.Math.*;
/**
 *
 * @author popov
 */
public class Main {
    public static void main(String[] args) {
        MathFunction f = new MathFunction() {

            @Override
            public double f(double x) {
                return Math.sin(x);
            }
        };
        
//        singleThread(f);
        multiThread(f);
    }
    
    static void multiThread(MathFunction f) {
        final int NUM_THREADS = 20;
        
        IntegralProgress multiP = new IntegralProgress() {
            final int step = 1;
            int progress = 0;
            final Map<Long, CountValues> map = new HashMap<>();
            
            @Override
            public synchronized void showProgress(long id, CountValues cv) {
                if(!map.containsKey(id)) {
                    map.put(id, cv);
                }
                
                double counted = 0;
                double toCount = 0;
                for (Map.Entry<Long, CountValues> entry : map.entrySet()) {
                    CountValues value = entry.getValue();
                    counted += value.counted;
                    toCount += value.toCount;
                }
                
                int newProgress = (int)(100 * counted / toCount);
                
                if(newProgress - progress >= step) {
                    progress = newProgress;
                    System.out.printf("Progress : %d%%\n", 
                            progress);         
                }
            }
            
            @Override
            public int getStep() {
                return step;
            }
        };
        double t1 = System.currentTimeMillis();
        double r1 = Integral.multiThreadCount(f, 0, Math.PI / 2, 
                NUM_THREADS, multiP);
        System.out.printf("Multi thread integral : %.4f\n", r1);
        System.out.printf("Time (with overhead) : %f\n", System.currentTimeMillis() - t1);
        
        
        double t2 = System.currentTimeMillis();
        double r2=  Integral.multiThreadCount(f, 0, Math.PI / 2, NUM_THREADS);
        System.out.printf("Multi thread integral : %.4f\n", r2);
        System.out.printf("Time (no overhead) : %f\n", System.currentTimeMillis() - t2);
    }
    
    static void singleThread(MathFunction f) {
        IntegralProgress singleP = new IntegralProgress() {
            final int step = 10;
            
            @Override
            public synchronized void showProgress(long id, CountValues cv) {
                System.out.printf("Progress : %d%%\n", 
                        (int)(100 * cv.counted / cv.toCount));
            }
            
            @Override
            public int getStep() {
                return step;
            }
        };
        
        double t1 = System.currentTimeMillis();
        double r1 = Integral.singleThreadCount(f, 0, Math.PI / 2, singleP);
        System.out.printf("Singe thread integral : %.4f\n", r1);
        System.out.printf("Time (with overhead) : %f\n", System.currentTimeMillis() - t1);
        
        double t2 = System.currentTimeMillis();
        double r2 = Integral.singleThreadCount(f, 0, Math.PI / 2);
        System.out.printf("Singe thread integral : %.4f\n", r2);
        System.out.printf("Time (no overhead) : %f\n", System.currentTimeMillis() - t2);
    }
}
