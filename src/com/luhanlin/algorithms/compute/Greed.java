package com.luhanlin.algorithms.compute;

import java.util.Stack;

/**
 * @description: 贪心算法 通过局部最优解取得全局最优解
 * @author: Mr.Lu
 * @create: 2019-04-24 19:05
 **/
public class Greed {

    public static void main(String[] args) {
        System.out.println(removeDigits("24530320",3));
    }

    /**
     * 升级版 速度提升5倍 2ms
     * @param num
     * @param k
     * @return
     */
    public static String removeDigits2(String num, int k){
        char[] s = num.toCharArray();
        int l = s.length;
        k = l - k;
        int min, last = 0, current, mi = -1;
        StringBuilder sb = new StringBuilder();
        while (k > 0) {
            min = 58;
            for (current = last; current + k <= l; current++) {
                if (s[current] == '0') {
                    min = '0';
                    mi = current;
                    break;
                }
                if (min > s[current]) {
                    min = s[current];
                    mi = current;
                }
            }
            if (sb.length() > 0 || min != '0')
                sb.append((char) min);
            k--;
            last = mi + 1;
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    /**
     * 移除 K个数字，是num成为最小值 10ms计算时间
     * @param num
     * @param k
     */
    public static String removeDigits(String num, int k){

        int length = num.length();

        if (k >= length) {
            return "0";
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < length; i++) {
            char c = num.charAt(i);

            if (stack.empty() && c != '0') {
                stack.push(c);
                continue;
            }

            while (!stack.empty() && stack.peek() > c && k > 0) {
                    stack.pop();
                    k--;
            }

            if (!(stack.empty() && c == '0')) {
                stack.push(c);
            }
        }

        // 以上顺序没有移除掉K数据，则
        while (k > 0) {
            stack.pop();
            k--;
        }

//        if (!stack.empty()) {
//            StringBuilder builder = new StringBuilder();
//            while (!stack.empty()){
//                builder.append(stack.pop());
//            }
        //     采用这种方式复杂度高
//            return builder.reverse().toString();
//        } else {
//            return "0";
//        }
        if (!stack.empty()) {
            char[] chars = new char[stack.size()];

            for (int i = chars.length -1; i >=0 ; i--) {
                chars[i] = stack.pop();
            }

            return new String(chars, 0, chars.length);
        } else {
            return "0";
        }
    }
}
