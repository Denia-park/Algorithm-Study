package CodingTest.LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println("1 : " + solution.amountOfTime(null, 3));
    }
}

class Solution {
    public int amountOfTime(final TreeNode root, final int start) {
        final int rootValue = root.val;
        final int maxLeftHeight = getMaxHeight(root.left);
        final int maxRightHeight = getMaxHeight(root.right);

        if (rootValue == start) {
            return Math.max(maxLeftHeight, maxRightHeight);
        }

        //root에서 start가 있는 쪽 탐색
        //  start까지 계산
        int rootToStartHeight = 0;
        TreeNode startNode = null;

        final Deque<MyNode> deque = new ArrayDeque<>();
        deque.offerLast(new MyNode(root, 0));

        while (!deque.isEmpty()) {
            final MyNode curNode = deque.pollFirst();
            final int nodeValue = curNode.node.val;
            final int nodeHeight = curNode.height;

            if (nodeValue == start) {
                rootToStartHeight = nodeHeight;
                startNode = curNode.node;
                break;
            }

            if (curNode.node.left != null)
                deque.offerLast(new MyNode(curNode.node.left, nodeHeight + 1));
            if (curNode.node.right != null)
                deque.offerLast(new MyNode(curNode.node.right, nodeHeight + 1));
        }

        //start에서 끝까지
        final int startToEndCount = Math.max(getMaxHeight(startNode.left), getMaxHeight(startNode.right));

        int oppositeHeight = 0;

        if (rootToStartHeight + startToEndCount == maxLeftHeight) {
            oppositeHeight = maxRightHeight;
        } else {
            oppositeHeight = maxLeftHeight;
        }

        System.out.println("oppositeHeight : " + oppositeHeight);
        System.out.println("rootToStartHeight : " + rootToStartHeight);
        System.out.println("startToEndCount : " + startToEndCount);

        return Math.max(oppositeHeight + rootToStartHeight, startToEndCount);
    }

    private int getMaxHeight(final TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(getMaxHeight(root.left), getMaxHeight(root.right)) + 1;
    }
}

class MyNode {
    TreeNode node;
    int height;

    public MyNode(final TreeNode node, final int height) {
        this.node = node;
        this.height = height;
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
