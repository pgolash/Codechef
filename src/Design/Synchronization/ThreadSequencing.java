package Design.Synchronization;

import LeetCode.Strings.ExcelSheetColumnTitle;
import sun.security.provider.SHA;

import java.util.Objects;

/**
 * Created by prashantgolash on 10/01/16.
 */

public class ThreadSequencing {
    public static void main(String[] args) {
        Shared s = new Shared();

        Thread t1 = new Thread(new Thread1(s));
        Thread t2 = new Thread(new Thread2(s));
        Thread t3 = new Thread(new Thread3(s));

        t1.start();
        t2.start();
        t3.start();
    }
}

class Shared {
    Object monitorObject;
    boolean a;
    boolean b;
    boolean c;

    Shared() {
        monitorObject = new Object();
        a = true;
        b = false;
        c = false;
    }
}

class Thread1 implements Runnable {

    private Shared o;
    public Thread1(Shared o) {
        this.o = o;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (o.monitorObject) {
                while (!o.a) {
                    try {
                        o.monitorObject.wait();
                    } catch (Exception e) {

                    }
                }
                System.out.println("Print 1");
                o.a = false;
                o.b = true;
                o.monitorObject.notifyAll();
            }
        }
    }
}

class Thread2 implements Runnable {
    private Shared o;
    public Thread2(Shared o) {
        this.o = o;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (o.monitorObject) {

                while (!o.b) {
                    try {
                        o.monitorObject.wait();
                    } catch (Exception e) {

                    }
                }
                System.out.println("Print 2");
                o.b = false;
                o.c = true;
                o.monitorObject.notifyAll();
            }
        }
    }
}

class Thread3 implements Runnable {
    private Shared o;
    public Thread3(Shared o) {
        this.o = o;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (o.monitorObject) {
                while (!o.c) {
                    try {
                        o.monitorObject.wait();
                    } catch (Exception e) {

                    }
                }
                System.out.println("Print 3");
                o.a = true;
                o.c = false;
                o.monitorObject.notifyAll();
            }
        }
    }
}