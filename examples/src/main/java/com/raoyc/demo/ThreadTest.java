package com.raoyc.demo;

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            // 数偶数
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

class MyRunnableThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            // 数奇数
            if (i % 2 == 1) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
public class ThreadTest {
    public static void main(String[] args) {

        // test one
        MyThread t1 = new MyThread();
        t1.start();

        MyThread t2 = new MyThread();
        t2.start();

        // test two
        MyRunnableThread rThread = new MyRunnableThread();
        Thread t3 = new Thread(rThread);
        t3.setName("my-runnable-thread-1");
        t3.start();

        Thread t4 = new Thread(rThread);
        t4.setName("my-runnable-thread-1");
        t4.start();
    }

}
