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
public interface IntegralProgress {
    void showProgress(long id, CountValues cv);
    int getStep();
}
