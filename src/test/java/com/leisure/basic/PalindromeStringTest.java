package com.leisure.basic;

import junit.framework.TestCase;

/**
 * ClassName: PalindromeStringTest
 * Package: com.leisure.basic
 * Description:
 *
 * @Author: MyLeisureLife 
 * @Date: 2025/3/1:23:15:35 星期六
 *
 */
public class PalindromeStringTest extends TestCase {
    /**
     * 测试是否可以正常识别回文字符串
     */
    public void testIsPalindrome() {
        String testString = "abbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbba";
        boolean palindromeString = PalindromeString.isPalindromeString(testString);
        System.out.println(palindromeString);
    }
}
