package leetcode.easy;

import java.util.List;

public class MaximumDepthOfNTree {
    static void main() {
        Node root = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        root.children = List.of(node1, node2, node3);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        node2.children = List.of(node4, node5);
            System.out.println(maxDepth(root));
    }
    public static int maxDepth(Node root) {
        int max = 0;
        if (root == null) {
            return max;
        }
        if (root.children == null || root.children.isEmpty()) {
            return 1;
        }
        for (Node node : root.children) {
            int depth = maxDepth(node);
            if (depth > max) {
                max = depth;
            }
        }
        return max + 1;
    }
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
