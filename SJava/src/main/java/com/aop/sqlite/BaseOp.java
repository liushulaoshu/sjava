package com.aop.sqlite;

import android.database.sqlite.SQLiteDatabase;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by liushu06 on 2015/12/9.
 */
public abstract class BaseOp implements IBaseOp, InvocationHandler {

    protected SQLiteDatabase getDatabase() throws SException {
        return DBManager.getInstance().getDatabase();
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }

}
