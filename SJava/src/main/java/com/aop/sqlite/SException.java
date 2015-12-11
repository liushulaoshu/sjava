package com.aop.sqlite;

/**
 * Created by liushu06 on 2015/12/9.
 */
class SException extends Throwable {

    private final Throwable mChildThrowable;

    public SException(Throwable throwable) {
        if (throwable != null) {
            mChildThrowable = throwable;
        } else {
            mChildThrowable = this;
        }
    }

    public Throwable getThrowable() {
        return mChildThrowable;
    }

}
