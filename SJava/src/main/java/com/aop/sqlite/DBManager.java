package com.aop.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by liushu06 on 2015/12/9.
 */
class DBManager {

    private static volatile DBManager sInstance;


    private SSqliteHelper mHelper;

    static DBManager getInstance() {
        if (sInstance == null) {
            synchronized (DBManager.class) {
                if (sInstance == null) {
                    sInstance = new DBManager();
                }
            }
        }
        return sInstance;
    }

    void init(Context ctx, SSqliteConfig cfg) {
        mHelper = new SSqliteHelper(ctx, cfg);
    }

    SQLiteDatabase getDatabase() throws SException {
        return mHelper.getDatabase();
    }
}
