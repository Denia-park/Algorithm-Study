package CodingTest.LeetCode;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println("1 : " + solution.amountOfTime(null, 3));
    }
}

class Solution {
    private int maxDistance = 0;

    public int amountOfTime(final TreeNode root, final int start) {
        traverse(root, start);
        return maxDistance;
    }

    public int traverse(final TreeNode root, final int start) {
        int depth = 0;
        if (root == null) {
            return depth;
        }

        final int leftDepth = traverse(root.left, start);
        final int rightDepth = traverse(root.right, start);

        if (root.val == start) {
            maxDistance = Math.max(leftDepth, rightDepth);
            depth = -1;
        } else if (leftDepth >= 0 && rightDepth >= 0) {
            depth = Math.max(leftDepth, rightDepth) + 1;
        } else {
            final int distance = Math.abs(leftDepth) + Math.abs(rightDepth);
            maxDistance = Math.max(maxDistance, distance);
            depth = Math.min(leftDepth, rightDepth) - 1;
        }

        return depth;
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
