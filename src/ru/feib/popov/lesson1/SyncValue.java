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
public class SyncValue {
    /*
    volatile запрещает системе копировать объект в кеш процессора, что помогает
    избежать ошибок, связанных с совместным доступом.
    Имеет смысл только для мутабельных объектов.
    */
    public volatile int counter = 0;
}
