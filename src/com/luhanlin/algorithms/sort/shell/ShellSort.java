package com.luhanlin.algorithms.sort.shell;

import com.luhanlin.Utils.CommonUtils;

/**
 * @description: 希尔排序 在直接插入排序上添加了step
 *       worst： O(n^2) average: O(n^2/3) best: O(n log^2n)
 * @author: Mr.Lu
 * @create: 2019-04-02 10:23
 **/
public class ShellSort {

    public static void sort(int[] a){
        int step = a.length / 2;

        while (step >= 1) {
            for (int i = step; i < a.length; i++) {
                int j;
                int temp = a[i];

                for (j = i - step; j >= 0 && a[j] > temp; j -= step) {
                    // 交换位置
                    a[j+step] = a[j];
                }
                a[j+step] = temp;
            }

            System.out.println("\n step = " + step);
            CommonUtils.printf(a);
            step = step / 2;
        }
    }

    public static void main(String[] args) {
        int[] a = {21,88,11,61,32,12,1,3,4};
        sort(a);
    }
}
