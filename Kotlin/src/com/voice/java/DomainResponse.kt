package com.voice.java

/* {
 "reason":"success",
 "resCode":0,
 "serverDomain":"cloudbackup.hwcloudtest.cn:6447",
 "accessToken":"b24998fe9b674c02a3f3daba00562c98"
 }*/
data class DomainResponse(val reason: String,
                          val resCode: Int,
                          val serverDomain: String?,
                          val accessToken: String?)