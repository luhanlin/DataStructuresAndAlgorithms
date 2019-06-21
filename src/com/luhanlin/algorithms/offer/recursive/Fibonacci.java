package com.luhanlin.algorithms.offer.recursive;

/**
 * @description: 裴波那契数列
 * @author: Mr.Lu
 * @create: 2019-06-21 14:55
 **/
public class Fibonacci {

    public static void main(String[] args) {
//        System.out.println(recursive(10000));
        System.out.println(loop(10000));
    }

    /**
     * 递归的求裴波那契数
     * @param n
     * @return
     */
    public static int recursive(int n){
        int[] ints = {0, 1};
        if (n < 2) {
            return ints[n];
        }

        return recursive(n-1) + recursive(n -2);
    }

    /**
     * 循环的求裴波那契数，节省性能
     * @param n
     * @return
     */
    public static int loop(int n){
        int[] ints = {0, 1};
        if (n < 2) {
            return ints[n];
        }

        int min = 0;
        int more = 1;
        int result = 0;

        for (int i = 2; i <= n; i++) {
            result = min + more;
            min = more;
            more = result;
        }

        return result;
    }
}
