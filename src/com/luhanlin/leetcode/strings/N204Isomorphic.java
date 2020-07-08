package com.luhanlin.leetcode.strings;

/**
 * <类详细描述>给定两个字符串 s 和 t，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 *
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * 示例 1:
 *
 * 输入: s = "egg", t = "add"
 * 输出: true
 *
 * @author luhanlin
 * @version [V_1.0.0, 2020-07-06 14:21]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class N204Isomorphic {

    /**
     * 映射字符串
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        if (n != t.length()) return false;
        int[] sMap = new int[256];
        int[] tMap = new int[256];

        for (int i = 0; i < n; i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if (sMap[cs] != tMap[ct]) {
                return false;
            } else {
                if (sMap[cs] == 0) {
                    sMap[cs] = i+1;
                    tMap[ct] = i+1;
                }
            }
        }
        return true;
    }
}
