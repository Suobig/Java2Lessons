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
public class Sync {
    public double value = 1;
    public Signals signal = Signals.COUNT_SIN;
    
    public void switchStatus() {
        signal = (signal == Signals.COUNT_SIN ? Signals.COUNT_ASIN : Signals.COUNT_SIN);
    }
}
