package com.voice.java.test

import com.voice.java.*

object GrsTest {
    @JvmStatic
    fun main(args: Array<String>) {
        val request = buildString {
            append(HTTPS)
            append(GRS_DOMAIN)
            append(DOMAIN_SEPARATOR)
            append(GRS_PORT)
            append(GRS_PATH)
        }

        val queryString = buildString {
            append(QUE_SEPARATOR)
            append("ser_country")
            append(EQUAL_SEPARATOR)
            append("CN")
            append(SEPARATOR)
            append("app_name")
            append(EQUAL_SEPARATOR)
            append("elfKidWatch")
        }
        val url = buildString {
            append(request)
            append(queryString)
        }
        println("URL --> $url")

        val testRequest = buildString {
            append(HTTPS)
            append(GRS_TEST_DOMAIN)
            append(DOMAIN_SEPARATOR)
            append(GRS_TEST_PORT)
            append(GRS_TEST_PATH)
        }
        //?ser_country=CN&app_name=hmsMirror
        val testQuery = buildString {
            append(QUE_SEPARATOR)
            append("ser_country")
            append(EQUAL_SEPARATOR)
            append("CN")
            append(SEPARATOR)
            append("app_name")
            append(EQUAL_SEPARATOR)
            append("elfKidWatch")
        }
        val testUrl = buildString {
            append(testRequest)
            append(testQuery)
        }
        println("test_url --> $testUrl")

        doPostInGrs(testUrl, "")
        doPostInGrs(url, "")

    }
}