public class nc102 {
    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        // write code here
        if(root==null) return -1;

        // o1 or o2就是根结点
        if(root.val==o1 || root.val==o2) return root.val;
        int left = lowestCommonAncestor(root.right,o1,o2);
        int right = lowestCommonAncestor(root.left,o1,o2);
        // 都在右边
        if(left==-1) return right;
        // 都在左边
        if(right==-1) return left;
        // 在左右两侧
        return root.val;
    }
}
