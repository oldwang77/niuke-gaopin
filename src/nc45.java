import java.util.ArrayList;
import java.util.List;

public class nc45 {
    /**
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    List<Integer> preList = new ArrayList<>();
    List<Integer> inList = new ArrayList<>();
    List<Integer> behindList = new ArrayList<>();

    public int[][] threeOrders(TreeNode root) {
        // write code here
//        preOrder(root);
//        inOrder(root);
//        behindOrder(root);

        dfs(root);
        int len = preList.size();
        int[][] result = new int[3][len];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < len; j++) {
                if (i == 0) {
                    result[i][j] = preList.get(j);
                } else if (i == 1) {
                    result[i][j] = inList.get(j);
                } else {
                    result[i][j] = behindList.get(j);
                }
            }
        }
        return result;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        preList.add(root.val);
        dfs(root.left);
        inList.add(root.val);
        dfs(root.right);
        behindList.add(root.val);
    }
}
