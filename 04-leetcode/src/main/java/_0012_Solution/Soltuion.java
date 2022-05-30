package _0012_Solution;

/**
 * @author YeYaqiao
 * 12. 整数转罗马数字
 */
public class Soltuion {
    public String intToRoman(int num) {
        //构建个十百千位
        String[] thousands = new String[]{"", "M", "MM", "MMM"};
        String[] hundreds = new String[]{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = new String[]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC",};
        String[] units = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return thousands[num / 1000] + hundreds[num / 100 % 10] + tens[num / 10 % 10] + units[num % 10];
    }
}
