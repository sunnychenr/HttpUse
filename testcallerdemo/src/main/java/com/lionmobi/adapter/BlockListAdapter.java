package com.lionmobi.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lionmobi.entry.MyContacts;
import com.lionmobi.testcallerdemo.R;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by ChenR on 2016/12/28.
 */

public class BlockListAdapter extends BaseAdapter {

    private List<MyContacts> model;
    private Context context;

    public BlockListAdapter(List<MyContacts> model, Context context) {
        this.model = model;
        this.context = context;
    }

    @Override
    public int getCount() {
        return (model == null) ? -1 : model.size();
    }

    @Override
    public Object getItem(int position) {
        return (model == null) ? null : model.get(position);
    }

    @Override
    public long getItemId(int position) {
        return (model == null) ? -1 : position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        if (convertView == null) {
            convertView = View.inflate(context, R.layout.block_list_item, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        MyContacts contact = model.get(position);
        holder.tvBlockListName.setText(contact.getName());
        holder.tvBlockListNumber.setText(contact.getNumber());

        return convertView;
    }

    static class ViewHolder {
        @InjectView(R.id.tv_blockList_number)
        TextView tvBlockListNumber;
        @InjectView(R.id.tv_blockList_name)
        TextView tvBlockListName;
        @InjectView(R.id.rl_blockList_delete)
        RelativeLayout rlBlockListDelete;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
