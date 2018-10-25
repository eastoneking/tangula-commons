package com.tangula.utils

import java.text.SimpleDateFormat
import java.util.*

class DateUtils{
    companion object {

        fun date2StrYyyMmDd(date:Date?):String{
            return date?.run {
                try {
                    SimpleDateFormat("yyyy-MM-dd").format(date)
                }catch (ex:Exception){

                    ""
                }
            }?:kotlin.run { "" }
        }

        fun strYyyMmDd2Date(date:String?):Date?{
            return date?.run {
                try {
                    SimpleDateFormat("yyyy-MM-dd 00:00:00.000").parse("$date 00:00:00.000")
                }catch (ex:Exception){
                    null
                }
            }?:kotlin.run { null }
        }


        fun seconds2HHmmssStr(seconds:Int?):String{
            return seconds?.run {
                val value = Math.abs(this)
                val s = value%60
                val m = value/60%60
                val h = value/3600
                "${(if(h<10) "0" else "")}$h:${(if(m<10) "0" else "")}$m:${(if(s<10) "0" else "")}$s"
            }?:kotlin.run {
                "00:00:00"
            }
        }

        fun millisSecond2HhmmsssssStr(millisSecond:Long?):String{
            return millisSecond?.run { "${seconds2HHmmssStr((millisSecond / 1000).toInt())}.${millisSecond%1000}" }
            ?:kotlin.run { "00:00:00.000" }
        }


    }
}