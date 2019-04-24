package com.luhanlin.structures.heap;

import java.util.Arrays;

/**
 * @description: 优先级队列
 * @author: Mr.Lu
 * @create: 2019-04-24 15:51
 **/
public class PriorityQueue {

    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue();
        queue.enQueue(11);
        queue.enQueue(125);
        queue.enQueue(1);
        queue.enQueue(14);

        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
    }

    private int[] array;
    private int size;

    public PriorityQueue() {
        this.array = new int[32];
    }

    /**
     * 入队
     * @param num
     */
    public void enQueue(int num){
        if (size >= array.length) {
            // 扩容
            reSize();
        }

        array[size++] = num;
        HeapOperator.upAdjust(array,size -1);
    }

    public int deQueue(){
        if (size <= 0) {
            throw new RuntimeException("队列空了...");
        }

        int head = array[0];

        array[0] = array[--size];

        HeapOperator.downAdjust(array, 0, size);
        return head;
    }

    private void reSize() {
        int newSize = this.size << 2;
        this.array = Arrays.copyOf(this.array, newSize);
    }
}
