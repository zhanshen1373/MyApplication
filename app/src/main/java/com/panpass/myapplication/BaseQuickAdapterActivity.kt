package com.panpass.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/**
 * xrecyclerview和basequickadapter无法一起使用
 * 因为无法转型为baseviewholder
 */
class BaseQuickAdapterActivity : AppCompatActivity() {

    private lateinit var rv:RecyclerView
    private var adapter:TestBaseQuickAdapter?=null
    private var data = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        EventBus.getDefault().register(this)
        setContentView(R.layout.activity_base_quick_adapter)
        initView()
        initData()
        initListener()
    }

    private fun initListener() {
        adapter?.addChildClickViewIds(R.id.adapter_key_protocol_upload_annex_delete_iv)
        adapter?.addChildClickViewIds(R.id.adapter_key_protocol_upload_annex_tv)
        adapter?.setOnItemChildClickListener { adapter, view, position ->
            when(view.id){
                R.id.adapter_key_protocol_upload_annex_delete_iv-> {
                    adapter.data.removeAt(position)
                    adapter.notifyDataSetChanged()
                }
                R.id.adapter_key_protocol_upload_annex_tv -> Toast.makeText(this, "xxxx", Toast.LENGTH_SHORT).show()
                }
            }
        adapter?.setOnItemClickListener { adapter, view, position ->
            startActivity(Intent(this,EventBusActivity::class.java).putExtra("position",position))
        }
    }

    private fun initData() {
        repeat(20,{  data.add(it.toString())})
//        for (i in 0 until 20) {
//          data.add(i.toString())
//        }
        rv.layoutManager = LinearLayoutManager(this)
        adapter = TestBaseQuickAdapter(data)
        rv.adapter = adapter
    }

    private fun initView() {
        rv = findViewById(R.id.BaseQuickAdapter_RecyclerView)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun accept(eventBusData: EventBusActivity.EventBusData) {
        // 列表刷新的时候，不会自动移动位置
        // 列表刷新的时候，只会刷新当前屏幕看到的几项
        // notifyitemchanged(position) 根据position改变单个holder的状态
//        if (!data.isNullOrEmpty())
//            data.clear()
//        for (i in 0 until 20) {
//            data.add("nihao")
//        }
//        adapter?.notifyDataSetChanged()
//        var x = rv.layoutManager as LinearLayoutManager
//        var firstPosition = x.findFirstVisibleItemPosition()
//        rv.scrollBy(0,rv.getChildAt(13-firstPosition).top)
//        rv.scrollToPosition(data.size-1)
            var x = eventBusData.position
            adapter?.notifyItemChanged(x,"哈哈哈")
    }


    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }

}