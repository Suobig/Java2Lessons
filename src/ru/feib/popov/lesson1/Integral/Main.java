/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.feib.popov.lesson1.Integral;
import ru.feib.popov.lesson1.Integral.Math.*;
/**
 *
 * @author popov
 */
public class Main {
    public static void main(String[] args) {
        double t1 = System.currentTimeMillis();
        double r1 = Integral.singleThreadCount(new MathFunction() {

            @Override
            public double f(double x) {
                return Math.sin(x);
            }
        }, 0, Math.PI / 2);
        System.out.printf("Singe thread integral : %.4f\n", r1);
        System.out.printf("Time : %f\n", System.currentTimeMillis() - t1);
    }
}
