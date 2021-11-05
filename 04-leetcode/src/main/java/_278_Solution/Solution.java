package _278_Solution;

/**
 * @author YeYaqiao
 * 278. 第一个错误的版本
 */
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int min = 1;
        int max = n;

        while (min < max) {
            int mid = min + (max - min) / 2;
            if (isBadVersion(mid)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }
}

class VersionControl {
    boolean isBadVersion(int version) {
        return false;
    }
}
