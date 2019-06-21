package com.luhanlin.algorithms.offer.array;

/**
 * @description:
 *      一组长度为n的数组含有范围取值为0 ~ n-1的数值，其中有些数值是重复的，找出其中任意重复的数值
 * @author: Mr.Lu
 * @create: 2019-06-20 14:23
 **/
public class RepeatNumber {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,2,1,2};
        // 传入没有初始值的数组没有输出-1，原因是数组中所有数的初始值为0
        System.out.println(duplicateNum(new int[4]));
        System.out.println(duplicateNum(arr));

    }

    public static int duplicateNum(int[] arr){

        // 排除空值，并且数组只有一个数时不可能重复
        if (arr == null || arr.length <= 1) {
            return -1;
        }

        // 对数组中数据是否越界做判断
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0 || arr[i] > arr.length - 1) {
                return -1;
            }
        }

        // 根据连续性的数组特性，比较下标和数组中数据的对应关系
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] != i) {
                if (arr[i] == arr[arr[i]]) {
                    return arr[i];
                }

                // swap arr[i] arr[arr[i]]
                swap(arr, i, arr[i]);
            }
        }

        return -1;
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
