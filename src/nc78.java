public class nc78 {
    public ListNode ReverseList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode pre = null,cur = head,behind = head;
        while(cur!=null){
            behind = cur.next;
            cur.next = pre;
            pre = cur;
            cur = behind;
        }
        return pre;
    }
}
