package com.panpass.myapplication;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;



/**
 * description：连麦管理
 * Author: 邵东
 * date: 2020/3/26
 */
public class RadioCallManagerAdapter extends RecyclerView.Adapter<RadioCallManagerAdapter.RadioCallManagerHolder> implements View.OnClickListener {
    private Context mContext;
    private List<String> list = new ArrayList<>();



    public RadioCallManagerAdapter(Context context) {
        this.mContext = context;

    }

    @NonNull
    @Override
    public RadioCallManagerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.manager, parent, false);
        return new RadioCallManagerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RadioCallManagerHolder tCallItemViewHolder, final int position) {
        if (position < 0 || position >= list.size()) {
            return;
        }


        String s = list.get(position);
        tCallItemViewHolder.tv_name.setText(s);

    }

    @Override
    public void onBindViewHolder(@NonNull RadioCallManagerHolder holder, int position, @NonNull List<Object> payloads) {
//        super.onBindViewHolder(holder, position, payloads);
        if (payloads.isEmpty()){
            onBindViewHolder(holder,position);
        }else {
            String s = (String) payloads.get(0);
            holder.tv_name.setText(s);
            list.set(position,s);
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setData(List<String> onlineMIClist) {
        if (onlineMIClist != null) {
            list.clear();
            list.addAll(onlineMIClist);
        }
    }

    @Override
    public void onClick(View v) {

    }


    class RadioCallManagerHolder extends RecyclerView.ViewHolder {
        TextView tv_name;


        public RadioCallManagerHolder(View itemView) {
            super(itemView);

            tv_name = itemView.findViewById(R.id.tvv);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /**
                     *  Log.e("www","位置"+getLayoutPosition());
                     *  Log.e("www","位置"+getAdapterPosition());
                     *  得到的数据大多数情况是一样的，getadapterposition在刷新的时候可能有问题
                     */

                    notifyItemRemoved(getLayoutPosition());
                    list.remove(getLayoutPosition());
                    //list执行的比较靠前,使得因为移除，本来屏幕外的一项成了屏幕内的一项。逻辑为预取成功-->存到
                    //recyclerviewpool中，下次从recyclerviewpool中取，执行onbindviewholder;预取失败-->createviewholder
                    //onbindviewholder。 两种情况都会onbindviewholder这时候集合中已经减1了，所以数据是对的。即使再次刷新
                    //列表，整体数据也是对的。

                }
            });

        }
    }



}
