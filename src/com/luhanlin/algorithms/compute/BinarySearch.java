package com.luhanlin.algorithms.compute;

import java.util.Arrays;

/**
 * @description: 二分查找法
 * @author: Mr.Lu
 * @create: 2019-06-11 11:23
 **/
public class BinarySearch {

    /**
     * 递归查找
     * @param arr   排好序的数组
     * @param x     寻找的参数
     * @return      找不到返回 -1
     */
    public static int recursionSearch(int[] arr, int x, int beginIndex, int endIndex){
        int midIndex = (endIndex - beginIndex) >> 1;

        if (arr.length == 0 || beginIndex > endIndex || x > arr[endIndex]) {
            return -1;
        }

        if (arr[midIndex] > x) {
            return recursionSearch(arr, x, beginIndex, midIndex-1);
        } else if (arr[midIndex] > x){
            return recursionSearch(arr, x, midIndex+1, endIndex);
        } else {
            return midIndex;
        }
    }

    /**
     * 循环查找
     * @param arr   排好序的数组
     * @param x     寻找的参数
     * @return      找不到返回 -1
     */
    public static int loopSearch(int[] arr, int x) {
        int beginIndex = 0;
        int endIndex = arr.length - 1;
        int midIndex = (endIndex - beginIndex) >> 1;

        if (arr.length == 0 || beginIndex > endIndex || x > arr[endIndex]) {
            return -1;
        }

        while(beginIndex < endIndex){
            if (arr[midIndex] > x) {
                endIndex = midIndex - 1;
            } else if (arr[midIndex] > x){
                beginIndex = midIndex + 1;
            } else {
                return midIndex;
            }
        }

        return -1;
    }

    /**
     * 一组有序可重复的数组，找到第一个与value相等的元素下标
     * @param a
     * @param value
     */
    public static int getFirstValue(int[] a, int value){
        int min = 0;
        int max = a.length-1;

        while (min <= max) {
            int middle = min + ((max - min) >> 1); // 去中间值
            if (a[middle] > value) {
                max = middle -1;
            } else if (a[middle] < value) {
                min = middle +1;
            } else{
                if (middle == 0 || a[middle -1] != value) {
                    return middle;
                } else {
                    max = middle -1;
                }
            }
        }
        return -1;
    }
    /**
     * 一组有序可重复的数组，找到最后一个与value相等的元素下标
     * @param a
     * @param value
     */
    public static int getLastValue(int[] a, int value){
        int min = 0;
        int max = a.length-1;

        while (min <= max) {
            int middle = min + ((max - min) >> 1); // 去中间值
            if (a[middle] > value) {
                max = middle -1;
            } else if (a[middle] < value) {
                min = middle +1;
            } else{
                if (middle == a.length -1 || a[middle +1] != value) {
                    return middle;
                } else {
                    min = middle + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 一组有序可重复的数组，找到第一个大于等于value的元素下标
     * @param a
     * @param value
     */
    public static int getFirstGtValue(int[] a, int value){
        int min = 0;
        int max = a.length-1;

        while (min <= max) {
            int middle = min + ((max - min) >> 1); // 去中间值
            if (a[middle] >= value) {
                if (middle == 0 || a[middle - 1] < value) {
                    return middle;
                } else {
                    max = middle - 1;
                }
            } else{
                min = middle + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 4, 4, 4, 6, 11, 13, 15};

//        System.out.println(getFirstValue(a, 4));
//        System.out.println(getLastValue(a, 4));
        System.out.println(getFirstGtValue(a, 5));

//        int[] ints = {1, 2, 3, 4, 6, 5, 4, 33};
//        Arrays.sort(ints);
//
//        System.out.println("recursionSearch: " + recursionSearch(ints, 4, 0, ints.length-1));
//        System.out.println("loopSearch: " + loopSearch(ints, 4));
    }
}
