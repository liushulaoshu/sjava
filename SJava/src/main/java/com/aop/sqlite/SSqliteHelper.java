package com.aop.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQuery;

/**
 * Created by liushu06 on 2015/12/9.
 */
final class SSqliteHelper {

    private final SSqliteHelperInner mInner;

    public SSqliteHelper(Context context, SSqliteConfig sSqliteConfig) {
        mInner = new SSqliteHelperInner(context, sSqliteConfig.mDbName,
                sSqliteConfig.mCursorFactory == null ? EMPTY_FACTORY : sSqliteConfig.mCursorFactory,
                sSqliteConfig.mVersion, sSqliteConfig.mISqliteOpenHelper);
    }


    public synchronized SQLiteDatabase getDatabase() throws SException {
        try {
            return mInner.getWritableDatabase();
        } catch (Throwable throwable) {
            throw new SException(throwable);
        }
    }


    private final static SQLiteDatabase.CursorFactory EMPTY_FACTORY = new SQLiteDatabase.CursorFactory() {
        @Override
        public Cursor newCursor(SQLiteDatabase db, SQLiteCursorDriver masterQuery, String editTable, SQLiteQuery query) {
            synchronized (SSqliteHelper.class) {
                SQLiteCursor sqLiteCursor = new SQLiteCursor(db, masterQuery, editTable, query);
                return sqLiteCursor;
            }
        }
    };

    private static final class SSqliteHelperInner extends SQLiteOpenHelper {

        private final ISqliteOpenHelper mISqliteOpenHelper;

        public SSqliteHelperInner(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, ISqliteOpenHelper helper) {
            super(context, name, factory, version);
            mISqliteOpenHelper = helper;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            if (mISqliteOpenHelper != null) {
                mISqliteOpenHelper.onCreate(db);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            if (mISqliteOpenHelper != null) {
                mISqliteOpenHelper.onUpgrade(db, oldVersion, newVersion);
            }
        }

    }
}


