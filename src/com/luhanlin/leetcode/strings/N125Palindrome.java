package com.luhanlin.leetcode.strings;

/**
 * <类详细描述>给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * @author luhanlin
 * @version [V_1.0.0, 2020-07-06 14:39]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class N125Palindrome {

    /**
     * 使用 jdk内置函数翻转 效率慢
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String reverse = new StringBuilder(actual).reverse().toString();
        return actual.equals(reverse);
    }

    /**
     * 双指针解法
     * @param s
     * @return
     */
    public boolean isPalindrome2(String s) {
        s = s.toLowerCase();

        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }

        return true;
    }
}
