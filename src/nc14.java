import java.util.*;

public class nc14 {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        LinkedList<TreeNode> que = new LinkedList<>();
        que.push(root);

        int book = 0;
        while (!que.isEmpty()) {
            LinkedList<Integer> ans = new LinkedList<>();
            ArrayList<TreeNode> tmp = new ArrayList<>();
            while (!que.isEmpty()) {
                TreeNode node = que.removeFirst();
                if (book == 1) {
                    ans.addFirst(node.val);
                } else {
                    ans.addLast(node.val);
                }
                tmp.add(node);
            }

            ArrayList<Integer> ans2 = new ArrayList<>();
            for (int i = 0; i < ans.size(); i++) {
                ans2.add(ans.get(i));
            }
            result.add(ans2);
            book = 1 - book;
            // 放入队列中
            for (int i = 0; i < tmp.size(); i++) {
                TreeNode node = tmp.get(i);
                if(node.left!=null) que.add(node.left);
                if(node.right!=null) que.add(node.right);
            }
        }
        return result;
    }
}
