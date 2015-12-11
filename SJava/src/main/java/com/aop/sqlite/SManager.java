package com.aop.sqlite;

import android.content.Context;

/**
 * Created by liushu06 on 2015/12/9.
 */


public class SManager {

    public static void init(Context ctx, SSqliteConfig config) {
        DBManager.getInstance().init(ctx, config);
        testAnnotatedMethod();
    }


    private  static void testAnnotatedMethod() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
