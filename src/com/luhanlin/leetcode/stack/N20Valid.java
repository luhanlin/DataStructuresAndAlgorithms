package com.luhanlin.leetcode.stack;

import java.util.Stack;

/**
 * 类详细描述：给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * @author Mr_lu
 * @version 1.0
 * @mail allen_lu_hh@163.com
 * 创建时间：2020/6/28 4:51 下午
 */
public class N20Valid {

    public Boolean isValid (String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }
            if(stack.isEmpty()) {return false;}
            Character pop = stack.pop();
            if ((c == ')' && pop != '(') || (c == ']' && pop != '[')
                    || (c == '}' && pop != '{') ) {
                return false;
            }
        }

        return stack.isEmpty();
    }

    public Boolean isValid2(String s) {
        while (s.contains("{}") || s.contains("[]") || s.contains("()")) {
            s.replace("{}","");
            s.replace("[]","");
            s.replace("()","");
        }
        return "".equals(s);
    }
}
