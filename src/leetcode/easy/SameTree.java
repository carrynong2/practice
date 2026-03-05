package leetcode.easy;

public class SameTree {
    static void main() {
        TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(isSameTree(p, q));
    }
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        boolean isSame;
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        isSame = isSameTree(p.left, q.left);
        if (!isSame) {
            return false;
        }
        isSame = isSameTree(p.right, q.right);
        return isSame;
    }
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
         this.left = left;
          this.right = right;
     }
 }

}
