package com.luhanlin.leetcode.strings;

import java.util.List;

/**
 * <类详细描述>给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
 *
 * @author luhanlin
 * @version [V_1.0.0, 2020-07-06 17:20]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class N524FindLongestWord {

    public String findLongestWord(String s, List<String> d) {
        String res = "";
        int n = s.length();
        for (String str : d) {
            int m = str.length();
            if (m > n) continue;
            int i = 0;
            int j = 0;

            while (i < n && j < m) {
                if (s.charAt(i++) == str.charAt(j)) {
                    j++;
                }
            }
            if (j == m) { // 说明都找到了
                if (res.length() < m || (res.length() == m && res.compareTo(str) < 0)) {
                    res = str;
                }
            }
        }
        return res;
    }

}
