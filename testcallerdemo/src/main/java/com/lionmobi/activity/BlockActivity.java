package com.lionmobi.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.lionmobi.constant.Constants;
import com.lionmobi.testcallerdemo.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class BlockActivity extends Activity {

    @InjectView(R.id.activity_block)
    RelativeLayout activityBlock;
    private Intent intent = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_block);
        ButterKnife.inject(this);
    }

    @OnClick({R.id.ll_blockListManagment, R.id.ll_blockLog, R.id.ll_blockSetting})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_blockListManagment:
                intent.setAction(Constants.ACT_BLOCKLIST);
                break;
            case R.id.ll_blockLog:
                intent.setAction(Constants.ACT_BLOCKLOG);
                break;
            case R.id.ll_blockSetting:
                intent.setAction(Constants.ACT_BLOCKSETTING);
                break;
        }
        startActivity(intent);
    }
}
