package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePath {
    static void main() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2, null, new TreeNode(5)),
                new TreeNode(3));
        List<String> res = binaryTreePaths(root);
        System.out.println(res);
    }
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        if (root.left == null && root.right == null) {
            res.add(String.valueOf(root.val));
            return res;
        }
        List<String> leftPaths = binaryTreePaths(root.left);
        for (String path : leftPaths) {
            res.add(root.val + "->" + path);
        }
        List<String> rightPaths = binaryTreePaths(root.right);
        for (String path : rightPaths) {
            res.add(root.val + "->" + path);
        }
        return res;
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
