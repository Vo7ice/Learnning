package com.voice.java

import com.voice.java.data.OffDay
import com.voice.java.data.Poem
import com.voice.java.data.WxMessage
import java.io.File
import java.lang.StringBuilder
import java.util.*

fun getLength(file: File): Long {
    return if (file.exists()) {
        file.length();
    } else {
        0;
    }
}

fun String.isInt(): Boolean =
    try {
        this.toInt()
        true
    } catch (ex: NumberFormatException) {
        false
    }

fun saveFile(content: String, path: String) {
    val file = File(path)
    if (!file.exists()) {
        file.createNewFile()
    }
    if (file.canWrite()) {
        file.writeText(content)
    } else {
        println("saveToken failed, $path can not write. ")
    }
}

fun readFile(path: String): String? {
    val file = File(path)
    if (file.canRead()) {
        return file.readText(Charsets.UTF_8)
    } else {
        return null
    }
}

fun isTokenExist(): Boolean {
    var result = false
    val file = File(TOKEN_FILE_PATH)
    println("file.canRead() ${file.canRead()}")
    if (file.canRead()) {
        val readText = file.readText(Charsets.UTF_8)
        println("readText --> $readText")
        println("readText.isNotEmpty() --> ${readText.isNotEmpty()}")
        if (readText.isNotEmpty()) {
            result = true
        }
    }
    return result
}

fun buildMsgFromPoem(poem: Poem): String {
    val title = poem.data.origin.title
    val dynasty = poem.data.origin.dynasty
    val author = poem.data.origin.author
    val content = poem.data.origin.content
    val tags = poem.data.matchTags
    println("title --> $title,dynasty --> $dynasty, author --> $author}")
    val msgContent = buildMsgContent(title, dynasty, author, content, tags)
    println("msgContent --> $msgContent")
    val msg = WxMessage()
    msg.msgtype = "markdown"
    msg.markdown = WxMessage.TextDTO()
    msg.markdown.content = msgContent
    return msg.toMarkDown()
}

fun buildMsgContent(title: String, dynasty: String, author: String, content: List<String>, tags: List<String>): String =
    with(StringBuilder()) {
        append("# ")
        append(title)
        append("\n")
        append("#### ")
        append(dynasty)
        append(" ")
        append(author)
        append("\n")
        append("#### ")
        tags.forEach {
            append("`")
            append(it)
            append("` ")
        }
        append("\n")
        content.forEach {
            append("### ")
            append(it)
            append("\n")
        }
        toString()
    }

fun buildOnOffMsg(date: Date, isOn: Int):String {
    val now = Calendar.getInstance()
    now.time = date
    val year = now.get(Calendar.YEAR).toString()
    val month = (now.get(Calendar.MONTH) + 1).toString()
    val day = now.get(Calendar.DAY_OF_MONTH).toString()
    val msg = WxMessage()
    val msgContent = buildDayOnContent(year, month, day, isOn)
    msg.msgtype = "markdown"
    msg.markdown = WxMessage.TextDTO()
    msg.markdown.content = msgContent
    msg.markdown.mentionedList = listOf("lijinnan", "@all")
    return msg.toMarkDown()
}

fun buildDayOnContent(year: String, month: String, day: String, isOn:Int): String =
    with(StringBuilder()) {
        append("> ")
        append("今天是")
        append("`")
        append(year)
        append("`")
        append("年")
        append("`")
        append(month)
        append("`")
        append("月")
        append("`")
        append(day)
        append("`")
        append("日")
        append(".")
        append("\n")
        append("> ")
        if (isOn == 1) {
            append("上班了,记得打卡和填昨天的日报哦！")
        } else if (isOn == 0){
            append("下班了,记得打卡和填今天的日报哦！")
        } else {

        }
        toString()
    }

fun Date.isWeekDay(offDay: OffDay): Boolean {
    val now = Calendar.getInstance()
    now.time = this
    val year = now.get(Calendar.YEAR)
    val month = now.get(Calendar.MONTH) + 1
    val day = now.get(Calendar.DAY_OF_MONTH)
    val weekDay = now.get(Calendar.DAY_OF_WEEK)
    println("year:$year,month:$month,day:$day,weekDay:$weekDay")
    return offDay.isCountryWeekDay(year.toString(), month, day, weekDay)
}


fun OffDay.findYearsDTO(year: String): OffDay.YearsDTO? {
    val filter = this.years.filter { it.year.equals(year) }
    return if (filter.isEmpty()) {
        null
    } else {
        filter[0]
    }
}

fun OffDay.isCountryWeekDay(year: String, month: Int, day: Int, weekDay: Int): Boolean {
    val fullDay = buildString {
        if (month >= 10) {
            append(month)
        } else {
            append("0").append(month)
        }
        if (day >= 10) {
            append(day)
        } else {
            append("0").append(day)
        }
    }
    val weekDays = this.findYearsDTO(year)
    return if (weekDays == null) {
        println("Do not support this year, $year")
        false
    } else {
        val offDay = weekDays.offDay
        val exchangeDay = weekDays.exchangeDay
        val specialDay = weekDays.specialDay
        if (offDay.contains(fullDay) || specialDay.contains(fullDay)) {
            true
        } else if (weekDay == Calendar.SUNDAY || weekDay == Calendar.SATURDAY) {
            !exchangeDay.contains(fullDay)
        } else {
            false
        }
    }
}
