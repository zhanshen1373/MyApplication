package com.panpass.myapplication;

import android.graphics.Color;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.panpass.myapplication.activity.RecyclerViewActivity;

import java.util.List;

/**
 * Created by dbj on 2021/7/19
 */
public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> list;
    private  RecyclerViewActivity.doClick click;

    public MyAdapter(List<String> nameList, RecyclerViewActivity.doClick click) {
        this.list = nameList;
        this.click = click;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType==1) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.normal, parent, false);
            return new ViewHolder(inflate);
        }else if (viewType==0) {
            View v= new View(parent.getContext());
            v.setBackgroundColor(Color.parseColor("#0000FF"));
//            v.setVisibility(View.GONE);
            v.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,10));
            return new EmptyViewHolder(v);
        }else if (viewType == 2){
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.tv, parent, false);
            return new ViewHolder(inflate);
        }else if (viewType == 3){
            EditText editText = new EditText(parent.getContext());
            editText.setHint("请输入");
            editText.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 300));
            return new EmptyViewHolder(editText);
        }else if (viewType == -1){
            Button button =new Button(parent.getContext());
            button.setText("这是一个按钮");
            return new EmptyViewHolder(button);
        }else{
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.constraint, parent,false);
            return new ConstraintViewHolder(inflate);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder) {
            ((ViewHolder) holder).tv1.setText(list.get(position));
        }
        if (holder instanceof ConstraintViewHolder) {
            if (position==0)
                holder.itemView.setBackgroundColor(Color.parseColor("#FF0000"));
            if (position==1)
                holder.itemView.setBackgroundColor(Color.parseColor("#00FF00"));
            if (position==2)
                holder.itemView.setBackgroundColor(Color.parseColor("#0000FF"));
            if (position==3)
                holder.itemView.setBackgroundColor(Color.parseColor("#FF00FF"));
            if (position==4)
                holder.itemView.setBackgroundColor(Color.parseColor("#00FFFF"));
            if (position==5)
                holder.itemView.setBackgroundColor(Color.parseColor("#FFFFFF"));
            if (position==6)
                holder.itemView.setBackgroundColor(Color.parseColor("#FFFF00"));
            if (position==7)
                holder.itemView.setBackgroundColor(Color.parseColor("#000000"));
            if (position==8)
                holder.itemView.setBackgroundColor(Color.parseColor("#70DB93"));


        }

    }

    @Override
    public int getItemViewType(int position) {
//        if (position ==0 || position==3) {
//            return 0;
//        }else if (position ==1){
//            return 1;
//        }else {
//            return position;
//        }
        super.getItemViewType(position);
        if (position==getItemCount()-1)
            return -1;
        return 3;

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

     class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tv1,tv2;
        private View bottom_line;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
            bottom_line = itemView.findViewById(R.id.bottom_line);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  Log.e("www","viewholder");
                    click.OnItemClick();
                }
            });
        }
    }

     class EmptyViewHolder extends RecyclerView.ViewHolder{

        public EmptyViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e("www","empty");
                    click.OnItemClick();
                }
            });
        }
    }

    class ConstraintViewHolder extends RecyclerView.ViewHolder {

        public ConstraintViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }



}
