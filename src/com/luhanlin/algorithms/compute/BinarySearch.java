package com.luhanlin.algorithms.compute;

import java.util.Arrays;
import java.util.Collections;

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

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 6, 5, 4, 33};

        Arrays.sort(ints);

        System.out.println("recursionSearch: " + recursionSearch(ints, 4, 0, ints.length-1));
        System.out.println("loopSearch: " + loopSearch(ints, 4));
    }
}
