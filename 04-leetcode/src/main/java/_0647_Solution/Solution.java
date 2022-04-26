package _0647_Solution;

/**
 * @author YeYaqiao
 * 647. 回文子串
 */
public class Solution {

    //中心扩展
    public int countSubstrings(String s) {
        int length = s.length();
        int result = 0;
        for (int i = 0; i < length; i++) {
            for (int l = i, r = i; l >= 0 && r < length && s.charAt(l) == s.charAt(r); l--, r++)
                result++;
            for (int l = i, r = i + 1; l >= 0 && r < length && s.charAt(l) == s.charAt(r); l--, r++)
                result++;

        }
        return result;
    }
}
