package com.luhanlin.algorithms.compute;

/**
 * @description: 求最大公约数
 *          1.暴力枚举法：时间复杂度是O(min(a, b)))
 *          2.辗转相除法：时间复杂度不太好计算，可以近似为O(log(max(a, b)))，但是取模运算性能较差。
 *          3.更相减损术：避免了取模运算，但是算法性能不稳定，最坏时间复杂度为O(max(a, b)))
 *          4.更相减损术与移位结合：不但避免了取模运算，而且算法性能稳定，时间复杂度为O(log(max(a, b)))
 * @author: Mr.Lu
 * @create: 2019-04-22 11:16
 **/
public class CommonDivisor {

    public static void main(String[] args) {
        System.out.println(getGreatestCommonDivisor_04(16, 24));

    }

    /**
     * 1. 暴力枚举法
     *      遍历次数过多，效率低
     */
    public static int getGreatestCommonDivisor_01(int a, int b){
        int result = 1;

        int min = a > b ? b : a;
        int max = a > b ? a : b;
        if (max % min == 0) {
            return min;
        }

        for (int i = 2; i < min/2; i++) {
            if (a % i == 0 && b % i == 0) {
                result = i;
            }
        }

        return result;
    }

    /**
     * 2. 辗转相除法， 又名欧几里得算法（Euclidean algorithm）
     *      两个正整数a和b（a>b），它们的最大公约数等于a除以b的余数c和b之间的最大公约数。
     *
     *      缺点： 对两个比较大的整数取模运算性能影响较大
     */
    public static int getGreatestCommonDivisor_02(int a, int b){
        int result;

        if(a > b){
            result = compute(b, a);
        } else {
            result = compute(a, b);
        }

        return result;
    }

    /**
     * 求最大公约数，  a > b
     * @param a
     * @param b
     * @return
     */
    private static int compute(int a, int b) {
        if (b % a == 0) {
            return a;
        } else {
            return compute(b % a, a);
        }
    }

    /**
     * 3. 更相减损术
     *      两个正整数a和b（a>b），它们的最大公约数等于a-b的差值c和较小数b的最大公约数
     *
     *      缺点： 两个数相差悬殊时，计算次数太多，不稳定
     */
    public static int getGreatestCommonDivisor_03(int a, int b){
        if (a == b) {
            return a;
        }

        if (a < b) {
            return getGreatestCommonDivisor_03(b-a, a);
        } else {
            return getGreatestCommonDivisor_03(a-b, b);
        }
    }

    /**
     * 3. 更相减损术 与 辗转相除法 结合  比 辗转相除法 性能高
     *      gcb(a,b)的意思是a,b的最大公约数函数：
     *
     *      当a和b均为偶数，gcb(a,b) = 2*gcb(a/2, b/2) = 2*gcb(a>>1, b>>1)
     *
     *      当a为偶数，b为奇数，gcb(a,b) = gcb(a/2, b) = gcb(a>>1, b)
     *
     *      当a为奇数，b为偶数，gcb(a,b) = gcb(a, b/2) = gcb(a, b>>1)
     *
     *      当a和b均为奇数，利用更相减损术运算一次，gcb(a,b) = gcb(b, a-b)， 此时a-b必然是偶数，又可以继续进行移位运算。
     *
     */
    public static int getGreatestCommonDivisor_04(int a, int b){
        if (a == b){
            return a;
        }

        if (a > b) {
            // 保证 a < b
            return getGreatestCommonDivisor_04(b, a);
        }

        if ((a & 1) == 0 && (b & 1) == 0) {
            // 都为偶数
            return getGreatestCommonDivisor_04(a >> 1, b >> 1) << 1;
        } else if ((a & 1) == 0 && (b & 1) != 0) {
            // a 是偶数
            return getGreatestCommonDivisor_04(a >> 1, b);
        } else if ((a & 1) != 0 && (b & 1) != 0) {
            // b 是偶数
            return getGreatestCommonDivisor_04(a, b >> 1);
        } else {
            // 更相减损法
            return getGreatestCommonDivisor_04(a, b-a);
        }
    }

}
