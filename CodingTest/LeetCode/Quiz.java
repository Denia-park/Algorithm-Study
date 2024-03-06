package CodingTest.LeetCode;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

//        System.out.println(solution.hasCycle("ca"));
    }
}

class Solution {
    public boolean hasCycle(final ListNode head) {
        ListNode cur = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            cur = cur.next;
            fast = fast.next.next;

            if (cur == fast) return true;
        }

        return false;
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
