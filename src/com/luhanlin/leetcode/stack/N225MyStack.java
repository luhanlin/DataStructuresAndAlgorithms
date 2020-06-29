package com.luhanlin.leetcode.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 类详细描述：用队列实现栈
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2020/6/28 7:05 下午
 */
public class N225MyStack {
    Queue<Integer> in;
    Queue<Integer> out;

    /** Initialize your data structure here. */
    public N225MyStack() {
        in = new LinkedList<>();
        out = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        in.offer(x);
        while (!out.isEmpty()) {
            in.offer(out.poll());
        }

        Queue tmp = in;
        in = out;
        out = tmp;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return out.poll();
    }

    /** Get the top element. */
    public int top() {
        return out.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return out.isEmpty();
    }
}
