package com.luhanlin.algorithms.sort.quick;

import com.luhanlin.Utils.CommonUtils;

/**
 * @description: Quick sort 【稳定排序】 时间复杂度 min: O(log(N+1)) mid: O(N log(N+1)) max: O(N^2)
 * @author: Mr.Lu
 * @create: 2019-04-01 14:15
 **/
public class QuickSort {

    /**
     * 快排
     * @param a 待排序的数组
     * @param l 数组左边界下标
     * @param r 数组右边界下标
     */
    public static void sort(int[] a, int l, int r){
        if (l < r) {
            int i = l;
            int j = r;

            // 获取初始中间变量
            int middle = a[i];

            while (i < j) {
                while (i < j && a[j] > middle) {
                    j--; // 从右往左找到第一个比middle小的值
                }

                if (i < j) {
                    a[i++] = a[j];
                }

                while (i < j && a[i] < middle) {
                    i++; // 从左往右找到第一个比middle大的值
                }

                if (i < j) {
                    a[j--] = a[i];
                }
            }

            a[i] = middle;

            sort(a, l , i - 1);
            sort(a, i + 1 , r);
        }
    }

    /**
     * 获取第K大的元素
     * @param a
     * @param k
     * @return
     */
    public static int getK(int[] a, int k){

        if (a.length < k) return -1;

        return sort(a, 0, a.length -1, k);

    }

    public static int sort(int[] a, int l, int r, int k){

        if (l < r) {
            int i = l;
            int j = r;

            int mid = a[i];

            while (i < j) {
                while (i < j && a[j] < mid) {
                    j--;
                }
                if (i < j) {
                    a[i++] = a[j];
                }

                while (i < j && a[i] > mid) {
                    i++;
                }
                if (i < j) {
                    a[j--] = a[i];
                }
            }
            a[i] = mid;

            if (i+1 == k) return mid;

            if (i+1 < k) {
                return sort(a, i +1, r, k);
            } else {
                return sort(a, l, i-1, k);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {21,88,11,61,32,12,1,3,4};
        System.out.println(getK(a, 4));

        sort(a, 0, a.length -1);
        CommonUtils.printf(a);
    }
}
