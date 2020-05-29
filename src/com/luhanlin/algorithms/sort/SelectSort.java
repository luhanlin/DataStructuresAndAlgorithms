package com.luhanlin.algorithms.sort;

import com.luhanlin.Utils.CommonUtils;

/**
 * 类详细描述：选择排序，每次找到未排序区域最小值放到已排区域末尾
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2020/5/16 9:54 PM
 */
public class SelectSort {

    /**
     * 选择排序，每次找到未排序区域最小值放到已排区域末尾
     * @param a 要进行排序的数组
     * @param n 数组的大小
     */
    public static void sort(int[] a,int n){
        if (n <=1) return;


        for (int i = 0; i < n; i++) {
            int index = i;
            // 寻找最小值
            for (int j = i + 1; j < n ; j++) {
                if (a[j] < a[index]) {
                    index = j;
                }
            }

            if (index != i) {
                int tmp = a[i];
                a[i] = a[index];
                a[index] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {21,88,11,61,32,12,1,3,4};

        sort(a, a.length);

        CommonUtils.printf(a);

    }

}
