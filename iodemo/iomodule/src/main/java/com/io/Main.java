package com.io;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import static java.util.concurrent.Executors.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = () -> {
            System.out.println("Hi");
        };
        Thread.Builder builder = Thread.ofVirtual().name("Virtual Thread");


        Thread thread = builder.start(runnable);
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

    }


}