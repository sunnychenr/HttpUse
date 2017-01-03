package com.lionmobi.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.lionmobi.adapter.BlockListAdapter;
import com.lionmobi.application.App;
import com.lionmobi.constant.Constants;
import com.lionmobi.greendao.entry.PhoneNumber;
import com.lionmobi.greendao.gen.TagInfoDao;
import com.lionmobi.testcallerdemo.R;
import com.lionmobi.utils.LogUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class BlockListActivity extends Activity {

    private final static int CALLLOG = 1;
    private final static int CONTACTS = 2;

    @InjectView(R.id.lv_blockList)
    ListView lvBlockList;
    @InjectView(R.id.tv_blockList)
    TextView tvBlockList;

    private BlockListAdapter adapter;
    private List<PhoneNumber> model = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_block_list);
        ButterKnife.inject(this);

        initData();
        setView();
        setListener();
    }

    private void setListener() {
        lvBlockList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    private void initData() {

        readData();

        lvBlockList.setAdapter(adapter);
    }

    private void readData() {
        TagInfoDao tagInfoDao = App.ds.getTagInfoDao();
        LogUtil.log("TagInfoDao -----> " + tagInfoDao.queryBuilder().list().toString());
    }

    private void setView() {
        /*if (model.isEmpty()) {
            tvBlockList.setVisibility(View.VISIBLE);
            lvBlockList.setVisibility(View.GONE);
        } else {
            tvBlockList.setVisibility(View.GONE);
            lvBlockList.setVisibility(View.VISIBLE);
        }*/
    }

    @OnClick(R.id.btn_addNumber)
    public void onClick() {
        final Intent in = new Intent();

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        View v = View.inflate(this, R.layout.dialog_floating_action_btn, null);
        dialog.setView(v);
        final AlertDialog show = dialog.show();

        v.findViewById(R.id.tv_fromCallLog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                in.setAction(Constants.ACT_CALLLOG);
                startActivityForResult(in, CALLLOG);
                show.dismiss();
            }
        });

        v.findViewById(R.id.tv_fromContacts).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                in.setAction(Constants.ACT_CONTACTS);
                startActivityForResult(in, CONTACTS);
                show.dismiss();
            }
        });

        v.findViewById(R.id.tv_fromInput).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNumber();
                show.dismiss();
            }

        });
    }

    private void inputNumber() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        View viewInputNumber = View.inflate(this, R.layout.dialog_input_number, null);
        final EditText edt_input = (EditText) viewInputNumber.findViewById(R.id.edt_input);
        TextView tv_dismiss = (TextView) viewInputNumber.findViewById(R.id.tv_dismiss);
        final Button btn_sure = (Button) viewInputNumber.findViewById(R.id.btn_sure);

        btn_sure.setEnabled(false);

        dialog.setView(viewInputNumber);

        final AlertDialog show = dialog.show();

        tv_dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show.dismiss();
            }
        });

        edt_input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                LogUtil.log("onTextChanged ----> " + s);
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!"".equals(s)) {
                    btn_sure.setEnabled(true);
                } else {
                    btn_sure.setEnabled(false);
                }
            }
        });

        btn_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = edt_input.getText().toString();
                /*BlockList contact = new BlockList();
                contact.setNumber(number);
                App.ds.getBlockListDao().insert(contact);*/
                adapter.notifyDataSetChanged();
                setView();
                show.dismiss();
            }
        });

    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        setView();
    }
}
