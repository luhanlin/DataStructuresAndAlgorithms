package com.luhanlin.leetcode.array;

/**
 * 类详细描述：实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2020/7/5 7:21 下午
 */
public class N28strStr {

    /**
     * 方式1：暴力解法
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {

        int n = needle.length();
        for (int i = 0; i < haystack.length() - n + 1; i++) {
            if (haystack.substring(i, i+ n).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 双指针算法，也属于暴力解法
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr2(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        for (int i = 0; i < n - m + 1; i++) {
            while (haystack.charAt(i) != needle.charAt(i)) {
                i++;
            }
            int start = i;
            for (int j = 0; j < m; j++) {
                if (haystack.charAt(start) != needle.charAt(j)) {
                    break;
                }
                start++;
            }
            if (start - i == n) {
                return i;
            }
        }

        return -1;
    }
}
