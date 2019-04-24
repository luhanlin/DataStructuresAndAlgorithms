package com.luhanlin.structures.heap;

import com.luhanlin.Utils.CommonUtils;

/**
 * @description: 二叉堆 底层为一个数组而不是链式结构
 *      以下为 最大堆的实现
 * @author: Mr.Lu
 * @create: 2019-04-24 14:28
 **/
public class HeapOperator {

    public static void main(String[] args) {

        int[] ints = {1, 3, 2, 5, 4, 6, 7, 9,8, 10, 0};


//        upAdjust(ints, ints.length-2);
//        CommonUtils.printf(ints);

//        createheap(ints);
//        CommonUtils.printf(ints);

        heapSort(ints);
        CommonUtils.printf(ints);

    }

    /**
     * 上浮
     * @param array
     * @param childIndex
     */
    public static void upAdjust(int[] array, int childIndex){

        int parentIndex = (childIndex - 1)  >> 1;

        int temp = array[childIndex];

        while (childIndex > 0 && temp > array[parentIndex]) {
            array[childIndex] = array[parentIndex];

            childIndex = parentIndex;
            parentIndex = (childIndex - 1) >> 1;
        }

        array[childIndex] = temp;
    }

    /**
     * 下沉 父节点
     * @param array
     * @param parentIndex
     */
    public static void downAdjust(int[] array, int parentIndex,int length){
        int childIndex = (parentIndex << 1) + 1;

        int temp = array[parentIndex];

        while (childIndex < length) {

            // 比较两个子节点的大小
            if (childIndex + 1 < length && array[childIndex + 1] > array[childIndex]) {
                childIndex++;
            }

            if (temp >= array[childIndex]) {
                break;
            }
            array[parentIndex] = array[childIndex];

            parentIndex = childIndex;

            childIndex = (parentIndex << 1) + 1;
        }

        array[parentIndex] = temp;
    }

    /**
     * 创建最大二叉堆，找到子节点依次下沉
     * @param array
     */
    public static void createheap(int[] array){
        // 从最后一个父节点开始遍历
        for (int i = (array.length -2) >> 1; i >=0 ; i--) {
            downAdjust(array,i, array.length);
        }
    }

    /**
     * 堆排序
     * @param array
     */
    public static void heapSort(int[] array){
        createheap(array);

        // 遍历节点，交换
        for (int i = array.length -1 ; i > 0 ; i--) {
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;

            downAdjust(array, 0, i);
        }
    }
}
