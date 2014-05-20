/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.feib.popov.lesson1.Integral.Math;

import java.util.*;

/**
 *
 * @author popov
 */
public class Integral {

    public static final int STEPS = 300_000_000;
    static double singleThreadCount(MathFunction func, double a, 
            double b, int steps) {
        double h = (b - a) / steps;
        double summa = 0D;
        for(int i = 0; i < steps; i ++) {
            double x = a + h * i + h / 2;
            double y = func.f(x);
            summa += y * h;
        } 
        return summa;
    }
    
    public static  double singleThreadCount(MathFunction func, double a, 
            double b) {
        return singleThreadCount(func, a, b, STEPS);
    }
    
    public static double multiThreadCount(MathFunction func, 
            double a, double b, int numThreads) { 
        
        IntegralSum s = new IntegralSum();
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < numThreads; i++) {
            Thread t = new Thread();
            
        }
   }
}
