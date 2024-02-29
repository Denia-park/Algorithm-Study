package CodingTest.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

//        System.out.println(solution.isEvenOddTree(
//        ));
//        System.out.println(solution.isEvenOddTree(
//        ));
    }
}

class Solution {
    public boolean isEvenOddTree(final TreeNode root) {
        final Queue<TreeNode> queue = new LinkedList<>();
        TreeNode current = root;
        queue.add(current);

        boolean even = true;

        while (!queue.isEmpty()) {
            int size = queue.size();

            int prev = Integer.MAX_VALUE;
            if (even) {
                prev = Integer.MIN_VALUE;
            }

            while (size > 0) {
                current = queue.poll();

                if ((even && (current.val % 2 == 0 || current.val <= prev))
                        || !even && (current.val % 2 == 1 || current.val >= prev)) {
                    return false;
                }

                prev = current.val;
                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }

                size--;
            }

            even = !even;
        }

        return true;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(final int val) {
        this.val = val;
    }

    TreeNode(final int val, final TreeNode left, final TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
