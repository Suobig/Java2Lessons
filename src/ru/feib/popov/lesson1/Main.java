package ru.feib.popov.lesson1;
//import java.io.IOException;

import ru.feib.popov.lesson1.sinCounter.TrafficLights;
import ru.feib.popov.lesson1.sinCounter.SinCounter;
import ru.feib.popov.lesson1.sinCounter.ASinCounter;
import java.util.logging.Level;
import java.util.logging.Logger;


//import java.util.logging.Level;
//import java.util.logging.Logger;


public class Main {

        
    public static void main(String[] args) {
        // По умолчанию потоки асинхронны
        // Моменты переключения от нас не зависят - решает машина
        // Можно назначать приоритеты, но это не обеспечит синхронность.
        // Синхронизация требуется для взаимодействия, например, обмен данными
        // Значит, поток, требующий данных, должен дождаться момента окончания расчета или завершения потока.
        // Это организуется с помощью усыпления потоков
        // Процесс можно усыпить и разбудить будильником
        // Весь процесс синхронизации построен на будильниках
        //	Можно усыпить на время
        //	Можно усыпить до окончания
        //	Можно усыпить до сигнала
        //	Можно завязать на общие ресурсы
        //	Запуск нового процесса - класс java.lang.Runtime

        //Запуск процесса
        /*
        final String APPLICATION = "explorer.exe";
        System.out.println("starting "+ APPLICATION);
        try {
                Runtime.getRuntime().exec(APPLICATION);
        } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        System.out.println("started " + APPLICATION);
        */


        // java.lang.Thread позволяет управлять потоками.
        // Как создать поток:
        // 1. Создать класс и реализовать интерфейс Runnable 
        // 2. Сделать наследника Thread и переопределить метод Run (самый используемый)
        // 3. Реализовать интерфейс Callable<>
        // Отличие: вместо run() - call() которое возвращает значение.
        //
        /*
        Thread t1 = new MyThread("t1");

        // Определяем метод run(), а запускаем метод start();
         t1.start();
        Thread t2 = new MyThread("t2");
        t2.start();

        // Второй вариант создания     
        MySimpleThread mst  = new MySimpleThread();
        Thread t3 = new Thread(mst);
        t3.start();

        // Второй вариант с анонимными классом
        (new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("Simple Thread #2");
                }
            }
        })).start();
        */
/*
        Основные методы Thread
            Имя, которое меняется методоми get/setName;
            Приоритет: get/setPriority;
            Демон: is/setDemon;
            (Демон - поток, работа которого не блокирует завершение Main
            Используется при создании серверов для обработки запросов. Тогда
            по команде на остановку сервера поток Main сразу завершится.
            Например GC - демон)
            Получить текущий экземпляр потока: currentThread()
*/            
        //получаем имя потока main:
//            System.out.println(Thread.currentThread().getName());
/*
        Методы stop, suspend - deprecated. Их использование может приводить
        взаимным блокировкам - дедлокам. Использование этих методов
        не приводит к высвобождению ресурсов.
        Для высвобождения ресусов используются методы:
         * sleep(...) - усыпление на n секунд
        Статический метод применяется к текущему потоку
        Окружается try-catch
*/
            
//            System.out.println("Спокойной ночи!");
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            System.out.println("Пора просыпаться!");

/*
            Синхронизация потоков методом join():
*/            
//            Thread t1 = new MyThread("A");
//            Thread t2 = new MyThread("B");
//            
//            t1.start();
//            t2.start();
//            
//            try {
//                t1.join();
//            } catch (InterruptedException ex) {
//                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            
//            try {
//                t2.join();
//            } catch (InterruptedException ex) {
//                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            
//            System.out.println("Я последний!");
        /*            
            Семантика join: усыпляет текущий поток, пока не завершится вызываемый
            объект. С точки зрения ООП все с ног на голову.
            При последовательном ожидании потоков порядок вызова join() не важен.
        */
//            Thread t1 = new MyThread("A");
//            Thread t2 = new MyWaitingThread("B", t1);
//            
//            t1.start();
//            t2.start();
//            Попытка некотролируемого использования общей памяти.
//            badSharedVariables();
//            Контролируемое использование общей памяти.
//            synchronizedValue();
            /*
                Преимущество синхронизации через метод: не надо писать лишних синхронизаций
                Недостаток: синхронизация будет идти даже в случае, если приложение
                однопоточное.
                Поэтому для работы со строками существует 2 класса:
                    - StringBuilder, у которого все метода асинхронны
                    - StringBuffer, у которого все методы синхронны.
                Аналогично есть Vector и ArrayList

                Для некоторых коллекций в классе java.util.Collection методы
                получения их синхронных версий (synchronizedSet, synchronizedMap, etc.)
            */
//            synchronizedMethod();
            /*
                Для того, чтобы нити могли обмениваться сообщениями, используются
                методы wait(), notify() и notifyAll() класса Object.
                wait() усыпляет поток до тех пор, пока ему не сделают notify().
                Методы wait() и notify() вызываются у некоего синхронизационного
                объекта, который есть в обоих потоках. Т.о. можно передавать
                данные вместе с сообщением. 
                Если передавать данные не требу
            */
//            synchronizeByEvents();
        }
        
