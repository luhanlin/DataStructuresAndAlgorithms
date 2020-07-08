package com.luhanlin.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;

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

    /**
     * BM(Boyer-Moore) 算法实现
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr3(String haystack, String needle) {
        char[] a = haystack.toCharArray();
        char[] b = needle.toCharArray();
        int n = haystack.length();
        int m = needle.length();
        int[] bc = new int[256];
        // 构建坏字符hash表
        generateBC(b, m, bc);
        // 构建好后缀与好前缀匹配hash表
        int[] suffix = new int[m+1]; // 下标比长度小1
        boolean[] prefix = new boolean[m+1];
        generateGS(b, m, suffix, prefix);

        // 根据好字符和坏字符进行位移判断
        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = m-1; j >= 0; j--) {
                if (a[i+j] != b[j]) break;  // 此时 j 为坏字符下标
            }
            if (j == -1) return i;

            // 计算坏字符位移距离
            int x = j - bc[(int)b[j]];
            int y = 0;
            if (j < m-1) { // 表明拥有好后缀
                y = moveByGS(j, m, suffix, prefix);
            }

            i = i + Math.max(x, y);
        }
        return -1;
    }

    /**
     * 生成模式串字符对应下标位置
     * @param b
     * @param m
     * @param bc
     */
    private void generateBC(char[] b, int m, int[] bc) {
        for (int i = 0; i < 256; i++) {
            bc[i] = -1;
        }
        for (int i = 0; i < m; i++) {
            int ascii = (int)b[i];
            bc[ascii] = i;
        }
    }

    /**
     * 构建好后缀与好前缀匹配hash表
     * @param b
     * @param m
     * @param suffix
     * @param prefix
     */
    private void generateGS(char[] b, int m, int[] suffix, boolean[] prefix) {
        for (int i = 0; i <= m; i++) {
            suffix[i] = -1;
            prefix[i] = false;
        }

        for (int i = 0; i < m; i++) {
            int j = i;
            int k = 0;
            while(j>=0 && b[m-1-k] == b[j]) {
                j--;
                k++;
                suffix[k] = j + 1;
            }
            if (j == -1) prefix[k] = true;
        }
    }

    private int moveByGS(int j, int m, int[] suffix, boolean[] prefix) {
        int k = m - j - 1;
        if (suffix[k] != -1) return j - suffix[k] + 1;

        for (int r = j+2; r <= m-1; ++r) {
            if (prefix[m-r] == true) {
                return r;
            }
        }
        return m;
    }


}
