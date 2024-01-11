package CodingTest.LeetCode;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        final TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);

        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);

        root.right.right = new TreeNode(14);

        root.right.right.left = new TreeNode(13);

        System.out.println("1 : " + solution.maxAncestorDiff(root)); //7

        final TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(2);
        root2.right.right = new TreeNode(0);
        root2.right.right.left = new TreeNode(3);

        System.out.println("2 : " + solution.maxAncestorDiff(root2)); //3
    }
}

class Solution {
    int maxDiffValue;

    public int maxAncestorDiff(final TreeNode root) {
        maxDiffValue = Integer.MIN_VALUE;

        //재귀 -> max값은 필드로 저장 //지금까지 내려오면서 subTree 기준 max값을 재귀를 태우자
        recur(root.left, root.val, root.val);
        recur(root.right, root.val, root.val);

        return maxDiffValue;
    }

    private void recur(final TreeNode root, final int subTreeMaxValue, final int subTreeMinValue) {
        if (root == null) {
            return;
        }

        maxDiffValue = Math.max(maxDiffValue, Math.abs(subTreeMaxValue - root.val));
        maxDiffValue = Math.max(maxDiffValue, Math.abs(subTreeMinValue - root.val));

        final int currentMaxValue = Math.max(subTreeMaxValue, root.val);
        final int currentMinValue = Math.min(subTreeMinValue, root.val);
        recur(root.left, currentMaxValue, currentMinValue);
        recur(root.right, currentMaxValue, currentMinValue);
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
