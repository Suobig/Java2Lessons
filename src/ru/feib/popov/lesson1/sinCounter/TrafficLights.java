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
public class TrafficLights {
    public double value = Math.PI / 2;
    public Signals signal = Signals.COUNT_SIN;
    
    public void switchStatus() {
        signal = (signal == Signals.COUNT_SIN ? Signals.COUNT_ASIN : Signals.COUNT_SIN);
    }
}
