package com.luhanlin.jksj.istack;

import java.util.Stack;

/**
 * 类详细描述：
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2020/5/15 12:31 PM
 */
public class MinStack {

    private Stack<Integer> stack;

    private Stack<Integer> tmpStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        tmpStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);

        if (tmpStack.isEmpty()) {
            tmpStack.push(x);
        } else {
            Integer peek = tmpStack.peek();
            if ( peek > x) {
                tmpStack.push(x);
            } else {
                tmpStack.push(peek);
            }
        }
    }

    public void pop() {
        stack.pop();
        tmpStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return tmpStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.push(-2);
        System.out.println(minStack.getMin());   // --> 返回 -3.
        minStack.pop();
        minStack.pop();
        System.out.println(minStack.top());      // --> 返回 0.
        System.out.println(minStack.getMin());   // --> 返回 -2.

    }
}
