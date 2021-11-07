#### 05. 替换空格

请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

示例 1：

输入：s = "We are happy."
输出："We%20are%20happy."

限制：

0 <= s 的长度 <= 10000

##### replace() 方法

使用 String 的 replace() 函数

```java
public class Solution {
   public String replaceSpace(String s) {
      return s.replace(" ", "%20");
   }
}
```

时间复杂度 O(N)：一次遍历字符数组

空间复杂度 O(1)：使用常数级的空间

##### 遍历添加


