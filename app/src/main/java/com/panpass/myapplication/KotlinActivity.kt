package com.panpass.myapplication

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import butterknife.Unbinder
import com.jcodecraeer.xrecyclerview.XRecyclerView
import java.util.*
import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.coroutines.createCoroutine
import kotlin.math.log

class KotlinActivity : AppCompatActivity() {

    @BindView(R.id.xrecyclerview)
    lateinit var xRecyclerView: XRecyclerView
    @BindView(R.id.titlebar)
    lateinit var titleBar: ConstraintLayout
    @BindView(R.id.merge_tv1)
    lateinit var merge_tv1: TextView
//    @BindView(R.id.viewstub)
//    lateinit var viewStub: ViewStub
    var bind: Unbinder? = null
    var xxx:String ?=null

    val statusInformationList : ArrayList<String> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)
        bind = ButterKnife.bind(this)
        merge_tv1.text = "hahaha"
        xRecyclerView.setPullRefreshEnabled(true)
        xRecyclerView.setLoadingMoreEnabled(true)
        xRecyclerView.adapter
        initData()
        initAdapter()
statusInformationList.add(xxx!!)
        Log.e("www",statusInformationList.size.toString())
        for (bean in statusInformationList) {
            Log.e("www","tttt");
        }
        statusInformationList.forEach {
            Log.e("www","xxxxxx");
        }


    }

    private fun initAdapter() {
        val tt = arrayListOf<String>()
        with(tt, { add("a")})
        tt?.takeIf { 2>1 }?.let { Log.e("www","ijjk") }
        tt?.apply { add("b") }?.let { for (item in it) Log.e("www",item) }

    }

    private fun initData() {
        var qqq :Easy.Q = Easy("0","0",null).Q(1)
        var easy = Easy("0","0",qqq)
        Log.e("www",easy.toString())
        easy.setData(null,"8")
        Log.e("www",easy.toString())
        Log.e("www",easy.name)
    }

    @OnClick(R.id.xrecyclerview, R.id.titlebar)
    fun xxx(view: View){
        when (view.id) {
            R.id.xrecyclerview -> Toast.makeText(this, "xrecyclerview", Toast.LENGTH_SHORT).show()
            R.id.titlebar -> inflate?.visibility = View.GONE
//                Toast.makeText(this, "titlebar", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        bind?.unbind()
    }
    var inflate:View?=null
    override fun onResume() {
        super.onResume()
//        if (inflate == null)
//            inflate = viewStub.inflate()
    }

object Constants  {
//    public static String url= "http://www.baidu.com";
    var url = "http://www.baidu.com"
}
}