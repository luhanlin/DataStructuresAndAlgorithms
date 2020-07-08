package com.luhanlin.leetcode.dp;

/**
 * 类详细描述：实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 *
 * @author luhanlin
 * @version [V_1.0.0, 2020-07-06 11:00]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class N28strStr {

    public static int strStr(String haystack, String needle) {
        KMP kmp = new KMP(needle);
        return kmp.search(haystack);
    }

    public static void main(String[] args) {
        System.out.println(strStr("hell0", "ll"));

    }
}
