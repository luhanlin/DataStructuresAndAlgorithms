package com.luhanlin.algorithms.sort.quick;

import com.luhanlin.algorithms.sort.CommonUtils;

/**
 * @description:
 * @author: Mr.Lu
 * @create: 2019-04-01 14:23
 **/
public class QuickTest {

    public static void main(String[] args) {
        int[] a = {21,88,11,61,32,12,1,3,4};

        QuickSort.sort(a, 0, a.length -1);

//        QuickSort.quickSort(a, 0, a.length -1);


        CommonUtils.printf(a);
    }
}
