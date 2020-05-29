package com.luhanlin.algorithms.sort;

import java.util.Arrays;

/**
 * @description: 计数排序 复杂度 O(N)
 *      步骤：
 *          首先会对每个输入进行频率统计，得到元素的频率表；
 *          然后将频率表转换为该元素的开始索引；
 *          根据各个元素的开始索引，将相同元素分类到临时数组中。
 *          最后将临时数组中的元素写回到原数组中。
 *
 * @author: Mr.Lu
 * @create: 2019-04-23 09:41
 **/
public class CountingSort {

    public static void sort(int[] arr) {
        // 计算最大最小值，严谨实现最好用ifPresent检查下
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int N = arr.length;
        int R = max - min + 1; // 最大最小元素之间范围[min, max]的长度
        // 1. 计算频率，在需要的数组长度上额外加1
        int[] count = new int[R+1];
        for (int i = 0; i < N; i++) {
            // 使用加1后的索引，有重复的该位置就自增
            count[arr[i] - min + 1]++;
        }
        // 2. 频率 -> 元素的开始索引
        for (int r = 0; r < R; r++) {
            count[r + 1] += count[r];
        }

        System.out.println("count : " + Arrays.toString(count));
        // 3. 元素按照开始索引分类，用到一个和待排数组一样大临时数组存放数据
        int[] aux = new int[N];
        for (int i = 0; i < N; i++) {
            // 填充一个数据后，自增，以便相同的数据可以填到下一个空位
            aux[count[arr[i] - min]++] = arr[i];
            System.out.println(count[arr[i] - min]);
        }
        // 4. 数据回写
        for (int i = 0; i < N; i++) {
            arr[i] = aux[i];
        }
    }

    public static void main(String[] args) {
        int[] a = {9, 7, 6, 3, 9, 2, 7, 3, 2, 8};
        CountingSort.countSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void countSort(int[] a){
        // 获取数组中最大最小值
        int max = Arrays.stream(a).max().getAsInt();
        int min = Arrays.stream(a).min().getAsInt();

        // 划分桶
        int len = max - min + 1;
        int[] c = new int[len +1];

        // 对数组a中的元素进行计数
        for (int i = 0; i < a.length; i++) {
            c[a[i]-min+1]++;
        }

        // 累加数据
        for (int j = 1; j < c.length; j++) {
            c[j] += c[j-1];
        }

        // 用一个临时数组，存放排序后的数据
        int[] tmp = new int[a.length];

        for (int r = a.length -1; r >=0; r--) {
            int cIndex = a[r] - min + 1;
            int index = c[cIndex] -1;
            tmp[index] = a[r];
            c[cIndex]--;
        }

        for (int i = 0; i < a.length; i++) {
            a[i] = tmp[i];
        }

    }
}
