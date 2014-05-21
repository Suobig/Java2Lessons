/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.feib.popov.lesson2;
import java.util.concurrent.*;

/**
 *
 * @author popov
 */
public class Main {
    /*
    Реализация интерфейса Callable
    Можно создать поток, который возвращает значения.
    Call в отличие от Run допускает выброс исключения
    Для вызова Call надо создать пул нитей. 
    Бывают простые, бывают фиксированные.
    Бывают сложные пулы, где потоков больше чем допустими для исполнения
    но  часть потоков ждет
    Используется для высоконагруженных сероверов. Например, пришло 10к запросов
    а потоков допускается 1к. Тогда 9к потов спят, а 1к выполняется.
    */
    public static void main(String[] args) 
            throws InterruptedException, ExecutionException {
        runPool();
    }
    
    public static void runPool() 
            throws InterruptedException, ExecutionException{
        /*
            Методы submit - загрузить поток
            invoke - загрузить коллекцию типизированных потоков.
            Принимает как Callable, так и Runnable
        */
        ExecutorService pool = Executors.newFixedThreadPool(1);
        
        Callable<Integer> t1 = new MyCallThread();
        /*
        Future - интерфейс
        Позволяет получить информацию о результате выполнения потока
        */
        Future<Integer> future = pool.submit(t1);
        /*
            Ждет выполнения потока.
            Аналог join
            Можно проверять - future.isDone()
        */
        Integer result = future.get();
        System.out.println(result);
        pool.shutdown();
    }
    
    public static void locks() {
        /*
            java.util.concurrent.locks
            Методы:
            lockInterruptibly() - можно разбудить методом interrupt
            newCondition() - возвращает объект интферейса Condition {
                Можно условно будить поток 
                await - ждать время аналог wait
                signal - аналог notify
            }
            На одну блокировку можно сделать сколько угодно Condition
        
            Классы- ReentrantLock 
            Простейший вариант семафора, практически имитирующий synchronized
        
        */
    }
    
}
