package com.luhanlin.algorithms.offer.link;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @description: 反向打印链表
 * @author: Mr.Lu
 * @create: 2019-06-21 10:24
 **/
public class ContraryPrintLink {

    public static void main(String[] args) {
        LinkedList<String> strings = new LinkedList<>();
        // 使用null测试
        strings.add(null);
        strings.add("aaa");
        strings.add("test");
        strings.add("world");
        strings.add("hello");

        printContraryLink2(strings);
    }

    /**
     * 使用栈进行打印
     * @param linkedList
     */
    public static void printContraryLink(LinkedList<String> linkedList) {
        // 开辟栈空间
        Stack<String> stack = new Stack<>();
        if (linkedList != null ) {
            while (!linkedList.isEmpty()) {
                stack.push(linkedList.pop());
            }

            while (!stack.isEmpty()){
                System.out.println(stack.pop());
            }
        }
    }

    /**
     * 使用递归的方式进行打印
     * @param linkedList
     */
    public static void printContraryLink2(LinkedList<String> linkedList) {
        if (linkedList != null && !linkedList.isEmpty()) {
            String result = linkedList.pop();
            printContraryLink2(linkedList);
            System.out.println(result);
        }
    }
}
