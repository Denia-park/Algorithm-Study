package CodingTest.LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        final TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);

        root.right = new TreeNode(1);
        root.right.right = new TreeNode(1);

        System.out.println("1 : " + solution.pseudoPalindromicPaths(
                root
        ));
    }
}

/*
아이디어
- DFS

시간복잡도
-

자료구조
- 이진 트리
 */

class Solution {
    int answer;

    public int pseudoPalindromicPaths(final TreeNode root) {
        answer = 0;
        final Deque<Integer> deque = new ArrayDeque<>();

        //leaf 노드까지 가야함 -> 양쪽 노드가 null인 노드
        deque.addLast(root.val);
        dfs(root, deque);

        return answer;
    }

    private void dfs(final TreeNode root, final Deque<Integer> deque) {
        if (root.left == null && root.right == null) {
            if (isPalindrome(deque)) {
                answer++;
            }

            return;
        }

        if (root.left != null) {
            final int leftVal = root.left.val;
            deque.addLast(leftVal);
            dfs(root.left, deque);
            deque.pollLast();
        }

        if (root.right != null) {
            final int rightVal = root.right.val;
            deque.addLast(rightVal);
            dfs(root.right, deque);
            deque.pollLast();
        }
    }

    public boolean isPalindrome(final Deque<Integer> deque) {
        final int[] arr = new int[10];

        for (final int val : deque) {
            arr[val]++;
        }

        final int size = deque.size();

        //deque size가 짝수면, 모두 짝수
        if (size % 2 == 0) {
            for (final int count : arr) {
                if (count % 2 == 1) {
                    return false;
                }
            }
        }
        //deque size가 홀수면, 한개는 홀수, 나머지 짝수
        else {
            int odd = 0;

            for (final int count : arr) {
                if (count % 2 == 1) {
                    odd++;
                }
            }

            return odd <= 1;
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
