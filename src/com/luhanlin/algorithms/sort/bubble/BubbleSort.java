package com.luhanlin.algorithms.sort.bubble;

/**
 * @description: bubble sort 【稳定排序】
 *               时间复杂度： O(N^2)
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
     */
    public static void sortUpgrade01(int[] a){
        boolean flag = true;

        int lastSwapIndex = 0;

        int sortBorder = a.length -1;

        for (int i = 0; i < a.length; i++) {
            // 每次排序a[0 ... i]
            for (int j = 0; j < sortBorder; j++) {
                if (a[j] > a[j+1]) {
                    // swap
                    swap(a, j, j + 1);
                    flag = false;
                    lastSwapIndex = j;
                }
            }
            sortBorder = lastSwapIndex;
            if (flag) break;
        }
    }

    /**
     * 冒泡排序 升级版 鸡尾酒排序
     * @param a 待排序的数组
     */
    public static void sortUpgrade02(int[] a){

        int leftLastSwapIndex = 0;
        int rightLastSwapIndex = 0;

        int leftSortBorder = 0;
        int rightSortBorder = a.length -1;

        // 因为每次双向操作，所以外层循环可以除以2
        for (int i = 0; i < a.length/2; i++) {
            // 从左向右排序
            boolean flag = true;
            for (int j = leftSortBorder; j < rightSortBorder; j++) {
                if (a[j] > a[j+1]) {
                    // swap
                    swap(a, j, j + 1);
                    flag = false;
                    rightLastSwapIndex = j;
                }
            }
            rightSortBorder = rightLastSwapIndex;
            if (flag) break;

            // 从右向左排序
            flag = true;
            for (int j = rightSortBorder; j > leftSortBorder; j--) {
                if (a[j] < a[j-1]) {
                    // swap
                    swap(a, j, j - 1);
                    flag = false;
                    leftLastSwapIndex = j;
                }
            }
            leftSortBorder = leftLastSwapIndex;
            if (flag) break;
        }
    }

    /**
     * swap a[i] and a[j]
     */
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
