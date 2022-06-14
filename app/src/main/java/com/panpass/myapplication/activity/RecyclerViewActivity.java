package com.panpass.myapplication.activity;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.panpass.myapplication.MainActivity2;
import com.panpass.myapplication.MyAdapter;
import com.panpass.myapplication.R;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

//只有recyclerview
public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<String> nameList = new ArrayList<>();
    private List<Long> timeList = new ArrayList<>();
    private WeakReference weakReference = new WeakReference(this);
//    private XRecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        ((MyApplication)getApplication()).pushStack(weakReference);
        setContentView(R.layout.activity_main3);
        recyclerView = findViewById(R.id.recyclerview);

        timeList.add(100L);
        timeList.add(5L);
        timeList.add(16L);
        timeList.add(64L);
        timeList.add(84L);
        timeList.add(12L);
        timeList.add(19L);
        timeList.add(7L);
        timeList.add(33L);
        timeList.add(65L);
        timeList.add(71L);
        timeList.add(91L);
        timeList.add(37L);
        timeList.add(55L);
        timeList.add(66L);
        timeList.add(81L);
        timeList.add(11L);
        timeList.add(100L);

        nameList.add("王一");
        nameList.add("张二");
        nameList.add("李三");
        nameList.add("赵四");
        nameList.add("");
        nameList.add("");
        nameList.add("");
        nameList.add("");
        nameList.add("");
        nameList.add("");
        nameList.add("");
        nameList.add("");
        nameList.add("");
        nameList.add("");
        nameList.add("");
        nameList.add("");
        nameList.add("");
        doClick c = () -> {
//            Stack<WeakReference<Activity>> weakReferences = ((MyApplication) getApplication()).showAll();
//            EventBus.getDefault().post("xxx");
            startActivity(new Intent(this, MainActivity2.class));
        };

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
//        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setHasFixedSize(true);
//        recyclerView.setAdapter(new MyAdapter(nameList,c));
        recyclerView.setAdapter(new MyAdapter(timeList));

        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {

            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                outRect.left = 15;
                outRect.top = 15;
                outRect.right = 15;
                outRect.bottom = 15;
            }
        });

        int width = getWindowManager().getDefaultDisplay().getWidth();
        Log.e("www","----"+width);
    }



    /*
    private void xRecyclerView() {
        recyclerView.setPullRefreshEnabled(true);
        recyclerView.setLoadingMoreEnabled(true);
        recyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        recyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);

        recyclerView
                .getDefaultRefreshHeaderView()
                .setRefreshTimeVisible(true);
        View header = LayoutInflater.from(this).inflate(R.layout.hhh,(ViewGroup)findViewById(android.R.id.content),false);
        recyclerView.addHeaderView(header);

        //        recyclerView.getDefaultFootView().setNoMoreHint("没有更多数据");
//        recyclerView.getDefaultFootView().setLoadingHint("努力加载中");
//        recyclerView.getDefaultFootView().setProgressStyle(ProgressStyle.BallSpinFadeLoader);

        recyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
//                recyclerView.refreshComplete();
            }

            @Override
            public void onLoadMore() {
//               recyclerView.loadMoreComplete();
            }
        });
    }
    */

    public interface doClick {
        void OnItemClick();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("www","ryactivity-onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("www","ryactivity-onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("www","ryactivity-onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("www","ryactivity-onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("www","ryactivity-onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("www","ryactivity-onDestroy");
    }
}