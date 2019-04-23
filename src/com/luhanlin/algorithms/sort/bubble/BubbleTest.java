package com.luhanlin.algorithms.sort.bubble;

import com.luhanlin.Utils.CommonUtils;

/**
 * @description:
 * @author: Mr.Lu
 * @create: 2019-04-01 13:50
 **/
public class BubbleTest {

    public static void main(String[] args) {
        int[] a = {21,33,11,61,32,12,1,3,4,22,4,3,3,4,5,6,445,33,43,323,232};

//        BubbleSort.sort(a, a.length);

        BubbleSort.sortUpgrade02(a);

        CommonUtils.printf(a);
    }

}
