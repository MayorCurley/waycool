package com.ligerperformance.waycool.concurrency;

public class FunThread implements Runnable {
    
    private long loops = 10;
    private long sleepMillis = 0;
    
    public FunThread() {
        
    }
    
    public FunThread(long loops, long sleepMillis) {
        super();
        this.loops = loops;
        this.sleepMillis = sleepMillis;
    }

    @Override
    public void run() {
        for(int i = 0; i < loops; i++) {
            if(sleepMillis > 0) {
                try {
                    Thread.sleep(sleepMillis);
                } catch (InterruptedException e) {
                    System.out.println("fun thread " + this + " interrupted");
                    e.printStackTrace();
                }
            }
            System.out.println("fun thread is running: " + this);
        }
    }

}
