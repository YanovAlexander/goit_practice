package com.goit.practice.semaphores;

import java.util.concurrent.Semaphore;

public class Main {
    private static Semaphore semaphore = new Semaphore(3);
    private static SimpleSemaphore simpleSemaphore = new SimpleSemaphore(3);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    semaphoreArea();
                } catch (InterruptedException e) {
                    System.out.println("Error occurred: " + e.getMessage());
                }
            }).start();
        }
    }

    private static void semaphoreArea() throws InterruptedException {
        simpleSemaphore.acquire();
        System.out.println("Join the critical area: thread name: " + Thread.currentThread().getName());
        Thread.sleep(10000);
        simpleSemaphore.release();
        System.out.println("Leave the critical area thread name: " + Thread.currentThread().getName());
    }
}
