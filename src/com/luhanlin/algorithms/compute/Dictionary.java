package com.luhanlin.algorithms.compute;

import java.util.Arrays;

/**
 * @description: 字典序算法
 * @author: Mr.Lu
 * @create: 2019-04-23 15:53
 **/
public class Dictionary {

    public static void main(String[] args) {
        int[] numbers = new int[]{1,2,5,4,3};
        int[] nearestNumber = findNearestNumber(numbers);

        printArray(nearestNumber);
    }

    public static int[] findNearestNumber(int[] numbers) {
        // 1. copy 一份数组
        int[] copyNum = Arrays.copyOf(numbers, numbers.length);

        // 2. 从后向前查看逆序区域，找到逆序区域的前一位，也就是数字置换的边界
        int index = findTransferPoint(copyNum);

        if (index == 0) {
            return null;
        }

        // 3. 把逆序区域的前一位和逆序区域中刚刚大于它的数字交换位置
        exchangeHead(copyNum, index);

        // 4. 将原来的逆序区域做顺序
        reserve(copyNum, index);

        return copyNum;
    }

    private static int findTransferPoint(int[] copyNum) {
        for (int i = copyNum.length -1; i >0 ; i-- ) {
            if (copyNum[i] > copyNum[i-1]) {
                return i;
            }
        }
        return 0;
    }

    private static void exchangeHead(int[] copyNum, int index) {
        int head = copyNum[index -1];

        for (int i = copyNum.length-1; i >= index ; i--) {
            if (head < copyNum[i]) {
                copyNum[index -1] = copyNum[i];
                copyNum[i] = head;
                break;
            }
        }
    }

    private static void reserve(int[] copyNum, int index) {
        for(int i=index,j=copyNum.length- 1; i<j; i++,j--){
            int temp = copyNum[i];
            copyNum[i] = copyNum[j];
            copyNum[j] = temp;
        }
    }

    private static void printArray(int[] numbers){
        System.out.println(Arrays.toString(numbers));
    }
}
