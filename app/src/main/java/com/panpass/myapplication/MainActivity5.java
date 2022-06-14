package com.panpass.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.panpass.myapplication.bean.PictureAndContentBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity5 extends AppCompatActivity {

    private ListView listView;
    private List<String> datas = new ArrayList<>();
    private List<HashMap<String,Object>> mapList = new ArrayList<>();
    private HashMap<String,Object> hashMap;
    private List<PictureAndContentBean> pictureAndContentBeanList = new ArrayList<>();
    private ExecutorService executorService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        executorService = Executors.newSingleThreadExecutor();
        listView = findViewById(R.id.listview);
        for (int i = 0; i < 20; i++) {
            PictureAndContentBean pictureAndContentBean =new PictureAndContentBean();
            pictureAndContentBean.setContent("position"+i);
            if (i%2==0){
                pictureAndContentBean.setPictureUrl("https://c-ssl.duitang.com/uploads/item/201808/03/20180803180607_nxrvx.jpg");
            }else if (i%2!=0){
                pictureAndContentBean.setPictureUrl("https://p6.itc.cn/images01/20220116/13b1e943e78f42fb8ad04410f19b4345.jpeg");
            }
            pictureAndContentBeanList.add(pictureAndContentBean);
        }
        for (int i = 0; i < 10; i++) {
            hashMap = new HashMap<>();
            hashMap.put("check",true);
            hashMap.put("textview",i+"");
            hashMap.put("imageview",R.mipmap.ic_launcher);
            mapList.add(hashMap);
        }
        String[] from = new String[]{"check","textview","imageview"};
        int[] to = new int[]{R.id.simple_checkbox,R.id.simple_textview,R.id.simple_imageview};

        /* 特点:只展示textview
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_2,
                android.R.id.text1, datas);
        */
        /* 特点:只能展示textview、imageview、Checkable
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, mapList, R.layout.simple_adapter, from, to);
         */
        ListViewAdapter listViewAdapter = new ListViewAdapter(this, pictureAndContentBeanList,executorService);
        listView.setAdapter(listViewAdapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.e("www",listView.getChildCount()+"");
//                listViewAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        executorService.shutdown();
    }
}