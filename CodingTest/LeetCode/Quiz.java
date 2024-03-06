package CodingTest.LeetCode;

import java.util.HashSet;
import java.util.Set;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

//        System.out.println(solution.hasCycle("ca"));
    }
}

class Solution {
    public boolean hasCycle(final ListNode head) {
        final Set<ListNode> isVisited = new HashSet<>();

        ListNode cur = head;

        while (cur != null && !isVisited.contains(cur)) {
            isVisited.add(cur);
            cur = head.next;
        }

        return cur != null;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(final int x) {
        val = x;
        next = null;
    }
}
