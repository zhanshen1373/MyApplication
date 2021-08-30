package com.panpass.myapplication;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by dbj on 2021/7/19
 */
class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> list;

    public MyAdapter(List<String> nameList) {
        this.list = nameList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType==1) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.tv, parent, false);
            return new ViewHolder(inflate);
        }else if (viewType==0) {
            View v= new View(parent.getContext());
            v.setVisibility(View.GONE);
            return new EmptyViewHolder(v);
        }
return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder) {
            ((ViewHolder) holder).tv.setText(list.get(position));
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (position ==0 || position==3) {
            return 0;
        }else
            return 1;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tttt);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  Log.e("www","viewholder");
                }
            });
        }
    }

    static class EmptyViewHolder extends RecyclerView.ViewHolder{

        public EmptyViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e("www","empty");
                }
            });
        }
    }


}
