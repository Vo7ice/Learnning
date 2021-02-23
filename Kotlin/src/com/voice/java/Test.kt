package com.voice.java

import java.lang.StringBuilder
import javax.crypto.spec.SecretKeySpec
import javax.crypto.Mac
import com.google.gson.Gson
import java.io.File


object Test {
    @JvmStatic
    fun main(args: Array<String>) {
        val httpRequest = buildString {
            append("POST")
            append("&")
            append("/v2/getServerDomain")
            append("&")
            append("appID=1018")
            append("&")
        }
        val httpBody = buildString {
            append("model=Elf-G00")
            append("&")
            append("romVersion=1.0.0.517")
            append("&")
            append("emuiVersion=PLUTO_MMI")
            append("&")
            append("osVersion=MT2502")
            append("&")
            append("countryCode=460")
            append("&")
            append("shaSN=1d33b7bf043cad15eda720528e4dde9c74a66da7483749a0b5702c22c5c9a160")
        }
        val queryString = "&appID=1018"
        val stringToSign = buildString {
            append(httpRequest)
            append(httpBody)
            append(queryString)
        }
        println("signature--> $stringToSign")
        val hmacSha256 = Utils.digest2Base64(Utils.HMACSHA256(stringToSign, "7a10267e7b9845da8b5475e031cecb09"))
        println("auth:$hmacSha256")
        // HMAC-SHA256 appID=1018, signature="BZRjE5HrZh43vuVK4Gr1oXiEOt0lwmfigtOCYFdhXPU="
        val auth = buildString {
            append("HMAC-SHA256 appID=1018, signature=\"")
            append(hmacSha256)
            append("\"")
        }
        println("auth --> $auth")
        println("httpPlayload --> $httpBody")
        // cloudbackup.hwcloudtest.cn:6447
        // logservice1.dbankcloud.cn:443
        // logservice1.hicloud.com:443
        // logservice.hicloud.com:443
//        HttpClient.doPost("https://logservice.hicloud.com:443/v2/getServerDomain?appID=1018", httpBody, auth)
        val domainResponse = doPostInKt("https://cloudbackup.hwcloudtest.cn:6447/v2/getServerDomain?appID=1018", httpBody, auth)
        val gson = Gson()
        val response = gson.fromJson(domainResponse, DomainResponse::class.java)
        println("response --> $response")
        if (!response.accessToken.isNullOrEmpty()) {

        }
        val weather = "https://lfhagmirror.hwcloudtest.cn:18449/hag-weather/v1/weather/query"
        val inquire = Inquire("weather-weatherInfo")
        val location = Location("31.161", "WGS84", "121.404")
        val device = Device(0,
                "9.1.1.215",
                "EmotionUI_9.1.1",
                "FRO-N09",
                "",
                "GMT+8:00",
                "",
                "huawei",
                location)
        val endpoint = EndPoint("CN", "zh_CN", device)
        val header = Header("WeatherIntentReq", "2021-01-14 18:01:00")
        val request = WeatherRequest(inquire, endpoint, header)
        val toJson = gson.toJson(request)
        println("example request --> $toJson")
        val weatherResponse = doPostInKtWeather(weather, toJson)
        println("weather response --> $weatherResponse")

        val ipResponse = doGetInKt("http://pv.sohu.com/cityjson")
        println("ip --> $ipResponse")
    }

    fun getServerDomainRequest() = buildString {
        append(HTTP_METHOD)
        append(SEPARATOR)
        append(GET_SERVER_DOMAIN)
        append(SEPARATOR)
        append(APP_ID)
        append(EQUAL_SEPARATOR)
        append(APP_ID_VALUE)
        append(SEPARATOR)
    }

    fun getUploadInfoRequest() = buildString {
        append(HTTP_METHOD)
        append(SEPARATOR)
        append(GET_UPLOAD_INFO)

    }

    fun getDeviceParas() = buildString {
        append("model=Elf-G00")
        append("&")
        append("romVersion=1.0.0.517")
        append("&")
        append("emuiVersion=PLUTO_MMI")
        append("&")
        append("osVersion=MT2502")
        append("&")
        append("countryCode=460")
        append("&")
        append("shaSN=1d33b7bf043cad15eda720528e4dde9c74a66da7483749a0b5702c22c5c9a160")
    }

    fun getUploadInfoParas() = buildString {
        append("logType=1")
        append("&")
        append("fileName=")
        append("")
    }

    fun hmac_sha256(src: String, secret: String): String {
        var hash = ""
        try {
            val sha256_HMAC = Mac.getInstance("HmacSHA256")
            val secret_key = SecretKeySpec(secret.toByteArray(Charsets.UTF_8), "HmacSHA256")
            sha256_HMAC.init(secret_key)
            val bytes = sha256_HMAC.doFinal(src.toByteArray(Charsets.UTF_8))
            hash = byteArrayToHexString(bytes)
            return hash
        } catch (e: Exception) {
            println("Error HmacSHA256 ===========" + e.message)
            return ""
        }
    }

    fun byteArrayToHexString(src: ByteArray): String {
        val sb = StringBuilder("")
        if (src.isEmpty()) {
            return ""
        }
        for (i in src.indices) {
            val v = src[i].toInt() and 0XFF
            val hv = Integer.toHexString(v)
            if (hv.length < 2) {
                sb.append(0)
            }
            sb.append(hv)
        }
        return sb.toString()
    }
}