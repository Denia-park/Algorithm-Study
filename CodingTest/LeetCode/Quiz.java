package CodingTest.LeetCode;

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
        final int[] arr = new int[10];

        //leaf 노드까지 가야함 -> 양쪽 노드가 null인 노드
        arr[root.val]++;
        dfs(root, arr);

        return answer;
    }

    private void dfs(final TreeNode root, final int[] arr) {
        if (root.left == null && root.right == null) {
            if (isPalindrome(arr)) {
                answer++;
            }

            return;
        }

        if (root.left != null) {
            final int leftVal = root.left.val;
            arr[leftVal]++;
            dfs(root.left, arr);
            arr[leftVal]--;
        }

        if (root.right != null) {
            final int rightVal = root.right.val;
            arr[rightVal]++;
            dfs(root.right, arr);
            arr[rightVal]--;
        }
    }

    public boolean isPalindrome(final int[] arr) {
        //deque size가 짝수면, 모두 짝수
        //deque size가 홀수면, 한개는 홀수, 나머지 짝수
        int odd = 0;
        int sum = 0;

        for (final int count : arr) {
            if (count % 2 == 1) {
                odd++;
            }

            sum += count;
        }

        if (sum % 2 == 0) {
            return odd == 0;
        } else {
            return odd <= 1;
        }
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
