package com.controller;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by
 *
 * @author :   zhangjian
 * @date :   2018-08-21
 */

public class MultiThreadTest {

    /**
     * 多线程处理
     *
     * @param data      数据
     * @param threadNum 线程数
     */
    public synchronized void handleList(List<String> data, int threadNum) {
        int length = data.size();
        int block = length % threadNum == 0 ? length / threadNum : (length / threadNum + 1);
        OneObject oneObject = new OneObject();
        for (int i = 0; i < threadNum; i++) {
            int end = (i + 1) * block;
            MyThread myThread = new MyThread(oneObject, "线程[" + (i + 1) + "] ", data, i * block, end > length ? length : end);
            myThread.start();   // 多线程启动function.start()
        }
    }

    private class MyThread extends Thread {
        // 线程变量定义
        private OneObject oneObject;
        private String threadName;
        private List<String> data;
        private int start;
        private int end;

        // 线程构造方法
        public MyThread(OneObject oneObject, String threadName, List<String> data, int start, int end) {
            this.oneObject = oneObject;
            this.threadName = threadName;
            this.data = data;
            this.start = start;
            this.end = end;
        }

        // 重写run()方法-线程执行方法
        public void run() {
            List<String> subList = data.subList(start, end);
            oneObject.func(threadName, subList);
        }
    }

    public class OneObject {
        // (synchronized 作用:1.未被static修饰, 同实例对象多线程不能同时访问,但是不同实例可以; 2.被static修饰,所有实例都不能同时访问;)
        // 总结一句话: 归根结底是看线程拿的是哪个对象的还是哪个类的锁, 对象和类都只有一把同步锁, 但互不影响, 类线程锁——所有对象都互斥, 对象线程锁——只对改对象的线程互斥
        public synchronized void func(String threadName, List<String> data) {
            for (int a = 0; a < data.size(); a++) {
                System.out.println(threadName + "处理了" + data.get(a) + "  ！");
            }
        }
    }

    public static void main(String[] args) {
        MultiThreadTest multiThreadTest = new MultiThreadTest();
        // 准备数据
        List<String> data = new ArrayList<String>();
        for (int i = 0; i < 5000; i++) {
            data.add("item" + i);
        }
        multiThreadTest.handleList(data, 6);
    }
}
