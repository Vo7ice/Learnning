package com.voice.java.test

import com.google.gson.Gson
import com.voice.java.*
import com.voice.java.data.OffDay
import java.text.SimpleDateFormat
import java.util.*

object WxWork {
    @JvmStatic
    fun main(args: Array<String>) {
        var wxWebHook = readFile(WEB_HOOK_FILE_PATH)
        var pushMsg = "{\"msgtype\": \"text\",\"text\": {\"content\": \"下班了，记得打卡哦\",\"mentioned_mobile_list\":[\"15052132094\",\"@all\"]}}"
        val msgList = arrayOf(DAY_OFF_MSG, DAY_ON_MSG, DAY_OT_MSG)
        var index = 0
        if (args.isNotEmpty()) {
            wxWebHook = args[0]
            if (args[1].isInt()) {
                index = args[1].toInt()
            }
//            pushMsg = msgList[index]
        }
        val gson = Gson()
        val offDay = readFile(OFF_DAYS_FILE_PATH)
        val offDayOfYears = gson.fromJson(offDay, OffDay::class.java)
        val now = Date()
        val todayIsWeekDay = now.isWeekDay(offDayOfYears)
        println("todayIsWeekDay --> $todayIsWeekDay")
        if (!todayIsWeekDay) {
            pushMsg = buildOnOffMsg(now, index)
            println("web_hook --> $wxWebHook + push_msg --> $pushMsg")
            doPostInWxWork(wxWebHook!!, Charsets.UTF_8, pushMsg)
        }
        /*val formatter = SimpleDateFormat("yyyyMMdd")
        val parse1 = formatter.parse("20211009")
        val parse2 = formatter.parse("20210411")
        val week1 = parse1.isWeekDay(offDayOfYears)
        val week2 = parse2.isWeekDay(offDayOfYears)
        println("week1 --> $week1, week2 --> $week2")*/
    }
}