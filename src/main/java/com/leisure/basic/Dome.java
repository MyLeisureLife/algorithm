package com.leisure.basic;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.sql.SQLOutput;
import java.util.Arrays;

/**
 * ClassName: Dome
 * Package: com.leisure.basic
 * Description:
 *
 * @Author: MyLeisureLife
 * @Date: 2026/3/9:09:19:02 星期一
 */
public class Dome {
    public static void main(String[] args) {
        String originText = "中";

        // 1. 同一个文字，编码成两套完全不同的字节
        // 重点：GBK 使用 Charset.forName
        Charset GBK_CHARSET = Charset.forName("GBK");

        byte[] gbkBytes = originText.getBytes(GBK_CHARSET);
        byte[] one = originText.getBytes();
        byte[] utf8Bytes = originText.getBytes(StandardCharsets.UTF_8);
        System.out.println(Arrays.toString(one));
        System.out.println(Arrays.toString(gbkBytes));
        System.out.println(Arrays.toString(utf8Bytes));
        System.out.println("GBK字节长度:" + gbkBytes.length);   // 2
        System.out.println("UTF‑8字节长度:" + utf8Bytes.length); // 3

    }
}
