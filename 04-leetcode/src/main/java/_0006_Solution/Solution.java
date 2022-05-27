package _0006_Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YeYaqiao
 * 6. Z 字形变换
 */
public class Solution {
    //找规律
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        //为每行创建一个 stringbuilder 用于拼接字符串
        List<StringBuilder> builders = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++)
            builders.add(new StringBuilder());
        //z字形字符串，一开始设为向上遍历，方便处理边界
        boolean down = false;
        //使用 row 来记录遍历z字形字符串的层数
        for (int i = 0, row = 0; i < s.length(); i++) {
            builders.get(row).append(s.charAt(i));
            //当遍历到z字形字符串第一层或者最后一层时，需要改变row的写入层数的方向
            if (row == 0 || row == numRows - 1)
                down = !down;
            row += down ? 1 : -1;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder builder : builders)
            res.append(builder);
        return res.toString();
    }


    //找规律
//    public String convert(String s, int numRows) {
//        if (numRows < 2)
//            return s;
//        List<StringBuilder> rows = new ArrayList<>(numRows);
//        for (int i = 0; i < numRows; i++) {
//            rows.add(new StringBuilder());
//        }
//        int i = 0, flag = -1;
//        for (char c : s.toCharArray()) {
//            rows.get(i).append(c);
//            if (i == 0 || i == numRows - 1)
//                flag = -flag;
//            i += flag;
//        }
//        StringBuilder res = new StringBuilder();
//        for (StringBuilder row : rows) {
//            res.append(row);
//        }
//        return res.toString();
//    }
}
