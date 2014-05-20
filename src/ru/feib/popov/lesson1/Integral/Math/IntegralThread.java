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
public class IntegralThread extends Thread {
    double s;

    public IntegralThread(double s, String name) {
        super(name);
        this.s = s;
    }
    
    @Override
    public void run() {
        
    }
}
