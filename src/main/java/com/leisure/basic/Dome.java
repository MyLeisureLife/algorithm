package com.leisure.basic;

/**
 * ClassName: Dome
 * Package: com.leisure.basic
 * Description:
 *
 * @Author: MyLeisureLife
 * @Date: 2026/3/9:09:19:02 星期一
 */
public class Dome {
    private static final long MOD = 1000000007L;

    // 快速幂：计算 (base^exp) % MOD
    public static long modPow(long base, long exp) {
        long result = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        // 分子：101 到 200 的乘积（边乘边取模）
        long numerator = 1;
        for (int i = 101; i <= 200; i++) {
            numerator = (numerator * i) % MOD;
        }

        // 分母：1 到 100 的乘积（即 100!，边乘边取模）
        long denominator = 1;
        for (int i = 1; i <= 100; i++) {
            denominator = (denominator * i) % MOD;
        }

        // 求分母的模逆元（因为 MOD 是质数，可用费马小定理）
        long invDenominator = modPow(denominator, MOD - 2);

        // 最终结果 = numerator * invDenominator % MOD
        long result = numerator * invDenominator % MOD;
        System.out.println(result); // 输出: 603871639
    }
}
