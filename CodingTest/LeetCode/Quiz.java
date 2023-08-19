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

        System.out.println(answer.equals("708"));
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode tail = dummyHead;

        int nextDigitNum = 0;

        while (l1 != null || l2 != null || nextDigitNum != 0) {
            int curDigitNum = 0;
            int l1Val = 0;
            int l2Val = 0;

            if (l1 != null) {
                l1Val = l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                l2Val = l2.val;
                l2 = l2.next;
            }

            curDigitNum += (l1Val + l2Val + nextDigitNum);

            nextDigitNum = curDigitNum / 10;
            curDigitNum = curDigitNum % 10;

            tail.next = new ListNode(curDigitNum);
            tail = tail.next;
        }

        return dummyHead.next;
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
