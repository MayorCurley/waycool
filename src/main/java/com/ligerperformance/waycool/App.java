package com.ligerperformance.waycool;

import com.ligerperformance.waycool.concurrency.FunThread;
import com.ligerperformance.waycool.concurrency.NotifyThread;

/**
 * Way Cool
 *
 */
public class App implements Runnable
{
    public final static Object obj = new Object();
    
    @Override
    public void run() {
        System.out.println( "Way Cool App started" );
        
        Thread nt1 = new Thread(new NotifyThread(18,200,obj));
        nt1.start();
        try {
            synchronized(obj) {
                System.out.println("waiting on NotifyThread " + nt1);
                obj.wait();
            }
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        
        Thread nt2 = new Thread(new NotifyThread(5,10000,obj));
        nt2.start();
        
        Thread t1 = new Thread(new FunThread(5,4000));
        Thread t2 = new Thread(new FunThread(10,2000));
        
        t1.start();
        t2.start();
        
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        /**
         * Kludgey way to use Object.wait()
         * Look to using Java SE Concurrency classes instead
         */
        
        try {
            synchronized(obj) {
                System.out.println("waiting on NotifyThread " + nt2);
                obj.wait();
            }
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        
        System.out.println( "Way Cool App completed" );
    }

    public static void main( String[] args )
    {
        App app = new App();
        app.run();
    }
}
