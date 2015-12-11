package com.aop.sqlite;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by liushu06 on 2015/12/9.
 */
public class SSqliteConfig {

    final String mDbName;

    final int mVersion;

    final SQLiteDatabase.CursorFactory mCursorFactory;

    final ISqliteOpenHelper mISqliteOpenHelper;


    private SSqliteConfig(String name, SQLiteDatabase.CursorFactory factory, int version, ISqliteOpenHelper helper) {
        mDbName = name;
        mCursorFactory = factory;
        mVersion = version;
        mISqliteOpenHelper = helper;

    }


    public static class SSqliteConfigBuilder {

        private final String mDbName;

        private int mVersion;

        private SQLiteDatabase.CursorFactory mCursorFactory;

        private ISqliteOpenHelper mISqliteOpenHelper;

        public SSqliteConfigBuilder(String name) {
            mDbName = name;
        }

        public SSqliteConfigBuilder builderVersion(int version) {
            mVersion = version;
            return this;
        }


        public SSqliteConfigBuilder builderCursorFactory(SQLiteDatabase.CursorFactory factory) {
            mCursorFactory = factory;
            return this;
        }

        public SSqliteConfigBuilder builderOpenHelper(ISqliteOpenHelper helper) {
            mISqliteOpenHelper = helper;
            return this;
        }

        public SSqliteConfig builder() {
            SSqliteConfig sSqliteConfig = new SSqliteConfig(mDbName, mCursorFactory, mVersion, mISqliteOpenHelper);
            return sSqliteConfig;
        }

    }

}
