package com.luhanlin.algorithms.compute;

import java.util.Stack;

/**
 * @description: 使用两个栈模拟一个栈，该栈可以在O(1)时间内获取栈中最小元素
 * @author: Mr.Lu
 * @create: 2019-04-22 14:08
 **/
public class GetMinEleFromStack {

    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();

        myStack.push(22);
        myStack.push(12);
        myStack.push(12);
        myStack.push(11);
        myStack.push(8);

        myStack.pop();
        myStack.pop();
        myStack.pop();
        System.out.println(myStack.getMin());
    }

    public static class MyStack<E>{
        Stack<E> s1 = null;
        Stack<E> s2 = null;

        public MyStack(){
            s1 = new Stack<E>();
            s2 = new Stack<E>();
        }

        //判断是否栈空
        public boolean isEmpty(){
            return s1.isEmpty();
        }

        //获取栈中元素个数
        public int size(){
            return s1.size();
        }

        //入栈，栈s1保存所有数据，若栈s2为空，则元素直接入栈，否则先和s2中栈顶元素比较，若更小则入栈
        public void push(E data){
            s1.push(data);

            if(s2.isEmpty())
                s2.push(data);
            else{
                if((int)data<=(int)s2.peek())  //注意替换该处的元素比较方法
                    s2.push(data);
            }
        }

        //出栈，直接弹出s1栈顶元素，同时判断弹出的元素和栈s2栈顶元素的大小，若等于则弹出s2的栈顶元素
        public E pop(){
            E topData = s1.pop();
            if(topData.equals(s2.peek()))
                s2.pop();
            return topData;
        }

        //获取栈顶元素
        public E peek(){
            return s1.peek();
        }

        //获取栈中的最小值
        public E getMin(){
            if(s2.isEmpty())
                return null;
            return s2.peek();
        }
    }
}
