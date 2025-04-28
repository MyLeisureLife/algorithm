package test.java.com.leisure.basic;

/**
 * ClassName: PalindromeStringTest
 * Package: com.leisure.basic
 * Description:
 *
 * @Author: MyLeisureLife 
 * @Date: 2025/3/1:23:15:35 星期六
 *
 */
public class PalindromeStringTest {
    /**
     * 测试是否可以正常识别回文字符串
     */
    public void testIsPalindrome() {
        String testString = "abbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbba";
        boolean palindromeString = com.leisure.basic.PalindromeString.isPalindromeString(testString);
        System.out.println(palindromeString);
    }
}
