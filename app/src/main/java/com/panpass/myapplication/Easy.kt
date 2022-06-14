package com.panpass.myapplication

import java.io.Serializable

data class Easy(
        var a: String?,
        var b: String,
        var q:Q?
) : Serializable {
     inner class Q(
            var x:Int
    ):Serializable {

    }
    fun setData(xa:String?,xb:String){
        a = xa;
        b = xb;
    }
}
val Easy.name:String get() {
  return "hahahah ${a?:"55"}"
}
class wsx{
    var q:String?=null
    get() {
        return field?:"null"
    }
}




