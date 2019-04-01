package com.luhanlin.algorithms.sort.bubble;

/**
 * @description: bubble sort
 * @author: Mr.Lu
 * @create: 2019-04-01 13:49
 **/
public class BubbleSort {

    /**
     * 冒泡排序
     * @param a 待排序的数组
     * @param n     数组的长度
     */
    public static void sort(int[] a, int n){

        for (int i = n-1; i >0; i--) {
            // 每次排序a[0 ... i]
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j+1]) {
                    // swap
                    swap(a, j, j + 1);
                }
            }
        }
    }

    /**
     * 冒泡排序 升级版
     * @param a 待排序的数组
     * @param n     数组的长度
     */
    public static void sortUpgrade01(int[] a, int n){
        boolean flag = true;

        for (int i = n-1; i >0; i--) {
            // 每次排序a[0 ... i]
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j+1]) {
                    // swap
                    swap(a, j, j + 1);
                    flag = false;
                }
            }

            if (flag) break;
        }
    }

    /**
     * swap a[i] and a[j]
     * @param a
     * @param i
     * @param j
     */
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
