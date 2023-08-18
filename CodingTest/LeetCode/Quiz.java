package CodingTest.LeetCode;

public class Quiz {
    public static void main(String[] args) {
        Solution solution = new Solution();

        //342
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        //465
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode listNode = solution.addTwoNumbers(l1, l2);

        String answer = "";

        while (listNode != null) {
            answer += listNode.val;
            listNode = listNode.next;
        }

        System.out.println(answer);
        System.out.println(answer.equals("708"));
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String l1Val = convertListNodeToReversedString(l1);
        String l2Val = convertListNodeToReversedString(l2);

        System.out.println("l1Val = " + l1Val);
        System.out.println("l2Val = " + l2Val);

        Long sum = Long.parseLong(l1Val) + Long.parseLong(l2Val);

        return convertStringToReversedListNode(sum);
    }

    private ListNode convertStringToReversedListNode(final Long sum) {
        System.out.println("sum = " + sum);

        String sumStr = String.valueOf(sum);
        final int length = sumStr.length();

        ListNode listNode = null;
        ListNode rtVal = null;

        for (int i = length - 1; i >= 0; i--) {
            if (rtVal == null) {
                listNode = new ListNode(sumStr.charAt(i) - '0');
                rtVal = listNode;
                continue;
            }

            listNode.next = new ListNode(sumStr.charAt(i) - '0');
            listNode = listNode.next;
        }

        return rtVal;
    }

    private String convertListNodeToReversedString(ListNode listNode) {
        StringBuilder sb = new StringBuilder();

        while (listNode != null) {
            sb.append(listNode.val);
            listNode = listNode.next;
        }

        return sb.reverse().toString();
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
