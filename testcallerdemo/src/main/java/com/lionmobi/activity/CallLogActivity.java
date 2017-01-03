package com.lionmobi.activity;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.CallLog;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.lionmobi.adapter.PhoneListAdapter;
import com.lionmobi.entry.DividerItemDecoration;
import com.lionmobi.entry.MyContacts;
import com.lionmobi.testcallerdemo.R;

import java.util.ArrayList;
import java.util.List;

public class CallLogActivity extends Activity {

    private RecyclerView rv_phoneList;
    private PhoneListAdapter adapter;

    private ContentResolver resolver;
    private List<MyContacts> model = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_log);

        resolver = getContentResolver();

        initView();
        initData();

    }

    private void initData() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CALL_LOG) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CALL_LOG}, 1);
            return;
        }
        Cursor query = resolver.query(CallLog.Calls.CONTENT_URI,
                new String[]{
                        CallLog.Calls.NUMBER,
                        CallLog.Calls.CACHED_NAME
                }, null, null, null);

        if (query != null) {
            while (query.moveToNext()) {
                String number = query.getString(0);
                String name = query.getString(1);
                adapter.addData(new MyContacts(name, number));
            }
            query.close();
        } else {
            Toast.makeText(this, "您的通话记录为空！！！无法添加到黑名单", Toast.LENGTH_SHORT).show();
        }
    }

    private void initView() {
        rv_phoneList = (RecyclerView) findViewById(R.id.rv_callLog);
        adapter = new PhoneListAdapter(model, this);
        rv_phoneList.setAdapter(adapter);
        rv_phoneList.setLayoutManager(new LinearLayoutManager(this));
        //rv_phoneList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }
}
