package com.lionmobi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lionmobi.entry.MyContacts;
import com.lionmobi.testcallerdemo.R;
import com.lionmobi.utils.LogUtil;

import java.util.List;

/**
 * Created by ChenR on 2016/12/29.
 */

public class PhoneListAdapter extends RecyclerView.Adapter<PhoneListAdapter.ViewHolder> {

    private List<MyContacts> model;
    private Context context;

    private OnItemClickListener mListener;

    public PhoneListAdapter(List<MyContacts> model, Context context) {
        this.model = model;
        this.context = context;
    }

    @Override
    public PhoneListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.phone_list_item, null);
        return new ViewHolder(view);
    }

    private boolean isChoice;

    @Override
    public void onBindViewHolder(final PhoneListAdapter.ViewHolder holder, final int position) {

        LogUtil.log("position =====> " + position);
        final MyContacts myContacts = model.get(position);
        holder.tv_phoneNumber.setText(myContacts.getNumber());
        holder.cb_choice.setChecked(myContacts.isChecked());

        if (myContacts.getName() == null) {
            holder.tv_phoneName.setText(myContacts.getNumber());
        } else {
            holder.tv_phoneName.setText(myContacts.getName());
        }

        LogUtil.log("联系人是否被选中 ---> " + myContacts.isChecked());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.cb_choice.setChecked(isChoice);
            }
        });

    }

    @Override
    public int getItemCount() {
        return (model == null) ? -1 : model.size();
    }

    public void addData (MyContacts contact) {
        model.add(0, contact);
        notifyItemInserted(0);
        LogUtil.log("添加数据");
    }

    public void removeData (int pos) {
        model.remove(pos);
        notifyItemRemoved(pos);
    }

    public void setOnItemClickListener (OnItemClickListener listener) {
        this.mListener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout ll_phoneContact;
        private TextView tv_phoneName;
        private TextView tv_phoneNumber;
        private RelativeLayout rl_choice;
        private CheckBox cb_choice;

        public ViewHolder(View itemView) {
            super(itemView);

            WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            DisplayMetrics outMetrics = new DisplayMetrics();
            wm.getDefaultDisplay().getMetrics(outMetrics);

            RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(outMetrics.widthPixels, (int) (60 * outMetrics.density));

            itemView.setLayoutParams(layoutParams);

            ll_phoneContact = (LinearLayout) itemView.findViewById(R.id.ll_phoneContact);
            rl_choice = (RelativeLayout) itemView.findViewById(R.id.rl_phoneList_delete);
            tv_phoneName = (TextView) itemView.findViewById(R.id.tv_phoneList_name);
            tv_phoneNumber = (TextView) itemView.findViewById(R.id.tv_phoneList_number);
            cb_choice = (CheckBox) itemView.findViewById(R.id.cb_choice);
            cb_choice.setEnabled(false);
        }
    }

    public interface OnItemClickListener {
        void onItemCheckedStateChangeListener (MyContacts item, boolean isCheck);
    }
}
