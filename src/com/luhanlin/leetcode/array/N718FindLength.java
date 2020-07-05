package com.luhanlin.leetcode.array;

import java.util.Collections;

/**
 * 类详细描述：给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2020/7/1 5:41 下午
 */
public class N718FindLength {

    /**
     * 动态规划法
     * @param A
     * @param B
     * @return
     */
    public int findLength(int[] A, int[] B) {
        int lenA = A.length;
        int lenB = B.length;

        int[][] dp = new int[lenA + 1][lenB + 1];

        int res = 0;
        for (int i = 1; i <= lenA; i++) {
            for (int j = 1; j <= lenB; j++) {
                dp[i][j] = A[i-1] == B[j-1] ? dp[i-1][j-1] + 1 : 0;

                res = Math.max(res, dp[i][j]);
            }
        }

        return res;
    }

    /**
     * 滑动窗口法
     * @param A
     * @param B
     * @return
     */
    public int findLength2(int[] A, int[] B) {
        return A.length < B.length ? findMax(A, B) : findMax(B, A);
    }

    int findMax(int[] A, int[] B) {
        int max = 0;
        int an = A.length, bn = B.length;
        for(int len=1; len <= an; len++) {
            max = Math.max(max, maxLen(A, 0, B, bn - len, len));
        }
        for(int j=bn-an; j >= 0;j--) {
            max = Math.max(max, maxLen(A, 0, B, j, an));
        }
        for(int i=1;i<an;i++) {
            max = Math.max(max, maxLen(A, i, B, 0, an - i));
        }
        return max;
    }

    int maxLen(int[] a, int i, int[] b, int j, int len) {
        int count = 0, max = 0;
        for(int k = 0; k < len; k++) {
            if(a[i+k] == b[j+k]) {
                count++;
            } else if(count > 0) {
                max = Math.max(max, count);
                count = 0;
            }
        }
        return count > 0 ? Math.max(max, count) : max;
    }
}
