package com.aop.sqlite.sdemo.app;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import com.aop.sqlite.ISqliteOpenHelper;
import com.aop.sqlite.SManager;
import com.aop.sqlite.SSqliteConfig;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDB();
    }

    void initDB() {
        SSqliteConfig cfg = new SSqliteConfig.SSqliteConfigBuilder("test").builderCursorFactory(null).builderOpenHelper(new ISqliteOpenHelper() {
            @Override
            public void onCreate(SQLiteDatabase database) {
                String sql = "CREATE TABLE test value (int _id)";
                database.execSQL(sql);
            }

            @Override
            public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            }
        }).builderVersion(1).builder();
        SManager.init(this, cfg);

        TestOp testOp = new TestOp();
        testOp.insert();
    }
}
