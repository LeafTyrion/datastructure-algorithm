package _17_Solution;


/**
 * @author YeYaqiao
 * 剑指 Offer 17. 打印从1到最大的n位数
 */
public class Solution {

    //当数字过大时需要使用字符串来表示，不会啊
    int[] res;
    int nine = 0, count = 0, start, n;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    //利用char全排列
    public int[] printNumbers(int n) {
        this.n = n;
        res = new int[(int) Math.pow(10, n) - 1];
        num = new char[n];
        start = n - 1;
        //开启递归，从第0位开始递归
        dfs(0);
        return res;
    }

    //递归构造loop的字符数组全排列
    private void dfs(int x) {
        //递归推出条件，当前位置等于目标位数时，将num中的结果截取并添加入 res
        if (x == n) {
            String s = String.valueOf(num).substring(start);
            if (!s.equals("0"))
                res[count++] = Integer.parseInt(s);
            if (n - start == nine)
                start--;
            return;
        }
        for (char i : loop) {
            if (i == '9')
                nine++;
            num[x] = i;
            //递归构造下一位的全排列
            dfs(x + 1);
        }
        nine--;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.printNumbers(3);
    }

    //面试不考这么简单
//    public int[] printNumbers(int n) {
//        int length = (int) (Math.pow(10, n) - 1);
//        int[] result = new int[length];
//        for (int i = 1; i <= length; i++) {
//            result[i-1] = i;
//        }
//        return result;
//    }
}
