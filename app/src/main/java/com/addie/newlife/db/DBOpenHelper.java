package com.addie.newlife.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by di.bian on 2016/6/23.
 */
public class DBOpenHelper extends SQLiteOpenHelper {
    private static final String BD_NAME = "MyData";
    private static final int BD_VERSION = 1;

    public DBOpenHelper(Context context) {
        super(context, BD_NAME, null, BD_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
