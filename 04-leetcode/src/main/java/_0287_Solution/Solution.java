package _0287_Solution;

/**
 * @author YeYaqiao
 * 287. 寻找重复数
 */
public class Solution {
    //快慢指针
    public int findDuplicate(int[] nums) {
        //将数组抽象成链表进行访问，每次访问
        int slow = 0, fast = 0;
        slow = nums[slow];//slow=slow.head
        fast = nums[nums[fast]];//fast=fast.next.next
        while (slow != fast) {
            slow = nums[slow];//slow=slow.head
            fast = nums[nums[fast]];//fast=fast.next.next
        }
        int head = 0;//fast=head;
        while (slow != head) {
            head = nums[head];//fast=fast.next
            slow = nums[slow];//slow=slow.head
        }
        return head;

    }
}
