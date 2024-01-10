package CodingTest.LeetCode;

import java.util.*;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        final TreeNode root = new TreeNode(1);
        root.left = new TreeNode(5);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(9);
        root.left.right.right = new TreeNode(2);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(6);

        System.out.println("1 : " + solution.amountOfTime(root, 3));

        final TreeNode root2 = new TreeNode(1);
        System.out.println("2 : " + solution.amountOfTime(root2, 1));
    }
}

class Solution {
    Map<Integer, Set<Integer>> graph;

    public int amountOfTime(final TreeNode root, final int start) {
        graph = new HashMap<>();
        binaryTreeToGraph(root);

        System.out.println(graph);

        return bfs(start);
    }

    private void binaryTreeToGraph(final TreeNode root) {
        //자식 연결하기
        final int rootVal = root.val;

        //왼쪽 자식 연결하기
        final TreeNode leftChild = root.left;
        if (leftChild != null) {
            connectChild(leftChild, rootVal);
            binaryTreeToGraph(leftChild);
        }

        //오른쪽 자식 연결하기
        final TreeNode rightChild = root.right;
        if (rightChild != null) {
            connectChild(rightChild, rootVal);
            binaryTreeToGraph(rightChild);
        }
    }

    private void connectChild(final TreeNode child, final int rootVal) {
        final Set<Integer> rootSet = graph.getOrDefault(rootVal, new HashSet<>());

        final int childVal = child.val;
        rootSet.add(childVal);
        graph.put(rootVal, rootSet);

        final Set<Integer> leftSet = graph.getOrDefault(childVal, new HashSet<>());
        leftSet.add(rootVal);
        graph.put(childVal, leftSet);
    }

    private int bfs(final int start) {
        int maxDistance = 0;

        final Set<Integer> isVisited = new HashSet<>();

        final Deque<MyNode> deque = new ArrayDeque<>();
        deque.add(new MyNode(start, 0));
        isVisited.add(start);

        while (!deque.isEmpty()) {
            final MyNode current = deque.pollFirst();
            final Set<Integer> currentSet = graph.get(current.val);
            final int currentDistance = current.distance;
            maxDistance = Math.max(maxDistance, currentDistance);

            if (currentSet == null) continue;

            for (final int next : currentSet) {
                if (!isVisited.contains(next)) {
                    deque.add(new MyNode(next, currentDistance + 1));
                    isVisited.add(next);
                }
            }
        }

        return maxDistance;
    }

    class MyNode {
        int val;
        int distance;

        public MyNode(final int val, final int distance) {
            this.val = val;
            this.distance = distance;
        }
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
