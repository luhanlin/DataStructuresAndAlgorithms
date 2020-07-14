package com.luhanlin.leetcode.strings;

import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * <类详细描述> 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * @author luhanlin
 * @version [V_1.0.0, 2020-07-14 11:28]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class N394DecodeString {

    /**
     * 使用辅助栈
     * @param s
     * @return
     */
    public String decodeString(String s) {
        Stack<Integer> stack_multi = new Stack<>();
        Stack<String> stack_res = new Stack<>();

        int multi = 0;
        StringBuilder res = new StringBuilder();
        for (char c: s.toCharArray()) {
            if (c >= '0' && c <='9') {
                multi = 10 * multi + Integer.parseInt(String.valueOf(c));
            } else if (c == '[') {
                stack_multi.push(multi);
                stack_res.push(res.toString());
                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                Integer preMulti = stack_multi.pop();
                String preRes = stack_res.pop();
                tmp.append(preRes);
                for (int i = 0; i < preMulti; i++) {
                    tmp.append(res);
                }
                res = new StringBuilder(tmp);
            } else {
                res.append(c);
            }
        }
        
        return res.toString();
    }

}
