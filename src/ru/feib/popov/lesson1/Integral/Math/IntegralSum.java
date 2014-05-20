/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.feib.popov.lesson1.Integral.Math;

/**
 *
 * @author popov
 */
public class IntegralSum {
    private volatile double s;
    
    public synchronized void increase(double v) {
        s += v;
    }
    
    public double get() {
        return s;
    }
}
