package com.aop.sqlite;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by liushu06 on 2015/12/10.
 */
class ExecutorManager {

    private static volatile ExecutorManager sInstance;


    private ThreadPoolExecutor mExecutor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue<Runnable>());

    static ExecutorManager getInstance() {
        if (sInstance == null) {
            synchronized (ExecutorManager.class) {
                if (sInstance == null) {
                    sInstance = new ExecutorManager();
                }
            }
        }
        return sInstance;
    }


    void execute(SafePriorityRun run) {
        mExecutor.execute(run);
    }

}
