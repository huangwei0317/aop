package com.hww.aop.thread;

import org.junit.jupiter.api.Test;

public class TestThread {

    @Test
    void test1() {
        MyThread myThread = new MyThread();
        myThread.setPriority(10);
        myThread.setName("10");
        MyThread myThread2 = new MyThread();
        myThread.setPriority(5);
        myThread.setName("5");
        myThread.start();
        myThread2.start();
    }
}
