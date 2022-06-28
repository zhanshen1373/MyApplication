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
    set(value) = if (value===null) field = "a" else field =null
    get() {
        return field?:"null"
    }
}
data class Wx(var a: String, var b: Int =1) : Serializable {
    var x:String = a
    get() {
       return if (a == null) "q" else "-"}
    var qqq = 2
}




