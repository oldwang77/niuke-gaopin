import java.util.*;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 * }
 */

public class nc40 {
    /**
     * @param head1 ListNode类
     * @param head2 ListNode类
     * @return ListNode类
     */
    public ListNode addInList(ListNode head1, ListNode head2) {
        // write code here
        ListNode node1 = head1, node2 = head2;
        LinkedList<ListNode> l1 = new LinkedList<>();
        LinkedList<ListNode> l2 = new LinkedList<>();
        while (node1 != null) {
            l1.add(node1);
            node1 = node1.next;
        }
        while (node2 != null) {
            l2.add(node2);
            node2 = node2.next;
        }
        int len1 = l1.size(), len2 = l2.size();
        // 确保len1>len2
        if (len2 > len1) {
            LinkedList<ListNode> tmp = l1;
            l1 = l2;
            l2 = tmp;
        }
        //直接在l1前面补一个0
        l1.addFirst(new ListNode(0));
        len1 = len1 + 1;

        LinkedList<Integer> result = new LinkedList<>();
        int cur1 = len1 - 1, cur2 = len2 - 1;
        int add = 0;
        while (cur2 >= 0) {
            int ans = l1.get(cur1).val + l2.get(cur2).val;
            ans = ans + add;
            add = 0;
            if (ans >= 10) {
                add = 1;
                ans = ans - 10;
            }
            result.addFirst(ans);
            cur1--;
            cur2--;
        }


        while (cur1 >= 0) {
            int ans = l1.get(cur1).val;
            ans = ans + add;
            add = 0;
            if (ans >= 10) {
                add = 1;
                ans = ans - 10;
            }
            result.addFirst(ans);
            cur1--;
        }
        // 如果result的第一位是0，那么移除
        if (result.getFirst() == 0) {
            result.removeFirst();
        }
        ListNode dump = new ListNode(-1);
        ListNode tmp = dump;
        for (int i = 0; i < result.size(); i++) {
            ListNode node = new ListNode(result.get(i));
            tmp.next = node;
            tmp = tmp.next;
        }
        return dump.next;
    }

    public static void main(String[] args) {
        nc40 n = new nc40();
        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(7);
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;

        node4.next = node5;
        n.addInList(node1, node4);
    }
}