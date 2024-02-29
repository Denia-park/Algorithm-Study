package CodingTest.LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

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

    private Map<Integer, Stack<Integer>> stackMap;

    public boolean isEvenOddTree(final TreeNode root) {
        stackMap = new HashMap<>();

        return check(root, 0);
    }

    private boolean check(final TreeNode root, final int depth) {
        //inorder로 순회
        if (root == null) {
            return true;
        }

        boolean answer;

        answer = check(root.left, depth + 1);

        //홀수
        if (depth % 2 == 1) {
            final int val = root.val;
            //홀수이면, 문제
            if (val % 2 == 1) {
                return false;
            }

            //짝수이면, 이전 값에 비해 감소하는지 비교하기.
            final Stack<Integer> stack = stackMap.getOrDefault(depth, new Stack<>());
            if (stack.isEmpty()) {
                stack.push(val);
            } else {
                final int peek = stack.peek();
                if (peek <= val) {
                    return false;
                }

                stack.push(val);
            }
            stackMap.put(depth, stack);
        }

        //짝수
        else if (depth % 2 == 0) {
            final int val = root.val;
            //짝수이면, 문제
            if (val % 2 == 0) {
                return false;
            }

            //홀수이면, 이전 값에 비해 증가하는지 비교하기.
            final Stack<Integer> stack = stackMap.getOrDefault(depth, new Stack<>());
            if (stack.isEmpty()) {
                stack.push(val);
            } else {
                final int peek = stack.peek();
                if (peek >= val) {
                    return false;
                }

                stack.push(val);
            }
            stackMap.put(depth, stack);
        }

        answer = answer && check(root.right, depth + 1);

        return answer;
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
