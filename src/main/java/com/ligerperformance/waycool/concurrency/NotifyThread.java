package com.ligerperformance.waycool.concurrency;

public class NotifyThread extends FunThread {

    private Object notifyObj;
    
    public NotifyThread(long loops, long sleepMillis, Object notifyObj) {
        super(loops, sleepMillis);
        this.notifyObj = notifyObj; 
    }

    @Override
    public void run() {
        super.run();
        System.out.println("NotifyThread finished running FunThread run() " + this);
        synchronized(notifyObj) {
            System.out.println("notifyAll() on NotifyThread " + this);
            notifyObj.notifyAll();
        }
        System.out.println("NotifyThread complete " + this);
    }
    
}
