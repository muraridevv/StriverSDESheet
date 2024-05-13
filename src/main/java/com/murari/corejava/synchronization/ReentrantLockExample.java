package com.murari.corejava.synchronization;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    private int count=0;
    private Lock lock= new ReentrantLock();

    public void increment(){
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    public void decrement(){
        lock.lock();
        try {
            count--;
        } finally {
            lock.unlock();
        }
    }

    public int getCount(){
        lock.lock();
        try{
            return count;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLockExample reentrantLockExample= new ReentrantLockExample();

        Thread incrementThread= new Thread(()->{
            for(int i=0;i< 10000; i++){
                reentrantLockExample.increment();
            }
        });

        Thread decrementThread= new Thread(()->{
            for(int i=0;i< 10000; i++){
                reentrantLockExample.decrement();
            }
        });

        incrementThread.start();
        decrementThread.start();

        try {
            incrementThread.join();
            decrementThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Final count"+ reentrantLockExample.getCount());
    }
}
