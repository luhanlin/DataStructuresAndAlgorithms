package com.luhanlin.algorithms.compute;

import java.util.HashMap;

/**
 * @description:
 * @author: Mr.Lu
 * @create: 2019-04-22 12:53
 **/
public class Simple {

    public static void main(String[] args) {
        int[] ints = {1,3,1,2,2,1,1,4,4,5,4,5,4};

        System.out.println(getLostNum(ints));

        int[] ints2 = {1,3,1,2,2,1,1,4,4,5,5,4};
        int[] a = new int[1];
        int[] b = new int[1];
        FindNumsAppearOnce2(ints2, a, b);
        System.out.println(a[0]+" "+b[0]);
    }

    /**
     * 依次遍历 ^ 求最终值，相同的数据^ 计算 == 0
     * @param array
     * @return
     */
    public static int getLostNum(int[] array){
        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            result = result ^ array[i];
        }
        return result;
    }

    /**
     * 方法 采用HashMap
     * @param array
     * @param a
     * @param b
     */
    public static void FindNumsAppearOnce(int [] array,int a[] , int b[]) {
        if (array.length<2||array==null) {
            a[0] = -1;
            b[0] = -1;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        Integer a1 = null;
        Integer a2 = null;
        for (int i = 0; i < array.length; i++) {
            if (hashMap.containsKey(array[i])) {
                hashMap.remove(array[i]);
            }else {
                hashMap.put(array[i], 1);
            }
        }
        for (Integer i : hashMap.keySet()) {
            if (a1==null) {
                a1 = i;
            }else {
                a2 = i;
            }
        }
        a[0] = a1;
        b[0] = a2;
    }

    /**
     * 方法2
     * @param array
     * @param a
     * @param b
     */
    public static void FindNumsAppearOnce2(int [] array,int a[] , int b[]) {
        if (array.length<2||array==null) {
            a[0] = -1;
            b[0] = -1;
        }
        int ans = array[0];//储存所有数相异或的结果
        for (int i = 1; i < array.length; i++) {
            ans ^= array[i];
        }
        int index = 0;//储存最右边的1是第几位
        while((ans&1)==0){
            ans=ans>>1;
            index++;
        }
        int[] a1 = new int[array.length];
        int[] a2 = new int[array.length];
        int i1 = 0;
        int i2 = 0;
        /*对两个分组分别进行异或 得到答案*/
        for (int i = 0; i < array.length; i++) {
            int temp = array[i];
            for (int j = 0; j < index; j++) {
                temp=temp>>1;
            }
            if ((temp&1)==0) {
                a1[i1++] = array[i];
                a[0] ^= array[i];
            }else {
                a2[i2++] = array[i];
                b[0] ^= array[i];
            }
        }
    }
}
