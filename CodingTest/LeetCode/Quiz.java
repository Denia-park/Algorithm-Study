package CodingTest.LeetCode;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println("1 : " + solution.amountOfTime(null, 3));
    }
}

class Solution {
    public int amountOfTime(TreeNode root, final int start) {
        final int rootValue = root.val;
        int oppositeHeight = 0;

        if (rootValue == start) {
            return Math.max(getMaxHeight(root.left), getMaxHeight(root.right));
        }

        //root에서 start가 없는 끝까지
        if (start < rootValue) {
            oppositeHeight = getMaxHeight(root.right);
        } else {
            oppositeHeight = getMaxHeight(root.left);
        }


        //root에서 start가 있는 쪽 탐색
        //  start까지 계산
        int rootToStartHeight = 0;

        while (root != null) {
            if (root.val == start) {
                break;
            }

            if (start < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }

            rootToStartHeight++;
        }

        //start에서 끝까지
        final int startToEndHeight = getMaxHeight(root);

        System.out.println("oppositeHeight : " + oppositeHeight);
        System.out.println("rootToStartHeight : " + rootToStartHeight);
        System.out.println("startToEndHeight : " + startToEndHeight);

        return Math.max(oppositeHeight + rootToStartHeight, startToEndHeight);
    }

    private int getMaxHeight(final TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(getMaxHeight(root.left), getMaxHeight(root.right)) + 1;
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
