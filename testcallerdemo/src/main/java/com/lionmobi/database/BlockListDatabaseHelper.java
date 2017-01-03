package com.lionmobi.database;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ChenR on 2016/12/29.
 */

public class BlockListDatabaseHelper extends SQLiteOpenHelper {

    public BlockListDatabaseHelper(Context context, int version) {
        super(context, "blocklist.db", null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "";
        //db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
