package com.voice.java

import java.io.File

fun getLength(file: File): Long {
    return if (file.exists()) {
        file.length();
    } else {
        0;
    }
}