package com.lionmobi.activity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.lionmobi.testcallerdemo.R;

public class BlockSettingActivity extends Activity {

    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_block_setting);

        initDataSave();

    }

    private void initDataSave() {
        sp = getSharedPreferences("BlockSetting", Context.MODE_PRIVATE);
    }
}
