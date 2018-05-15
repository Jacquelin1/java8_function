package com.thread.chapter01;

import java.util.Random;

public class MyThread25 extends Thread {

    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            Random random = new Random();
            random.nextInt();
        }

        System.out.println("thread25 use time =" + (System.currentTimeMillis() - beginTime) + "毫秒");
    }
}