package com.panpass.myapplication

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

class TestBaseQuickAdapter(list:MutableList<String>):
        BaseQuickAdapter<String,BaseViewHolder>(R.layout.adapter_key_protocol_upload_annex,list) {

    override fun convert(holder: BaseViewHolder, item: String) {
        var iv = holder.getView<ImageView>(R.id.adapter_key_protocol_upload_annex_iv)
        Glide.with(context).load(R.drawable.a).into(iv)
        holder.setText(R.id.type_1_tv,item)
    }

    override fun convert(holder: BaseViewHolder, item: String, payloads: List<Any>) {
        if (payloads.isNullOrEmpty()){
            convert(holder,item)
        } else {
            holder.setText(R.id.type_1_tv,payloads[0].toString())
        }
    }

}