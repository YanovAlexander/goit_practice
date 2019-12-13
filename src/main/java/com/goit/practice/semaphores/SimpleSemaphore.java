package com.goit.practice.semaphores;

public class SimpleSemaphore {
    private static int THREADS_AMOUNT = 0;
    private static int BLOCKED = 0;

    public SimpleSemaphore(int number) {
        THREADS_AMOUNT = number;
    }

    public synchronized void acquire() throws InterruptedException {
        while (BLOCKED == THREADS_AMOUNT) {
            wait();
        }
        BLOCKED++;
        notifyAll();
    }

    public synchronized void release() throws InterruptedException {
        while (BLOCKED == 0) {
            wait();
        }
        BLOCKED--;
        notifyAll();
    }
}