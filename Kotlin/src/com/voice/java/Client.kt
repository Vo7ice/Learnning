package com.voice.java

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL
import java.nio.charset.Charset

fun doPostInKt(url: String, body: String, auth: String, charset: Charset = Charsets.UTF_8): String {
    val sb = StringBuilder()
    val connection = URL(url).openConnection() as HttpURLConnection
    connection.apply {
        requestMethod = "POST"
        connectTimeout = 15000
        readTimeout = 60000
        doOutput = true
        doInput = true
    }
    connection.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded")
    connection.setRequestProperty("Accept-Charset", charset.name())
    connection.setRequestProperty("Authorization", auth)
    val os = connection.outputStream
    os.write(body.toByteArray(charset))
    val code = connection.responseCode
    println("code -> $code")
    if (connection.responseCode == HttpURLConnection.HTTP_OK) {
        println("http is ok")
        val br = BufferedReader(InputStreamReader(connection.inputStream, charset))
        br.readLines().forEach { sb.append(it) }
//        val readLine = br.readLine()
//        sb.append(readLine)
//        println("line -> $readLine")
        br.close()
    }

    os.close()
    val toString = sb.toString()
    println("result --> $toString")
    return sb.toString()
}

fun doPostInKtWeather(url: String, body: String, charset: Charset = Charsets.UTF_8): String {
    val sb = StringBuilder()
    val connection = URL(url).openConnection() as HttpURLConnection
    connection.apply {
        requestMethod = "POST"
        connectTimeout = 15000
        readTimeout = 60000
        doOutput = true
        doInput = true
    }
    connection.setRequestProperty("Content-Type", "application/json")
    connection.setRequestProperty("x-client-version", "com.huawei.app_10.0.1")
    connection.setRequestProperty("x-hag-trace-id", "AABBCCDDEEFFGG112233445566778899-000001")
    connection.setRequestProperty("x-prd-pkg-name", "com.huawei.android.totemweather")
    connection.setRequestProperty("x-access-key", "10001")
    val os = connection.outputStream
    os.write(body.toByteArray(charset))
    val code = connection.responseCode
    println("code -> $code")
    if (connection.responseCode == HttpURLConnection.HTTP_OK) {
        println("http is ok")
        val br = BufferedReader(InputStreamReader(connection.inputStream, charset))
        br.readLines().forEach { sb.append(it) }
//        val readLine = br.readLine()
//        sb.append(readLine)
//        println("line -> $readLine")
        br.close()
    }

    os.close()
    val toString = sb.toString()
    println("result --> $toString")
    return sb.toString()
}

fun doGetInKt(url: String, charset: Charset = Charsets.UTF_8): String {
    val sb = StringBuilder()
    val connection = URL(url).openConnection() as HttpURLConnection
    connection.apply {
        requestMethod = "GET"
        connectTimeout = 15000
        readTimeout = 60000
        doOutput = true
        doInput = true
    }

    val code = connection.responseCode
    println("code -> $code")
    if (connection.responseCode == HttpURLConnection.HTTP_OK) {
        println("http is ok")
        val br = BufferedReader(InputStreamReader(connection.inputStream, charset))
        br.readLines().forEach { sb.append(it) }
        br.close()
    }
    return sb.toString()
}