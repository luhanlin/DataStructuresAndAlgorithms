package com.luhanlin.Utils;

import com.luhanlin.jksj.link.ListNode;

/**
 * @description:
 * @author: Mr.Lu
 * @create: 2019-04-01 14:41
 **/
public class CommonUtils {

    public static void printf(int[] a) {
        for (int n : a) {
            System.out.print(n + "\t");
        }
    }

    public static void printAll(ListNode node){
        ListNode nextNode = node;

        while (nextNode != null) {
            System.out.print(nextNode.getVal() + " ");
            nextNode = nextNode.getNext();
        }

        System.out.println();
    }
}
