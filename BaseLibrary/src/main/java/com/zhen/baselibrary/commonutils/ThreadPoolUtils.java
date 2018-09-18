package com.zhen.baselibrary.commonutils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolUtils {

    private static final ExecutorService THREADPOOL = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    private static class Holder{
        private static final ThreadPoolUtils INSTANCE = new ThreadPoolUtils();
    }

    public static ThreadPoolUtils getInstance(){
        return Holder.INSTANCE;
    }

    final void addTask(Runnable runnable){
        if (runnable == null) return;
        THREADPOOL.execute(runnable);
    }
}
