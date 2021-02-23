package com.voice.java;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Utils {

    public static byte[] HMACSHA256(String data, String secretKey) throws Exception {

        Mac mac = Mac.getInstance("HmacSHA256");

        SecretKeySpec key = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), "HmacSHA256");

        mac.init(key);

        return mac.doFinal(data.getBytes(StandardCharsets.UTF_8));
    }

    public static String digest2Base64(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }
}
