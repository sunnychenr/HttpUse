package com.lionmobi.application;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;

import com.lionmobi.greendao.entry.TagInfo;
import com.lionmobi.greendao.gen.DaoMaster;
import com.lionmobi.greendao.gen.DaoSession;
import com.lionmobi.greendao.gen.TagInfoDao;

/**
 * Created by ChenR on 2016/12/27.
 */

public class App extends Application {

    public static Context context;
    public static DaoSession ds;

    private SharedPreferences sp;
    private boolean isFirst;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        sp = getSharedPreferences("setting", MODE_PRIVATE);

        isFirst = sp.getBoolean("firstLoading", true);
        createDatabase();
    }

    private void createDatabase() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, "caller.db", null);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster master = new DaoMaster(db);
        ds = master.newSession();

        if (isFirst) {
            initTagInfo();

            sp.edit().putBoolean("firstLoading", false).commit();
        }
    }

    private void initTagInfo() {
        TagInfo t1 = new TagInfo(0L, 0, "骚扰", null);
        TagInfo t2 = new TagInfo(1L, 1, "诈骗", null);
        TagInfo t3 = new TagInfo(2L, 2, "推销", null);
        TagInfoDao tagInfoDao = ds.getTagInfoDao();

        tagInfoDao.insert(t1);
        tagInfoDao.insert(t2);
        tagInfoDao.insert(t3);
    }
}
