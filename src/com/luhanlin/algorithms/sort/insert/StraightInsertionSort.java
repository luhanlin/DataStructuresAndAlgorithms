package com.luhanlin.algorithms.sort.insert;

import com.luhanlin.algorithms.sort.CommonUtils;

/**
 * @description: 直接插入排序 复杂度 O(N^2)
 * @author: Mr.Lu
 * @create: 2019-04-01 15:08
 **/
public class StraightInsertionSort {

    /**
     * 直接插入排序
     * @param a 数组
     * @param n 数组长度
     */
    public static void sort(int[] a, int n) {
        int i, j, k;

        for (i = 1; i < n; i++) {

            //为a[i]在前面的a[0...i-1]有序区间中找一个合适的位置
            for (j = i - 1; j >= 0; j--)
                if (a[j] < a[i])
                    break;

            //如找到了一个合适的位置
            if (j != i - 1) {
                //将比a[i]大的数据向后移
                int temp = a[i];
                for (k = i - 1; k > j; k--)
                    a[k + 1] = a[k];
                //将a[i]放到正确位置上
                a[k + 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {21,88,11,61,32,12,1,3,4};

        sort(a, a.length);

        CommonUtils.printf(a);
    }
}
