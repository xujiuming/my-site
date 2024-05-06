package com.ming.core.utils;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * 签名工具类
 *
 * @author ming
 * @date 2024-05-06 11:16:46
 */
public class SignatureUtils {


    private SignatureUtils() {
    }

    public static String md5ToHex(byte[] bytes) {
        return DigestUtils.md5Hex(bytes);
    }

    public static String md5ToHex(String str) {
        return DigestUtils.md5Hex(str);
    }

    public static String md5ToHex(InputStream inputStream) throws IOException {
        return DigestUtils.md5Hex(inputStream);
    }
}
