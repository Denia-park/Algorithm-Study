package CodingTest.LeetCode;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

//        System.out.println(solution.removeZeroSumSublists("cba", "abcd"));
//        System.out.println(solution.removeZeroSumSublists("bcafg", "abcd"));
    }
}

class Solution {
    public ListNode removeZeroSumSublists(final ListNode head) {
        final ListNode front = new ListNode(0, head);
        ListNode start = front;

        while (start != null) {
            int prefixSum = 0;
            ListNode end = start.next;

            while (end != null) {
                // Add end's value to the prefix sum
                prefixSum += end.val;
                // Delete zero sum consecutive sequence
                // by setting node before sequence to node after
                if (prefixSum == 0) {
                    start.next = end.next;
                }
                end = end.next;
            }

            start = start.next;
        }
        return front.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(final int val) {
        this.val = val;
    }

    ListNode(final int val, final ListNode next) {
        this.val = val;
        this.next = next;
    }
}
