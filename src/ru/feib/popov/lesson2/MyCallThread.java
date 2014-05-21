/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.feib.popov.lesson2;

import java.util.concurrent.Callable;

/**
 *
 * @author popov
 */
public class MyCallThread implements Callable<Integer> {
    
    @Override
    public Integer call() throws Exception {
        int summa = 0;
        for (int i = 1; i <= 1000; i++) {
            summa += i;
        }
        
        return summa;
    }
    
}
