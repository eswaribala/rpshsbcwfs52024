package src.main.java.com.hsbc;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import static java.util.concurrent.Executors.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Runnable runnable=()->{
            System.out.println("Hi");
        };
        Thread.Builder builder=Thread.ofVirtual().name("Virtual Thread");


        Thread thread=  builder.start(runnable);
        System.out.println(Thread.currentThread().getName());
        thread.join();
        CompletableFuture<Void> future = CompletableFuture
                .supplyAsync(() -> "Virtual Thread")
                .thenApplyAsync(result -> result.toUpperCase())
                .thenAcceptAsync(uppercaseResult -> {
                    System.out.println("Uppercase result: " + uppercaseResult +
                            " in thread: " + Thread.currentThread().getName());
                });

        future.join();


        ExecutorService executor = Executors.newVirtualThreadExecutor();

        for (int i = 0; i < 10; i++) {
            executor.submit(() -> {
                System.out.println("Running task in a virtual thread: "
                        + Thread.currentThread().getName());
            });
        }

        executor.shutdown();
        ThreadFactory virtualThreadFactory = Thread.builder().virtual().factory();

        ExecutorService executor =
                newFixedThreadPool(8, virtualThreadFactory);

        for (int i = 0; i < 8; i++) {
            executor.submit(() -> {
                System.out.println("Running task in a virtual thread: "
                        + Thread.currentThread().getName());
            });
        }

        executor.shutdown();

        ThreadGroup virtualThreadGroup =
                Thread.builder().virtual().getThreadGroup();

        Thread virtualThread = new Thread(virtualThreadGroup, () -> {
            System.out.println("Running task in a virtual thread: "
                    + Thread.currentThread().getName());
        });

        virtualThread.start();
    }

}