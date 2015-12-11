package com.aop.sqlite;

/**
 * Created by liushu06 on 2015/12/10.
 */
public abstract class SafePriorityRun implements Runnable, Comparable<SafePriorityRun> {

    private final int mPriority;

    SafePriorityRun(int priority) {
        mPriority = priority;
    }

    @Override
    public int compareTo(SafePriorityRun another) {
        if (another == null) {
            return 1;
        }
        if (mPriority == another.mPriority) {
            return 0;
        }
        return mPriority > another.mPriority ? 1 : -1;
    }

    public static class Priority {

        public static final int LOWER = 1;

        public static final int LOW = LOWER + 1;

        public static final int NORMAL = LOW + 1;

        public static final int HIGH = NORMAL + 1;

        public static final int HIGHER = HIGH + 1;

    }

}
