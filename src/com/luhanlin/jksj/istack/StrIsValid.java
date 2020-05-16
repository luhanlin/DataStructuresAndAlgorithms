package com.luhanlin.jksj.istack;

import java.util.Stack;

/**
 * 类详细描述：给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足： leedcode 20
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2020/5/15 10:37 AM
 */
public class StrIsValid {

    public static boolean isValid(String str){

        // 奇数不用判定
        if (str==null || (str.length() % 2) != 0) return false;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;

                Character preC = stack.peek();

                if (c == ')' && preC == '(') {
                    stack.pop();
                }
                if (c == '}' && preC == '{') {
                    stack.pop();
                }
                if (c == ']' && preC == '[') {
                    stack.pop();
                }
            }
        }

        return stack.empty();
    }

    public static void main(String[] args) {
        String s1 = "{}[]()";
        String s2 = "{[](})";
        String s3 = "{[]()}";

        System.out.println("s1-> " + isValid(s1));
        System.out.println("s2-> " + isValid(s2));
        System.out.println("s3-> " + isValid(s3));

    }

}
