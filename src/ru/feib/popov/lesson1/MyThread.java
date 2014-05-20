package ru.feib.popov.lesson1;

import static java.lang.System.out;

public class MyThread extends Thread {
        int iter = 100;
        SyncValue syncValue;
        SyncMethod syncMethod;
        
        public MyThread(String name) {
		super(name);
	}

        public MyThread(String name, int iter) {
            super(name);
            this.iter = iter;
        }
        
        public MyThread(String name, int iter, SyncValue sync) {
            super(name);
            this.iter = iter;
            this.syncValue = sync;
        }
        
        public MyThread(String name, int iter, SyncMethod sync) {
            super(name);
            this.iter = iter;
            this.syncMethod = sync;
        }
	
	@Override
	public void run() {
		for (int i = 0; i < iter; i++) {
                    out.printf("%s : %d\n", this.getName(),  i);
                    if (syncValue == null) {
                        syncMethod.incrementCounter();
                    } else {
                        synchronized(syncValue) {
                            syncValue.counter++;
                        }
                    }
            }
	}
}
