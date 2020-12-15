import java.util.LinkedList;
import java.util.List;

public class nc50 {
    public ListNode reverseKGroup(ListNode head, int k) {
        int len = getLen(head);
        if(len==1 || head==null || k==1){
            return head;
        }

        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp = head;

        for(int i=0;i<len/k;i++){

            // 头插法，反转每一段节点，相当于单链表的反转
            for(int j=1;j<k;j++){
                tmp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = tmp;
            }

            pre = cur;
            cur = cur.next;
        }
        return head;
    }

    public int getLen(ListNode node) {
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        nc50 c = new nc50();
        c.reverseKGroup(node1,2);
    }
}
