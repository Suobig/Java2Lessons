/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.feib.popov.lesson1.sinCounter;

/**
 *
 * @author Антон
 */
public class CountRunner {
    public static void main(String[] args) {
        final int NUM_ITER = 1_000;
        TrafficLights tl = new TrafficLights();
        Thread t1 = new SinCounter(" Sin", NUM_ITER, tl);
        Thread t2 = new ASinCounter("ASin", NUM_ITER, tl);
        
        t1.start();
        t2.start();
    }
}
