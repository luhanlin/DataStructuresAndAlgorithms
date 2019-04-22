package com.luhanlin.algorithms.sort.bubble;

import com.luhanlin.Utils.CommonUtils;

/**
 * @description:
 * @author: Mr.Lu
 * @create: 2019-04-01 13:50
 **/
public class BubbleTest {

    public static void main(String[] args) {
        int[] a = {21,33,11,61,32,12,1,3,4};

//        BubbleSort.sort(a, a.length);

        BubbleSort.sortUpgrade01(a, a.length);

        CommonUtils.printf(a);
    }

}
