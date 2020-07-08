package com.luhanlin.leetcode.strings;

/**
 * <类详细描述>判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 你能不将整数转为字符串来解决这个问题吗？
 *
 * @author luhanlin
 * @version [V_1.0.0, 2020-07-06 16:04]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class N09Palindrome {

    /**
     * 将数字变成字符后进行判断
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        String s = String.valueOf(x);

        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }

    /**
     * 将数字放入一个整形数组中然后判断
     * @param x
     * @return
     */
    public boolean isPalindrome2(int x) {
        if (x < 0) return false;

        int[] nums = new int[32];
        int i = 0;
        while (x > 0) {
            nums[i++] = x % 10;
            x = x/10;
        }

        int l = 0;
        int r = i - 1;
        while (l < r) {
            if (nums[l++] != nums[r--]) return false;
        }

        return true;
    }

    /**
     * 数字翻转
     * @param x
     * @return
     */
    public boolean isPalindrome3(int x) {
        if (x < 0) return false;

        int y = 0;
        int z = x;
        while (z > 0) {
            int m = z % 10;
            y = y * 10 + m;
            z = z / 10;
        }

        return x == y;
    }
}
