package com.example.shichunlei.testimage;

/**
 * Created by shichunlei
 * on 2019/2/22
 */
public class http {

    public void init(){
        thread thread = new thread();
        Thread thread1 = new Thread(thread);
        thread1.start();
    }

    class  thread implements Runnable {

        @Override
        public void run() {

        }
    }
}
