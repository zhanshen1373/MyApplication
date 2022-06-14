package com.panpass.myapplication;

import android.graphics.Color;
import android.text.Editable;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.panpass.myapplication.activity.RecyclerViewActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnFocusChange;
import butterknife.OnTextChanged;

/**
 * Created by dbj on 2021/7/19
 */
public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> list;
    private List<Long> timelist;
    private  RecyclerViewActivity.doClick click;
    private HashMap<Integer,String> map = new HashMap<>();
    private HashMap<Integer,Boolean> map1 = new HashMap<>();


    public MyAdapter(List<Long> nameList) {
        this.timelist = nameList;
    }

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
            editText.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 350));
            return new EmptyViewHolder(editText);
        }else if (viewType == -1){
            Button button =new Button(parent.getContext());
            button.setText("这是一个按钮");
            return new EmptyViewHolder(button);
        }else if (viewType == -2){
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.constraint, parent,false);
            return new ConstraintViewHolder(inflate);
        } else if (viewType==-3){
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.edittextandcheckbox, parent, false);
            return new EditAndCheckBoxViewHolder(inflate);
        } else {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.chronometerandtv, parent, false);
            ChronometerAndTvViewHolder chronometerAndTvViewHolder = new ChronometerAndTvViewHolder(inflate);
            CountDownHelp countDownHelp = new CountDownHelp();
            chronometerAndTvViewHolder.itemView.setTag(countDownHelp);
            return chronometerAndTvViewHolder;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder) {
            ((ViewHolder) holder).tv1.setText(list.get(position));
        }
        if (holder instanceof ConstraintViewHolder) {
            holder.itemView.setTag(position);
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
            if (position==9)
                holder.itemView.setBackgroundColor(Color.parseColor("#ff7f50"));
            if (position==10)
                holder.itemView.setBackgroundColor(Color.parseColor("#eee8aa"));
        }
        if(holder instanceof EditAndCheckBoxViewHolder) {
            ((EditAndCheckBoxViewHolder) holder).tv.setText(list.get(position));
            ((EditAndCheckBoxViewHolder) holder).checkBox.setChecked(map1.get(position)==null?false:map1.get(position));
            ((EditAndCheckBoxViewHolder) holder).et.setText(map.get(position));
        }
        if (holder instanceof ChronometerAndTvViewHolder) {
            CountDownHelp countDownHelp = (CountDownHelp) holder.itemView.getTag();
            countDownHelp.countDownTime(((ChronometerAndTvViewHolder) holder).textView,timelist.get(position));
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
        return -4;

    }

    @Override
    public int getItemCount() {
        return timelist.size();
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


    class EditAndCheckBoxViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv)
        TextView tv;
        @BindView(R.id.et)
        EditText et;
        @BindView(R.id.checkbox)
        CheckBox checkBox;

        @OnTextChanged(R.id.et)
        void afterTextChanged(Editable s){
            map.put(getLayoutPosition(),s.toString());
        }

        @OnCheckedChanged(R.id.checkbox)
        void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
                map1.put(getLayoutPosition(),isChecked);
        }



        public EditAndCheckBoxViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    class ChronometerAndTvViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.cter)
        Chronometer cter;
        @BindView(R.id.tv)
        TextView textView;
        public ChronometerAndTvViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }




}
