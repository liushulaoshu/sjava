package com.aop.sqlite;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by liushu06 on 2015/12/9.
 */
public interface ISqliteOpenHelper {

    void onCreate(SQLiteDatabase database);

    void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion);
}