        /*
            Потоки обращаются к одной и той же области памяти, на которую ссылаются
            на одну и ту же переменную counter
        */
        public static int badCounter;
        public static void badSharedVariables() {
            final int ITER_COUNT = 100_000;
            
            Thread t1 = new MyThread("A", ITER_COUNT);
            Thread t2 = new MyThread("B", ITER_COUNT);
            
            t1.start();
            t2.start();
            
            try {
                t1.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                t2.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            /*
                counter <= (!!!) ITER_COUNT * 2. Операция присваивания не атомарное
                действие (таких действий очень мало. Даже операция получения 
                текущего значения может быть не атомарной (int - атомарная, 
                long - нет). Иногда второй поток "вклинивается"
                в процесс, увеличения переменной и перменная увеличивается лишь
                один раз.
                Синхронизация доступа к объектам осуществляется с помощью мониторов,
                которые контролируют доступ к данным.
                Если поток свободен - монитор вернет ссылку на объек. 
                Если поток занят - монитор усыпит поток, пытающийся подключиться
                к данным и будит его. При этом если в очереди на получение данных 
                стоит несколько потоков, разбужен будет не первый пришедший, а
                случайны поток.
                Однако мониторы работают только со ссылками. Если 
            */
            System.out.printf("Total : %d\n", badCounter);
        }
        
    /*
        counter = ITER_COUNT * 2. Это обеспечивается оператором synchronized(){};    
        Поток, захватывающий объект, называется "владелец монитора".
        Может возникнуть ситуация, когда два потока одного процесса разнесены
        на разные ядра. В таком случае в кеше памяти каждого ядра будет по
        экземпляру объекта sync, что снова приведет к ошибке.
    */
        
    private static void synchronizedValue() {
            final int ITER_COUNT = 100_000;
            
            SyncValue sync = new SyncValue();
            
            Thread t1 = new MyThread("A", ITER_COUNT, sync);
            Thread t2 = new MyThread("B", ITER_COUNT, sync);
            
            t1.start();
            t2.start();
            
            try {
                t1.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                t2.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.printf("Total : %d\n", sync.counter);
    }
    
    private static void synchronizedMethod() {
        final int ITER_COUNT = 1_000;
            SyncMethod sync = new SyncMethod();
            
            Thread t1 = new MyThread("A", ITER_COUNT, sync);
            Thread t2 = new MyThread("B", ITER_COUNT, sync);
            
            t1.start();
            t2.start();
            
            try {
                t1.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                t2.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.printf("Total by method : %d\n", sync.getCounter());
    }

    private static void synchronizeByEvents() {
        final int ITER_COUNT = 100;
        Notifier notifier = new Notifier(ITER_COUNT);
        
        Thread t1 = new MyNotifyThread("A", ITER_COUNT, notifier);
        Thread t2 = new MyWaitingThread("B", ITER_COUNT, notifier);
        
        t1.start();
        t2.start();
    }   
}