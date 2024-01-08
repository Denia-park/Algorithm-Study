package CodingTest.LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println("1 : " + solution.rangeSumBST(null, 7, 15));
    }
}

class Solution {
    public int rangeSumBST(final TreeNode root, final int low, final int high) {
        int answer = 0;
        final Deque<TreeNode> deque = new ArrayDeque<>();

        deque.addLast(root);

        while (!deque.isEmpty()) {
            final TreeNode node = deque.pollFirst();

            if (low <= node.val && node.val <= high) {
                answer += node.val;
            }

            if (node.val > low && node.left != null) {
                deque.offerLast(node.left);
            }

            if (node.val < high && node.right != null) {
                deque.add(node.right);
            }
        }

        return answer;
    }
}

//Definition for a binary tree node.
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
