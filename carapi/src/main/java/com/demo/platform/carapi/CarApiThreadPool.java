package com.demo.platform.carapi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xiaojun
 *
 * @date 19-3-27
 */
public class CarApiThreadPool {
    private static ExecutorService sThreadPool = Executors.newCachedThreadPool();

    public static void execute(Runnable runnable) {
        sThreadPool.execute(runnable);
    }

    public static void shuttdown() {
        sThreadPool.shutdown();
    }

}
