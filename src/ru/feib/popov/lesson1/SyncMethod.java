/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.feib.popov.lesson1;

/**
 *
 * @author Антон
 */
public class SyncMethod {
    private volatile int counter = 0;

    public synchronized int getCounter() {
        return counter;
    }
     /*
    Модификатор synchronized приводит к захвату процессом,
    вызвавшим этот метод, монитора над этим объектом.
    */
    public synchronized void incrementCounter() {
        counter++;
    }
}
