package com.panpass.myapplication;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.panpass.myapplication.bean.PictureAndContentBean;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

public class ListViewAdapter extends BaseAdapter {

    private List<PictureAndContentBean> datas;
    private Context mContext;
    private Object object = new Object();
    private ExecutorService executorService;


    public ListViewAdapter(Context context,List<PictureAndContentBean> datas, ExecutorService args0) {
        this.mContext = context;
        this.datas = datas;
        this.executorService = args0;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        //list.get(position).get
        return 0;
//        return super.getItemViewType(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        try {
//            throw new NullPointerException("1");
//        }catch (Exception e){
//            Log.e("www",Log.getStackTraceString(e));
//              使用这种方式看调用栈
//        } finally {
        if (getItemViewType(position) != 0) {
            if (convertView == null) {
                convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.checkedtextview, parent, false);
            }
        } else {
            ViewHolder0 viewHolder = null;
            if (convertView == null) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.imageviewandtextview, null);
                viewHolder = new ViewHolder0();
//                viewHolder.linearLayout = convertView.findViewById(R.id.scrollView_linearlayout);
//                viewHolder.tv  = convertView.findViewById(R.id.simple_textview);
//                viewHolder.linearLayout = convertView.findViewById(R.id.s_l);
                viewHolder.tv = convertView.findViewById(R.id.listview_text);
                viewHolder.iv = convertView.findViewById(R.id.listview_image);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder0) convertView.getTag();
            }
//            for (int i=0;i<30;i++){
//                TextView textView = new TextView(mContext);
//                textView.setText("hello");
//                textView.setGravity(Gravity.CENTER_VERTICAL);
//                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(100, 100);
//                viewHolder.linearLayout.addView(textView,layoutParams);
//                viewHolder.linearLayout.setGravity(Gravity.CENTER_VERTICAL);
//            }
//            viewHolder.tv.setText(datas.get(position).getContent());
//            loadImageView(datas.get(position).getPictureUrl(), viewHolder.iv);
            ViewHolder0 finalViewHolder = viewHolder;
            Future<?> submit = executorService.submit(new Runnable() {
                @Override
                public void run() {
                    load(datas.get(position).getPictureUrl(), finalViewHolder.iv);
                }
            });

        }

            return convertView;
//        }
    }


    class ViewHolder0  {
       private TextView tv;
       private ImageView iv;
    }


    private void loadImageView(String address,ImageView iv){

               new Thread(new Runnable() {
                   @Override
                   public void run() {
                       Log.e("www", Thread.currentThread().getName() + "----tn");
                       synchronized (object) {
                           load(address, iv);
                       }
                   }
               }).start();

    }

    private  void load(String address,ImageView iv) {

        HttpURLConnection httpURLConnection = null;
        try {
            URL url = new URL(address);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(4000);
            httpURLConnection.setReadTimeout(4000);
//            httpURLConnection.setDoInput(true);
//            httpURLConnection.setDoOutput(true);
            if (httpURLConnection.getResponseCode() == 200) {
                InputStream inputStream = httpURLConnection.getInputStream();
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                ((Activity)mContext).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        iv.setImageBitmap(bitmap);
                    }
                });
            }

//            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//            StringBuilder stringBuilder = new StringBuilder();
//            String line;
//            while ((line = bufferedReader.readLine())!=null){
//                stringBuilder.append(line);
//            }
//            bufferedReader.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
    }

}
