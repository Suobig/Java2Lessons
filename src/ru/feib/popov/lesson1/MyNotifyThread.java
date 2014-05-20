/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.feib.popov.lesson1;

import static java.lang.System.out;

/**
 *
 * @author Антон
 */
public class MyNotifyThread  extends Thread {
    int iter = 100;
    final Notifier notifier;
  
    public MyNotifyThread(String name, int iter, Notifier n) {
        super(name);
        this.iter = iter;
        this.notifier = n;
    }


    @Override
    public void run() {
            for (int i = 0; i < iter; i++) {
                out.printf("%s : %d\n", this.getName(),  i);
                synchronized(notifier) {
                    //Пусть просыпающийся поток сам проверяет условие пробуждения
                    notifier.counter = i;
                    notifier.notify();
                }
        }
    }
}
