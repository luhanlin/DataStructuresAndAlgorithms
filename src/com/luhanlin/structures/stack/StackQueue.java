package com.luhanlin.structures.stack;

import java.util.Stack;

/**
 * @description: 双栈实现队列
 * @author: Mr.Lu
 * @create: 2019-04-24 17:00
 **/
public class StackQueue {

    private static Stack<Integer> stackA = new Stack<>();
    private static Stack<Integer> stackB = new Stack<>();

    /**
     * 入栈
     * @param num
     */
    public void enQueue(Integer num){
        stackA.push(num);
    }

    public Integer deQueue(){
        if (stackB.empty()) {
            if (stackA.empty()) {
                return null;
            }

            // 从栈A中取数
            transfer();
        }

        return stackB.pop();
    }

    private void transfer() {
        while (!stackA.empty()) {
            stackB.push(stackA.pop());
        }
    }

    public static void main(String[] args) {
        StackQueue queue = new StackQueue();

        queue.enQueue(11);
        queue.enQueue(34);
        queue.enQueue(66);

        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        queue.enQueue(88);
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());

    }

}
