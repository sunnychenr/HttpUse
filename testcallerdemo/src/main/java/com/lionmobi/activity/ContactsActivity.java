package com.lionmobi.activity;

import android.app.Activity;
import android.os.Bundle;

import com.lionmobi.testcallerdemo.R;

public class ContactsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        initView();
    }

    private void initView() {

    }
}
