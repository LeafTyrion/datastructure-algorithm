#### 03. 数组中重复的数字

找出数组中重复的数字。

在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

示例 1：

输入：
[2, 3, 1, 0, 2, 5, 3]
输出：2 或 3

限制：

2 <= n <= 100000

##### 暴力法 双层 for 循环

使用双层 for 循环两两比较

1. 外层循环遍历数组，获取当前位置上的数字 cur；
   1. 内层循环将当前位置上的数字与其位置之后的数字 next 依次比较；
      1. 若 cur == next，则返回 cur；
2. 若循环结束尚未返回，则直接返回 -1

```java
public class _704_Solution.Solution {
    public int findRepeatNumber(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j])
                    return nums[i];
            }
        }
        return -1;
    }
}
```

时间复杂度 O(N^2)：双层循环遍历

空间复杂度 O(1)：没有使用额外空间

##### HashSet 哈希表

利用 HashSet 只能存入不重复元素的特性

1. 新建 HashSet
2. 遍历数组 nums，获取当前数字 num
   1. 若 HashSet 中是否存在 num，则返回 num
   2. 将 num 存入 HashSet 中
3. 若遍历结束尚未返回，则返回 -1

```java
public class _704_Solution.Solution {
    
   //    利用 HashSet
   public int findRepeatNumber(int[] nums) {

      Set<Integer> set = new HashSet<>();
      for (Integer num : nums) {
         if (set.contains(num)) {
            return num;
         }
         set.add(num);
      }
      return -1;
   }
}
```
时间复杂度 O(N)：遍历一次长度为 n 的数组

空间复杂度 O(N)：HashSet 占用了大小为 n 的空间

##### 原地交换法

长度为 n 的数组里所有的数字范围都在 0~n-1 范围内；
若数字不重复的情况下，说明每个数字和其索引值是一一对应的；
若数字重复，则某个索引值则会至少存在两个对应的数字

1. 遍历数组 nums，获取当前索引值 i 和当前数字 nums[i]（需要手动控制索引 i 的指向）
   1. 若 i == nums[i]，则跳过当前循环，i++，继续下一次循环
   2. 若 i != nums[i]
      1. 若 nums[i] == nums[nums[i]]，则说明当前数字 nums[i] 所应该处的位置已经存在了正确的值，则直接返回 nums[i]； 
      2. 否则将 nums[i] 交换到其对应的位置上去，继续从索引 i 开始下一次循环
2. 若遍历完尚未返回，则返回 -1

```java
public class _704_Solution.Solution {
    
    //    原地交换
    public static int findRepeatNumber(int[] nums) {

        int i = 0;
        while (i < nums.length) {

            if (nums[i] == i){
                i++;
                continue;
            }
            if (nums[nums[i]] == nums[i])
                return nums[i];
            int temp = nums[i];
            nums[i] = nums[temp];
            nums[temp] = temp;
        }
        return -1;
    }
}
```
时间复杂度 O(N)：遍历一次长度为 n 的数组

空间复杂度 O(1)：使用常数复杂度的额外空间


