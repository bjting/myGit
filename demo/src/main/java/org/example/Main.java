package org.example;
import java.io.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
class MyThread implements Runnable{
    private int ticket = 8;
    Object lock = new Object();
    public void run(){
        while(true){
            saleticket();

        }
    }
    private synchronized void saleticket(){
            if(ticket>0){
                try{
                    Thread.sleep(1000);
                } catch (Exception e){
                    e.printStackTrace();
                }finally{
                    System.out.println(Thread.currentThread().getName()+"正在发售第"+ticket--+"张票");
                }
            }

    }
}

public class Main {
    public static void  main(String[] args) throws IOException, InterruptedException {
        MyThread mythread = new MyThread();
        Thread ticket1 = new Thread(mythread,"窗口1");
        Thread ticket2 = new Thread(mythread,"窗口2");
        Thread ticket3 = new Thread(mythread,"窗口3");
        ticket1.start();
        ticket2.start();
        ticket3.start();

    }
}
//class MyThread extends Thread{
//    MyThread(String name){
//        super(name);
//    }
//    public void run(){
//        int i=0;
//        while(i++<5){
//            System.out.println(Thread.currentThread().getName()+"-----"+i);
//           if(i==2){
//               System.out.println("线程让步");
//               Thread.yield();
//           }
//        }
//    }
//}
//class MyThread extends Thread{
//    MyThread(String name){
//        super(name);
//    }
//    public void run(){
//        int i=0;
//        while(i++<10){
//            System.out.println(Thread.currentThread().getName()+"的run方法在运行");
//        }
//    }
//}
