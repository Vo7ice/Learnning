package com.voice.java.test

import com.google.gson.Gson
import com.voice.java.*
import com.voice.java.data.Poem
import com.voice.java.data.Token

object DailyPoem {
    @JvmStatic
    fun main(args: Array<String>) {
        val wxWebHook = readFile(WEB_HOOK_FILE_PATH)
        val gson = Gson()
        if (!isTokenExist()) {
            println("token not exist!")
            val poemToken = getPoemToken(POEM_BASE_URL + POEM_TOKEN)
            println("from http poemToken: $poemToken")
            if (poemToken.isNotEmpty()) {
                val token = gson.fromJson(poemToken, Token::class.java)
                println("token: $token")
                saveFile(token.data, TOKEN_FILE_PATH)
            }
        } else {
            println("token is exist！")
            var dailyPoem = ""
            var poemInfo = ""
            val readToken = readFile(TOKEN_FILE_PATH)
            println("token --> $readToken")
            if (readToken?.isNotEmpty() == true) {
                dailyPoem = getPoemResponse(POEM_BASE_URL + POEM_SENTENCE, readToken)
                println("dailyPoem --> $dailyPoem")
                val poem = gson.fromJson(dailyPoem, Poem::class.java)
                val msg = buildMsgFromPoem(poem)
                println("msg--> $msg")
                doPostInWxWork(wxWebHook!!, Charsets.UTF_8, msg)
//                poemInfo = getPoemResponse(POEM_BASE_URL + POEM_TEST_INFO, readToken)
//                println("poemInfo --> $poemInfo")
            } else {
                dailyPoem = getOnePoemWithoutToken(POEM_BASE_URL + POEM_ONE)
                println("dailyPoem --> $dailyPoem")
            }
        }
    }
}