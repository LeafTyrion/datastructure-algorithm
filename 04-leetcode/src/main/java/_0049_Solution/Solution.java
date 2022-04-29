package _0049_Solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author YeYaqiao
 * 49. 字母异位词分组
 */
public class Solution {
    //字母计数法
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] counts = new int[26];
            int length = str.length();
            for (int i = 0; i < length; i++) {
                //对每个字母出现的次数进行计数
                counts[str.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (counts[i] != 0) {
                    //将出现的字母和出现的次数拼接成字符串
                    sb.append((char) ('a' + i));
                    sb.append(counts[i]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }


    //hashmap+排序
//    public List<List<String>> groupAnagrams(String[] strs) {
//        Map<String, List<String>> map = new HashMap<>();
//        for (String str : strs) {
//            char[] chars = str.toCharArray();
//            Arrays.sort(chars);
//            String s = String.valueOf(chars);
//            if (map.containsKey(s)) {
//                List<String> list = map.get(s);
//                list.add(str);
//            } else {
//                List<String> list = new ArrayList<>();
//                list.add(str);
//                map.put(s, list);
//            }
//        }
//        return new ArrayList<>(map.values());
//    }
}
