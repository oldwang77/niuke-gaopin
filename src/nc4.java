public class nc4 {
    public class Solution {
        public boolean hasCycle(ListNode head) {
            // 空间复杂度是O(1)
            // 快慢指针相遇，则证明有环
            if(head==null){
                return false;
            }
            ListNode slow = head,fast = head;
            while(fast.next!=null && fast.next.next!=null){
                slow = slow.next;
                fast = fast.next.next;
                if(slow==fast){
                    return true;
                }
            }
            // 快指针到达终点了，返回false
            return false;
        }
    }
}
