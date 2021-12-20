package com.voice.java.data

data class WeatherRequest(val inquire: Inquire,
                          val endpoint: EndPoint,
                          val header: Header)

data class Inquire(val apiKey: String)

data class EndPoint(val countryCode: String,
                    val locale: String,
                    val device: Device)

data class Header(val type: String,
                  val timestamp: String)

data class Device(
        val deviceType: Int,
        val prdVer: String,
        val sysVer: String,
        val phoneType: String,
        val deviceId: String,
        val timezone: String,
        val osVer: String,
        val brand: String,
        val location: Location)

data class Location(val latitude: String,
                    val locationSystem: String,
                    val longitude: String)